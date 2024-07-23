package jp.dataforms.test.tester.devtool.webres.page;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.Dimension;

import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.tester.PageTester;
import jp.dataforms.test.testitem.TestItem;

import jp.dataforms.fw.devtool.webres.page.WebResourcePage;
import jp.dataforms.test.testitem.devtool.webres.page.WebResourceQueryFormTestItem;
import jp.dataforms.test.testitem.devtool.webres.page.WebResourceQueryResultFormTestItem;
import jp.dataforms.test.testitem.devtool.webres.page.WebResourceFormTestItem;


/**
 *  ページテスター。
 */
public class WebResourcePageTester extends PageTester {
	/**
	 * Logger.
	 */
	// private static Logger logger = LogManager.getLogger(WebResourcePageTester.class);
	
	/**
	 * コンストラクタ。
	 */
	public WebResourcePageTester() {
		super(WebResourcePage.class);
	}
	
		/**
	 * WebResourceQueryFormのテストを行います。
	 * @param browser ブラウザ。
	 * @return テスト結果リスト。
	 * @throws Exception 例外。
	 */
	private List<TestItem> testWebResourceQueryForm(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(1024, 540));
		// WebResourceQueryFormのテスト項目のリストを取得する。
		List<TestItem> list = this.queryCheckItem(WebResourceQueryFormTestItem.class);
		List<TestItem> testResult = new ArrayList<TestItem>();
		// WebResourceQueryFormのテスト項目を実行し、その結果をtestResultに保存
		testResult.addAll(this.execTestItemList(browser, list));
		return testResult;
	}

	/**
	 * WebResourceQueryResultFormのテストを行います。
	 * @param browser ブラウザ。
	 * @return テスト結果リスト。
	 * @throws Exception 例外。
	 */
	private List<TestItem> testWebResourceQueryResultForm(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(1024, 540));
		// WebResourceQueryResultFormのテスト項目のリストを取得する。
		List<TestItem> list = this.queryCheckItem(WebResourceQueryResultFormTestItem.class);
		List<TestItem> testResult = new ArrayList<TestItem>();
		// WebResourceQueryResultFormのテスト項目を実行し、その結果をtestResultに保存
		testResult.addAll(this.execTestItemList(browser, list));
		return testResult;
	}

	/**
	 * WebResourceFormのテストを行います。
	 * @param browser ブラウザ。
	 * @return テスト結果リスト。
	 * @throws Exception 例外。
	 */
	private List<TestItem> testWebResourceForm(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(1024, 540));
		// WebResourceFormのテスト項目のリストを取得する。
		List<TestItem> list = this.queryCheckItem(WebResourceFormTestItem.class);
		List<TestItem> testResult = new ArrayList<TestItem>();
		// WebResourceFormのテスト項目を実行し、その結果をtestResultに保存
		testResult.addAll(this.execTestItemList(browser, list));
		return testResult;
	}


	
	@Override
	public void exec() throws Exception {
		TestItem.setTestResult(this.getConf().getTestApp().getTestResult());
		Browser browser = this.getBrowser();
		this.openPage(browser);
		String pageName = browser.getTitle();
		List<TestItem> resultList = new ArrayList<TestItem>();
		
		// resultList.addAll(this.testSomething(browser));
		resultList.addAll(this.testWebResourceQueryForm(browser));
		resultList.addAll(this.testWebResourceQueryResultForm(browser));
		resultList.addAll(this.testWebResourceForm(browser));

		this.saveIndexHtml(pageName, resultList);
		browser.close();
	}
	
}
