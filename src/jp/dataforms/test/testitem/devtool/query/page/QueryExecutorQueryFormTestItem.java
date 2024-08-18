package jp.dataforms.test.testitem.devtool.query.page;

import jp.dataforms.test.testitem.TestItem;
import jp.dataforms.fw.devtool.query.page.QueryExecutorPage;
import jp.dataforms.fw.devtool.query.page.QueryExecutorQueryForm;


/**
 * QueryExecutorQueryFormテスト項目基本クラス。
 */
public abstract class QueryExecutorQueryFormTestItem extends TestItem {
	/**
	 * コンストラクタ。
	 * @param condition テスト条件。
	 * @param expected 期待値。
	 */
	public QueryExecutorQueryFormTestItem(final String condition, final String expected) {
		super(QueryExecutorPage.class, QueryExecutorQueryForm.class, condition, expected);
	}
}

