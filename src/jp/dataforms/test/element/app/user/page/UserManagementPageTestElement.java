package jp.dataforms.test.element.app.user.page;

import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.controller.PageTestElement;
import jp.dataforms.test.selenium.Browser;

/**
 *  ページのテスト要素。
 */
public class UserManagementPageTestElement extends PageTestElement {
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param element WebElement。
	 */
	public UserManagementPageTestElement(final Browser browser, final WebElement element) {
		super(browser, null, element);
	}
	
	/**
	 * UserEditFormのテスト要素を取得します。
	 * @return UserEditFormのテスト要素。
	 */
	public UserEditFormTestElement getUserEditForm() {
		return this.getForm(UserEditFormTestElement.ID, UserEditFormTestElement.class);
	}

	/**
	 * UserQueryFormのテスト要素を取得します。
	 * @return UserQueryFormのテスト要素。
	 */
	public UserQueryFormTestElement getUserQueryForm() {
		return this.getForm(UserQueryFormTestElement.ID, UserQueryFormTestElement.class);
	}

	/**
	 * UserQueryResultFormのテスト要素を取得します。
	 * @return UserQueryResultFormのテスト要素。
	 */
	public UserQueryResultFormTestElement getUserQueryResultForm() {
		return this.getForm(UserQueryResultFormTestElement.ID, UserQueryResultFormTestElement.class);
	}


}
