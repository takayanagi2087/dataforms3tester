package jp.dataforms.test.testitem.devtool.db.page;

import jp.dataforms.fw.devtool.init.page.InitDevelopmentToolForm;
import jp.dataforms.fw.devtool.init.page.InitDevelopmentToolPage;
import jp.dataforms.test.testitem.TestItem;

/**
 * 開発者編集フォームのテスト項目のベースクラス。
 */
public abstract class DeveloperEditFormTestItem extends TestItem {
	/**
	 * コンストラクタ。
	 * @param condition テスト条件。
	 * @param expected 期待値。
	 */
	public DeveloperEditFormTestItem(final String condition, final String expected) {
		super(InitDevelopmentToolPage.class, InitDevelopmentToolForm.class, condition, expected);
	}
}
