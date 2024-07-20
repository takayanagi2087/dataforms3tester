package jp.dataforms.test.tester.devtool.db.page;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.Dimension;

import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.tester.PageTester;
import jp.dataforms.test.testitem.TestItem;

import jp.dataforms.fw.devtool.db.page.TableManagementPage;
import jp.dataforms.test.testitem.devtool.db.page.DatabaseInfoFormTestItem;
import jp.dataforms.test.testitem.devtool.db.page.TableManagementQueryFormTestItem;
import jp.dataforms.test.testitem.devtool.db.page.TableManagementQueryResultFormTestItem;


/**
 *  ページテスター。
 */
public class TableManagementPageTester extends PageTester {
	/**
	 * Logger.
	 */
	// private static Logger logger = LogManager.getLogger(TableManagementPageTester.class);
	
	/**
	 * コンストラクタ。
	 */
	public TableManagementPageTester() {
		super(TableManagementPage.class);
	}
	
		/**
	 * DatabaseInfoFormのテストを行います。
	 * @param browser ブラウザ。
	 * @return テスト結果リスト。
	 * @throws Exception 例外。
	 */
	private List<TestItem> testDatabaseInfoForm(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(1024, 540));
		// DatabaseInfoFormのテスト項目のリストを取得する。
		List<TestItem> list = this.queryCheckItem(DatabaseInfoFormTestItem.class);
		List<TestItem> testResult = new ArrayList<TestItem>();
		// DatabaseInfoFormのテスト項目を実行し、その結果をtestResultに保存
		testResult.addAll(this.execTestItemList(browser, list));
		return testResult;
	}

	/**
	 * TableManagementQueryFormのテストを行います。
	 * @param browser ブラウザ。
	 * @return テスト結果リスト。
	 * @throws Exception 例外。
	 */
	private List<TestItem> testTableManagementQueryForm(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(1024, 540));
		// TableManagementQueryFormのテスト項目のリストを取得する。
		List<TestItem> list = this.queryCheckItem(TableManagementQueryFormTestItem.class);
		List<TestItem> testResult = new ArrayList<TestItem>();
		// TableManagementQueryFormのテスト項目を実行し、その結果をtestResultに保存
		testResult.addAll(this.execTestItemList(browser, list));
		return testResult;
	}

	/**
	 * TableManagementQueryResultFormのテストを行います。
	 * @param browser ブラウザ。
	 * @return テスト結果リスト。
	 * @throws Exception 例外。
	 */
	private List<TestItem> testTableManagementQueryResultForm(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(1024, 540));
		// TableManagementQueryResultFormのテスト項目のリストを取得する。
		List<TestItem> list = this.queryCheckItem(TableManagementQueryResultFormTestItem.class);
		List<TestItem> testResult = new ArrayList<TestItem>();
		// TableManagementQueryResultFormのテスト項目を実行し、その結果をtestResultに保存
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
		resultList.addAll(this.testDatabaseInfoForm(browser));
		resultList.addAll(this.testTableManagementQueryForm(browser));
		resultList.addAll(this.testTableManagementQueryResultForm(browser));

		this.saveIndexHtml(pageName, resultList);
		browser.close();
	}
	
}
