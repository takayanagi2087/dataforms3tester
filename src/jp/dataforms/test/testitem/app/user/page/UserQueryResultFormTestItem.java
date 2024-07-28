package jp.dataforms.test.testitem.app.user.page;

import jp.dataforms.test.testitem.TestItem;
import jp.dataforms.fw.app.user.page.UserManagementPage;
import jp.dataforms.fw.app.user.page.UserQueryResultForm;


/**
 * UserQueryResultFormテスト項目基本クラス。
 */
public abstract class UserQueryResultFormTestItem extends TestItem {
	/**
	 * コンストラクタ。
	 * @param condition テスト条件。
	 * @param expected 期待値。
	 */
	public UserQueryResultFormTestItem(final String condition, final String expected) {
		super(UserManagementPage.class, UserQueryResultForm.class, condition, expected);
	}
}

