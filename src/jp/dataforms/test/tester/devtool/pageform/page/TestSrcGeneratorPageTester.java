package jp.dataforms.test.tester.devtool.pageform.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Dimension;

import jp.dataforms.test.devtool.pageform.page.TestSrcGeneratorPage;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.tester.PageTester;
import jp.dataforms.test.testitem.TestItem;
import jp.dataforms.test.testitem.devtool.pageform.page.PageGeneratorQueryFormTestItem;
import jp.dataforms.test.testitem.devtool.pageform.page.PageGeneratorQueryResultFormTestItem;
import jp.dataforms.test.testitem.devtool.pageform.page.TestSrcGeneratorEditFormTestItem;


/**
 *  ページテスター。
 */
public class TestSrcGeneratorPageTester extends PageTester {
	/**
	 * Logger.
	 */
	// private static Logger logger = LogManager.getLogger(TestSrcGeneratorPageTester.class);
	
	/**
	 * コンストラクタ。
	 */
	public TestSrcGeneratorPageTester() {
		super(TestSrcGeneratorPage.class);
	}
	
		/**
	 * TestSrcGeneratorEditFormのテストを行います。
	 * @param browser ブラウザ。
	 * @return テスト結果リスト。
	 * @throws Exception 例外。
	 */
	private List<TestItem> testTestSrcGeneratorEditForm(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(1024, 540));
		// TestSrcGeneratorEditFormのテスト項目のリストを取得する。
		List<TestItem> list = this.queryCheckItem(TestSrcGeneratorEditFormTestItem.class);
		List<TestItem> testResult = new ArrayList<TestItem>();
		// TestSrcGeneratorEditFormのテスト項目を実行し、その結果をtestResultに保存
		testResult.addAll(this.execTestItemList(browser, list));
		return testResult;
	}

	/**
	 * PageGeneratorQueryFormのテストを行います。
	 * @param browser ブラウザ。
	 * @return テスト結果リスト。
	 * @throws Exception 例外。
	 */
	private List<TestItem> testPageGeneratorQueryForm(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(1024, 540));
		// PageGeneratorQueryFormのテスト項目のリストを取得する。
		List<TestItem> list = this.queryCheckItem(PageGeneratorQueryFormTestItem.class);
		List<TestItem> testResult = new ArrayList<TestItem>();
		// PageGeneratorQueryFormのテスト項目を実行し、その結果をtestResultに保存
		testResult.addAll(this.execTestItemList(browser, list));
		return testResult;
	}

	/**
	 * PageGeneratorQueryResultFormのテストを行います。
	 * @param browser ブラウザ。
	 * @return テスト結果リスト。
	 * @throws Exception 例外。
	 */
	private List<TestItem> testPageGeneratorQueryResultForm(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(1024, 540));
		// PageGeneratorQueryResultFormのテスト項目のリストを取得する。
		List<TestItem> list = this.queryCheckItem(PageGeneratorQueryResultFormTestItem.class);
		List<TestItem> testResult = new ArrayList<TestItem>();
		// PageGeneratorQueryResultFormのテスト項目を実行し、その結果をtestResultに保存
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
		resultList.addAll(this.testTestSrcGeneratorEditForm(browser));
		resultList.addAll(this.testPageGeneratorQueryForm(browser));
		resultList.addAll(this.testPageGeneratorQueryResultForm(browser));

		this.saveIndexHtml(pageName, resultList);
		browser.close();
	}
	
}
