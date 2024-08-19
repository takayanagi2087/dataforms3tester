package jp.dataforms.test.tester.docss;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;

import jp.dataforms.fw.devtool.db.page.TableManagementPage;
import jp.dataforms.fw.devtool.query.page.QueryGeneratorPage;
import jp.dataforms.fw.devtool.table.page.TableGeneratorPage;
import jp.dataforms.test.element.devtool.db.page.TableManagementPageTestElement;
import jp.dataforms.test.element.devtool.db.page.TableManagementQueryFormTestElement;
import jp.dataforms.test.element.devtool.db.page.TableManagementQueryResultFormTestElement;
import jp.dataforms.test.element.devtool.query.page.QueryGeneratorEditFormTestElement;
import jp.dataforms.test.element.devtool.query.page.QueryGeneratorPageTestElement;
import jp.dataforms.test.element.devtool.query.page.QueryGeneratorQueryFormTestElement;
import jp.dataforms.test.element.devtool.table.page.TableGeneratorEditFormTestElement;
import jp.dataforms.test.element.devtool.table.page.TableGeneratorPageTestElement;
import jp.dataforms.test.element.devtool.table.page.TableGeneratorQueryFormTestElement;
import jp.dataforms.test.element.htmltable.TableTestElement;
import jp.dataforms.test.proj.WebAppProject;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.util.ImageEditor;

/**
 * 「2.5.問合せクラスの作成」のスクリーンショットを取得するツール。
 */
public class DocScreenShot311Tester extends DocScreenShotTester {
	
	/**
	 * Logger.
	 */
	private static Logger logger = LogManager.getLogger(DocScreenShot251Tester.class);

	/**
	 * コンストラクタ。
	 */
	public DocScreenShot311Tester() {
		super("3.1.dao");
	}

	
	/**
	 * フィールドリスト。
	 */
	private static final String[][] FIELD_LIST = {
			{ "JoinTestIdField", "RecordIdField", "", "join test ID" },
			{ "SampleIdField", "RecordIdField", "", "レコードID" },
			{ "JoinTestTextField", "VarcharField", "64", "テキスト" },
	};

	/**
	 * フィールドリストを設定します。
	 * @param ef EditForm。
	 */
	private void setFieldList(final TableGeneratorEditFormTestElement ef) {
		TableTestElement t = ef.getFieldList();
		for (int i = 0; i < FIELD_LIST.length; i++) {
			t.addRow();
		}
		for (int i = 0; i < FIELD_LIST.length; i++) {
			t.getField(i, "fieldClassName").setValue(FIELD_LIST[i][0]);
			t.getField(i, "superSimpleClassName").setValue(FIELD_LIST[i][1]);
			t.getField(i, "fieldLength").setValue(FIELD_LIST[i][2]);
			t.getField(i, "comment").setValue(FIELD_LIST[i][3]);
		}
		t.getField(0, "pkFlag").click();
		t.getField(0, "notNullFlag").click();
	}
	
	/**
	 * 結合対象のテーブル作成します。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void makeJoinTestTable(final Browser browser) throws Exception {
		browser.open(TableGeneratorPage.class);
		browser.setClientSize(new Dimension(1700, 600));
		TableGeneratorPageTestElement p = browser.getPageTestElement(TableGeneratorPageTestElement.class);
		TableGeneratorQueryFormTestElement qf = p.getQueryForm(TableGeneratorQueryFormTestElement.class);
		qf.newData();
		TableGeneratorEditFormTestElement ef = p.getTableGeneratorEditForm();
		ef.getFunctionSelect().setValue("/edittable");
		ef.getTableClassName().setValue("JoinTestTable");
		ef.getTableComment().setValue("結合テストテーブル");
		this.setFieldList(ef);
		ef.confirm();
		ef.getButton("errorSkipButton").click();
		ef.confirm();
		ef.save();
		p.getAlertDialog().clickOkButton();
		Browser.sleep(this.getConf().getTestApp().getBuildWait());
		this.reloadWebApp(this.getConf().getTestApp().getContextPath());
	}

	
	/**
	 * FKの作成。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void createJoinTestTable(final Browser browser) throws Exception {
//		WebAppProject proj = WebAppProject.newWebAppProject(this.getConf());
		browser.open(TableManagementPage.class);
		TableManagementPageTestElement p = browser.getPageTestElement(TableManagementPageTestElement.class);
		TableManagementQueryFormTestElement qf = p.getTableManagementQueryForm();
		qf.getFunctionSelect().setValue("/edittable");
		p.getQueryForm().query();
		browser.setSize(new Dimension(1600, 800));
		TableManagementQueryResultFormTestElement qrf = p.getTableManagementQueryResultForm();
		qrf.getButton("updateTableButton").click();
		p.getConfirmDialog().clickOkButton();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
	}

	/**
	 * FKの作成。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void createFk(final Browser browser) throws Exception {
		WebAppProject proj = WebAppProject.newWebAppProject(this.getConf());
		proj.copyJavaSrc("/jp/dataforms/sample/edittable/dao/JoinTestTableRelation.java", "/jp/dataforms/sample/edittable/dao/JoinTestTableRelation.java");
		Browser.sleep(this.getConf().getTestApp().getBuildWait());
		browser.open(TableManagementPage.class);
		TableManagementPageTestElement p = browser.getPageTestElement(TableManagementPageTestElement.class);
		TableManagementQueryFormTestElement qf = p.getTableManagementQueryForm();
		qf.getFunctionSelect().setValue("/edittable");
		p.getQueryForm().query();
		browser.setSize(new Dimension(1600, 800));
		TableManagementQueryResultFormTestElement qrf = p.getTableManagementQueryResultForm();
		qrf.getButton("selectDiffButton").click();
		String imgfile = this.saveScreenShot(browser, "fkey.png");
		ImageEditor.addMarkRect(imgfile, 242, 426, 1486, 458);
		ImageEditor.addMarkRect(imgfile, 242, 486, 286, 526);
		qrf.getButton("updateTableButton").click();
		p.getConfirmDialog().clickOkButton();
		Browser.sleep(5);
	}

	/**
	 * JoinSueryを作成する。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void createJoinQuery(final Browser browser) throws Exception {
	//	WebAppProject proj = WebAppProject.newWebAppProject(this.getConf());
		browser.open(QueryGeneratorPage.class);
		QueryGeneratorPageTestElement p = browser.getPageTestElement(QueryGeneratorPageTestElement.class);
		QueryGeneratorQueryFormTestElement qf = p.getQueryGeneratorQueryForm();
		qf.newData();
		QueryGeneratorEditFormTestElement ef = p.getQueryGeneratorEditForm();
		ef.getFunctionSelect().setValue("/edittable");
		ef.getQueryClassName().setValue("JoinTestQuery");
		ef.getQueryComment().setValue("Joinテスト問合せ");
		ef.getMainTableFunctionSelect().setValue("/edittable");
		ef.getMainTableClassName().setValue("JoinTestTable");
		ef.getQueryClassName().click();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		TableTestElement joinTableList = ef.getJoinTableList();
		joinTableList.addRow();
		joinTableList.setValue(0, "functionSelect", "/edittable");
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		joinTableList.setValue(0, "tableClassName", "SampleTable");
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		ef.getField("queryClassName").click();
		ef.getButton("selectAll").click();
		String img = this.saveScreenShot(browser, "query.png");
		ImageEditor.addMarkRect(img , 1170, 408, 1473, 480);
		ef.confirm();
		ef.save();
		p.getAlertDialog().clickOkButton();
		Browser.sleep(this.getConf().getTestApp().getBuildWait());
		this.reloadWebApp(this.getConf().getTestApp().getContextPath());
		browser.setClientSize(new Dimension(1024, 600));
		qf.getFunctionSelect().setValue("/edittable");
		qf.getQueryClassName().setValue("JoinTestQuery");
		qf.getField("packageName").click();
		Browser.sleep(this.getConf().getTestApp().getLongWait());
		qf.query();
		String imgfile = this.saveScreenShot(browser, "subquery.png");
		ImageEditor.addMarkRect(imgfile , 702, 298, 795, 332);
	}
	
	/**
	 * 集計問合せの作成する。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void createGroupByQuery(final Browser browser) throws Exception {
		browser.setSize(new Dimension(1600, 800));
		browser.open(QueryGeneratorPage.class);
		QueryGeneratorPageTestElement p = browser.getPageTestElement(QueryGeneratorPageTestElement.class);
		QueryGeneratorQueryFormTestElement qf = p.getQueryGeneratorQueryForm();
		qf.newData();
		QueryGeneratorEditFormTestElement ef = p.getQueryGeneratorEditForm();
		ef.getFunctionSelect().setValue("/edittable");
		ef.getQueryClassName().setValue("TestQuery");
		ef.getQueryComment().setValue("別名、集計テスト");		
		ef.getMainTableFunctionSelect().setValue("/edittable");
		ef.getMainTableClassName().setValue("SampleTable");
		ef.getQueryClassName().click();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		TableTestElement selectFieldList = ef.getSelectFieldList();
		selectFieldList.setValue(0, "sel", "jp.dataforms.fw.field.sqlfunc.CountField");
		selectFieldList.setValue(4, "sel", "1");
		selectFieldList.setValue(4, "alias", "sel");
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		this.saveScreenShot(browser, "alias.png");
		ef.confirm();
		ef.save();
		p.getAlertDialog().clickOkButton();
		Browser.sleep(this.getConf().getTestApp().getBuildWait());
		
	}

	
	/**
	 * SqlFieldのサンプル問合せ作成。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void createSqlfuncQuery(final Browser browser) throws Exception {
		browser.setSize(new Dimension(1600, 800));
		browser.open(QueryGeneratorPage.class);
		QueryGeneratorPageTestElement p = browser.getPageTestElement(QueryGeneratorPageTestElement.class);
		QueryGeneratorQueryFormTestElement qf = p.getQueryGeneratorQueryForm();
		qf.newData();
		QueryGeneratorEditFormTestElement ef = p.getQueryGeneratorEditForm();
		ef.getFunctionSelect().setValue("/edittable");
		ef.getQueryClassName().setValue("Test2Query");
		ef.getQueryComment().setValue("SQLフィールドテスト");
		ef.getMainTableFunctionSelect().setValue("/edittable");
		ef.getMainTableClassName().setValue("SampleTable");
		ef.getQueryClassName().click();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		TableTestElement selectFieldList = ef.getSelectFieldList();
		selectFieldList.setValue(0, "sel", "1");
		selectFieldList.setValue(1, "sel", "1");
		Browser.sleep(this.getConf().getTestApp().getShortWait());

		TableTestElement sqlFieldList = ef.getSqlFieldList();
		sqlFieldList.addRow();
		sqlFieldList.setValue(0, "fieldId", "sampleNumeric2");
		sqlFieldList.setValue(0, "fieldClassName", "jp.dataforms.fw.field.sqltype.NumericField");
		sqlFieldList.setValue(0, "fieldLength", "10,2");
		sqlFieldList.setValue(0, "sql", "m.sample_numeric * 2");
		this.saveScreenShot(browser, "sqlfield.png");
		ef.confirm();
		ef.save();
		p.getAlertDialog().clickOkButton();
		Browser.sleep(this.getConf().getTestApp().getBuildWait());
		
	}

	
	@Override
	public void exec() throws Exception {
		WebAppProject proj = WebAppProject.newWebAppProject(this.getConf());
		this.dropTables("join_test");
		proj.loadSnapshot("step02");
		proj.copyWebappSrc("/WEB-INF/dataforms.conf.jsonc", "/WEB-INF/dataforms.conf.jsonc");
		proj.copyTestApi();
		Browser.sleep(this.getConf().getTestApp().getBuildWait());
		this.reloadWebApp(this.getConf().getTestApp().getContextPath());
		
		proj.importDb("step02", "jp.dataforms.fw.app", "jp.dataforms.sample.edittable");
		Browser browser = this.getBrowser();
		this.login(browser, "developer");
		this.makeJoinTestTable(browser);
		this.createJoinTestTable(browser);
		this.createFk(browser);
		this.createJoinQuery(browser);
		this.createGroupByQuery(browser);
		this.createSqlfuncQuery(browser);
		
		browser.close();
		logger.info(this.getDocumentPath() + "取得終了");
	}
}
