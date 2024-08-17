package jp.dataforms.test.element.app.login.page;

import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.controller.PageTestElement;
import jp.dataforms.test.selenium.Browser;

/**
 * ログインページのテスト要素。
 */
public class LoginPageTestElement extends PageTestElement {
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param element WebElement。
	 */
	public LoginPageTestElement(final Browser browser, final WebElement element) {
		super(browser, element);
	}
	
	/**
	 * ログインフォームを取得します。
	 * @return ログインフォームのテスト要素。
	 */
	public LoginFormTestElement getLoginForm() {
		return this.getForm(LoginFormTestElement.ID, LoginFormTestElement.class);
	}
}
