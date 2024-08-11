package jp.dataforms.test.element.app.enumtype.page;

import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.controller.PageTestElement;
import jp.dataforms.test.selenium.Browser;

/**
 *  ページのテスト要素。
 */
public class EnumPageTestElement extends PageTestElement {
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param element WebElement。
	 */
	public EnumPageTestElement(final Browser browser, final WebElement element) {
		super(browser, null, element);
	}
	
	/**
	 * EnumEditFormのテスト要素を取得します。
	 * @return EnumEditFormのテスト要素。
	 */
	public EnumEditFormTestElement getEnumEditForm() {
		return this.getForm(EnumEditFormTestElement.ID, EnumEditFormTestElement.class);
	}

	/**
	 * EnumQueryFormのテスト要素を取得します。
	 * @return EnumQueryFormのテスト要素。
	 */
	public EnumQueryFormTestElement getEnumQueryForm() {
		return this.getForm(EnumQueryFormTestElement.ID, EnumQueryFormTestElement.class);
	}

	/**
	 * EnumQueryResultFormのテスト要素を取得します。
	 * @return EnumQueryResultFormのテスト要素。
	 */
	public EnumQueryResultFormTestElement getEnumQueryResultForm() {
		return this.getForm(EnumQueryResultFormTestElement.ID, EnumQueryResultFormTestElement.class);
	}


}
