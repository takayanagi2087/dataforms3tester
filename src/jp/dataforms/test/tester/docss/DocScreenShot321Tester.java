package jp.dataforms.test.tester.docss;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import jp.dataforms.fw.devtool.db.page.TableManagementPage;
import jp.dataforms.fw.devtool.pageform.page.DaoAndPageGeneratorPage;
import jp.dataforms.fw.devtool.query.page.QueryGeneratorPage;
import jp.dataforms.fw.devtool.table.page.TableGeneratorPage;
import jp.dataforms.fw.devtool.webres.page.WebResourcePage;
import jp.dataforms.test.element.controller.DialogTestElement;
import jp.dataforms.test.element.controller.EditFormTestElement;
import jp.dataforms.test.element.controller.FormTestElement;
import jp.dataforms.test.element.controller.PageTestElement;
import jp.dataforms.test.element.controller.QueryFormTestElement;
import jp.dataforms.test.element.devtool.db.page.TableManagementPageTestElement;
import jp.dataforms.test.element.devtool.db.page.TableManagementQueryResultFormTestElement;
import jp.dataforms.test.element.devtool.pageform.page.DaoAndPageGeneratorEditFormTestElement;
import jp.dataforms.test.element.devtool.pageform.page.DaoAndPageGeneratorPageTestElement;
import jp.dataforms.test.element.devtool.pageform.page.PageGeneratorQueryFormTestElement;
import jp.dataforms.test.element.devtool.query.page.QueryGeneratorPageTestElement;
import jp.dataforms.test.element.devtool.query.page.QueryGeneratorQueryFormTestElement;
import jp.dataforms.test.element.devtool.query.page.QueryGeneratorQueryResultFormTestElement;
import jp.dataforms.test.element.devtool.table.page.TableGeneratorEditFormTestElement;
import jp.dataforms.test.element.devtool.table.page.TableGeneratorPageTestElement;
import jp.dataforms.test.element.devtool.webres.page.WebResourceFormTestElement;
import jp.dataforms.test.element.devtool.webres.page.WebResourcePageTestElement;
import jp.dataforms.test.element.devtool.webres.page.WebResourceQueryFormTestElement;
import jp.dataforms.test.element.devtool.webres.page.WebResourceQueryResultFormTestElement;
import jp.dataforms.test.element.htmltable.TableTestElement;
import jp.dataforms.test.proj.WebAppProject;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.util.ImageEditor;

/**
 * 「2.5.問合せクラスの作成」のスクリーンショットを取得するツール。
 */
public class DocScreenShot321Tester extends DocScreenShotTester {
	
	/**
	 * Logger.
	 */
	private static Logger logger = LogManager.getLogger(DocScreenShot251Tester.class);

	/**
	 * コンストラクタ。
	 */
	public DocScreenShot321Tester() {
		super("3.2.page");
	}

	/**
	 * サンプルページ2のページクラス。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void testDaoAndPage(final Browser browser) throws Exception {
		browser.setSize(new Dimension(1600, 800));
		browser.open(DaoAndPageGeneratorPage.class);
		DaoAndPageGeneratorPageTestElement p = browser.getPageTestElement(DaoAndPageGeneratorPageTestElement.class);
		PageGeneratorQueryFormTestElement qf = p.getPageGeneratorQueryForm();
		qf.newData();
		DaoAndPageGeneratorEditFormTestElement ef = p.getDaoAndPageGeneratorEditForm();
		ef.getFunctionSelect().setValue("/edittable");
		ef.getPageName().setValue("サンプルページ2");
		ef.getDescription().setValue("1レコードに紐づく複数レコード編集");
		ef.getPageClassName().setValue("Sample2Page");
		ef.getDaoClassName().setValue("Sample2Dao");

		ef.getListQueryFunctionSelect().setValue("/edittable");
		ef.getListQueryPackageName().setValue("jp.dataforms.sample.edittable");
		ef.getListQueryClassName().setValue("SampleTable");
		
		ef.getEditQueryFunctionSelect().setValue("/edittable");
		ef.getEditQueryPackageName().setValue("jp.dataforms.sample.edittable");
		ef.getEditQueryClassName().setValue("SampleTable");
		
		TableTestElement table = ef.getMultiRecordQueryList();
		table.addRow();
		table.getField(0, "functionSelect").setValue("/edittable");
		table.getField(0, "queryClassName").setValue("JoinTestTable");
		ef.getDaoClassName().click();
		
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		this.saveScreenShot(browser, "daoAndPage1.png");
		ef.confirm();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		ef.save();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		p.getAlertDialog().clickOkButton();
		Browser.sleep(this.getConf().getTestApp().getBuildWait());
		this.reloadWebApp(this.getConf().getTestApp().getContextPath());
	}

	/**
	 * サンプルページ2のHTML作成。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void testDaoAndHtml(final Browser browser) throws Exception {
		browser.open(WebResourcePage.class);
		WebResourcePageTestElement p = browser.getPageTestElement(WebResourcePageTestElement.class);
		WebResourceQueryFormTestElement qf = p.getWebResourceQueryForm();
		qf.getFunctionSelect().setValue("/edittable");
		qf.getPageClassName().setValue("Sample2Page");
		qf.getClassName().setValue("Sample2Page");
		qf.getClassName().click();
		qf.query();
		Browser.sleep(this.getConf().getTestApp().getMiddleWait());
		this.saveScreenShot(browser, "page4.png");
		
		WebResourceQueryResultFormTestElement qrf = p.getWebResourceQueryResultForm();
		TableTestElement table = qrf.getTable("queryResult");
		table.getField(0, "className").click();
		WebResourceFormTestElement wrf = p.getWebResourceDialog().getWebResourceForm();
		wrf.getButton("generateHtml").click();
		Browser.sleep(this.getConf().getTestApp().getMiddleWait());
		p.getAlertDialog().clickOkButton();
		wrf.getField("outputFormHtml").click();

		String imgfile = this.saveScreenShot(browser, "page3.png");
		ImageEditor.addMarkRect(imgfile, 580, 346, 780, 368);
		ImageEditor.addMarkRect(imgfile, 1142, 317, 1186, 348);
		wrf.getButton("closeButton").click();
		
		WebAppProject proj = WebAppProject.newWebAppProject(this.getConf());
		proj.copyTestApi();
		Browser.sleep(this.getConf().getTestApp().getBuildWait());
		this.reloadWebApp(this.getConf().getTestApp().getContextPath());
		
	}
	
	/**
	 * Sample2Pageの動作。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void showSample2Page(final Browser browser) throws Exception {
		WebAppProject proj = WebAppProject.newWebAppProject(this.getConf());
		String url = proj.getUrl() + "edittable/page/Sample2Page.html";
		browser.open(url);
		PageTestElement p = browser.getPageTestElement();
		QueryFormTestElement qf = p.getQueryForm();
		qf.newData();
		EditFormTestElement ef = p.getEditForm();
		ef.setValue("sampleText", "text");
		ef.setValue("sampleNumeric", "123.00");
		ef.setValue("sampleDate", "2023/01/02");
		ef.setValue("sampleSelect", "1");
		TableTestElement table = ef.getTable("joinTestList");
		table.addRow();
		table.addRow();
		table.getField(0, "joinTestText").setValue("row1");
		table.getField(1, "joinTestText").setValue("row2");
		String imgfile = this.saveScreenShot(browser, "page2.png");
		ImageEditor.addMarkRect(imgfile, 240, 224, 556, 366);
		
	}

	
	/**
	 * カラム固定テーブルのテスト。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void testColumnFixedTable(final Browser browser) throws Exception {
		WebAppProject proj = WebAppProject.newWebAppProject(this.getConf());
		proj.copyJavaSrc("/jp/dataforms/sample/edittable/page/Sample2QueryResultForm.java", "/jp/dataforms/sample/edittable/page/Sample2QueryResultForm.java");
		proj.copyWebappSrc("/edittable/page/Sample2Page.html", "/edittable/page/Sample2Page.html");
		Browser.sleep(this.getConf().getTestApp().getBuildWait());
		this.reloadWebApp(this.getConf().getTestApp().getContextPath());
		
		String url = proj.getUrl() + "edittable/page/Sample2Page.html";
		PageTestElement p = browser.open(url);
		p.getQueryForm().query();
		Browser.sleep(this.getConf().getTestApp().getMiddleWait());
		browser.setSize(new Dimension(800, 800));
		Browser.sleep(this.getConf().getTestApp().getMiddleWait());
		
		FormTestElement qrf = p.getForm("queryResultForm");
		TableTestElement table = qrf.getTable("queryResult");
		table.getField(0, "sampleNumeric").click();
		WebDriver driver = browser.getWebDriver();
		JavascriptExecutor exec = (JavascriptExecutor) driver;
		exec.executeScript("document.getElementById('mainDiv.queryResultForm.queryResult').scrollLeft = 50;");
		this.saveScreenShot(browser, "table1.png");
	}
	
	/**
	 * フィールドリスト。
	 */
	private static String[][] FIELD_LIST = {
		{"sample.field", "MultiTestIdField", "RecordIdField", null, "レコードID" },
		{"jp.dataforms.fw.field.common", "SortOrderField", null, null, null },
		{"sample.field", "Code1Field", "VarcharField", "8", "コード1" },
		{"sample.field", "Code2Field", "VarcharField", "8", "コード2" },
		{"sample.field", "MultiTextField", "VarcharField", "64", "テキスト" },
	};
	

	/**
	 * MultiTestTableの作成。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void makeMultiTestTable(final Browser browser) throws Exception {
		browser.open(TableGeneratorPage.class);
		TableGeneratorPageTestElement p = browser.getPageTestElement(TableGeneratorPageTestElement.class);
		p.getQueryForm().newData();
		TableGeneratorEditFormTestElement ef = p.getTableGeneratorEditForm();
		ef.getFunctionSelect().setValue("/edittable");
		ef.getTableClassName().setValue("MultiTestTable");
		ef.getTableComment().setValue("複数レコード編集テスト");
		TableTestElement table = ef.getTable("fieldList");
		table.addRow();
		table.addRow();
		table.addRow();
		table.addRow();
		table.addRow();
		for (int i = 0; i < FIELD_LIST.length; i++) {
			table.getField(i, "packageName").setValue(FIELD_LIST[i][0]);
			table.getField(i, "fieldClassName").setValue(FIELD_LIST[i][1]);
			if (FIELD_LIST[i][2] != null) {
					table.getField(i, "superSimpleClassName").setValue(FIELD_LIST[i][2]);
			}
			if (FIELD_LIST[i][3] != null) {
				table.getField(i, "fieldLength").setValue(FIELD_LIST[i][3]);
			}
			if (FIELD_LIST[i][4] != null) {
				table.getField(i, "comment").setValue(FIELD_LIST[i][4]);
			}
			if (i == 0) {
				table.getField(i, "pkFlag").click();
				table.getField(i, "notNullFlag").click();
			}
		}
		ef.getField("tableClassName").click();
		browser.setSize(new Dimension(1700, 720));
		this.saveScreenShot(browser, "mtable.png");
		ef.getField("overwriteMode").setValue("force");
		ef.getButton("allForceOverwriteButton").click();
		ef.confirm();
		ef.save();
		p.getAlertDialog().clickOkButton();
		Browser.sleep(this.getConf().getTestApp().getBuildWait());
		this.reloadWebApp(this.getConf().getTestApp().getContextPath());
	}

	
	/**
	 * テーブルクラスに対応したテーブルにDBを作成します。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void createMultiTestTable(final Browser browser) throws Exception {
		browser.open(TableManagementPage.class);
		TableManagementPageTestElement p = browser.getPageTestElement(TableManagementPageTestElement.class);
		QueryFormTestElement qf = p.getQueryForm();
		qf.getField("functionSelect").setValue("/edittable");
		qf.query();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		TableManagementQueryResultFormTestElement qrf = p.getTableManagementQueryResultForm();
		qrf.getSelectDiffButton().click();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		qrf.getUpdateTableButton().click();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		p.getConfirmDialog().clickOkButton();
//		this.getWebAppProject().update();
	}
	
	/**
	 * MultiTestCode1Queryの作成。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void makeCode1CountQuery(final Browser browser) throws Exception {
		WebAppProject proj = WebAppProject.newWebAppProject(this.getConf());
		proj.copyJavaSrc("/jp/dataforms/sample/edittable/dao/MultiTestCode1Query.java", "/jp/dataforms/sample/edittable/dao/MultiTestCode1Query.java");
		Browser.sleep(this.getConf().getTestApp().getBuildWait());

		browser.open(QueryGeneratorPage.class);
		QueryGeneratorPageTestElement p = browser.getPageTestElement(QueryGeneratorPageTestElement.class); 
		browser.setSize(new Dimension(1400, 800));
		QueryGeneratorQueryFormTestElement qf = p.getQueryGeneratorQueryForm();
		qf.getFunctionSelect().setValue("/edittable");
		qf.getQueryClassName().setValue("MultiTestCode1Query");
		qf.getPackageName().click();
		qf.query();
		Browser.sleep(this.getConf().getTestApp().getMiddleWait());

		QueryGeneratorQueryResultFormTestElement qrf = p.getQueryGeneratorQueryResultForm();
		TableTestElement queryResult = qrf.getQueryResult();
		queryResult.getField(0, "fullClassName").click();
//		browser.saveResizedScreenShot("/3.2.page/mquery.png");
		this.saveScreenShot(browser, "mquery.png");
	}
	
	/**
	 * 複数レコード編集ページの作成。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void makeMultiPage(final Browser browser) throws Exception {
		browser.maximize();
		browser.open(DaoAndPageGeneratorPage.class);
		DaoAndPageGeneratorPageTestElement p = browser.getPageTestElement(DaoAndPageGeneratorPageTestElement.class);
		p.getQueryForm().newData();
		DaoAndPageGeneratorEditFormTestElement ef = p.getDaoAndPageGeneratorEditForm();
		ef.getPagePattern().setValue("p3112");
		ef.getFunctionSelect().setValue("/edittable");
		ef.getPageName().setValue("複数レコード編集ページ");
		ef.getPackageName().setValue("jp.dataforms.sample.edittable.page");
		ef.getPageClassName().setValue("MultiTestPage");
		ef.getDaoPackageName().setValue("jp.dataforms.sample.edittable.dao");
		ef.setValue("daoClassName", "MultiTestDao");
		ef.getDaoClassName().setValue("MultiTestDao");
		ef.getListQueryFunctionSelect().setValue("/edittable");
		ef.getListQueryPackageName().setValue("jp.dataforms.sample.edittable.dao");
		ef.getListQueryClassName().setValue("MultiTestCode1Query");
		ef.getEditQueryFunctionSelect().setValue("/edittable");
		ef.getEditQueryPackageName().setValue("jp.dataforms.sample.edittable.dao");
		ef.getEditQueryClassName().setValue("MultiTestTable");
		ef.getPackageName().click();
		{
			String imgfile = this.saveScreenShot(browser, "genmpage1.png");
			ImageEditor.addMarkRect(imgfile, 1044, 648, 1156, 679);
		}
		ef.getButton("editQueryButton").click();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		DialogTestElement dlg = p.getDialog("fieldListDialog");
		FormTestElement f = dlg.getForm("fieldListForm");
		TableTestElement t = f.getTable("fieldList");
		t.getField(0, "editKey").click();
		t.getField(2, "editKey").click();
		{
			String imgfile = this.saveScreenShot(browser, "genmpage2.png");
			ImageEditor.addMarkRect(imgfile, 822, 345, 855, 644);
		}
		f.getButton("okButton").click();
		ef.confirm();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		ef.save();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		p.getAlertDialog().clickOkButton();
	}
	
	/**
	 * HTML作成。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void makeMultiTestHtml(final Browser browser) throws Exception {
		browser.open(WebResourcePage.class);
		WebResourcePageTestElement p = browser.getPageTestElement(WebResourcePageTestElement.class);
		WebResourceQueryFormTestElement qf = p.getWebResourceQueryForm();
		qf.getField("functionSelect").setValue("/edittable");
		qf.getField("packageName").setValue("jp.dataforms.sample.edittable");
		qf.getField("pageClassName").setValue("MultiTestPage");
		qf.getField("className").click();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		qf.getButton("uncheckAllTypeButton").click();
		qf.getField("webComponentTypeList[0]").click();
		qf.query();
		Browser.sleep(this.getConf().getTestApp().getLongWait());
		WebResourceQueryResultFormTestElement qrf = p.getWebResourceQueryResultForm();
		TableTestElement table = qrf.getTable("queryResult");
		table.getField(0, "className").click();
		
		DialogTestElement dlg = p.getDialog("webResourceDialog");
		FormTestElement webResourceForm = dlg.getForm("webResourceForm");
		webResourceForm.getField("forceOverwrite").click();
		webResourceForm.getButton("generateHtml").click();
		Browser.sleep(this.getConf().getTestApp().getLongWait());

		p.getAlertDialog().clickOkButton();
		webResourceForm.getButton("closeButton").click();
		
		WebAppProject proj = WebAppProject.newWebAppProject(this.getConf());
		proj.copyTestApi();
		Browser.sleep(this.getConf().getTestApp().getBuildWait());
		this.reloadWebApp(this.getConf().getTestApp().getContextPath());
	}
	
	/**
	 * テストデータを作成する。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void makeMultiTestData(final Browser browser) throws Exception {
		List<String> sqlList = new ArrayList<String>();
		sqlList.add("delete from multi_test");
		sqlList.add("insert into multi_test values(1, 0, 'aaa', '111', 'atext1', 1, current_timestamp, 1, current_timestamp)");
		sqlList.add("insert into multi_test values(2, 1, 'aaa', '222', 'atext2', 1, current_timestamp, 1, current_timestamp)");
		sqlList.add("insert into multi_test values(3, 2, 'aaa', '333', 'atext3', 1, current_timestamp, 1, current_timestamp)");
		sqlList.add("insert into multi_test values(4, 0, 'bbb', '111', 'btext1', 1, current_timestamp, 1, current_timestamp)");
		sqlList.add("insert into multi_test values(5, 1, 'bbb', '222', 'btext2', 1, current_timestamp, 1, current_timestamp)");
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("sqlList", sqlList);
		WebAppProject proj = WebAppProject.newWebAppProject(this.getConf());
		String url = proj.getUrl() + "test/api/UpdateTableApi.api";
		@SuppressWarnings("unchecked")
		Map<String, Object> response = (Map<String, Object>) this.callApi(url, p);
		logger.debug("status=" + response.get("status"));
	}
	
	/**
	 * 複数レコード編集ページのテスト。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void showMultiTestPage(final Browser browser) throws Exception {
		WebAppProject proj = WebAppProject.newWebAppProject(this.getConf());
		String url = proj.getUrl() + "edittable/page/MultiTestPage.html";
		PageTestElement p = browser.open(url);
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		p.getQueryForm().query();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		this.saveScreenShot(browser, "mpage1.png");
		FormTestElement qrf = p.getForm("queryResultForm");
		TableTestElement table = qrf.getTable("queryResult");
		table.getField(0, "code1").click();
		this.saveScreenShot(browser, "mpage2.png");
	}

	
	/**
	 * multi_testのデータの確認。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void showMultiTestData(final Browser browser) throws Exception {
		WebAppProject proj = WebAppProject.newWebAppProject(this.getConf());
		String url = proj.getUrl() + "dataforms/devtool/query/page/QueryExecutorPage.html?t=multi_test";
		PageTestElement p = browser.open(url);
		p.getQueryForm().query();
		this.saveScreenShot(browser, "mdata.png");
//		browser.saveResizedScreenShot("/3.2.page/mdata.png");
//		browser.saveResizedScreenShot("/3.4.report/data.png");
	}

	/**
	 * バリデーションのテスト。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void showMultiRecValidator(final Browser browser) throws Exception {
		WebAppProject proj = WebAppProject.newWebAppProject(this.getConf());
		proj.copyJavaSrc("/jp/dataforms/sample/edittable/page/MultiTestEditForm.java", "/jp/dataforms/sample/edittable/page/MultiTestEditForm.java");
		Browser.sleep(30);
		this.reloadWebApp(this.getConf().getTestApp().getContextPath());
		String url = proj.getUrl() + "edittable/page/MultiTestPage.html";
		PageTestElement p = browser.open(url);
		p.getQueryForm().newData();
		EditFormTestElement ef = p.getEditForm();
		TableTestElement table = ef.getTable("multiTestList");
		table.addRow();
		//ef.getButton(EditForm.ID_CONFIRM_BUTTON).click();
		ef.confirm();
		this.saveScreenShot(browser, "mpage3.png");
	}

	
	@Override
	public void exec() throws Exception {
		WebAppProject proj = WebAppProject.newWebAppProject(this.getConf());
		this.dropTables("multi_test");
		proj.loadSnapshot("step03");
		proj.importDb("step03", "jp.dataforms.fw.app", "jp.dataforms.sample.edittable");
		this.reloadWebApp(this.getConf().getTestApp().getContextPath());
		Browser browser = this.getBrowser();
		this.login(browser, "developer");
		this.testDaoAndPage(browser);
		this.testDaoAndHtml(browser);
		proj.copyTestApi();
		Browser.sleep(this.getConf().getTestApp().getBuildWait());
		this.reloadWebApp(this.getConf().getTestApp().getContextPath());
		this.showSample2Page(browser);
		this.testColumnFixedTable(browser);
		this.makeMultiTestTable(browser);
		this.createMultiTestTable(browser);
		this.makeCode1CountQuery(browser);
		this.makeMultiPage(browser);
		this.makeMultiTestHtml(browser);
		this.makeMultiTestData(browser);
		this.showMultiTestPage(browser);
		this.showMultiTestData(browser);
		this.showMultiRecValidator(browser);
		browser.close();
		logger.info(this.getDocumentPath() + "取得終了");
	}
}
