package jp.dataforms.test.tester.devtool.menu.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Dimension;

import jp.dataforms.fw.devtool.menu.page.MenuEditPage;
import jp.dataforms.test.proj.WebAppProject;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.tester.PageTester;
import jp.dataforms.test.testitem.TestItem;
import jp.dataforms.test.testitem.devtool.menu.page.MenuEditFormTestItem;

/**
 *  ページテスター。
 */
public class MenuEditPageTester extends PageTester {
	/**
	 * Logger.
	 */
	// private static Logger logger = LogManager.getLogger(MenuEditPageTester.class);
	
	/**
	 * コンストラクタ。
	 */
	public MenuEditPageTester() {
		super(MenuEditPage.class);
	}
	
	/**
	 * 何かのテストを行います。
	 * @param browser ブラウザ。
	 * @return テスト結果リスト。
	 * @throws Exception 例外。
	 */
	private List<TestItem> testMenuEditForm(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(1024, 540));
		List<TestItem> list = this.queryCheckItem("jp.dataforms.test.testitem.devtool", MenuEditFormTestItem.class, null, null);
		List<TestItem> ret = new ArrayList<TestItem>();
		ret.addAll(this.execTestItemList(browser, list, "validation"));
		ret.addAll(this.execTestItemList(browser, list, "save"));
		return ret;
	}
	
	
	@Override
	public void exec() throws Exception {
		WebAppProject proj = WebAppProject.newWebAppProject(this.getConf());
		proj.cleanPackage("/jp");
		proj.initProject(false);
		Browser.sleep(this.getConf().getTestApp().getBuildWait());
		TestItem.setTestResult(this.getConf().getTestApp().getTestResult());
		Browser browser = this.getBrowser();
		this.login(browser, "developer");
		this.openPage(browser);
		String pageName = browser.getTitle();
		List<TestItem> list = new ArrayList<TestItem>();
		//list.addAll(this.testResponsive(browser, MenuEditPage.class, MenuEditForm.class));
		list.addAll(this.testMenuEditForm(browser));
		this.saveIndexHtml(pageName, list);
		browser.close();
	}
	
}
