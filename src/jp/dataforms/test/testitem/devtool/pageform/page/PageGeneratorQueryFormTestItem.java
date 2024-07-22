package jp.dataforms.test.testitem.devtool.pageform.page;

import jp.dataforms.fw.devtool.pageform.page.PageGeneratorQueryForm;
import jp.dataforms.test.devtool.pageform.page.TestSrcGeneratorPage;
import jp.dataforms.test.testitem.TestItem;


/**
 * PageGeneratorQueryFormテスト項目基本クラス。
 */
public abstract class PageGeneratorQueryFormTestItem extends TestItem {
	/**
	 * コンストラクタ。
	 * @param condition テスト条件。
	 * @param expected 期待値。
	 */
	public PageGeneratorQueryFormTestItem(final String condition, final String expected) {
		super(TestSrcGeneratorPage.class, PageGeneratorQueryForm.class, condition, expected);
	}
}

