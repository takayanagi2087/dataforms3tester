package jp.dataforms.test.element.devtool.table.page;


import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.TestElement;
import jp.dataforms.test.element.controller.EditFormTestElement;
import jp.dataforms.test.element.field.FieldTestElement;
import jp.dataforms.test.element.htmltable.TableTestElement;
import jp.dataforms.test.selenium.Browser;


/**
 * TableGeneratorEditForm フォームテスト要素。 
 */
public class TableGeneratorEditFormTestElement extends EditFormTestElement {
	/**
	 * フォームID。
	 */
	public static final String ID = "editForm";
	
	/**
	 * 保存モード。
	 */
	public static final String ID_SAVE_MODE = "saveMode";

	/**
	 * フォルダのパス。。
	 */
	public static final String ID_JAVA_SOURCE_PATH = "javaSourcePath";

	/**
	 * 機能。
	 */
	public static final String ID_FUNCTION_SELECT = "functionSelect";

	/**
	 * パッケージ名。
	 */
	public static final String ID_PACKAGE_NAME = "packageName";

	/**
	 * 。
	 */
	public static final String ID_TABLE_COMMENT = "tableComment";

	/**
	 * テーブルクラス名。
	 */
	public static final String ID_TABLE_CLASS_NAME = "tableClassName";

	/**
	 * 。
	 */
	public static final String ID_OVERWRITE_MODE = "overwriteMode";

	/**
	 * 主キー自動生成フラグ。
	 */
	public static final String ID_AUTO_INCREMENT_ID = "autoIncrementId";

	/**
	 * 更新情報フィールド。
	 */
	public static final String ID_UPDATE_INFO_FLAG = "updateInfoFlag";

	/**
	 * 。
	 */
	public static final String ID_IMPORT_TABLE = "importTable";

	// ----- テーブル関連定数 -----
	/**
	 * テーブル。
	 */
	public static final String ID_FIELD_LIST = "fieldList";

	/**
	 * 基本パッケージ名。
	 */
	public static final String ID_SUPER_PACKAGE_NAME = "superPackageName";

	/**
	 * 基本クラス名。
	 */
	public static final String ID_SUPER_SIMPLE_CLASS_NAME = "superSimpleClassName";

	/**
	 * クラス名。
	 */
	public static final String ID_FIELD_CLASS_NAME = "fieldClassName";

	/**
	 * フィールドID。
	 */
	public static final String ID_FIELD_ID = "fieldId";

	/**
	 * フィールド長。
	 */
	public static final String ID_FIELD_LENGTH = "fieldLength";

	/**
	 * 主キー。
	 */
	public static final String ID_PK_FLAG = "pkFlag";

	/**
	 * Not Null。
	 */
	public static final String ID_NOT_NULL_FLAG = "notNullFlag";

	/**
	 * コメント。
	 */
	public static final String ID_COMMENT = "comment";

	/**
	 * 。
	 */
	public static final String ID_IS_DATAFORMS_FIELD = "isDataformsField";


	
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param parent 親コンポーネント。
	 * @param webElement FormのWebElement。
	 */
	public TableGeneratorEditFormTestElement(final Browser browser, final TestElement parent, final WebElement webElement) {
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
	 * フォルダのパス。のテスト要素を取得します。
	 * @return フォルダのパス。のテスト要素。
	 */
	public FieldTestElement getJavaSourcePath() {
		return this.getField(ID_JAVA_SOURCE_PATH);
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
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getTableComment() {
		return this.getField(ID_TABLE_COMMENT);
	}
	/**
	 * テーブルクラス名のテスト要素を取得します。
	 * @return テーブルクラス名のテスト要素。
	 */
	public FieldTestElement getTableClassName() {
		return this.getField(ID_TABLE_CLASS_NAME);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getOverwriteMode() {
		return this.getField(ID_OVERWRITE_MODE);
	}
	/**
	 * 主キー自動生成フラグのテスト要素を取得します。
	 * @return 主キー自動生成フラグのテスト要素。
	 */
	public FieldTestElement getAutoIncrementId() {
		return this.getField(ID_AUTO_INCREMENT_ID);
	}
	/**
	 * 更新情報フィールドのテスト要素を取得します。
	 * @return 更新情報フィールドのテスト要素。
	 */
	public FieldTestElement getUpdateInfoFlag() {
		return this.getField(ID_UPDATE_INFO_FLAG);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getImportTable() {
		return this.getField(ID_IMPORT_TABLE);
	}
	/**
	 * テーブルのテスト要素を取得します。
	 * @return テーブルのテスト要素。
	 */
	public TableTestElement getFieldList() {
		return this.getTable(ID_FIELD_LIST);
	}
	
}
