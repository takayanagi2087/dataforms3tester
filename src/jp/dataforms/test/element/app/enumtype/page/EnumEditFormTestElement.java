package jp.dataforms.test.element.app.enumtype.page;


import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.TestElement;
import jp.dataforms.test.element.controller.EditFormTestElement;
import jp.dataforms.test.element.field.FieldTestElement;
import jp.dataforms.test.element.htmltable.TableTestElement;
import jp.dataforms.test.selenium.Browser;


/**
 * EnumEditForm フォームテスト要素。 
 */
public class EnumEditFormTestElement extends EditFormTestElement {
	/**
	 * フォームID。
	 */
	public static final String ID = "editForm";
	
	/**
	 * 保存モード。
	 */
	public static final String ID_SAVE_MODE = "saveMode";

	/**
	 * 列挙型ID。
	 */
	public static final String ID_ENUM_ID = "enumId";

	/**
	 * 親IDフィールド。
	 */
	public static final String ID_PARENT_ID = "parentId";

	/**
	 * ソート順。
	 */
	public static final String ID_SORT_ORDER = "sortOrder";

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

	/**
	 * 列挙型名称。
	 */
	public static final String ID_ENUM_NAME = "enumName";

	/**
	 * 列挙型名称。
	 */
	public static final String ID_JA_ENUM_NAME = "jaEnumName";

	// ----- テーブル関連定数 -----
	/**
	 * テーブル。
	 */
	public static final String ID_OPTION_TABLE = "optionTable";


	
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param parent 親コンポーネント。
	 * @param webElement FormのWebElement。
	 */
	public EnumEditFormTestElement(final Browser browser, final TestElement parent, final WebElement webElement) {
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
	 * 列挙型IDのテスト要素を取得します。
	 * @return 列挙型IDのテスト要素。
	 */
	public FieldTestElement getEnumId() {
		return this.getField(ID_ENUM_ID);
	}
	/**
	 * 親IDフィールドのテスト要素を取得します。
	 * @return 親IDフィールドのテスト要素。
	 */
	public FieldTestElement getParentId() {
		return this.getField(ID_PARENT_ID);
	}
	/**
	 * ソート順のテスト要素を取得します。
	 * @return ソート順のテスト要素。
	 */
	public FieldTestElement getSortOrder() {
		return this.getField(ID_SORT_ORDER);
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
	 * 列挙型名称のテスト要素を取得します。
	 * @return 列挙型名称のテスト要素。
	 */
	public FieldTestElement getEnumName() {
		return this.getField(ID_ENUM_NAME);
	}
	/**
	 * 列挙型名称のテスト要素を取得します。
	 * @return 列挙型名称のテスト要素。
	 */
	public FieldTestElement getJaEnumName() {
		return this.getField(ID_JA_ENUM_NAME);
	}
	/**
	 * テーブルのテスト要素を取得します。
	 * @return テーブルのテスト要素。
	 */
	public TableTestElement getOptionTable() {
		return this.getTable(ID_OPTION_TABLE);
	}
	
}
