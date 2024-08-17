package jp.dataforms.test.element.devtool.menu.page;

import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.controller.PageTestElement;
import jp.dataforms.test.selenium.Browser;

/**
 *  ページのテスト要素。
 */
public class MenuEditPageTestElement extends PageTestElement {
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param element WebElement。
	 */
	public MenuEditPageTestElement(final Browser browser, final WebElement element) {
		super(browser, element);
	}
	
	/**
	 * MenuEditFormのテスト要素を取得します。
	 * @return MenuEditFormのテスト要素。
	 */
	public MenuEditFormTestElement getMenuEditForm() {
		return this.getForm(MenuEditFormTestElement.ID, MenuEditFormTestElement.class);
	}


}
