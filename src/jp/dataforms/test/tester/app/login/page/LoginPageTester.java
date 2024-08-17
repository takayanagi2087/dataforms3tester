package jp.dataforms.test.tester.app.login.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Dimension;

import jp.dataforms.fw.app.login.page.LoginForm;
import jp.dataforms.fw.app.login.page.LoginPage;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.tester.PageTester;
import jp.dataforms.test.testitem.TestItem;
import jp.dataforms.test.testitem.app.login.page.LoginFormTestItem;

/**
 * ログインページテスター。
 */
public class LoginPageTester extends PageTester {
	/**
	 * Logger.
	 */
//	private static Logger logger = LogManager.getLogger(LoginPageTester.class);
	
	/**
	 * コンストラクタ。
	 */
	public LoginPageTester() {
		super(LoginPage.class);
	}
	
	/**
	 * バリデージョンのテスト。
	 * @param browser ブラウザ。
	 * @return テスト結果リスト。
	 * @throws Exception 例外。
	 */
	private List<TestItem> testValidation(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(1024, 540));
		List<TestItem> list = this.queryCheckItem("jp.dataforms.test.testitem.app.login.page", LoginFormTestItem.class, null, null);
		return this.execTestItemList(browser, list);
	}
	
	
	@Override
	public void exec() throws Exception {
		TestItem.setTestResult(this.getConf().getTestApp().getTestResult());
		Browser browser = this.getBrowser();
		browser.open(getPageClass());
		String pageName = browser.getTitle();
		List<TestItem> list = new ArrayList<TestItem>();
		list.addAll(this.testResponsive(browser, LoginPage.class, LoginForm.class));
		list.addAll(this.testValidation(browser));
		this.saveIndexHtml(pageName, list);
		browser.close();
	}
	
}
