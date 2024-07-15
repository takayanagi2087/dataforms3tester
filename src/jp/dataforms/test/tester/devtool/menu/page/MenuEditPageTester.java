package jp.dataforms.test.tester.devtool.menu.page;

import java.util.ArrayList;
import java.util.List;

import jp.dataforms.fw.devtool.menu.page.MenuEditForm;
import jp.dataforms.fw.devtool.menu.page.MenuEditPage;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.tester.PageTester;
import jp.dataforms.test.testitem.TestItem;

/**
 * メニュー編集ページテスター。
 */
public class MenuEditPageTester extends PageTester {
	/**
	 * コンストラクタ。
	 */
	public MenuEditPageTester() {
		super(MenuEditPage.class);
	}
	
	@Override
	public void exec() throws Exception {
		TestItem.setTestResult(this.getConf().getTestApp().getTestResult());
		Browser browser = this.getBrowser();
		this.login(browser, "developer");
		String url = this.getConf().getTestApp().getApplicationURL() + "dataforms/devtool/menu/page/MenuEditPage.df";
		browser.open(url);
		String pageName = browser.getTitle();
		List<TestItem> list = new ArrayList<TestItem>();
		list.addAll(this.testResponsive(browser, MenuEditPage.class, MenuEditForm.class));
		this.saveIndexHtml(pageName, list);
		browser.close();
		
	}

}
