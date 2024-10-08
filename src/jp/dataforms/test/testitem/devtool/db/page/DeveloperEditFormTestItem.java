package jp.dataforms.test.testitem.devtool.db.page;

import jp.dataforms.fw.devtool.db.page.DeveloperEditForm;
import jp.dataforms.fw.devtool.db.page.InitializeDatabasePage;
import jp.dataforms.test.testitem.TestItem;


/**
 * DeveloperEditFormテスト項目基本クラス。
 */
public abstract class DeveloperEditFormTestItem extends TestItem {
	/**
	 * コンストラクタ。
	 * @param condition テスト条件。
	 * @param expected 期待値。
	 */
	public DeveloperEditFormTestItem(final String condition, final String expected) {
		super(InitializeDatabasePage.class, DeveloperEditForm.class, condition, expected);
	}
}

