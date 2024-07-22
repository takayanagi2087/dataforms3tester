package jp.dataforms.test.testitem.devtool.pageform.page;

import jp.dataforms.fw.devtool.pageform.page.PageGeneratorQueryResultForm;
import jp.dataforms.test.devtool.pageform.page.TestSrcGeneratorPage;
import jp.dataforms.test.testitem.TestItem;


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
		super(TestSrcGeneratorPage.class, PageGeneratorQueryResultForm.class, condition, expected);
	}
}

