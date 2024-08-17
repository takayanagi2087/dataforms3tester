package jp.dataforms.test.testitem.devtool.query.page;

import jp.dataforms.test.testitem.TestItem;
import jp.dataforms.fw.devtool.query.page.QueryGeneratorPage;
import jp.dataforms.fw.devtool.query.page.QueryGeneratorQueryResultForm;


/**
 * QueryGeneratorQueryResultFormテスト項目基本クラス。
 */
public abstract class QueryGeneratorQueryResultFormTestItem extends TestItem {
	/**
	 * コンストラクタ。
	 * @param condition テスト条件。
	 * @param expected 期待値。
	 */
	public QueryGeneratorQueryResultFormTestItem(final String condition, final String expected) {
		super(QueryGeneratorPage.class, QueryGeneratorQueryResultForm.class, condition, expected);
	}
}

