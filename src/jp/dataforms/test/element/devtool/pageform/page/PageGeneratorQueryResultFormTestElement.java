package jp.dataforms.test.element.devtool.pageform.page;


import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.TestElement;
import jp.dataforms.test.element.controller.QueryResultFormTestElement;
import jp.dataforms.test.element.field.FieldTestElement;
import jp.dataforms.test.element.htmltable.TableTestElement;
import jp.dataforms.test.selenium.Browser;


/**
 * PageGeneratorQueryResultForm フォームテスト要素。 
 */
public class PageGeneratorQueryResultFormTestElement extends QueryResultFormTestElement {
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
	 * パッケージ名。
	 */
	public static final String ID_PACKAGE_NAME = "packageName";

	/**
	 * ページクラス名。
	 */
	public static final String ID_PAGE_CLASS_NAME = "pageClassName";

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
	 * クラス名。
	 */
	public static final String ID_FULL_CLASS_NAME = "fullClassName";

	/**
	 * クラス名。
	 */
	public static final String ID_DAO_CLASS_NAME = "daoClassName";

	/**
	 * 。
	 */
	public static final String ID_PAGE_PATTERN = "pagePattern";


	
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param parent 親コンポーネント。
	 * @param webElement FormのWebElement。
	 */
	public PageGeneratorQueryResultFormTestElement(final Browser browser, final TestElement parent, final WebElement webElement) {
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
	 * パッケージ名のテスト要素を取得します。
	 * @return パッケージ名のテスト要素。
	 */
	public FieldTestElement getPackageName() {
		return this.getField(ID_PACKAGE_NAME);
	}
	/**
	 * ページクラス名のテスト要素を取得します。
	 * @return ページクラス名のテスト要素。
	 */
	public FieldTestElement getPageClassName() {
		return this.getField(ID_PAGE_CLASS_NAME);
	}
	/**
	 * テーブルのテスト要素を取得します。
	 * @return テーブルのテスト要素。
	 */
	public TableTestElement getQueryResult() {
		return this.getTable(ID_QUERY_RESULT);
	}
	
}
