package jp.dataforms.test.element.devtool.webres.page;

import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.controller.PageTestElement;
import jp.dataforms.test.selenium.Browser;

/**
 *  ページのテスト要素。
 */
public class WebResourcePageTestElement extends PageTestElement {
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param element WebElement。
	 */
	public WebResourcePageTestElement(final Browser browser, final WebElement element) {
		super(browser, null, element);
	}
	
	/**
	 * WebResourceQueryFormのテスト要素を取得します。
	 * @return WebResourceQueryFormのテスト要素。
	 */
	public WebResourceQueryFormTestElement getWebResourceQueryForm() {
		return this.getForm(WebResourceQueryFormTestElement.ID, WebResourceQueryFormTestElement.class);
	}

	/**
	 * WebResourceQueryResultFormのテスト要素を取得します。
	 * @return WebResourceQueryResultFormのテスト要素。
	 */
	public WebResourceQueryResultFormTestElement getWebResourceQueryResultForm() {
		return this.getForm(WebResourceQueryResultFormTestElement.ID, WebResourceQueryResultFormTestElement.class);
	}


}
