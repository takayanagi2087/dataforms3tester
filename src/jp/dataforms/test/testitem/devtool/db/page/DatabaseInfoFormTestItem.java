package jp.dataforms.test.testitem.devtool.db.page;

import jp.dataforms.test.testitem.TestItem;
import jp.dataforms.fw.devtool.db.page.InitializeDatabasePage;
import jp.dataforms.fw.devtool.db.page.DatabaseInfoForm;


/**
 * DatabaseInfoFormテスト項目基本クラス。
 */
public abstract class DatabaseInfoFormTestItem extends TestItem {
	/**
	 * コンストラクタ。
	 * @param condition テスト条件。
	 * @param expected 期待値。
	 */
	public DatabaseInfoFormTestItem(final String condition, final String expected) {
		super(InitializeDatabasePage.class, DatabaseInfoForm.class, condition, expected);
	}
}

