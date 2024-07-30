package jp.dataforms.test.tester.docss;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Dimension;

import jp.dataforms.fw.app.menu.page.SiteMapPage;
import jp.dataforms.fw.app.user.page.UserManagementPage;
import jp.dataforms.fw.devtool.webres.page.WebResourcePage;
import jp.dataforms.fw.util.JsonUtil;
import jp.dataforms.test.element.app.user.page.UserEditFormTestElement;
import jp.dataforms.test.element.app.user.page.UserManagementPageTestElement;
import jp.dataforms.test.element.app.user.page.UserQueryFormTestElement;
import jp.dataforms.test.element.controller.EditFormTestElement;
import jp.dataforms.test.element.controller.PageTestElement;
import jp.dataforms.test.element.controller.QueryFormTestElement;
import jp.dataforms.test.element.devtool.webres.page.WebResourcePageTestElement;
import jp.dataforms.test.element.devtool.webres.page.WebResourceQueryFormTestElement;
import jp.dataforms.test.element.devtool.webres.page.WebResourceQueryResultFormTestElement;
import jp.dataforms.test.element.htmltable.TableTestElement;
import jp.dataforms.test.proj.WebAppProject;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.util.ImageEditor;

/**
 * プロジェクトの初期化のスクリーンショットを取得するツール。
 */
public class DocScreenShot231Tester extends DocScreenShotTester {

	/**
	 * コンストラクタ。
	 */
	public DocScreenShot231Tester() {
		super("2.3.customize");
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
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		if (screenShot) {
			this.saveScreenShot(browser, "userManagement2.png", false);
		}
		table.getField(0, "userAttributeValue").click();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		ef.confirm();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		ef.save();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		p.getAlertDialog().clickOkButton();
	}

	/**
	 * ユーザメンテナンス。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void userMaint(final Browser browser) throws Exception {
		this.openPage(browser, UserManagementPage.class);
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
		PageTestElement p = this.openPage(browser, SiteMapPage.class);
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
			ImageEditor.addMarkRect(imgfile, 266, 334, 480, 366);
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
			ImageEditor.addMarkRect(imgfile, 266, 334, 480, 366);
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
			this.openPage(browser, WebResourcePage.class);
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
			ImageEditor.addMarkRect(imgfile, 270, 430, 620, 460);
			//
			WebResourceQueryResultFormTestElement qrf = p.getWebResourceQueryResultForm();
			TableTestElement table = qrf.getQueryResultTable();
			table.getField(0, "className").click();
			imgfile = this.saveScreenShot(browser, "validator6.png");
			ImageEditor.addMarkRect(imgfile, 980, 410, 1024, 442);
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
		this.saveScreenShot(browser, "reference1.png");
	}

	
	@Override
	public void exec() throws Exception {
		WebAppProject proj = WebAppProject.newWebAppProject(this.getConf());
		proj.importDb("step01", "jp.dataforms.fw.app", "jp.dataforms.sample.edittable");
		proj.loadSnapshot("step01");
		this.reloadWebApp(this.getConf().getTestApp().getContextPath());
		Browser browser = this.getBrowser();
		this.login(browser, "developer");
		this.userMaint(browser);
		this.testUserLevel(browser);
		this.sortTest(browser, SAMPLE_JSON);
		this.testValidator(browser);
		this.testAutocomplete(browser);
		proj.saveSnapshot("step02");
		proj.exportDb("step02", "jp.dataforms.fw.app", "jp.dataforms.sample.edittable");
		browser.close();

	}
}
