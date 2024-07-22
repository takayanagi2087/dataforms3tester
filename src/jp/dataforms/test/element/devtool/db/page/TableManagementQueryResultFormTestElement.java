package jp.dataforms.test.element.devtool.db.page;


import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.TestElement;
import jp.dataforms.test.element.controller.QueryResultFormTestElement;
import jp.dataforms.test.element.field.ButtonTestElement;
import jp.dataforms.test.element.field.FieldTestElement;
import jp.dataforms.test.element.htmltable.TableTestElement;
import jp.dataforms.test.selenium.Browser;


/**
 * TableManagementQueryResultForm フォームテスト要素。 
 */
public class TableManagementQueryResultFormTestElement extends QueryResultFormTestElement {
	/**
	 * フォームID。
	 */
	public static final String ID = "queryResultForm";
	
	/**
	 * 。
	 */
	public static final String ID_HIT_COUNT = "hitCount";

	/**
	 * 。
	 */
	public static final String ID_PAGE_NO = "pageNo";

	/**
	 * 。
	 */
	public static final String ID_LINES_PER_PAGE = "linesPerPage";

	/**
	 * 。
	 */
	public static final String ID_SORT_ORDER = "sortOrder";

	/**
	 * 。
	 */
	public static final String ID_CLASS_NAME = "className";

	/**
	 * 。
	 */
	public static final String ID_CHECKED_CLASS = "checkedClass";

	// ----- テーブル関連定数 -----
	/**
	 * テーブル。
	 */
	public static final String ID_QUERY_RESULT = "queryResult";

	/**
	 * No.。
	 */
	public static final String ID_ROW_NO = "rowNo";

	/**
	 * 。
	 */
	public static final String ID_TABLE_NAME = "tableName";

	/**
	 * 。
	 */
	public static final String ID_TABLE_COMMENT = "tableComment";

	/**
	 * 。
	 */
	public static final String ID_INDEX_NAMES = "indexNames";

	/**
	 * 。
	 */
	public static final String ID_STATUS = "status";

	/**
	 * 。
	 */
	public static final String ID_STATUS_VAL = "statusVal";

	/**
	 * 。
	 */
	public static final String ID_SEQUENCE_GENERATION = "sequenceGeneration";

	/**
	 * 。
	 */
	public static final String ID_DIFFERENCE = "difference";

	/**
	 * 。
	 */
	public static final String ID_DIFFERENCE_VAL = "differenceVal";

	/**
	 * 。
	 */
	public static final String ID_BACKUP_TABLE = "backupTable";

	/**
	 * 。
	 */
	public static final String ID_RECORD_COUNT = "recordCount";

	/**
	 * 更新ボタンID。
	 */
	public static final String ID_UPDATE_TABLE_BUTTON = "updateTableButton";
	/**
	 * 初期化ボタンID。
	 */
	public static final String ID_INIT_TABLE_BUTTON = "initTableButton";
	/**
	 * 削除ボタンID。
	 */
	public static final String ID_DROP_TABLE_BUTTON = "dropTableButton";
	/**
	 * 初期化データとしてエクスポートボタンID。
	 */
	public static final String ID_EXPORT_AS_INITIAL_DATA_BUTTON = "exportAsInitialDataButton";
	/**
	 * エクスポートボタンID。
	 */
	public static final String ID_EXPORT_TABLE_BUTTON = "exportTableButton";
	/**
	 * インポートボタンID。
	 */
	public static final String ID_IMPORT_TABLE_BUTTON = "importTableButton";

	
	
	
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param parent 親コンポーネント。
	 * @param webElement FormのWebElement。
	 */
	public TableManagementQueryResultFormTestElement(final Browser browser, final TestElement parent, final WebElement webElement) {
		super(browser, parent, webElement);
	}
	
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getHitCount() {
		return this.getField(ID_HIT_COUNT);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getPageNo() {
		return this.getField(ID_PAGE_NO);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getLinesPerPage() {
		return this.getField(ID_LINES_PER_PAGE);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getSortOrder() {
		return this.getField(ID_SORT_ORDER);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getClassName() {
		return this.getField(ID_CLASS_NAME);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getCheckedClass() {
		return this.getField(ID_CHECKED_CLASS);
	}
	/**
	 * テーブルのテスト要素を取得します。
	 * @return テーブルのテスト要素。
	 */
	public TableTestElement getQueryResult() {
		return this.getTable(ID_QUERY_RESULT);
	}

	
	/**
	 * 更新ボタンを取得します。
	 * @return 更新ボタン。
	 */
	public ButtonTestElement getUpdateTableButton() {
		return this.getButton(ID_UPDATE_TABLE_BUTTON);
	}

	/**
	 * 初期化ボタンを取得します。
	 * @return 初期化ボタン。
	 */
	public ButtonTestElement getInitTableButton() {
		return this.getButton(ID_INIT_TABLE_BUTTON);
		
	}
	/**
	 * 削除ボタンを取得します。
	 * @return 削除ボタン。
	 */
	public ButtonTestElement getDropTableButton() {
		return this.getButton(ID_DROP_TABLE_BUTTON);
	}

	/**
	 * 初期化データとしてエクスポートボタンを取得します。
	 * @return 初期化データとしてエクスポートボタン。
	 */
	public ButtonTestElement getExportAsInitialDataButton() {
		return this.getButton(ID_EXPORT_AS_INITIAL_DATA_BUTTON);
	}
	
	/**
	 * エクスポートボタンを所得します。
	 * @return エクスポートボタン。
	 */
	public ButtonTestElement getExportTableButton() {
		return this.getButton(ID_EXPORT_TABLE_BUTTON);
	}

	/**
	 * インポートボタンを取得します。
	 * @return インポートポートボタン。
	 */
	public ButtonTestElement getImportTableButton() {
		return this.getButton(ID_IMPORT_TABLE_BUTTON);
	}
	
}
