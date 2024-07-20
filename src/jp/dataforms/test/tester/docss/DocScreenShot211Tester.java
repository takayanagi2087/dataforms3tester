package jp.dataforms.test.tester.docss;

import jp.dataforms.test.element.devtool.init.page.InitDevelopmentToolFormTestElement;
import jp.dataforms.test.element.devtool.init.page.InitDevelopmentToolPageTestElement;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.testitem.TestItem;

/**
 * プロジェクトの初期化のスクリーンショットを取得するツール。
 */
public class DocScreenShot211Tester extends DocScreenShotTester {

	/**
	 * コンストラクタ。
	 */
	public DocScreenShot211Tester() {
		super("2.1.devenv");
	}
	
	@Override
	public void exec() throws Exception {
		Browser browser = this.getBrowser();
		browser.open(this.getConf().getTestApp().getApplicationURL());
		Browser.sleep(TestItem.getConf().getTestApp().getMiddleWait());
		this.saveScreenShot(browser, "initproj001.png");
		InitDevelopmentToolPageTestElement p = browser.getPageTestElement(InitDevelopmentToolPageTestElement.class);
		InitDevelopmentToolFormTestElement f = p.getInitDevelopmentToolForm();
		f.getConfirmButton().click();
		Browser.sleep(TestItem.getConf().getTestApp().getShortWait());
		f.getSaveButton().click();
		Browser.sleep(TestItem.getConf().getTestApp().getMiddleWait());
		this.saveScreenShot(browser, "initproj002.png");
		browser.close();
	}
}
