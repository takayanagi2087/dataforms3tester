package jp.dataforms.test.testitem.devtool.pageform.page;

import jp.dataforms.test.testitem.TestItem;
import jp.dataforms.fw.devtool.pageform.page.DaoAndPageGeneratorPage;
import jp.dataforms.fw.devtool.pageform.page.PageGeneratorQueryResultForm;


/**
 * PageGeneratorQueryResultFormテスト項目基本クラス。
 */
public abstract class PageGeneratorQueryResultFormTestItem extends TestItem {
	/**
	 * コンストラクタ。
	 * @param condition テスト条件。
	 * @param expected 期待値。
	 */
	public PageGeneratorQueryResultFormTestItem(final String condition, final String expected) {
		super(DaoAndPageGeneratorPage.class, PageGeneratorQueryResultForm.class, condition, expected);
	}
}

