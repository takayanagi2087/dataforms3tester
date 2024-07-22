package jp.dataforms.test.testitem.devtool.menu.page;

import jp.dataforms.fw.devtool.menu.page.MenuEditForm;
import jp.dataforms.fw.devtool.menu.page.MenuEditPage;
import jp.dataforms.test.testitem.TestItem;


/**
 * MenuEditFormテスト項目基本クラス。
 */
public abstract class MenuEditFormTestItem extends TestItem {
	/**
	 * コンストラクタ。
	 * @param condition テスト条件。
	 * @param expected 期待値。
	 */
	public MenuEditFormTestItem(final String condition, final String expected) {
		super(MenuEditPage.class, MenuEditForm.class, condition, expected);
	}
}

