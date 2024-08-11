package jp.dataforms.test.tester.app.enumtype.page;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.Dimension;

import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.tester.PageTester;
import jp.dataforms.test.testitem.TestItem;

import jp.dataforms.fw.app.enumtype.page.EnumPage;
import jp.dataforms.test.testitem.app.enumtype.page.EnumEditFormTestItem;
import jp.dataforms.test.testitem.app.enumtype.page.EnumQueryFormTestItem;
import jp.dataforms.test.testitem.app.enumtype.page.EnumQueryResultFormTestItem;


/**
 *  ページテスター。
 */
public class EnumPageTester extends PageTester {
	/**
	 * Logger.
	 */
	// private static Logger logger = LogManager.getLogger(EnumPageTester.class);
	
	/**
	 * コンストラクタ。
	 */
	public EnumPageTester() {
		super(EnumPage.class);
	}
	
		/**
	 * EnumEditFormのテストを行います。
	 * @param browser ブラウザ。
	 * @return テスト結果リスト。
	 * @throws Exception 例外。
	 */
	private List<TestItem> testEnumEditForm(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(1024, 540));
		// EnumEditFormのテスト項目のリストを取得する。
		List<TestItem> list = this.queryCheckItem(EnumEditFormTestItem.class);
		List<TestItem> testResult = new ArrayList<TestItem>();
		// EnumEditFormのテスト項目を実行し、その結果をtestResultに保存
		testResult.addAll(this.execTestItemList(browser, list));
		return testResult;
	}

	/**
	 * EnumQueryFormのテストを行います。
	 * @param browser ブラウザ。
	 * @return テスト結果リスト。
	 * @throws Exception 例外。
	 */
	private List<TestItem> testEnumQueryForm(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(1024, 540));
		// EnumQueryFormのテスト項目のリストを取得する。
		List<TestItem> list = this.queryCheckItem(EnumQueryFormTestItem.class);
		List<TestItem> testResult = new ArrayList<TestItem>();
		// EnumQueryFormのテスト項目を実行し、その結果をtestResultに保存
		testResult.addAll(this.execTestItemList(browser, list));
		return testResult;
	}

	/**
	 * EnumQueryResultFormのテストを行います。
	 * @param browser ブラウザ。
	 * @return テスト結果リスト。
	 * @throws Exception 例外。
	 */
	private List<TestItem> testEnumQueryResultForm(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(1024, 540));
		// EnumQueryResultFormのテスト項目のリストを取得する。
		List<TestItem> list = this.queryCheckItem(EnumQueryResultFormTestItem.class);
		List<TestItem> testResult = new ArrayList<TestItem>();
		// EnumQueryResultFormのテスト項目を実行し、その結果をtestResultに保存
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
		resultList.addAll(this.testEnumEditForm(browser));
		resultList.addAll(this.testEnumQueryForm(browser));
		resultList.addAll(this.testEnumQueryResultForm(browser));

		this.saveIndexHtml(pageName, resultList);
		browser.close();
	}
	
}
