package jp.dataforms.test.element.app.user.page;


import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.TestElement;
import jp.dataforms.test.element.controller.QueryResultFormTestElement;
import jp.dataforms.test.element.field.FieldTestElement;
import jp.dataforms.test.element.htmltable.TableTestElement;
import jp.dataforms.test.selenium.Browser;


/**
 * UserQueryResultForm フォームテスト要素。 
 */
public class UserQueryResultFormTestElement extends QueryResultFormTestElement {
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
	 * ユーザを示すID。
	 */
	public static final String ID_USER_ID = "userId";

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
	 * ログインID。
	 */
	public static final String ID_LOGIN_ID = "loginId";

	/**
	 * 氏名。
	 */
	public static final String ID_USER_NAME = "userName";

	/**
	 * 列挙型名称。
	 */
	public static final String ID_ATTRIBUTE0 = "attribute0";

	/**
	 * 列挙型名称。
	 */
	public static final String ID_ATTRIBUTE1 = "attribute1";

	/**
	 * 列挙型名称。
	 */
	public static final String ID_ATTRIBUTE2 = "attribute2";

	/**
	 * 列挙型名称。
	 */
	public static final String ID_ATTRIBUTE3 = "attribute3";

	/**
	 * 列挙型名称。
	 */
	public static final String ID_ATTRIBUTE4 = "attribute4";

	/**
	 * 列挙型名称。
	 */
	public static final String ID_ATTRIBUTE5 = "attribute5";

	/**
	 * 列挙型名称。
	 */
	public static final String ID_ATTRIBUTE6 = "attribute6";

	/**
	 * 列挙型名称。
	 */
	public static final String ID_ATTRIBUTE7 = "attribute7";

	/**
	 * 列挙型名称。
	 */
	public static final String ID_ATTRIBUTE8 = "attribute8";

	/**
	 * 列挙型名称。
	 */
	public static final String ID_ATTRIBUTE9 = "attribute9";


	
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param parent 親コンポーネント。
	 * @param webElement FormのWebElement。
	 */
	public UserQueryResultFormTestElement(final Browser browser, final TestElement parent, final WebElement webElement) {
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
	 * ユーザを示すIDのテスト要素を取得します。
	 * @return ユーザを示すIDのテスト要素。
	 */
	public FieldTestElement getUserId() {
		return this.getField(ID_USER_ID);
	}
	/**
	 * テーブルのテスト要素を取得します。
	 * @return テーブルのテスト要素。
	 */
	public TableTestElement getQueryResult() {
		return this.getTable(ID_QUERY_RESULT);
	}
	
}
