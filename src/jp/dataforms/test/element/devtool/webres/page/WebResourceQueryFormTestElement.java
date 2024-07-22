package jp.dataforms.test.element.devtool.webres.page;


import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.TestElement;
import jp.dataforms.test.element.controller.QueryFormTestElement;
import jp.dataforms.test.element.field.FieldTestElement;
import jp.dataforms.test.selenium.Browser;


/**
 * WebResourceQueryForm フォームテスト要素。 
 */
public class WebResourceQueryFormTestElement extends QueryFormTestElement {
	/**
	 * フォームID。
	 */
	public static final String ID = "queryForm";
	
	/**
	 * フォルダのパス。。
	 */
	public static final String ID_WEB_SOURCE_PATH = "webSourcePath";

	/**
	 * 機能。
	 */
	public static final String ID_FUNCTION_SELECT = "functionSelect";

	/**
	 * パッケージ名。
	 */
	public static final String ID_PACKAGE_NAME = "packageName";

	/**
	 * ページクラス名。
	 */
	public static final String ID_PAGE_CLASS_NAME = "pageClassName";

	/**
	 * 。
	 */
	public static final String ID_WEB_COMPONENT_TYPE_LIST = "webComponentTypeList";

	/**
	 * 。
	 */
	public static final String ID_GENERATABLE_ONLY = "generatableOnly";

	/**
	 * クラス名。
	 */
	public static final String ID_CLASS_NAME = "className";


	
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param parent 親コンポーネント。
	 * @param webElement FormのWebElement。
	 */
	public WebResourceQueryFormTestElement(final Browser browser, final TestElement parent, final WebElement webElement) {
		super(browser, parent, webElement);
	}
	
	/**
	 * フォルダのパス。のテスト要素を取得します。
	 * @return フォルダのパス。のテスト要素。
	 */
	public FieldTestElement getWebSourcePath() {
		return this.getField(ID_WEB_SOURCE_PATH);
	}
	/**
	 * 機能のテスト要素を取得します。
	 * @return 機能のテスト要素。
	 */
	public FieldTestElement getFunctionSelect() {
		return this.getField(ID_FUNCTION_SELECT);
	}
	/**
	 * パッケージ名のテスト要素を取得します。
	 * @return パッケージ名のテスト要素。
	 */
	public FieldTestElement getPackageName() {
		return this.getField(ID_PACKAGE_NAME);
	}
	/**
	 * ページクラス名のテスト要素を取得します。
	 * @return ページクラス名のテスト要素。
	 */
	public FieldTestElement getPageClassName() {
		return this.getField(ID_PAGE_CLASS_NAME);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getWebComponentTypeList() {
		return this.getField(ID_WEB_COMPONENT_TYPE_LIST);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getGeneratableOnly() {
		return this.getField(ID_GENERATABLE_ONLY);
	}
	/**
	 * クラス名のテスト要素を取得します。
	 * @return クラス名のテスト要素。
	 */
	public FieldTestElement getClassName() {
		return this.getField(ID_CLASS_NAME);
	}
	
}
