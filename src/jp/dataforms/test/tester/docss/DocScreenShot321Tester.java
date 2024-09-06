package jp.dataforms.test.tester.docss;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import jp.dataforms.fw.devtool.pageform.page.DaoAndPageGeneratorPage;
import jp.dataforms.fw.devtool.webres.page.WebResourcePage;
import jp.dataforms.test.element.controller.EditFormTestElement;
import jp.dataforms.test.element.controller.FormTestElement;
import jp.dataforms.test.element.controller.PageTestElement;
import jp.dataforms.test.element.controller.QueryFormTestElement;
import jp.dataforms.test.element.devtool.pageform.page.DaoAndPageGeneratorEditFormTestElement;
import jp.dataforms.test.element.devtool.pageform.page.DaoAndPageGeneratorPageTestElement;
import jp.dataforms.test.element.devtool.pageform.page.PageGeneratorQueryFormTestElement;
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
		ImageEditor.addMarkRect(imgfile, 1208, 526, 1256, 562);
		ImageEditor.addMarkRect(imgfile, 698, 556, 902, 582);
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
//		browser.close();
		logger.info(this.getDocumentPath() + "取得終了");
	}
}
