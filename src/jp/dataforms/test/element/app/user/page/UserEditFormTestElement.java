package jp.dataforms.test.element.app.user.page;


import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.TestElement;
import jp.dataforms.test.element.controller.EditFormTestElement;
import jp.dataforms.test.element.field.FieldTestElement;
import jp.dataforms.test.element.htmltable.TableTestElement;
import jp.dataforms.test.selenium.Browser;


/**
 * UserEditForm フォームテスト要素。 
 */
public class UserEditFormTestElement extends EditFormTestElement {
	/**
	 * フォームID。
	 */
	public static final String ID = "editForm";
	
	/**
	 * 保存モード。
	 */
	public static final String ID_SAVE_MODE = "saveMode";

	/**
	 * ユーザを示すID。
	 */
	public static final String ID_USER_ID = "userId";

	/**
	 * ログインID。
	 */
	public static final String ID_LOGIN_ID = "loginId";

	/**
	 * パスワード。
	 */
	public static final String ID_PASSWORD = "password";

	/**
	 * パスワード。
	 */
	public static final String ID_PASSWORD_CHECK = "passwordCheck";

	/**
	 * 氏名。
	 */
	public static final String ID_USER_NAME = "userName";

	/**
	 * メールアドレス。
	 */
	public static final String ID_MAIL_ADDRESS = "mailAddress";

	/**
	 * 外部ユーザフラグ。
	 */
	public static final String ID_EXTERNAL_USER_FLAG = "externalUserFlag";

	/**
	 * ユーザ有効フラグ。
	 */
	public static final String ID_ENABLED_FLAG = "enabledFlag";

	/**
	 * パスワード必須フラグ。
	 */
	public static final String ID_PASSWORD_REQUIRED_FLAG = "passwordRequiredFlag";

	/**
	 * PassKey必須フラグ。
	 */
	public static final String ID_PASSKEY_REQUIRED_FLAG = "passkeyRequiredFlag";

	/**
	 * 削除フラグ。
	 */
	public static final String ID_DELETE_FLAG = "deleteFlag";

	/**
	 * 作成者ID。
	 */
	public static final String ID_CREATE_USER_ID = "createUserId";

	/**
	 * 作成日時。
	 */
	public static final String ID_CREATE_TIMESTAMP = "createTimestamp";

	/**
	 * 更新者ID。
	 */
	public static final String ID_UPDATE_USER_ID = "updateUserId";

	/**
	 * 更新日時。
	 */
	public static final String ID_UPDATE_TIMESTAMP = "updateTimestamp";

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
	public UserEditFormTestElement(final Browser browser, final TestElement parent, final WebElement webElement) {
		super(browser, parent, webElement);
	}
	
	/**
	 * 保存モードのテスト要素を取得します。
	 * @return 保存モードのテスト要素。
	 */
	public FieldTestElement getSaveMode() {
		return this.getField(ID_SAVE_MODE);
	}
	/**
	 * ユーザを示すIDのテスト要素を取得します。
	 * @return ユーザを示すIDのテスト要素。
	 */
	public FieldTestElement getUserId() {
		return this.getField(ID_USER_ID);
	}
	/**
	 * ログインIDのテスト要素を取得します。
	 * @return ログインIDのテスト要素。
	 */
	public FieldTestElement getLoginId() {
		return this.getField(ID_LOGIN_ID);
	}
	/**
	 * パスワードのテスト要素を取得します。
	 * @return パスワードのテスト要素。
	 */
	public FieldTestElement getPassword() {
		return this.getField(ID_PASSWORD);
	}
	/**
	 * パスワードのテスト要素を取得します。
	 * @return パスワードのテスト要素。
	 */
	public FieldTestElement getPasswordCheck() {
		return this.getField(ID_PASSWORD_CHECK);
	}
	/**
	 * 氏名のテスト要素を取得します。
	 * @return 氏名のテスト要素。
	 */
	public FieldTestElement getUserName() {
		return this.getField(ID_USER_NAME);
	}
	/**
	 * メールアドレスのテスト要素を取得します。
	 * @return メールアドレスのテスト要素。
	 */
	public FieldTestElement getMailAddress() {
		return this.getField(ID_MAIL_ADDRESS);
	}
	/**
	 * 外部ユーザフラグのテスト要素を取得します。
	 * @return 外部ユーザフラグのテスト要素。
	 */
	public FieldTestElement getExternalUserFlag() {
		return this.getField(ID_EXTERNAL_USER_FLAG);
	}
	/**
	 * ユーザ有効フラグのテスト要素を取得します。
	 * @return ユーザ有効フラグのテスト要素。
	 */
	public FieldTestElement getEnabledFlag() {
		return this.getField(ID_ENABLED_FLAG);
	}
	/**
	 * パスワード必須フラグのテスト要素を取得します。
	 * @return パスワード必須フラグのテスト要素。
	 */
	public FieldTestElement getPasswordRequiredFlag() {
		return this.getField(ID_PASSWORD_REQUIRED_FLAG);
	}
	/**
	 * PassKey必須フラグのテスト要素を取得します。
	 * @return PassKey必須フラグのテスト要素。
	 */
	public FieldTestElement getPasskeyRequiredFlag() {
		return this.getField(ID_PASSKEY_REQUIRED_FLAG);
	}
	/**
	 * 削除フラグのテスト要素を取得します。
	 * @return 削除フラグのテスト要素。
	 */
	public FieldTestElement getDeleteFlag() {
		return this.getField(ID_DELETE_FLAG);
	}
	/**
	 * 作成者IDのテスト要素を取得します。
	 * @return 作成者IDのテスト要素。
	 */
	public FieldTestElement getCreateUserId() {
		return this.getField(ID_CREATE_USER_ID);
	}
	/**
	 * 作成日時のテスト要素を取得します。
	 * @return 作成日時のテスト要素。
	 */
	public FieldTestElement getCreateTimestamp() {
		return this.getField(ID_CREATE_TIMESTAMP);
	}
	/**
	 * 更新者IDのテスト要素を取得します。
	 * @return 更新者IDのテスト要素。
	 */
	public FieldTestElement getUpdateUserId() {
		return this.getField(ID_UPDATE_USER_ID);
	}
	/**
	 * 更新日時のテスト要素を取得します。
	 * @return 更新日時のテスト要素。
	 */
	public FieldTestElement getUpdateTimestamp() {
		return this.getField(ID_UPDATE_TIMESTAMP);
	}
	/**
	 * テーブルのテスト要素を取得します。
	 * @return テーブルのテスト要素。
	 */
	public TableTestElement getAttTable() {
		return this.getTable(ID_ATT_TABLE);
	}
	
}
