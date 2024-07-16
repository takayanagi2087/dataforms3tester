package jp.dataforms.test.testitem.app.login.page;

import java.util.List;

import jp.dataforms.test.element.app.login.page.LoginFormTestElement;
import jp.dataforms.test.element.app.login.page.LoginPageTestElement;
import jp.dataforms.test.element.app.menu.page.SiteMapFormTestElement;
import jp.dataforms.test.element.app.menu.page.SiteMapPageTestElement;
import jp.dataforms.test.element.controller.PageTestElement;
import jp.dataforms.test.element.field.ButtonTestElement;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.tester.PageTester.Conf;
import jp.dataforms.test.tester.PageTester.TestUser;
import jp.dataforms.test.testitem.TestItem;

/**
 * ログインテストの基本クラス。
 */
public abstract class LoginTestItem extends LoginFormTestItem {

	/**
	 * コンストラクタ。
	 * @param condition テスト条件。
	 * @param expected 期待値。
	 */
	public LoginTestItem(final String condition, final String expected) {
		super(condition, expected);
	}
	
	/**
	 * ログインIDを取得します。
	 * @return ログインID。
	 */
	protected abstract String getLoginId();

	
	/**
	 * サイトマップをチェックします。
	 * @param browser ブラウザ。
	 * @return サイトマップのチェック結果。
	 */
	protected abstract ResultType checkSiteMap(final Browser browser);
	
	
	@Override
	protected ResultType test(final Browser browser) throws Exception {
		LoginPageTestElement pageTestElement = browser.getPageTestElement(LoginPageTestElement.class);
		Conf conf = TestItem.getConf();
		TestUser user = conf.getTestUser(this.getLoginId());
		LoginFormTestElement f = pageTestElement.getLoginForm();
		f.getLoginIdField().setValue(user.getLoginId());
		f.getPasswordField().setValue(user.getPassword());
		this.saveScreenShot(browser);
		f.getLoginButton().click();
		Browser.sleep(TestItem.getConf().getTestApp().getShortWait());
		ResultType ret = this.checkSiteMap(browser);
		this.saveScreenShot(browser);
		return ret;
	}


	@Override
	protected void finish(final Browser browser) throws Exception {
		Browser.sleep(TestItem.getConf().getTestApp().getShortWait());
		PageTestElement pageTestElement = browser.getPageTestElement();
		ButtonTestElement btn = pageTestElement.getLogoutButton();
		btn.click();
	}
	
	/**
	 * リンクの存在チェックを行います。
	 * @param browser ブラウザ。
	 * @param url URL。
	 * @return 存在する場合true。
	 */
	protected boolean findLink(final Browser browser, final String url) {
		boolean ret = false;
		SiteMapPageTestElement pte = browser.getPageTestElement(SiteMapPageTestElement.class); // this.getSietMapPageTestElement(browser);
		SiteMapFormTestElement fte = pte.getSiteMapForm();
		List<String> list = fte.getLinkList();
		for (String link: list) {
			if (link.indexOf(url) >= 0) {
				ret = true;
			}
		}
		return ret;
	}
}
