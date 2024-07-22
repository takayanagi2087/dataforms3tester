package jp.dataforms.test.element.devtool.webres.page;

import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.TestElement;
import jp.dataforms.test.element.controller.DialogTestElement;
import jp.dataforms.test.selenium.Browser;

/**
 * WebResourceDialog のテスト要素。
 */
public class WebResourceDialogTestElement extends DialogTestElement {
	/**
	 * ダイアログID。
	 */
	public static final String ID = "webResourceDialog";
	
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param parent 親テスト要素。
	 * @param element WebElement。
	 */
	public WebResourceDialogTestElement(final Browser browser, final TestElement parent, final WebElement element) {
		super(browser, parent, element);
	}
	
	/**
	 * WebResourceFormのテスト要素を取得します。
	 * @return WebResourceFormのテスト要素。
	 */
	public WebResourceFormTestElement getWebResourceForm() {
		return this.getForm(WebResourceFormTestElement.ID, WebResourceFormTestElement.class);
	}


}
