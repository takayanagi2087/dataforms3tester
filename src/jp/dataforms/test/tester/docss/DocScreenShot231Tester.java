package jp.dataforms.test.tester.docss;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;

import jp.dataforms.fw.app.enumtype.page.EnumPage;
import jp.dataforms.fw.app.menu.page.SiteMapPage;
import jp.dataforms.fw.app.user.page.UserManagementPage;
import jp.dataforms.fw.devtool.db.page.TableManagementPage;
import jp.dataforms.fw.devtool.table.page.TableGeneratorPage;
import jp.dataforms.fw.devtool.webres.page.WebResourcePage;
import jp.dataforms.fw.util.JsonUtil;
import jp.dataforms.test.element.app.enumtype.page.EnumEditFormTestElement;
import jp.dataforms.test.element.app.enumtype.page.EnumPageTestElement;
import jp.dataforms.test.element.app.enumtype.page.EnumQueryFormTestElement;
import jp.dataforms.test.element.app.enumtype.page.EnumQueryResultFormTestElement;
import jp.dataforms.test.element.app.menu.page.SiteMapPageTestElement;
import jp.dataforms.test.element.app.user.page.UserEditFormTestElement;
import jp.dataforms.test.element.app.user.page.UserManagementPageTestElement;
import jp.dataforms.test.element.app.user.page.UserQueryFormTestElement;
import jp.dataforms.test.element.controller.EditFormTestElement;
import jp.dataforms.test.element.controller.PageTestElement;
import jp.dataforms.test.element.controller.QueryFormTestElement;
import jp.dataforms.test.element.controller.QueryResultFormTestElement;
import jp.dataforms.test.element.devtool.db.page.TableManagementPageTestElement;
import jp.dataforms.test.element.devtool.db.page.TableManagementQueryFormTestElement;
import jp.dataforms.test.element.devtool.db.page.TableManagementQueryResultFormTestElement;
import jp.dataforms.test.element.devtool.table.page.TableGeneratorEditFormTestElement;
import jp.dataforms.test.element.devtool.table.page.TableGeneratorPageTestElement;
import jp.dataforms.test.element.devtool.table.page.TableGeneratorQueryFormTestElement;
import jp.dataforms.test.element.devtool.table.page.TableGeneratorQueryResultFormTestElement;
import jp.dataforms.test.element.devtool.webres.page.WebResourcePageTestElement;
import jp.dataforms.test.element.devtool.webres.page.WebResourceQueryFormTestElement;
import jp.dataforms.test.element.devtool.webres.page.WebResourceQueryResultFormTestElement;
import jp.dataforms.test.element.field.FieldTestElement;
import jp.dataforms.test.element.htmltable.TableTestElement;
import jp.dataforms.test.proj.WebAppProject;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.util.ImageEditor;

/**
 * 「2.3.ページのカスタマイズ」のスクリーンショットを取得するツール。
 */
public class DocScreenShot231Tester extends DocScreenShotTester {
	/**
	 * Logger.
	 */
	private static Logger logger = LogManager.getLogger(DocScreenShot212Tester.class);

	/**
	 * コンストラクタ。
	 */
	public DocScreenShot231Tester() {
		super("2.3.customize");
	}
	
	/**
	 * sampleテーブルをテーブルクラスの構造にうわせる。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void restoreTable(final Browser browser) throws Exception {
		browser.setSize(new Dimension(1600, 800));
		browser.open(TableManagementPage.class);
		TableManagementPageTestElement p = browser.getPageTestElement(TableManagementPageTestElement.class);
		TableManagementQueryFormTestElement qf = p.getTableManagementQueryForm();
		qf.getFunctionSelect().setValue("/edittable");
		qf.query();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		TableManagementQueryResultFormTestElement qrf = p.getTableManagementQueryResultForm();
		TableTestElement table = qrf.getQueryResultTable();
		table.getField(0, "checkedClass").click();
		qrf.getUpdateTableButton().click();
		Browser.sleep(this.getConf().getTestApp().getMiddleWait());
		p.getConfirmDialog().clickOkButton();
		Browser.sleep(this.getConf().getTestApp().getMiddleWait());
	}
	

	
	/**
	 * ユーザの登録。
	 * @param browser ブラウザ。
	 * @param p ページテスト要素。
	 * @param user ユーザ。
	 * @param screenShot スクリーンショット取得フラグ。
	 * @throws Exception 例外。
	 */
	private void addUser(final Browser browser, final UserManagementPageTestElement p, final String user, final boolean screenShot) throws Exception {
		browser.setClientSize(new Dimension(1400, 900));
		UserQueryFormTestElement qf = p.getUserQueryForm();
		qf.newData();
		UserEditFormTestElement ef = p.getUserEditForm();
		TestUser testUser = this.getConf().getTestUser(user);
		ef.getLoginId().setValue(testUser.getLoginId());
		ef.getPassword().setValue(testUser.getPassword());
		ef.getPasswordCheck().setValue(testUser.getPassword());
		ef.getUserName().setValue(user + " name");
		ef.getMailAddress().setValue(user + "@hogehoge.jp");
		TableTestElement table = ef.getAttTable();
		table.addRow();
		table.setValue(0, "userAttributeType", "userLevel");
		table.setValue(0, "userAttributeValue", user);
		table.getField(0, "userAttributeValue").click();
		Browser.sleep(this.getConf().getTestApp().getMiddleWait());
		if (screenShot) {
			this.saveScreenShot(browser, "userManagement2.png", false);
		}
		table.getField(0, "userAttributeValue").click();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		ef.confirm();
		Browser.sleep(this.getConf().getTestApp().getMiddleWait());
		ef.save();
		Browser.sleep(this.getConf().getTestApp().getMiddleWait());
		p.getAlertDialog().clickOkButton();
	}

	
	
	/**
	 * ユーザメンテナンス。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void userMaint(final Browser browser) throws Exception {
		browser.open(UserManagementPage.class);
		UserManagementPageTestElement p = browser.getPageTestElement(UserManagementPageTestElement.class);
		UserQueryFormTestElement qf = p.getUserQueryForm();
		qf.query();
		this.saveScreenShot(browser, "userManagement.png");
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		this.addUser(browser, p, "admin", true);
		this.addUser(browser, p, "user", false);
		this.addUser(browser, p, "guest", false);
		this.logout(browser);
	}
	
	/**
	 * ユーザレベルのテスト。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void testUserLevel(final Browser  browser) throws Exception {
		WebAppProject prj = WebAppProject.newWebAppProject(this.getConf());
		prj.copyJavaSrc("/jp/dataforms/sample/edittable/page/SamplePage.java", "/jp/dataforms/sample/edittable/page/SamplePage.java");
		Browser.sleep(this.getConf().getTestApp().getBuildWait());
		browser.open(SiteMapPage.class);
		SiteMapPageTestElement p = browser.getPageTestElement(SiteMapPageTestElement.class);
		browser.setSize(new Dimension(1280, 600));
		p.clickAllMenuGroup();
		this.saveScreenShot(browser, "userManagement3.png");
		this.login(browser, "user");
		browser.setSize(new Dimension(1280, 640));
		p.clickMenuGroup("テーブル編集");
		String img = this.saveScreenShot(browser, "userManagement4.png", false);
		ImageEditor.addMarkRect(img, 18, 100, 162, 124);
		ImageEditor.addMarkRect(img, 240, 92, 385, 118);
	}
	
	/**
	 * Sampleテーブルに追加するデータ。
	 */
	private static String SAMPLE_JSON = """
	{
		"sampleText": "aab",
		"sampleNumeric": "1111.22",
		"sampleDate": "2024/07/30"
	}
	""";
	
	/**
	 * サンプルテーブルのデータ追加。
	 * @param browser ブラウザ。
	 * @param json 追加データ。
	 * @throws Exception 例外。
	 */
	private void sortTest(final Browser browser, final String json) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String, Object> data = (Map<String, Object>) JsonUtil.decode(json, HashMap.class);
		String url = this.getConf().getTestApp().getApplicationURL() + "edittable/page/SamplePage.html";
		PageTestElement p = browser.open(url);
		QueryFormTestElement qf = p.getQueryForm();
		qf.newData();
		EditFormTestElement ef = p.getEditForm();
		for (String key: data.keySet()) {
			ef.getField(key).setValue((String) data.get(key));
		}
		ef.confirm();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		ef.save();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		p.getAlertDialog().clickOkButton();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		qf.query();
		{
			String imgfile = this.saveScreenShot(browser, "columnSort1.png");
			ImageEditor.addMarkRect(imgfile, 266, 334, 448, 366);
		}
		WebAppProject prj = WebAppProject.newWebAppProject(this.getConf());
		prj.copyJavaSrc("/jp/dataforms/sample/edittable/page/SampleQueryResultForm.java", "/jp/dataforms/sample/edittable/page/SampleQueryResultForm.java");
		Browser.sleep(this.getConf().getTestApp().getBuildWait());
		browser.reload();
		p = browser.getPageTestElement();
		p.getQueryForm().query();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		{
			String imgfile = this.saveScreenShot(browser, "columnSort2.png");
			ImageEditor.addMarkRect(imgfile, 266, 334, 448, 366);
		}
	}
	
	/**
	 * バリデータのテスト。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void testValidator(final Browser browser) throws Exception {
		this.logout(browser);
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		this.login(browser, "developer");
		String url = this.getConf().getTestApp().getApplicationURL() + "edittable/page/SamplePage.html";
		{
			PageTestElement p = browser.open(url);
			QueryFormTestElement qf = p.getQueryForm();
			qf.newData();
			EditFormTestElement ef = p.getEditForm();
			ef.getField("sampleNumeric").setValue("abc");
			ef.getField("sampleDate").setValue("2023/02/30");
			ef.confirm();
			this.saveScreenShot(browser, "validator1.png");
		}
		{
			WebAppProject prj = WebAppProject.newWebAppProject(this.getConf());
			prj.copyJavaSrc("/jp/dataforms/sample/edittable/page/SampleEditForm.java", "/jp/dataforms/sample/edittable/page/SampleEditForm.java");
			Browser.sleep(this.getConf().getTestApp().getBuildWait());
			browser.reload();
			PageTestElement p = browser.open(url);
			QueryFormTestElement qf = p.getQueryForm();
			qf.newData();
			EditFormTestElement ef = p.getEditForm();
			ef.confirm();
			this.saveScreenShot(browser, "validator2.png");
		}
		{
			WebAppProject prj = WebAppProject.newWebAppProject(this.getConf());
			prj.copyJavaSrc("/jp/dataforms/sample/edittable/field/SampleTextField.java", "/jp/dataforms/sample/edittable/field/SampleTextField.java");
			Browser.sleep(this.getConf().getTestApp().getBuildWait());
			browser.reload();
			PageTestElement p = browser.open(url);
			QueryFormTestElement qf = p.getQueryForm();
			qf.newData();
			EditFormTestElement ef = p.getEditForm();
			ef.getField("sampleText").setValue("漢字");
			ef.confirm();
			this.saveScreenShot(browser, "validator3.png");
		}
		{
			WebAppProject prj = WebAppProject.newWebAppProject(this.getConf());
			prj.copyWebappSrc("/edittable/page/SamplePage.properties", "/edittable/page/SamplePage.properties");
			prj.copyJavaSrc("/jp/dataforms/sample/edittable/page/SampleEditForm.java.1", "/jp/dataforms/sample/edittable/page/SampleEditForm.java");
			Browser.sleep(this.getConf().getTestApp().getBuildWait());
			browser.reload();
			PageTestElement p = browser.open(url);
			QueryFormTestElement qf = p.getQueryForm();
			qf.newData();
			EditFormTestElement ef = p.getEditForm();
			ef.getField("sampleText").setValue("abc");
			ef.getField("sampleNumeric").setValue("123.00");
			ef.confirm();
			this.saveScreenShot(browser, "validator4.png");
		}
		{
			WebAppProject prj = WebAppProject.newWebAppProject(this.getConf());
			browser.open(WebResourcePage.class);
			Browser.sleep(this.getConf().getTestApp().getShortWait());
			WebResourcePageTestElement p = browser.getPageTestElement(WebResourcePageTestElement.class);
			WebResourceQueryFormTestElement qf = p.getWebResourceQueryForm();
			qf.getFunctionSelect().setValue("/edittable");
			qf.getPageClassName().setValue("SamplePage");
			qf.getClassName().setValue("SampleEditForm");
			qf.query();
			//
			Browser.sleep(this.getConf().getTestApp().getShortWait());
			browser.setSize(new Dimension(1280, 900));
			String imgfile = this.saveScreenShot(browser, "validator5.png");
			ImageEditor.addMarkRect(imgfile, 264, 430, 605, 466);
			//
			WebResourceQueryResultFormTestElement qrf = p.getWebResourceQueryResultForm();
			TableTestElement table = qrf.getQueryResultTable();
			table.getField(0, "className").click();
			imgfile = this.saveScreenShot(browser, "validator6.png");
			ImageEditor.addMarkRect(imgfile, 980, 408, 1022, 442);
			//
			p.getWebResourceDialog().getWebResourceForm().getGenerateJavascriptButton().click();
			p.getAlertDialog().clickOkButton();
			p.getWebResourceDialog().getWebResourceForm().getCloseButton().click();
			//
			Browser.sleep(this.getConf().getTestApp().getShortWait());
			prj.copyWebappSrc("/edittable/page/SampleEditForm.js", "/edittable/page/SampleEditForm.js");
			this.reloadWebApp("/sample");
			browser.open(url);
			p = browser.getPageTestElement(WebResourcePageTestElement.class);
			qf = p.getWebResourceQueryForm();
			qf.newData();
			EditFormTestElement ef = p.getEditForm();
			ef.getField("sampleText").setValue("abc");
			ef.getField("sampleNumeric").setValue("123.00");
			ef.confirm();
			
		}
	}
	
	/**
	 * Autocompleteのテスト。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void testAutocomplete(final Browser browser) throws Exception {
		WebAppProject prj = WebAppProject.newWebAppProject(this.getConf());
		prj.copyJavaSrc("/jp/dataforms/sample/edittable/field/SampleTextField.java.1", "/jp/dataforms/sample/edittable/field/SampleTextField.java");
		prj.copyJavaSrc("/jp/dataforms/sample/edittable/page/SampleEditForm.java.2", "/jp/dataforms/sample/edittable/page/SampleEditForm.java");
		Browser.sleep(this.getConf().getTestApp().getBuildWait());
		this.reloadWebApp("/sample");
		String url = prj.getUrl() + "edittable/page/SamplePage.html";
		browser.open(url);
		PageTestElement p = browser.getPageTestElement();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		QueryFormTestElement qf = p.getQueryForm();
		qf.newData();
		EditFormTestElement ef = p.getEditForm();
		ef.getField("sampleText").setValue("a");
		browser.setSize(new Dimension(1280, 900));
		String imgfile = this.saveScreenShot(browser, "autocomplete1.png");
		ImageEditor.addMarkRect(imgfile, 442, 98, 1240, 182);
		ef.getField("sampleText").setValue("aaa");
		ef.getField("sampleDate").click();
		Browser.sleep(this.getConf().getTestApp().getMiddleWait());
		this.saveScreenShot(browser, "reference1.png");
	}

	/**
	 * レポートのテスト。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void testReport(final Browser browser) throws Exception {
		WebAppProject prj = WebAppProject.newWebAppProject(this.getConf());
		prj.copyWebappSrc("/edittable/page/SamplePage.html.1", "/edittable/page/SamplePage.html");
		prj.copyWebappSrc("/edittable/page/SampleEditForm.js.1", "/edittable/page/SampleEditForm.js");
		prj.copyTestApi();
		Browser.sleep(this.getConf().getTestApp().getBuildWait());
		this.reloadWebApp("/sample");
		String url = prj.getUrl() + "edittable/page/SamplePage.html";
		browser.open(url);
		browser.setSize(new Dimension(1280, 900));
		{
			PageTestElement p = browser.getPageTestElement();
			QueryFormTestElement qf = p.getQueryForm();
			qf.newData();
			Browser.sleep(this.getConf().getTestApp().getMiddleWait());
			EditFormTestElement ef = p.getEditForm();
			ef.getButton("printButton").click();
			Browser.sleep(this.getConf().getTestApp().getShortWait());
			
		}
		this.saveScreenShot(browser, "function1.png");
		// 
		prj.copyWebappSrc("/exceltemplate/sample.xlsx", "/exceltemplate/sample.xlsx");
		prj.copyJavaSrc("/jp/dataforms/sample/edittable/report/SampleExcelReport.java", "/jp/dataforms/sample/edittable/report/SampleExcelReport.java");
		prj.copyWebappSrc("/edittable/page/SampleEditForm.js.2", "/edittable/page/SampleEditForm.js");
		prj.copyJavaSrc("/jp/dataforms/sample/edittable/page/SampleEditForm.java.3", "/jp/dataforms/sample/edittable/page/SampleEditForm.java");
		Browser.sleep(this.getConf().getTestApp().getBuildWait());
		this.reloadWebApp("/sample");
		browser.open(url);
		browser.setSize(new Dimension(1280, 900));
		{
			PageTestElement p = browser.getPageTestElement();
			QueryFormTestElement qf = p.getQueryForm();
			qf.query();
			QueryResultFormTestElement el = p.getQueryResultForm();
			el.getQueryResultTable().getField(0, "sampleText").click();
			Browser.sleep(this.getConf().getTestApp().getShortWait());
		}
		String imgfile = this.saveScreenShot(browser, "function4.png");
		ImageEditor.addMarkRect(imgfile, 368, 236, 414, 268);

		
	}
	
	/**
	 * 列挙型テスト。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void testEnum(final Browser browser) throws Exception {
		WebAppProject prj = WebAppProject.newWebAppProject(this.getConf());
		browser.open(EnumPage.class);
		{
			EnumPageTestElement p = browser.getPageTestElement(EnumPageTestElement.class);
			EnumQueryFormTestElement qf = p.getEnumQueryForm();
			qf.getEnumCode().setValue("userLevel");
			qf.query();
			EnumQueryResultFormTestElement qrf = p.getEnumQueryResultForm();
			TableTestElement qrt = qrf.getQueryResultTable();
			qrt.getField(0, "enumCode").click();
			this.saveScreenShot(browser, "enum1.png");
		}
		{
			EnumPageTestElement p = browser.getPageTestElement(EnumPageTestElement.class);
			EnumEditFormTestElement ef = p.getEnumEditForm();
			ef.back();
			EnumQueryFormTestElement qf = p.getEnumQueryForm();
			qf.newData();
			ef = p.getEnumEditForm();
			ef.getEnumCode().setValue("sampleSelect");
			ef.getEnumName().setValue("選択肢サンプル");
			TableTestElement table = ef.getOptionTable();
			table.addRow();
			table.addRow();
			table.addRow();
			final String[][] OPT = {
					{"1", "A"},
					{"2", "B"},
					{"3", "C"},
				};
			for (int i = 0; i < OPT.length; i++) {
				FieldTestElement codeField = table.getField(i, "enumCode");
				codeField.setValue(OPT[i][0]);
				FieldTestElement nameField = table.getField(i, "enumName");
				nameField.setValue(OPT[i][1]);
			}
			this.saveScreenShot(browser, "enum2.png");
			ef.confirm();
			Browser.sleep(this.getConf().getTestApp().getShortWait());
			ef.save();
			p.getAlertDialog().clickOkButton();
			
		}
		{
			browser.setSize(new Dimension(1720, 840));
			browser.open(TableGeneratorPage.class);
			TableGeneratorPageTestElement p = browser.getPageTestElement(TableGeneratorPageTestElement.class);
			TableGeneratorQueryFormTestElement qf = p.getTableGeneratorQueryForm();
			qf.getFunctionSelect().setValue("/edittable");
			qf.query();
			TableGeneratorQueryResultFormTestElement qrf = p.getTableGeneratorQueryResultForm();
			qrf.getQueryResultTable().getField(0, "fullClassName").click();
			Browser.sleep(this.getConf().getTestApp().getShortWait());
			TableGeneratorEditFormTestElement ef = p.getTableGeneratorEditForm();
			TableTestElement list = ef.getFieldList();
			list.addRow();
			list.getField(4, "fieldClassName").setValue("SampleSelectField");
			list.getField(4, "superPackageName").setValue("jp.dataforms.fw.field.common");
			list.getField(4, "superSimpleClassName").setValue("EnumOptionSingleSelectField");
			list.getField(4, "comment").setValue("サンプル選択肢");
			Browser.sleep(this.getConf().getTestApp().getShortWait());
			ef.getConfirmButton().click();
			Browser.sleep(this.getConf().getTestApp().getShortWait());
			String imgfile = this.saveScreenShot(browser, "enum3.png");
			ImageEditor.addMarkRect(imgfile, 1176, 218, 1712, 258);
			ImageEditor.addMarkRect(imgfile, 1352, 356, 1540, 386);
			ef.getButton("errorSkipButton").click();
			ef.getField("overwriteMode").setValue("force");
			ef.confirm();
			ef.save();
			Browser.sleep(this.getConf().getTestApp().getShortWait());
			p.getAlertDialog().clickOkButton();
			Browser.sleep(this.getConf().getTestApp().getBuildWait());
			this.reloadWebApp("/sample");
			qf.query();
			Browser.sleep(this.getConf().getTestApp().getLongWait());
		}
		{
			browser.setSize(new Dimension(1600, 800));
			browser.open(TableManagementPage.class);
			TableManagementPageTestElement p = browser.getPageTestElement(TableManagementPageTestElement.class);
			TableManagementQueryFormTestElement qf = p.getTableManagementQueryForm();
			qf.getFunctionSelect().setValue("/edittable");
			qf.query();
			Browser.sleep(this.getConf().getTestApp().getShortWait());
			TableManagementQueryResultFormTestElement qrf = p.getTableManagementQueryResultForm();
			qrf.getSelectDiffButton().click();
			{
				String imgfile = this.saveScreenShot(browser, "enum5.png");
				ImageEditor.addMarkRect(imgfile, 270, 430, 302, 460);
				ImageEditor.addMarkRect(imgfile, 242, 460, 285, 492);
			}
			qrf.getUpdateTableButton().click();
			Browser.sleep(this.getConf().getTestApp().getMiddleWait());
			p.getConfirmDialog().clickOkButton();
			Browser.sleep(this.getConf().getTestApp().getMiddleWait());
			this.saveScreenShot(browser, "enum6.png");
		}
		{
			prj.copyWebappSrc("/edittable/page/SamplePage.html", "/edittable/page/SamplePage.html");
			prj.copyJavaSrc("/jp/dataforms/sample/edittable/field/SampleSelectField.java", "/jp/dataforms/sample/edittable/field/SampleSelectField.java");
			Browser.sleep(this.getConf().getTestApp().getBuildWait());
			this.reloadWebApp("/sample");
			String url = prj.getUrl() + "edittable/page/SamplePage.html";
			browser.open(url);
			browser.setSize(new Dimension(1280, 900));
			PageTestElement p = browser.getPageTestElement();
			QueryFormTestElement qf = p.getQueryForm();
			qf.newData();
			Browser.sleep(this.getConf().getTestApp().getShortWait());
			EditFormTestElement ef = p.getEditForm();
			ef.getField("sampleText").setValue("aac");
			ef.getField("sampleNumeric").setValue("1111.11");
			ef.getField("sampleDate").setValue("2024/08/11");
			ef.getField("sampleSelect").setValue("1");
			ef.getField("sampleSelect").click();
			Browser.sleep(this.getConf().getTestApp().getShortWait());
			this.saveScreenShot(browser, "enum7.png");
			ef.confirm();
			ef.save();
			p.getAlertDialog().clickOkButton();
			Browser.sleep(this.getConf().getTestApp().getShortWait());
			qf.query();
			this.saveScreenShot(browser, "enum8.png");
		}
		
	}
	
	@Override
	public void exec() throws Exception {
		WebAppProject proj = WebAppProject.newWebAppProject(this.getConf());
		proj.importDb("step01", "jp.dataforms.fw.app", "jp.dataforms.sample.edittable");
		proj.loadSnapshot("step01");
		this.reloadWebApp(this.getConf().getTestApp().getContextPath());
		Browser browser = this.getBrowser();
		this.login(browser, "developer");
		this.restoreTable(browser);
		this.userMaint(browser);
		this.testUserLevel(browser);
		this.sortTest(browser, SAMPLE_JSON);
		this.testValidator(browser);
		this.testAutocomplete(browser);
		this.testEnum(browser);
		this.testReport(browser);
		proj.saveSnapshot("step02");
		proj.exportDb("step02", "jp.dataforms.fw.app", "jp.dataforms.sample.edittable");
		logger.info(this.getDocumentPath() + "取得終了");
		browser.close();
	}
}
