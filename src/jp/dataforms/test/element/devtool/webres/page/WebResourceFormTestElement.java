package jp.dataforms.test.element.devtool.webres.page;


import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.TestElement;
import jp.dataforms.test.element.controller.FormTestElement;
import jp.dataforms.test.element.field.ButtonTestElement;
import jp.dataforms.test.element.field.FieldTestElement;
import jp.dataforms.test.selenium.Browser;


/**
 * WebResourceForm フォームテスト要素。 
 */
public class WebResourceFormTestElement extends FormTestElement {
	/**
	 * フォームID。
	 */
	public static final String ID = "webResourceForm";
	
	/**
	 * 。
	 */
	public static final String ID_FIELD_LAYOUT = "fieldLayout";

	/**
	 * フォルダのパス。。
	 */
	public static final String ID_WEB_SOURCE_PATH = "webSourcePath";

	/**
	 * クラス名。
	 */
	public static final String ID_CLASS_NAME = "className";

	/**
	 * 。
	 */
	public static final String ID_WEB_COMPONENT_TYPE = "webComponentType";

	/**
	 * 。
	 */
	public static final String ID_HTML_PATH = "htmlPath";

	/**
	 * 。
	 */
	public static final String ID_HTML_STATUS = "htmlStatus";

	/**
	 * 。
	 */
	public static final String ID_OUTPUT_FORM_HTML = "outputFormHtml";

	/**
	 * 。
	 */
	public static final String ID_JAVASCRIPT_PATH = "javascriptPath";

	/**
	 * 。
	 */
	public static final String ID_JAVASCRIPT_STATUS = "javascriptStatus";

	/**
	 * 。
	 */
	public static final String ID_JAVASCRIPT_CLASS = "javascriptClass";

	/**
	 * 。
	 */
	public static final String ID_FORCE_OVERWRITE = "forceOverwrite";

	/**
	 * HTMLの作成ボタンのID。
	 */
	public static final String ID_GENERATE_HTML = "generateHtml";
	
	/**
	 * Javasciptの作成ボタンのID。
	 */
	public static final String ID_GENERATE_JAVASCRIPT = "generateJavascript";
	
	/**
	 * closeButtonの作成ボタンのID。
	 */
	public static final String ID_CLOSE_BUTTON = "closeButton";
	
	
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param parent 親コンポーネント。
	 * @param webElement FormのWebElement。
	 */
	public WebResourceFormTestElement(final Browser browser, final TestElement parent, final WebElement webElement) {
		super(browser, parent, webElement);
	}
	
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getFieldLayout() {
		return this.getField(ID_FIELD_LAYOUT);
	}
	/**
	 * フォルダのパス。のテスト要素を取得します。
	 * @return フォルダのパス。のテスト要素。
	 */
	public FieldTestElement getWebSourcePath() {
		return this.getField(ID_WEB_SOURCE_PATH);
	}
	/**
	 * クラス名のテスト要素を取得します。
	 * @return クラス名のテスト要素。
	 */
	public FieldTestElement getClassName() {
		return this.getField(ID_CLASS_NAME);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getWebComponentType() {
		return this.getField(ID_WEB_COMPONENT_TYPE);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getHtmlPath() {
		return this.getField(ID_HTML_PATH);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getHtmlStatus() {
		return this.getField(ID_HTML_STATUS);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getOutputFormHtml() {
		return this.getField(ID_OUTPUT_FORM_HTML);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getJavascriptPath() {
		return this.getField(ID_JAVASCRIPT_PATH);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getJavascriptStatus() {
		return this.getField(ID_JAVASCRIPT_STATUS);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getJavascriptClass() {
		return this.getField(ID_JAVASCRIPT_CLASS);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getForceOverwrite() {
		return this.getField(ID_FORCE_OVERWRITE);
	}

	
	/**
	 * HTML作成ボタンのテスト要素を取得します。
	 * @return HTML作成ボタンのテスト要素。
	 */
	public ButtonTestElement getGenerateHtmlButton() {
		return this.getButton(ID_GENERATE_HTML);
	}

	/**
	 * Javascript作成ボタンのテスト要素を取得します。
	 * @return Javascript作成ボタンのテスト要素。
	 */
	public ButtonTestElement getGenerateJavascriptButton() {
		return this.getButton(ID_GENERATE_JAVASCRIPT);
	}
	
	/**
	 * 「閉じる」ボタンのテスト要素を取得します。
	 * @return 「閉じる」ボタンのテスト要素。
	 */
	public ButtonTestElement getCloseButton() {
		return this.getButton(ID_CLOSE_BUTTON);
	}
}
