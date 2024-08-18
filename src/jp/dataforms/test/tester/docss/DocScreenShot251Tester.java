package jp.dataforms.test.tester.docss;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;

import jp.dataforms.fw.devtool.query.page.QueryExecutorPage;
import jp.dataforms.fw.devtool.query.page.QueryGeneratorPage;
import jp.dataforms.test.element.devtool.query.page.QueryExecutorPageTestElement;
import jp.dataforms.test.element.devtool.query.page.QueryExecutorQueryFormTestElement;
import jp.dataforms.test.element.devtool.query.page.QueryGeneratorEditFormTestElement;
import jp.dataforms.test.element.devtool.query.page.QueryGeneratorPageTestElement;
import jp.dataforms.test.element.devtool.query.page.QueryGeneratorQueryFormTestElement;
import jp.dataforms.test.element.htmltable.TableTestElement;
import jp.dataforms.test.proj.WebAppProject;
import jp.dataforms.test.selenium.Browser;

/**
 * 「2.5.問合せクラスの作成」のスクリーンショットを取得するツール。
 */
public class DocScreenShot251Tester extends DocScreenShotTester {
	
	/**
	 * Logger.
	 */
	private static Logger logger = LogManager.getLogger(DocScreenShot251Tester.class);

	/**
	 * コンストラクタ。
	 */
	public DocScreenShot251Tester() {
		super("2.5.query");
	}
	
	/**
	 * 問合せを作成します。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void createQuer(final Browser browser) throws Exception {
		browser.open(QueryGeneratorPage.class);
		browser.setClientSize(new Dimension(1600, 800));
		QueryGeneratorPageTestElement p = browser.getPageTestElement(QueryGeneratorPageTestElement.class);
		QueryGeneratorQueryFormTestElement qf = p.getQueryGeneratorQueryForm();
		qf.newData();
		QueryGeneratorEditFormTestElement ef = p.getQueryGeneratorEditForm();
		ef.getFunctionSelect().setValue("/edittable");
		ef.getQueryClassName().setValue("Enum01Query");
		ef.getQueryComment().setValue("単純な結合問合わせ");
		ef.getMainTableFunctionSelect().setValue("/dataforms/app");
		ef.getMainTableClassName().setValue("EnumTable");
		ef.getQueryClassName().click();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		TableTestElement t = ef.getJoinTableList();
		t.addRow();
		t.getField(0, "functionSelect").setValue("/dataforms/app");
		t.getField(0, "tableClassName").setValue("EnumNameTable");
		ef.getQueryClassName().click();
		Browser.sleep(this.getConf().getTestApp().getMiddleWait());
		ef.getButton("selectAll").click();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		this.saveScreenShot(browser, "simpleJoin.png");
		ef.confirm();
		ef.save();
		p.getAlertDialog().clickOkButton();
		Browser.sleep(this.getConf().getTestApp().getBuildWait());
		this.reloadWebApp(this.getConf().getTestApp().getContextPath());
	}

	/**
	 * 問合せの実行テスト。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void executeQuer(final Browser browser) throws Exception {
		browser.open(QueryExecutorPage.class);
		QueryExecutorPageTestElement p = browser.getPageTestElement(QueryExecutorPageTestElement.class);
		QueryExecutorQueryFormTestElement qf = p.getQueryExecutorQueryForm();
		qf.getFunctionSelect().setValue("/edittable");
		qf.getQueryClassName().setValue("Enum01Query");
		qf.getSql().click();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		qf.query();
		browser.maximize();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		this.saveScreenShot(browser, "queryExec.png");
	}
	
	
	/**
	 * 問合せ2を作成します。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void createQuer2(final Browser browser) throws Exception {
		browser.open(QueryGeneratorPage.class);
		browser.setClientSize(new Dimension(1600, 800));
		QueryGeneratorPageTestElement p = browser.getPageTestElement(QueryGeneratorPageTestElement.class);
		QueryGeneratorQueryFormTestElement qf = p.getQueryGeneratorQueryForm();
		qf.newData();
		QueryGeneratorEditFormTestElement ef = p.getQueryGeneratorEditForm();
		ef.getFunctionSelect().setValue("/edittable");
		ef.getQueryClassName().setValue("Enum02Query");
		ef.getQueryComment().setValue("複雑な結合問合わせ");
		ef.getMainTableFunctionSelect().setValue("/dataforms/app");
		ef.getMainTableClassName().setValue("EnumTable");
		ef.getQueryClassName().click();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		TableTestElement t = ef.getJoinTableList();
		t.addRow();
		t.addRow();
		t.addRow();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		t.setValue(0, "functionSelect", "/dataforms/app");
		t.setValue(0, "tableClassName", "EnumTable");
		t.setValue(0, "aliasName", "p");
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		t.setValue(1, "functionSelect", "/dataforms/app");
		t.setValue(1, "tableClassName", "EnumNameTable");
		t.setValue(1, "aliasName", "nm");
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		t.setValue(2, "functionSelect", "/dataforms/app");
		t.setValue(2, "tableClassName", "EnumNameTable");
		t.setValue(2, "aliasName", "pnm");
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		ef.getQueryClassName().click();
		Browser.sleep(this.getConf().getTestApp().getMiddleWait());
		ef.getButton("selectAll").click();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		
		TableTestElement ft = ef.getSelectFieldList();
		ft.setValue(13, "sel", "1");
		ft.setValue(13, "alias", "parentCode");
		ft.setValue(22, "sel", "1");
		ft.setValue(29, "sel", "1");
		ft.setValue(29, "alias", "parentName");
		this.saveScreenShot(browser, "complexquery.png");
		ef.confirm();
		ef.save();
		p.getAlertDialog().clickOkButton();
		Browser.sleep(this.getConf().getTestApp().getBuildWait());
		this.reloadWebApp(this.getConf().getTestApp().getContextPath());
	}
	
	/**
	 * 問合せの実行テスト。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void executeQuer2(final Browser browser) throws Exception {
		browser.open(QueryExecutorPage.class);
		QueryExecutorPageTestElement p = browser.getPageTestElement(QueryExecutorPageTestElement.class);
		QueryExecutorQueryFormTestElement qf = p.getQueryExecutorQueryForm();
		qf.getFunctionSelect().setValue("/edittable");
		qf.getQueryClassName().setValue("Enum02Query");
		qf.getSql().click();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		qf.query();
		browser.maximize();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		this.saveScreenShot(browser, "queryExec2.png");
	}
	

	@Override
	public void exec() throws Exception {
		WebAppProject proj = WebAppProject.newWebAppProject(this.getConf());
		proj.importDb("step02", "jp.dataforms.fw.app", "jp.dataforms.sample.edittable");
		proj.loadSnapshot("step02");
		this.reloadWebApp(this.getConf().getTestApp().getContextPath());
		Browser browser = this.getBrowser();
		this.login(browser, "developer");
		this.createQuer(browser);
		this.executeQuer(browser);
		this.createQuer2(browser);
		proj.copyJavaSrc("/jp/dataforms/sample/edittable/dao/Enum02Query.java", "/jp/dataforms/sample/edittable/dao/Enum02Query.java");
		Browser.sleep(this.getConf().getTestApp().getBuildWait());
		this.reloadWebApp(this.getConf().getTestApp().getContextPath());
		this.executeQuer2(browser);
		browser.close();
		logger.info(this.getDocumentPath() + "取得終了");
	}
}
