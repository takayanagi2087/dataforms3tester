package jp.dataforms.test.tester.devtool.db.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Dimension;

import jp.dataforms.fw.devtool.db.page.DeveloperEditForm;
import jp.dataforms.fw.devtool.db.page.InitializeDatabasePage;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.tester.PageTester;
import jp.dataforms.test.testitem.TestItem;
import jp.dataforms.test.testitem.devtool.db.page.initdb.DatabaseInfoFormTestItem;
import jp.dataforms.test.testitem.devtool.db.page.initdb.DeveloperEditFormTestItem;

/**
 * データベース初期化 ページテスター。
 */
public class InitializeDatabasePageTester extends PageTester {
	/**
	 * Logger.
	 */
	// private static Logger logger = LogManager.getLogger(InitializeDatabasePageTester.class);
	
	/**
	 * コンストラクタ。
	 */
	public InitializeDatabasePageTester() {
		super(InitializeDatabasePage.class);
	}
	
	/**
	 * DatabaseInfoFormのテストを行います。
	 * @param browser ブラウザ。
	 * @return テスト結果リスト。
	 * @throws Exception 例外。
	 */
	private List<TestItem> testDatabaseInfoForm(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(1024, 540));
		List<TestItem> list = this.queryCheckItem("jp.dataforms.test.testitem.devtool.db.page", DatabaseInfoFormTestItem.class, null, null);
		for (TestItem ci: list) {
			ci.exec(browser);
		}
		return list;
	}

	/**
	 * DeveloperEditFormのテストを行います。
	 * @param browser ブラウザ。
	 * @return テスト結果リスト。
	 * @throws Exception 例外。
	 */
	private List<TestItem> testDeveloperEditForm(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(1024, 540));
		List<TestItem> list = this.queryCheckItem("jp.dataforms.test.testitem.devtool.db.page", DeveloperEditFormTestItem.class, null, null);
		this.execTestItemList(browser, list, "disp");
		this.execTestItemList(browser, list, "validation");
		this.execTestItemList(browser, list, "save");
		return list;
	}

	
	@Override
	public void exec() throws Exception {
		TestItem.setTestResult(this.getConf().getTestApp().getTestResult());
		Browser browser = this.getBrowser();
		this.openPage(browser);
		String pageName = browser.getTitle();
		List<TestItem> list = new ArrayList<TestItem>();
		list.addAll(this.testResponsive(browser, InitializeDatabasePage.class, DeveloperEditForm.class));
		list.addAll(this.testDatabaseInfoForm(browser));
		list.addAll(this.testDeveloperEditForm(browser));
		this.saveIndexHtml(pageName, list);
		browser.close();
	}
	
}
