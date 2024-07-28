package jp.dataforms.test.element.app.user.page;


import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.TestElement;
import jp.dataforms.test.element.controller.QueryFormTestElement;
import jp.dataforms.test.element.field.FieldTestElement;
import jp.dataforms.test.element.htmltable.TableTestElement;
import jp.dataforms.test.selenium.Browser;


/**
 * UserQueryForm フォームテスト要素。 
 */
public class UserQueryFormTestElement extends QueryFormTestElement {
	/**
	 * フォームID。
	 */
	public static final String ID = "queryForm";
	
	/**
	 * ログインID。
	 */
	public static final String ID_LOGIN_ID = "loginId";

	/**
	 * 氏名。
	 */
	public static final String ID_USER_NAME = "userName";

	// ----- テーブル関連定数 -----
	/**
	 * テーブル。
	 */
	public static final String ID_ATT_TABLE = "attTable";

	/**
	 * ユーザ属性。
	 */
	public static final String ID_USER_ATTRIBUTE_TYPE = "userAttributeType";

	/**
	 * ユーザ属性値。
	 */
	public static final String ID_USER_ATTRIBUTE_VALUE = "userAttributeValue";


	
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param parent 親コンポーネント。
	 * @param webElement FormのWebElement。
	 */
	public UserQueryFormTestElement(final Browser browser, final TestElement parent, final WebElement webElement) {
		super(browser, parent, webElement);
	}
	
	/**
	 * ログインIDのテスト要素を取得します。
	 * @return ログインIDのテスト要素。
	 */
	public FieldTestElement getLoginId() {
		return this.getField(ID_LOGIN_ID);
	}
	/**
	 * 氏名のテスト要素を取得します。
	 * @return 氏名のテスト要素。
	 */
	public FieldTestElement getUserName() {
		return this.getField(ID_USER_NAME);
	}
	/**
	 * テーブルのテスト要素を取得します。
	 * @return テーブルのテスト要素。
	 */
	public TableTestElement getAttTable() {
		return this.getTable(ID_ATT_TABLE);
	}
	
}
