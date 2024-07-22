package jp.dataforms.test.testitem.devtool.db.page;

import jp.dataforms.fw.devtool.db.page.TableManagementPage;
import jp.dataforms.fw.devtool.db.page.TableManagementQueryResultForm;
import jp.dataforms.test.testitem.TestItem;


/**
 * TableManagementQueryResultFormテスト項目基本クラス。
 */
public abstract class TableManagementQueryResultFormTestItem extends TestItem {
	/**
	 * コンストラクタ。
	 * @param condition テスト条件。
	 * @param expected 期待値。
	 */
	public TableManagementQueryResultFormTestItem(final String condition, final String expected) {
		super(TableManagementPage.class, TableManagementQueryResultForm.class, condition, expected);
	}
}

