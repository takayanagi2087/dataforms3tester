package jp.dataforms.test.tester.devtool.query.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Dimension;

import jp.dataforms.fw.devtool.query.page.QueryExecutorPage;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.tester.PageTester;
import jp.dataforms.test.testitem.TestItem;
import jp.dataforms.test.testitem.devtool.query.page.QueryExecutorQueryFormTestItem;
import jp.dataforms.test.testitem.devtool.query.page.QueryExecutorQueryResultFormTestItem;


/**
 *  ページテスター。
 */
public class QueryExecutorPageTester extends PageTester {
	/**
	 * Logger.
	 */
	// private static Logger logger = LogManager.getLogger(QueryExecutorPageTester.class);
	
	/**
	 * コンストラクタ。
	 */
	public QueryExecutorPageTester() {
		super(QueryExecutorPage.class);
	}
	
		/**
	 * QueryExecutorQueryFormのテストを行います。
	 * @param browser ブラウザ。
	 * @return テスト結果リスト。
	 * @throws Exception 例外。
	 */
	private List<TestItem> testQueryExecutorQueryForm(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(1024, 540));
		// QueryExecutorQueryFormのテスト項目のリストを取得する。
		List<TestItem> list = this.queryCheckItem(QueryExecutorQueryFormTestItem.class);
		List<TestItem> testResult = new ArrayList<TestItem>();
		// QueryExecutorQueryFormのテスト項目を実行し、その結果をtestResultに保存
		testResult.addAll(this.execTestItemList(browser, list));
		return testResult;
	}

	/**
	 * QueryExecutorQueryResultFormのテストを行います。
	 * @param browser ブラウザ。
	 * @return テスト結果リスト。
	 * @throws Exception 例外。
	 */
	private List<TestItem> testQueryExecutorQueryResultForm(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(1024, 540));
		// QueryExecutorQueryResultFormのテスト項目のリストを取得する。
		List<TestItem> list = this.queryCheckItem(QueryExecutorQueryResultFormTestItem.class);
		List<TestItem> testResult = new ArrayList<TestItem>();
		// QueryExecutorQueryResultFormのテスト項目を実行し、その結果をtestResultに保存
		testResult.addAll(this.execTestItemList(browser, list));
		return testResult;
	}


	
	@Override
	public void exec() throws Exception {
		TestItem.setTestResult(this.getConf().getTestApp().getTestResult());
		Browser browser = this.getBrowser();
		// this.openPage(browser);
		browser.open(getPageClass());
		String pageName = browser.getTitle();
		List<TestItem> resultList = new ArrayList<TestItem>();
		
		// resultList.addAll(this.testSomething(browser));
		resultList.addAll(this.testQueryExecutorQueryForm(browser));
		resultList.addAll(this.testQueryExecutorQueryResultForm(browser));

		this.saveIndexHtml(pageName, resultList);
		browser.close();
	}
	
}
