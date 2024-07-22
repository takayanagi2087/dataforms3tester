package jp.dataforms.test.element.devtool.table.page;


import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.TestElement;
import jp.dataforms.test.element.controller.QueryFormTestElement;
import jp.dataforms.test.element.field.FieldTestElement;
import jp.dataforms.test.selenium.Browser;


/**
 * TableGeneratorQueryForm フォームテスト要素。 
 */
public class TableGeneratorQueryFormTestElement extends QueryFormTestElement {
	/**
	 * フォームID。
	 */
	public static final String ID = "queryForm";
	
	/**
	 * 機能。
	 */
	public static final String ID_FUNCTION_SELECT = "functionSelect";

	/**
	 * パッケージ名。
	 */
	public static final String ID_PACKAGE_NAME = "packageName";

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
	public TableGeneratorQueryFormTestElement(final Browser browser, final TestElement parent, final WebElement webElement) {
		super(browser, parent, webElement);
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
	 * クラス名のテスト要素を取得します。
	 * @return クラス名のテスト要素。
	 */
	public FieldTestElement getClassName() {
		return this.getField(ID_CLASS_NAME);
	}
	
}
