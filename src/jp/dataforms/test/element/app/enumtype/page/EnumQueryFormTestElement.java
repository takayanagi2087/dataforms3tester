package jp.dataforms.test.element.app.enumtype.page;


import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.TestElement;
import jp.dataforms.test.element.controller.QueryFormTestElement;
import jp.dataforms.test.element.field.FieldTestElement;
import jp.dataforms.test.selenium.Browser;


/**
 * EnumQueryForm フォームテスト要素。 
 */
public class EnumQueryFormTestElement extends QueryFormTestElement {
	/**
	 * フォームID。
	 */
	public static final String ID = "queryForm";
	
	/**
	 * 列挙型コード。
	 */
	public static final String ID_ENUM_CODE = "enumCode";

	/**
	 * 列挙型グループコード.。
	 */
	public static final String ID_ENUM_GROUP_CODE = "enumGroupCode";

	/**
	 * メモ。
	 */
	public static final String ID_MEMO = "memo";


	
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param parent 親コンポーネント。
	 * @param webElement FormのWebElement。
	 */
	public EnumQueryFormTestElement(final Browser browser, final TestElement parent, final WebElement webElement) {
		super(browser, parent, webElement);
	}
	
	/**
	 * 列挙型コードのテスト要素を取得します。
	 * @return 列挙型コードのテスト要素。
	 */
	public FieldTestElement getEnumCode() {
		return this.getField(ID_ENUM_CODE);
	}
	/**
	 * 列挙型グループコード.のテスト要素を取得します。
	 * @return 列挙型グループコード.のテスト要素。
	 */
	public FieldTestElement getEnumGroupCode() {
		return this.getField(ID_ENUM_GROUP_CODE);
	}
	/**
	 * メモのテスト要素を取得します。
	 * @return メモのテスト要素。
	 */
	public FieldTestElement getMemo() {
		return this.getField(ID_MEMO);
	}
	
}
