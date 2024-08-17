package jp.dataforms.test.tester.devtool.query.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Dimension;

import jp.dataforms.fw.devtool.query.page.QueryGeneratorPage;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.tester.PageTester;
import jp.dataforms.test.testitem.TestItem;
import jp.dataforms.test.testitem.devtool.query.page.QueryGeneratorEditFormTestItem;
import jp.dataforms.test.testitem.devtool.query.page.QueryGeneratorQueryFormTestItem;
import jp.dataforms.test.testitem.devtool.query.page.QueryGeneratorQueryResultFormTestItem;


/**
 *  ページテスター。
 */
public class QueryGeneratorPageTester extends PageTester {
	/**
	 * Logger.
	 */
	// private static Logger logger = LogManager.getLogger(QueryGeneratorPageTester.class);
	
	/**
	 * コンストラクタ。
	 */
	public QueryGeneratorPageTester() {
		super(QueryGeneratorPage.class);
	}
	
		/**
	 * QueryGeneratorEditFormのテストを行います。
	 * @param browser ブラウザ。
	 * @return テスト結果リスト。
	 * @throws Exception 例外。
	 */
	private List<TestItem> testQueryGeneratorEditForm(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(1024, 540));
		// QueryGeneratorEditFormのテスト項目のリストを取得する。
		List<TestItem> list = this.queryCheckItem(QueryGeneratorEditFormTestItem.class);
		List<TestItem> testResult = new ArrayList<TestItem>();
		// QueryGeneratorEditFormのテスト項目を実行し、その結果をtestResultに保存
		testResult.addAll(this.execTestItemList(browser, list));
		return testResult;
	}

	/**
	 * QueryGeneratorQueryFormのテストを行います。
	 * @param browser ブラウザ。
	 * @return テスト結果リスト。
	 * @throws Exception 例外。
	 */
	private List<TestItem> testQueryGeneratorQueryForm(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(1024, 540));
		// QueryGeneratorQueryFormのテスト項目のリストを取得する。
		List<TestItem> list = this.queryCheckItem(QueryGeneratorQueryFormTestItem.class);
		List<TestItem> testResult = new ArrayList<TestItem>();
		// QueryGeneratorQueryFormのテスト項目を実行し、その結果をtestResultに保存
		testResult.addAll(this.execTestItemList(browser, list));
		return testResult;
	}

	/**
	 * QueryGeneratorQueryResultFormのテストを行います。
	 * @param browser ブラウザ。
	 * @return テスト結果リスト。
	 * @throws Exception 例外。
	 */
	private List<TestItem> testQueryGeneratorQueryResultForm(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(1024, 540));
		// QueryGeneratorQueryResultFormのテスト項目のリストを取得する。
		List<TestItem> list = this.queryCheckItem(QueryGeneratorQueryResultFormTestItem.class);
		List<TestItem> testResult = new ArrayList<TestItem>();
		// QueryGeneratorQueryResultFormのテスト項目を実行し、その結果をtestResultに保存
		testResult.addAll(this.execTestItemList(browser, list));
		return testResult;
	}


	
	@Override
	public void exec() throws Exception {
		TestItem.setTestResult(this.getConf().getTestApp().getTestResult());
		Browser browser = this.getBrowser();
		browser.open(getPageClass());
		String pageName = browser.getTitle();
		List<TestItem> resultList = new ArrayList<TestItem>();
		
		// resultList.addAll(this.testSomething(browser));
		resultList.addAll(this.testQueryGeneratorEditForm(browser));
		resultList.addAll(this.testQueryGeneratorQueryForm(browser));
		resultList.addAll(this.testQueryGeneratorQueryResultForm(browser));

		this.saveIndexHtml(pageName, resultList);
		browser.close();
	}
	
}
