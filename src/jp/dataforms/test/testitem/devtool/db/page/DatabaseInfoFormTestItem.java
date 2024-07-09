package jp.dataforms.test.testitem.devtool.db.page;

import jp.dataforms.fw.devtool.db.page.DatabaseInfoForm;
import jp.dataforms.fw.devtool.init.page.InitDevelopmentToolPage;
import jp.dataforms.test.testitem.TestItem;

/**
 * データベース編集フォームのテスト項目のベースクラス。
 */
public abstract class DatabaseInfoFormTestItem extends TestItem {
	/**
	 * コンストラクタ。
	 * @param condition テスト条件。
	 * @param expected 期待値。
	 */
	public DatabaseInfoFormTestItem(final String condition, final String expected) {
		super(InitDevelopmentToolPage.class, DatabaseInfoForm.class, condition, expected);
	}
}
