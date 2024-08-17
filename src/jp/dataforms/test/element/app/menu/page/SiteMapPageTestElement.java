package jp.dataforms.test.element.app.menu.page;

import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.controller.PageTestElement;
import jp.dataforms.test.selenium.Browser;

/**
 * サイトマップページのテスト要素。
 */
public class SiteMapPageTestElement extends PageTestElement {
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param element WebElement。
	 */
	public SiteMapPageTestElement(final Browser browser, final WebElement element) {
		super(browser, element);
	}
	
	/**
	 * サイトマップフォームを取得します。
	 * @return サイトマップフォームのテスト要素。
	 */
	public SiteMapFormTestElement getSiteMapForm() {
		return (SiteMapFormTestElement) this.getForm(SiteMapFormTestElement.ID, SiteMapFormTestElement.class);
	}
}
