package jp.dataforms.test.tester.docss;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;

import jp.dataforms.fw.devtool.db.page.TableManagementPage;
import jp.dataforms.test.element.controller.QueryResultFormTestElement;
import jp.dataforms.test.element.devtool.db.page.TableManagementPageTestElement;
import jp.dataforms.test.element.devtool.db.page.TableManagementQueryFormTestElement;
import jp.dataforms.test.element.field.FieldTestElement;
import jp.dataforms.test.element.htmltable.TableTestElement;
import jp.dataforms.test.proj.WebAppProject;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.util.ImageEditor;

/**
 * 「2.4.アプリケーションのデプロイ」のスクリーンショットを取得するツール。
 */
public class DocScreenShot241Tester extends DocScreenShotTester {
	
	/**
	 * Logger.
	 */
	private static Logger logger = LogManager.getLogger(DocScreenShot241Tester.class);

	/**
	 * コンストラクタ。
	 */
	public DocScreenShot241Tester() {
		super("2.4.deploy");
	}
	
	/**
	 * テーブルを作成します。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void exportInitialData(final Browser browser) throws Exception {
		this.openPage(browser, TableManagementPage.class);
		browser.setClientSize(new Dimension(1600, 800));
		TableManagementPageTestElement p = browser.getPageTestElement(TableManagementPageTestElement.class);
		TableManagementQueryFormTestElement qf = p.getTableManagementQueryForm();
		qf.getFunctionSelect().setValue("/dataforms/app");
		qf.query();
		QueryResultFormTestElement qrf = p.getQueryResultForm();
		TableTestElement table = qrf.getQueryResultTable();
		for (int i = 0; i < table.getRowCount(); i++) {
			FieldTestElement ck = table.getField(i, "checkedClass");
			String v = ck.getValue();
			logger.debug("v=" + v);
			if ("jp.dataforms.fw.app.enumtype.dao.EnumNameTable".equals(v)) {
				ck.click();
			}
			if ("jp.dataforms.fw.app.enumtype.dao.EnumTable".equals(v)) {
				ck.click();
			}
		}
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		String imgfile = this.saveScreenShot(browser, "initialdata1.png");
		ImageEditor.addMarkRect(imgfile, 270, 440, 300, 496);
		ImageEditor.addMarkRect(imgfile, 392, 602, 594, 642);

		qrf.getButton("exportAsInitialDataButton").click();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		p.getConfirmDialog().clickOkButton();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		p.getAlertDialog().clickOkButton();
	}
	
	
	
	
	@Override
	public void exec() throws Exception {
		WebAppProject proj = WebAppProject.newWebAppProject(this.getConf());
		proj.importDb("step02", "jp.dataforms.fw.app", "jp.dataforms.sample.edittable");
		proj.loadSnapshot("step02");
		this.reloadWebApp(this.getConf().getTestApp().getContextPath());
		Browser browser = this.getBrowser();
		this.login(browser, "developer");
		this.exportInitialData(browser);
//		proj.saveSnapshot("step03");
//		proj.exportDb("step03", "jp.dataforms.fw.app", "jp.dataforms.sample.edittable");
//		browser.close();
	}
}
