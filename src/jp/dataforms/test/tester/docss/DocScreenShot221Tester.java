package jp.dataforms.test.tester.docss;

import org.openqa.selenium.Dimension;

import jp.dataforms.fw.app.menu.page.SiteMapPage;
import jp.dataforms.fw.devtool.db.page.TableManagementPage;
import jp.dataforms.fw.devtool.menu.page.MenuEditPage;
import jp.dataforms.fw.devtool.pageform.page.DaoAndPageGeneratorPage;
import jp.dataforms.fw.devtool.table.page.TableGeneratorPage;
import jp.dataforms.fw.devtool.webres.page.WebResourcePage;
import jp.dataforms.test.element.controller.EditFormTestElement;
import jp.dataforms.test.element.controller.PageTestElement;
import jp.dataforms.test.element.controller.QueryFormTestElement;
import jp.dataforms.test.element.controller.QueryResultFormTestElement;
import jp.dataforms.test.element.devtool.db.page.TableManagementPageTestElement;
import jp.dataforms.test.element.devtool.db.page.TableManagementQueryFormTestElement;
import jp.dataforms.test.element.devtool.db.page.TableManagementQueryResultFormTestElement;
import jp.dataforms.test.element.devtool.menu.page.MenuEditFormTestElement;
import jp.dataforms.test.element.devtool.menu.page.MenuEditPageTestElement;
import jp.dataforms.test.element.devtool.pageform.page.DaoAndPageGeneratorEditFormTestElement;
import jp.dataforms.test.element.devtool.pageform.page.DaoAndPageGeneratorPageTestElement;
import jp.dataforms.test.element.devtool.pageform.page.PageGeneratorQueryFormTestElement;
import jp.dataforms.test.element.devtool.table.page.TableGeneratorEditFormTestElement;
import jp.dataforms.test.element.devtool.table.page.TableGeneratorPageTestElement;
import jp.dataforms.test.element.devtool.table.page.TableGeneratorQueryFormTestElement;
import jp.dataforms.test.element.devtool.webres.page.WebResourceDialogTestElement;
import jp.dataforms.test.element.devtool.webres.page.WebResourceFormTestElement;
import jp.dataforms.test.element.devtool.webres.page.WebResourcePageTestElement;
import jp.dataforms.test.element.devtool.webres.page.WebResourceQueryFormTestElement;
import jp.dataforms.test.element.devtool.webres.page.WebResourceQueryResultFormTestElement;
import jp.dataforms.test.element.htmltable.TableTestElement;
import jp.dataforms.test.proj.WebAppProject;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.testitem.TestItem;
import jp.dataforms.test.util.ImageEditor;

/**
 * 「2.2.開発ツールでページを作成」のスクリーンショットを取得するツール。
 */
public class DocScreenShot221Tester extends DocScreenShotTester {

	/**
	 * コンストラクタ。
	 */
	public DocScreenShot221Tester() {
		super("2.2.devtool");
	}
	
	/**
	 * システム名の変更。
	 * 
	 * @param browser ブラウザ。
	 * @param proj プロジェクト。
	 * @throws Exception 例外。
	 */
	private void changeSystemName(final Browser browser, final WebAppProject proj) throws Exception {
		this.login(browser, "developer");
		Browser.sleep(TestItem.getConf().getTestApp().getMiddleWait());
		this.saveScreenShot(browser, "sitemap.png");
		this.logout(browser);
		proj.setSystemName("サンプルシステム", "Sample system");
		Browser.sleep(this.getConf().getTestApp().getBuildWait());
		this.reloadWebApp(this.getConf().getTestApp().getContextPath());
		Browser.sleep(this.getConf().getTestApp().getMiddleWait());
		browser.reload();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		String img = this.saveScreenShot(browser, "changedsystemname.png");
		ImageEditor.addMarkRect(img, 8, 10, 190, 40);
	}


	/**
	 * システム名の変更。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void editMenu(final Browser browser) throws Exception {
		this.login(browser, "developer");
		this.openPage(browser, MenuEditPage.class);
		MenuEditPageTestElement p = browser.getPageTestElement(MenuEditPageTestElement.class);
		MenuEditFormTestElement f = p.getMenuEditForm();
		this.saveScreenShot(browser, "menuedit001.png");
		f.getAppBasePackage().setValue("jp.dataforms.sample");
		TableTestElement table = f.getMenuList();
		table.addRow(0);
		table.setValue(0, "path", "/edittable");
		table.setValue(0, "defaultName", "Edit table");
		table.setValue(0, "jaName", "テーブル編集");
		String img = this.saveScreenShot(browser, "menuedit002.png");
		ImageEditor.addMarkRect(img, 220, 100, 940, 138);
		ImageEditor.addMarkRect(img, 100, 250, 869, 286);
		f.getConfirmButton().click();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		f.getSaveButton().click();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		p.getAlertDialog().clickOkButton();
		Browser.sleep(this.getConf().getTestApp().getBuildWait());
		this.reloadWebApp(this.getConf().getTestApp().getContextPath());
	}
	
	/**
	 * フィールドリスト。
	 */
	private static final String[][] FIELD_LIST = {
			{ "SampleIdField", "RecordIdField", "", "レコードID" },
			{ "SampleTextField", "VarcharField", "64", "文字列" },
			{ "SampleNumericField", "NumericField", "10,2", "数字" },
			{ "SampleDateField", "DateField", "", "日付" },
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
		for (int i = 0; i < 4; i++) {
			t.getField(i, "fieldClassName").setValue(FIELD_LIST[i][0]);
			t.getField(i, "superSimpleClassName").setValue(FIELD_LIST[i][1]);
			t.getField(i, "fieldLength").setValue(FIELD_LIST[i][2]);
			t.getField(i, "comment").setValue(FIELD_LIST[i][3]);
		}
		t.getField(0, "pkFlag").click();
		t.getField(0, "notNullFlag").click();
	}

	
	/**
	 * テーブルJavaクラス作成のスクリーンショットを所得します。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void editTable(final Browser browser) throws Exception {
		this.openPage(browser, TableGeneratorPage.class);
		browser.setClientSize(new Dimension(1700, 600));
		TableGeneratorPageTestElement p = browser.getPageTestElement(TableGeneratorPageTestElement.class);
		TableGeneratorQueryFormTestElement qf = p.getQueryForm(TableGeneratorQueryFormTestElement.class);
		qf.newData();
		TableGeneratorEditFormTestElement ef = p.getTableGeneratorEditForm();
		ef.getFunctionSelect().setValue("/edittable");
		ef.getTableClassName().setValue("SampleTable");
		ef.getTableComment().setValue("サンプルテーブル");
		this.setFieldList(ef);
		this.saveScreenShot(browser, "table1.png");
		ef.getConfirmButton().click();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		ef.getSaveButton().click();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		p.getAlertDialog().clickOkButton();
		Browser.sleep(this.getConf().getTestApp().getBuildWait());
		this.reloadWebApp(this.getConf().getTestApp().getContextPath());
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		qf.getFunctionSelect().setValue("/edittable");
		qf.query();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		browser.setClientSize(new Dimension(1200, 600));
		this.saveScreenShot(browser, "table3.png");
	}

	/**
	 * テーブルを作成します。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void createTable(final Browser browser) throws Exception {
		this.openPage(browser, TableManagementPage.class);
		browser.setClientSize(new Dimension(1600, 600));
		TableManagementPageTestElement p = browser.getPageTestElement(TableManagementPageTestElement.class);
		TableManagementQueryFormTestElement qf = p.getTableManagementQueryForm();
		qf.getFunctionSelect().setValue("/edittable");
		qf.query();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		this.saveScreenShot(browser, "table4.png");
		TableManagementQueryResultFormTestElement qrf = p.getTableManagementQueryResultForm();
		qrf.getUpdateTableButton().click();
		Browser.sleep(this.getConf().getTestApp().getMiddleWait());
		p.getConfirmDialog().clickOkButton();
		Browser.sleep(this.getConf().getTestApp().getMiddleWait());
		this.saveScreenShot(browser, "table5.png");
	}
	
	/**
	 * DAO&ページの作成。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void createDaoAndPage(final Browser browser) throws Exception {
		this.openPage(browser, DaoAndPageGeneratorPage.class);
		browser.setClientSize(new Dimension(1600, 600));
		DaoAndPageGeneratorPageTestElement p = browser.getPageTestElement(DaoAndPageGeneratorPageTestElement.class);
		PageGeneratorQueryFormTestElement qf = p.getPageGeneratorQueryForm();
		qf.newData();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		DaoAndPageGeneratorEditFormTestElement ef = p.getDaoAndPageGeneratorEditForm();
		ef.getFunctionSelect().setValue("/edittable");
		ef.getPageName().setValue("サンプルテーブル編集");
		ef.getPageClassName().setValue("SamplePage");
		ef.getDescription().setValue("テーブルsampleを編集するページ");
		ef.getListQueryFunctionSelect().setValue("/edittable");
		ef.getListQueryClassName().setValue("SampleTable");
		ef.getEditQueryFunctionSelect().setValue("/edittable");
		ef.getEditQueryClassName().setValue("SampleTable");
		this.saveScreenShot(browser, "page1.png");
		ef.getConfirmButton().click();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		ef.getSaveButton().click();
		p.getAlertDialog().clickOkButton();
		Browser.sleep(this.getConf().getTestApp().getBuildWait());
		this.reloadWebApp(this.getConf().getTestApp().getContextPath());
	}
	
	/**
	 * Webリソースの作成。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void createHtmlPage(final Browser browser) throws Exception {
		this.openPage(browser, WebResourcePage.class);
		browser.setClientSize(new Dimension(1600, 600));
		WebResourcePageTestElement p = browser.getPageTestElement(WebResourcePageTestElement.class);
		WebResourceQueryFormTestElement qf = p.getWebResourceQueryForm();
		qf.getFunctionSelect().setValue("/edittable");
		qf.getPageClassName().setValue("SamplePage");
		qf.getClassName().setValue("SamplePage");
		qf.query();
		this.saveScreenShot(browser, "page3.png");
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		WebResourceQueryResultFormTestElement qrf = p.getWebResourceQueryResultForm();
		TableTestElement t = qrf.getQueryResultTable();
		t.getField(0, "className").click();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		String img = this.saveScreenShot(browser, "page4.png");
		ImageEditor.addMarkRect(img, 1149, 286, 1195, 321);
		WebResourceDialogTestElement dlg = p.getWebResourceDialog();
		WebResourceFormTestElement frm = dlg.getWebResourceForm();
		frm.getGenerateHtmlButton().click();
		p.getAlertDialog().clickOkButton();
		frm.getCloseButton().click();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		this.reloadWebApp(this.getConf().getTestApp().getContextPath());
		this.openPage(browser, SiteMapPage.class);
		img = this.saveScreenShot(browser, "samplepage1.png");
		ImageEditor.addMarkRect(img, 240, 94, 346, 114);
	}
	
	/**
	 * サンプルページのテスト。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void testSamplePage(final Browser browser) throws Exception {
		String pageUrl = this.getConf().getTestApp().getApplicationURL() + "edittable/page/SamplePage.html";
		browser.open(pageUrl);
		this.saveScreenShot(browser, "samplepage2.png");
		PageTestElement p = browser.getPageTestElement();
		QueryFormTestElement qf = p.getQueryForm();
		qf.newData();
		EditFormTestElement ef = p.getEditForm();
		ef.getField("sampleText").setValue("aaa");
		ef.getField("sampleNumeric").setValue("1234.56");
		ef.getField("sampleDate").setValue("2024/07/23");
		this.saveScreenShot(browser, "samplepage3.png");
		ef.confirm();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		this.saveScreenShot(browser, "samplepage4.png");
		ef.save();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		p.getAlertDialog().clickOkButton();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		qf.query();
		Browser.sleep(this.getConf().getTestApp().getMiddleWait());
		this.saveScreenShot(browser, "samplepage5.png");
		QueryResultFormTestElement qrf = p.getQueryResultForm();
		qrf.getQueryResultTable().getField(0, "sampleText").click();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		this.saveScreenShot(browser, "samplepage6.png");
		
	}
	
	@Override
	public void exec() throws Exception {
		WebAppProject proj = WebAppProject.newWebAppProject(this.getConf());
		proj.initSrc();
		this.dropTables("sample");
		Browser.sleep(this.getConf().getTestApp().getBuildWait());
		this.reloadWebApp(this.getConf().getTestApp().getContextPath());
		Browser browser = this.getBrowser();
		this.changeSystemName(browser, proj);
		this.editMenu(browser);
		this.editTable(browser);
		this.createTable(browser);
		this.createDaoAndPage(browser);
		this.createHtmlPage(browser);
		this.testSamplePage(browser);
		proj.saveSnapshot("step01");
		proj.exportDb("step01", "jp.dataforms.fw.app", "jp.dataforms.sample.edittable");
		browser.close();
	}
}
