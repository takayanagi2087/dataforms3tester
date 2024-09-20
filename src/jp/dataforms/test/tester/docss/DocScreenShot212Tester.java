package jp.dataforms.test.tester.docss;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.dataforms.test.element.devtool.db.page.DeveloperEditFormTestElement;
import jp.dataforms.test.element.devtool.db.page.InitializeDatabasePageTestElement;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.testitem.TestItem;

/**
 * 「2.1.開発環境の構築」その2 データベース初期化のスクリーンショットを取得するツール。
 */
public class DocScreenShot212Tester extends DocScreenShotTester {
	/**
	 * Logger.
	 */
	private static Logger logger = LogManager.getLogger(DocScreenShot212Tester.class);

	/**
	 * コンストラクタ。
	 */
	public DocScreenShot212Tester() {
		super("2.1.devenv");
	}
	
	@Override
	public void exec() throws Exception {
		Browser browser = this.getBrowser();
		browser.open(this.getConf().getTestApp().getApplicationURL());
		Browser.sleep(TestItem.getConf().getTestApp().getMiddleWait());
		this.saveScreenShot(browser, "initdb001.png");
		InitializeDatabasePageTestElement p = browser.getPageTestElement(InitializeDatabasePageTestElement.class);
		DeveloperEditFormTestElement f = p.getDeveloperEditForm();
		f.getPassword().setValue("developer");
		f.getPasswordCheck().setValue("developer");
		f.getConfirmButton().click();
		Browser.sleep(TestItem.getConf().getTestApp().getShortWait());
		f.getSaveButton().click();
		Browser.sleep(TestItem.getConf().getTestApp().getMiddleWait());
		p.getAlertDialog().clickOkButton();
		Browser.sleep(TestItem.getConf().getTestApp().getMiddleWait());
		this.saveScreenShot(browser, "initdb002.png");
		this.login(browser, "developer");
		Browser.sleep(TestItem.getConf().getTestApp().getMiddleWait());
		this.saveScreenShot(browser, "initdb003.png");
		logger.info(this.getDocumentPath() + "取得終了");
		browser.close();

	}
}
