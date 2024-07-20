package jp.dataforms.test.testitem.devtool.pageform.page;

import jp.dataforms.test.testitem.TestItem;
import jp.dataforms.fw.devtool.pageform.page.DaoAndPageGeneratorPage;
import jp.dataforms.fw.devtool.pageform.page.PageGeneratorQueryForm;


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
		super(DaoAndPageGeneratorPage.class, PageGeneratorQueryForm.class, condition, expected);
	}
}

