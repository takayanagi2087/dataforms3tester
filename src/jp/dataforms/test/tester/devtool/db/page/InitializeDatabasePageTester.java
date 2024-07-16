package jp.dataforms.test.tester.devtool.db.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Dimension;

import jp.dataforms.fw.devtool.db.page.DeveloperEditForm;
import jp.dataforms.fw.devtool.db.page.InitializeDatabasePage;
import jp.dataforms.test.proj.WebAppProject;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.tester.PageTester;
import jp.dataforms.test.testitem.TestItem;
import jp.dataforms.test.testitem.devtool.db.page.DatabaseInfoFormTestItem;
import jp.dataforms.test.testitem.devtool.db.page.DeveloperEditFormTestItem;

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
		return this.execTestItemList(browser, list);
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
		List<TestItem> ret = new ArrayList<TestItem>();
		
		ret.addAll(this.execTestItemList(browser, list, "disp"));
		ret.addAll(this.execTestItemList(browser, list, "validation"));
		ret.addAll(this.execTestItemList(browser, list, "save"));
		this.cleanDB();
		Browser.sleep(this.getConf().getTestApp().getMiddleWait());
		browser.open(this.getConf().getTestApp().getApplicationURL());
		ret.addAll(this.execTestItemList(browser, list, "import"));
		return ret;
	}

	
	@Override
	public void exec() throws Exception {
		TestItem.setTestResult(this.getConf().getTestApp().getTestResult());
		this.cleanDB();
		WebAppProject proj = WebAppProject.newWebAppProject(this.getConf());
		proj.copyUserInitialData();
		this.reloadWebApp(this.getConf().getTestApp().getContextPath());
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
