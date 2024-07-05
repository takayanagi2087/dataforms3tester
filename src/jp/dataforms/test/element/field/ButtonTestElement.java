package jp.dataforms.test.element.field;

import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.TestElement;
import jp.dataforms.test.selenium.Browser;

/**
 * ボタンのテスト要素。
 */
public class ButtonTestElement extends TestElement {
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param parent 親コンポーネント。
	 * @param element WebElement。
	 */
	public ButtonTestElement(final Browser browser, final TestElement parent, final WebElement element) {
		super(browser, parent, element);
	}

	/**
	 * ボタンをクリックします。
	 */
	public void click() {
		this.getWebElement().click();
	}

}
