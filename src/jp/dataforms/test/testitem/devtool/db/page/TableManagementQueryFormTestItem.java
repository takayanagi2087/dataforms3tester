package jp.dataforms.test.testitem.devtool.db.page;

import jp.dataforms.fw.devtool.db.page.TableManagementPage;
import jp.dataforms.fw.devtool.db.page.TableManagementQueryForm;
import jp.dataforms.test.testitem.TestItem;


/**
 * TableManagementQueryFormテスト項目基本クラス。
 */
public abstract class TableManagementQueryFormTestItem extends TestItem {
	/**
	 * コンストラクタ。
	 * @param condition テスト条件。
	 * @param expected 期待値。
	 */
	public TableManagementQueryFormTestItem(final String condition, final String expected) {
		super(TableManagementPage.class, TableManagementQueryForm.class, condition, expected);
	}
}

