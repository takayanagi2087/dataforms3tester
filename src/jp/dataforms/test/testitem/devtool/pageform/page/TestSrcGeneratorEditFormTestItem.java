package jp.dataforms.test.testitem.devtool.pageform.page;

import jp.dataforms.test.devtool.pageform.page.TestSrcGeneratorEditForm;
import jp.dataforms.test.devtool.pageform.page.TestSrcGeneratorPage;
import jp.dataforms.test.testitem.TestItem;


/**
 * TestSrcGeneratorEditFormテスト項目基本クラス。
 */
public abstract class TestSrcGeneratorEditFormTestItem extends TestItem {
	/**
	 * コンストラクタ。
	 * @param condition テスト条件。
	 * @param expected 期待値。
	 */
	public TestSrcGeneratorEditFormTestItem(final String condition, final String expected) {
		super(TestSrcGeneratorPage.class, TestSrcGeneratorEditForm.class, condition, expected);
	}
}

