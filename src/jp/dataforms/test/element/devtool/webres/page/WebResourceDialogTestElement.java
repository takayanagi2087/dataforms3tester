package jp.dataforms.test.element.devtool.webres.page;

import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.controller.DialogTestElement;
import jp.dataforms.test.element.controller.PageTestElement;
import jp.dataforms.test.selenium.Browser;

/**
 * WebResourceDialog のテスト要素。
 */
public class WebResourceDialogTestElement extends DialogTestElement {
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param parent 親テスト要素。
	 * @param element WebElement。
	 */
	public WebResourceDialogTestElement(final Browser browser, final PageTestElement parent, final WebElement element) {
		super(browser, parent, element);
	}
	

}
