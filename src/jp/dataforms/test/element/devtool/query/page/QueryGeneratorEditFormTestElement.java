package jp.dataforms.test.element.devtool.query.page;


import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.TestElement;
import jp.dataforms.test.element.controller.EditFormTestElement;
import jp.dataforms.test.element.field.FieldTestElement;
import jp.dataforms.test.element.htmltable.TableTestElement;
import jp.dataforms.test.selenium.Browser;


/**
 * QueryGeneratorEditForm フォームテスト要素。 
 */
public class QueryGeneratorEditFormTestElement extends EditFormTestElement {
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
	 * 問合せクラス名。
	 */
	public static final String ID_QUERY_CLASS_NAME = "queryClassName";

	/**
	 * 。
	 */
	public static final String ID_OVERWRITE_MODE = "overwriteMode";

	/**
	 * 。
	 */
	public static final String ID_DISTINCT_FLAG = "distinctFlag";

	/**
	 * 。
	 */
	public static final String ID_QUERY_COMMENT = "queryComment";

	/**
	 * 主テーブルの機能。
	 */
	public static final String ID_MAIN_TABLE_FUNCTION_SELECT = "mainTableFunctionSelect";

	/**
	 * 主テーブルのパッケージ。
	 */
	public static final String ID_MAIN_TABLE_PACKAGE_NAME = "mainTablePackageName";

	/**
	 * 主テーブルクラス名。
	 */
	public static final String ID_MAIN_TABLE_CLASS_NAME = "mainTableClassName";

	/**
	 * 別名。
	 */
	public static final String ID_ALIAS_NAME = "aliasName";

	/**
	 * 。
	 */
	public static final String ID_NOT_UPDATE_CONSTRACTOR = "notUpdateConstractor";

	/**
	 * 。
	 */
	public static final String ID_NOT_GENERATE_ENTITY = "notGenerateEntity";

	// ----- テーブル関連定数 -----
	/**
	 * テーブル。
	 */
	public static final String ID_JOIN_TABLE_LIST = "joinTableList";

	/**
	 * テーブル結合種別。
	 */
	public static final String ID_JOIN_TYPE = "joinType";

	/**
	 * テーブルクラス名。
	 */
	public static final String ID_TABLE_CLASS_NAME = "tableClassName";

	/**
	 * 。
	 */
	public static final String ID_JOIN_CONDITION = "joinCondition";

	// ----- テーブル関連定数 -----
	/**
	 * テーブル。
	 */
	public static final String ID_SELECT_FIELD_LIST = "selectFieldList";

	/**
	 * 。
	 */
	public static final String ID_SEL = "sel";

	/**
	 * ソート順。
	 */
	public static final String ID_SORT_ORDER = "sortOrder";

	/**
	 * 問合せフィールドID。
	 */
	public static final String ID_FIELD_ID = "fieldId";

	/**
	 * 。
	 */
	public static final String ID_ALIAS = "alias";

	/**
	 * フィールドクラス名。
	 */
	public static final String ID_FIELD_CLASS_NAME = "fieldClassName";

	/**
	 * テーブルクラス名。
	 */
	public static final String ID_TABLE_FULL_CLASS_NAME = "tableFullClassName";

	/**
	 * 。
	 */
	public static final String ID_MATCH_TYPE = "matchType";

	/**
	 * 。
	 */
	public static final String ID_LIST_FIELD_DISPLAY = "listFieldDisplay";

	/**
	 * 。
	 */
	public static final String ID_EDIT_KEY = "editKey";

	/**
	 * 。
	 */
	public static final String ID_EDIT_FIELD_DISPLAY = "editFieldDisplay";

	/**
	 * 。
	 */
	public static final String ID_TABLE_ALIAS = "tableAlias";

	/**
	 * 。
	 */
	public static final String ID_COMMENT = "comment";

	// ----- テーブル関連定数 -----
	/**
	 * テーブル。
	 */
	public static final String ID_SQL_FIELD_LIST = "sqlFieldList";

	/**
	 * フィールド長。
	 */
	public static final String ID_FIELD_LENGTH = "fieldLength";

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
	public QueryGeneratorEditFormTestElement(final Browser browser, final TestElement parent, final WebElement webElement) {
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
	public FieldTestElement getOverwriteMode() {
		return this.getField(ID_OVERWRITE_MODE);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getDistinctFlag() {
		return this.getField(ID_DISTINCT_FLAG);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getQueryComment() {
		return this.getField(ID_QUERY_COMMENT);
	}
	/**
	 * 主テーブルの機能のテスト要素を取得します。
	 * @return 主テーブルの機能のテスト要素。
	 */
	public FieldTestElement getMainTableFunctionSelect() {
		return this.getField(ID_MAIN_TABLE_FUNCTION_SELECT);
	}
	/**
	 * 主テーブルのパッケージのテスト要素を取得します。
	 * @return 主テーブルのパッケージのテスト要素。
	 */
	public FieldTestElement getMainTablePackageName() {
		return this.getField(ID_MAIN_TABLE_PACKAGE_NAME);
	}
	/**
	 * 主テーブルクラス名のテスト要素を取得します。
	 * @return 主テーブルクラス名のテスト要素。
	 */
	public FieldTestElement getMainTableClassName() {
		return this.getField(ID_MAIN_TABLE_CLASS_NAME);
	}
	/**
	 * 別名のテスト要素を取得します。
	 * @return 別名のテスト要素。
	 */
	public FieldTestElement getAliasName() {
		return this.getField(ID_ALIAS_NAME);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getNotUpdateConstractor() {
		return this.getField(ID_NOT_UPDATE_CONSTRACTOR);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getNotGenerateEntity() {
		return this.getField(ID_NOT_GENERATE_ENTITY);
	}
	/**
	 * テーブルのテスト要素を取得します。
	 * @return テーブルのテスト要素。
	 */
	public TableTestElement getJoinTableList() {
		return this.getTable(ID_JOIN_TABLE_LIST);
	}
	/**
	 * テーブルのテスト要素を取得します。
	 * @return テーブルのテスト要素。
	 */
	public TableTestElement getSelectFieldList() {
		return this.getTable(ID_SELECT_FIELD_LIST);
	}
	/**
	 * テーブルのテスト要素を取得します。
	 * @return テーブルのテスト要素。
	 */
	public TableTestElement getSqlFieldList() {
		return this.getTable(ID_SQL_FIELD_LIST);
	}
	
}
