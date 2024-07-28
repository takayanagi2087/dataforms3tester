package jp.dataforms.test.tester.app.user.page;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.Dimension;

import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.tester.PageTester;
import jp.dataforms.test.testitem.TestItem;

import jp.dataforms.fw.app.user.page.UserManagementPage;
import jp.dataforms.test.testitem.app.user.page.UserEditFormTestItem;
import jp.dataforms.test.testitem.app.user.page.UserQueryFormTestItem;
import jp.dataforms.test.testitem.app.user.page.UserQueryResultFormTestItem;


/**
 *  ページテスター。
 */
public class UserManagementPageTester extends PageTester {
	/**
	 * Logger.
	 */
	// private static Logger logger = LogManager.getLogger(UserManagementPageTester.class);
	
	/**
	 * コンストラクタ。
	 */
	public UserManagementPageTester() {
		super(UserManagementPage.class);
	}
	
		/**
	 * UserEditFormのテストを行います。
	 * @param browser ブラウザ。
	 * @return テスト結果リスト。
	 * @throws Exception 例外。
	 */
	private List<TestItem> testUserEditForm(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(1024, 540));
		// UserEditFormのテスト項目のリストを取得する。
		List<TestItem> list = this.queryCheckItem(UserEditFormTestItem.class);
		List<TestItem> testResult = new ArrayList<TestItem>();
		// UserEditFormのテスト項目を実行し、その結果をtestResultに保存
		testResult.addAll(this.execTestItemList(browser, list));
		return testResult;
	}

	/**
	 * UserQueryFormのテストを行います。
	 * @param browser ブラウザ。
	 * @return テスト結果リスト。
	 * @throws Exception 例外。
	 */
	private List<TestItem> testUserQueryForm(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(1024, 540));
		// UserQueryFormのテスト項目のリストを取得する。
		List<TestItem> list = this.queryCheckItem(UserQueryFormTestItem.class);
		List<TestItem> testResult = new ArrayList<TestItem>();
		// UserQueryFormのテスト項目を実行し、その結果をtestResultに保存
		testResult.addAll(this.execTestItemList(browser, list));
		return testResult;
	}

	/**
	 * UserQueryResultFormのテストを行います。
	 * @param browser ブラウザ。
	 * @return テスト結果リスト。
	 * @throws Exception 例外。
	 */
	private List<TestItem> testUserQueryResultForm(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(1024, 540));
		// UserQueryResultFormのテスト項目のリストを取得する。
		List<TestItem> list = this.queryCheckItem(UserQueryResultFormTestItem.class);
		List<TestItem> testResult = new ArrayList<TestItem>();
		// UserQueryResultFormのテスト項目を実行し、その結果をtestResultに保存
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
		resultList.addAll(this.testUserEditForm(browser));
		resultList.addAll(this.testUserQueryForm(browser));
		resultList.addAll(this.testUserQueryResultForm(browser));

		this.saveIndexHtml(pageName, resultList);
		browser.close();
	}
	
}
