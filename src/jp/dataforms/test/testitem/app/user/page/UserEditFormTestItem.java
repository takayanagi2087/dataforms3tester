package jp.dataforms.test.testitem.app.user.page;

import jp.dataforms.test.testitem.TestItem;
import jp.dataforms.fw.app.user.page.UserManagementPage;
import jp.dataforms.fw.app.user.page.UserEditForm;


/**
 * UserEditFormテスト項目基本クラス。
 */
public abstract class UserEditFormTestItem extends TestItem {
	/**
	 * コンストラクタ。
	 * @param condition テスト条件。
	 * @param expected 期待値。
	 */
	public UserEditFormTestItem(final String condition, final String expected) {
		super(UserManagementPage.class, UserEditForm.class, condition, expected);
	}
}

