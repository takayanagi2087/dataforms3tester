package jp.dataforms.test.devtool;

import org.openqa.selenium.WebElement;

import jp.dataforms.test.component.PageTestElement;
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
		return (InitDevelopmentToolFormTestElement) this.getForm(InitDevelopmentToolFormTestElement.ID, InitDevelopmentToolFormTestElement.class);
	}

}
