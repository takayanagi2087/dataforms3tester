package jp.dataforms.test.element.devtool.query.page;


import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.TestElement;
import jp.dataforms.test.element.controller.QueryResultFormTestElement;
import jp.dataforms.test.element.field.FieldTestElement;
import jp.dataforms.test.element.htmltable.TableTestElement;
import jp.dataforms.test.selenium.Browser;


/**
 * QueryExecutorQueryResultForm フォームテスト要素。 
 */
public class QueryExecutorQueryResultFormTestElement extends QueryResultFormTestElement {
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
	public static final String ID_DUMMY_DATE = "dummyDate";

	/**
	 * 。
	 */
	public static final String ID_DUMMY_TIMESTAMP = "dummyTimestamp";

	/**
	 * 。
	 */
	public static final String ID_DUMMY_SMALLINT = "dummySmallint";

	/**
	 * 。
	 */
	public static final String ID_DUMMY_INTEGER = "dummyInteger";

	/**
	 * 。
	 */
	public static final String ID_DUMMY_BIGINT = "dummyBigint";

	/**
	 * 。
	 */
	public static final String ID_DUMMY_NUMERIC = "dummyNumeric";

	/**
	 * 。
	 */
	public static final String ID_DUMMY_CHAR = "dummyChar";

	/**
	 * ソート順。
	 */
	public static final String ID_DUMMY_SORT_ORDER = "dummySortOrder";

	// ----- テーブル関連定数 -----
	/**
	 * テーブル。
	 */
	public static final String ID_QUERY_RESULT = "queryResult";


	
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param parent 親コンポーネント。
	 * @param webElement FormのWebElement。
	 */
	public QueryExecutorQueryResultFormTestElement(final Browser browser, final TestElement parent, final WebElement webElement) {
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
	public FieldTestElement getDummyDate() {
		return this.getField(ID_DUMMY_DATE);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getDummyTimestamp() {
		return this.getField(ID_DUMMY_TIMESTAMP);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getDummySmallint() {
		return this.getField(ID_DUMMY_SMALLINT);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getDummyInteger() {
		return this.getField(ID_DUMMY_INTEGER);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getDummyBigint() {
		return this.getField(ID_DUMMY_BIGINT);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getDummyNumeric() {
		return this.getField(ID_DUMMY_NUMERIC);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getDummyChar() {
		return this.getField(ID_DUMMY_CHAR);
	}
	/**
	 * ソート順のテスト要素を取得します。
	 * @return ソート順のテスト要素。
	 */
	public FieldTestElement getDummySortOrder() {
		return this.getField(ID_DUMMY_SORT_ORDER);
	}
	/**
	 * テーブルのテスト要素を取得します。
	 * @return テーブルのテスト要素。
	 */
	public TableTestElement getQueryResult() {
		return this.getTable(ID_QUERY_RESULT);
	}
	
}
