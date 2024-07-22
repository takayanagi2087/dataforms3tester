package jp.dataforms.test.testitem.devtool.pageform.page;

import jp.dataforms.fw.devtool.pageform.page.DaoAndPageGeneratorEditForm;
import jp.dataforms.fw.devtool.pageform.page.DaoAndPageGeneratorPage;
import jp.dataforms.test.testitem.TestItem;


/**
 * DaoAndPageGeneratorEditFormテスト項目基本クラス。
 */
public abstract class DaoAndPageGeneratorEditFormTestItem extends TestItem {
	/**
	 * コンストラクタ。
	 * @param condition テスト条件。
	 * @param expected 期待値。
	 */
	public DaoAndPageGeneratorEditFormTestItem(final String condition, final String expected) {
		super(DaoAndPageGeneratorPage.class, DaoAndPageGeneratorEditForm.class, condition, expected);
	}
}

