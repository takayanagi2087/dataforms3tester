package jp.dataforms.test.tester.devtool.db.page;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.tester.PageTester;
import jp.dataforms.test.testitem.TestItem;

import jp.dataforms.fw.devtool.db.page.InitializeDatabasePage;

/**
 * データベース初期化 ページテスター。
 */
public class InitializeDatabasePageTester extends PageTester {
	/**
	 * Logger.
	 */
	private static Logger logger = LogManager.getLogger(InitializeDatabasePageTester.class);
	
	/**
	 * コンストラクタ。
	 */
	public InitializeDatabasePageTester() {
		super(InitializeDatabasePage.class);
	}
	
	/**
	 * 何かのテストを行います。
	 * @param browser ブラウザ。
	 * @return テスト結果リスト。
	 * @throws Exception 例外。
	 */
/*	private List<TestItem> testSomething(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(1024, 540));
		List<TestItem> list = this.queryCheckItem("jp.dataforms.test.testitem.something", SomethingTestItem.class, null, null);
		for (TestItem ci: list) {
			ci.exec(browser);
			Browser.sleep(1);
		}
		return list;
	}
*/	
	
	@Override
	public void exec() throws Exception {
		TestItem.setTestResult(this.getConf().getTestApp().getTestResult());
		Browser browser = this.getBrowser();
		this.openPage(browser);
		List<TestItem> list = new ArrayList<TestItem>();
		// list.addAll(this.testSomething(browser));
		this.saveIndexHtml(list);
		browser.close();
	}
	
}
