package jp.dataforms.test.element.devtool.query.page;


import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.TestElement;
import jp.dataforms.test.element.controller.QueryFormTestElement;
import jp.dataforms.test.element.field.FieldTestElement;
import jp.dataforms.test.selenium.Browser;


/**
 * QueryExecutorQueryForm フォームテスト要素。 
 */
public class QueryExecutorQueryFormTestElement extends QueryFormTestElement {
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
	 * 問合せクラス名。
	 */
	public static final String ID_QUERY_CLASS_NAME = "queryClassName";

	/**
	 * 。
	 */
	public static final String ID_SQL = "sql";


	
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param parent 親コンポーネント。
	 * @param webElement FormのWebElement。
	 */
	public QueryExecutorQueryFormTestElement(final Browser browser, final TestElement parent, final WebElement webElement) {
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
	 * 問合せクラス名のテスト要素を取得します。
	 * @return 問合せクラス名のテスト要素。
	 */
	public FieldTestElement getQueryClassName() {
		return this.getField(ID_QUERY_CLASS_NAME);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getSql() {
		return this.getField(ID_SQL);
	}
	
}
