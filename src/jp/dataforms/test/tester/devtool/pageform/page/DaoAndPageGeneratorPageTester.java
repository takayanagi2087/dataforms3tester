package jp.dataforms.test.tester.devtool.pageform.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Dimension;

import jp.dataforms.fw.devtool.pageform.page.DaoAndPageGeneratorPage;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.tester.PageTester;
import jp.dataforms.test.testitem.TestItem;
import jp.dataforms.test.testitem.devtool.pageform.page.DaoAndPageGeneratorEditFormTestItem;
import jp.dataforms.test.testitem.devtool.pageform.page.PageGeneratorQueryFormTestItem;
import jp.dataforms.test.testitem.devtool.pageform.page.PageGeneratorQueryResultFormTestItem;


/**
 *  ページテスター。
 */
public class DaoAndPageGeneratorPageTester extends PageTester {
	/**
	 * Logger.
	 */
	// private static Logger logger = LogManager.getLogger(DaoAndPageGeneratorPageTester.class);
	
	/**
	 * コンストラクタ。
	 */
	public DaoAndPageGeneratorPageTester() {
		super(DaoAndPageGeneratorPage.class);
	}
	
		/**
	 * DaoAndPageGeneratorEditFormのテストを行います。
	 * @param browser ブラウザ。
	 * @return テスト結果リスト。
	 * @throws Exception 例外。
	 */
	private List<TestItem> testDaoAndPageGeneratorEditForm(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(1024, 540));
		// DaoAndPageGeneratorEditFormのテスト項目のリストを取得する。
		List<TestItem> list = this.queryCheckItem(DaoAndPageGeneratorEditFormTestItem.class);
		List<TestItem> testResult = new ArrayList<TestItem>();
		// DaoAndPageGeneratorEditFormのテスト項目を実行し、その結果をtestResultに保存
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
		browser.open(getPageClass());
		String pageName = browser.getTitle();
		List<TestItem> resultList = new ArrayList<TestItem>();
		
		// resultList.addAll(this.testSomething(browser));
		resultList.addAll(this.testDaoAndPageGeneratorEditForm(browser));
		resultList.addAll(this.testPageGeneratorQueryForm(browser));
		resultList.addAll(this.testPageGeneratorQueryResultForm(browser));

		this.saveIndexHtml(pageName, resultList);
		browser.close();
	}
	
}
