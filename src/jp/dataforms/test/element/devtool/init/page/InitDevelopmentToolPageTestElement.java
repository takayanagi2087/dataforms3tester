package jp.dataforms.test.element.devtool.init.page;

import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.controller.PageTestElement;
import jp.dataforms.test.selenium.Browser;

/**
 * ログインページのテスト要素。
 */
public class InitDevelopmentToolPageTestElement extends PageTestElement {
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param element WebElement。
	 */
	public InitDevelopmentToolPageTestElement(final Browser browser, final WebElement element) {
		super(browser, null, element);
	}
	
	/**
	 * ログインフォームを取得します。
	 * @return ログインフォームのテスト要素。
	 */
	public InitDevelopmentToolFormTestElement getInitDevelopmentToolForm() {
		return this.getForm(InitDevelopmentToolFormTestElement.ID, InitDevelopmentToolFormTestElement.class);
	}

}
