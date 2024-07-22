package jp.dataforms.test.element.devtool.db.page;


import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.TestElement;
import jp.dataforms.test.element.controller.FormTestElement;
import jp.dataforms.test.element.field.FieldTestElement;
import jp.dataforms.test.selenium.Browser;


/**
 * DatabaseInfoForm フォームテスト要素。 
 */
public class DatabaseInfoFormTestElement extends FormTestElement {
	/**
	 * フォームID。
	 */
	public static final String ID = "databaseInfoForm";
	
	/**
	 * DBサーバ名。
	 */
	public static final String ID_DB_SERVER_NAME = "dbServerName";

	/**
	 * DBサーババージョン。
	 */
	public static final String ID_DB_SERVER_VERSION = "dbServerVersion";

	/**
	 * DB接続URL。
	 */
	public static final String ID_DB_SERVER_URL = "dbServerURL";


	
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param parent 親コンポーネント。
	 * @param webElement FormのWebElement。
	 */
	public DatabaseInfoFormTestElement(final Browser browser, final TestElement parent, final WebElement webElement) {
		super(browser, parent, webElement);
	}
	
	/**
	 * DBサーバ名のテスト要素を取得します。
	 * @return DBサーバ名のテスト要素。
	 */
	public FieldTestElement getDbServerName() {
		return this.getField(ID_DB_SERVER_NAME);
	}
	/**
	 * DBサーババージョンのテスト要素を取得します。
	 * @return DBサーババージョンのテスト要素。
	 */
	public FieldTestElement getDbServerVersion() {
		return this.getField(ID_DB_SERVER_VERSION);
	}
	/**
	 * DB接続URLのテスト要素を取得します。
	 * @return DB接続URLのテスト要素。
	 */
	public FieldTestElement getDbServerURL() {
		return this.getField(ID_DB_SERVER_URL);
	}
	
}
