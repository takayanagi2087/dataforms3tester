package jp.dataforms.test.element.app.enumtype.page;


import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.TestElement;
import jp.dataforms.test.element.controller.QueryResultFormTestElement;
import jp.dataforms.test.element.field.FieldTestElement;
import jp.dataforms.test.element.htmltable.TableTestElement;
import jp.dataforms.test.selenium.Browser;


/**
 * EnumQueryResultForm フォームテスト要素。 
 */
public class EnumQueryResultFormTestElement extends QueryResultFormTestElement {
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
	 * 列挙型ID。
	 */
	public static final String ID_ENUM_ID = "enumId";

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
	 * 親IDフィールド。
	 */
	public static final String ID_PARENT_ID = "parentId";

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
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param parent 親コンポーネント。
	 * @param webElement FormのWebElement。
	 */
	public EnumQueryResultFormTestElement(final Browser browser, final TestElement parent, final WebElement webElement) {
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
	 * 列挙型IDのテスト要素を取得します。
	 * @return 列挙型IDのテスト要素。
	 */
	public FieldTestElement getEnumId() {
		return this.getField(ID_ENUM_ID);
	}
	/**
	 * テーブルのテスト要素を取得します。
	 * @return テーブルのテスト要素。
	 */
	public TableTestElement getQueryResult() {
		return this.getTable(ID_QUERY_RESULT);
	}
	
}
