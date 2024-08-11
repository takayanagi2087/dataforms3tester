package jp.dataforms.test.testitem.app.enumtype.page;

import jp.dataforms.test.testitem.TestItem;
import jp.dataforms.fw.app.enumtype.page.EnumPage;
import jp.dataforms.fw.app.enumtype.page.EnumEditForm;


/**
 * EnumEditFormテスト項目基本クラス。
 */
public abstract class EnumEditFormTestItem extends TestItem {
	/**
	 * コンストラクタ。
	 * @param condition テスト条件。
	 * @param expected 期待値。
	 */
	public EnumEditFormTestItem(final String condition, final String expected) {
		super(EnumPage.class, EnumEditForm.class, condition, expected);
	}
}

