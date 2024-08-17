package jp.dataforms.test.testitem.devtool.query.page;

import jp.dataforms.test.testitem.TestItem;
import jp.dataforms.fw.devtool.query.page.QueryGeneratorPage;
import jp.dataforms.fw.devtool.query.page.QueryGeneratorEditForm;


/**
 * QueryGeneratorEditFormテスト項目基本クラス。
 */
public abstract class QueryGeneratorEditFormTestItem extends TestItem {
	/**
	 * コンストラクタ。
	 * @param condition テスト条件。
	 * @param expected 期待値。
	 */
	public QueryGeneratorEditFormTestItem(final String condition, final String expected) {
		super(QueryGeneratorPage.class, QueryGeneratorEditForm.class, condition, expected);
	}
}

