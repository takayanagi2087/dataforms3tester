package jp.dataforms.test.testitem.devtool.table.page;

import jp.dataforms.test.testitem.TestItem;
import jp.dataforms.fw.devtool.table.page.TableGeneratorPage;
import jp.dataforms.fw.devtool.table.page.TableGeneratorEditForm;


/**
 * TableGeneratorEditFormテスト項目基本クラス。
 */
public abstract class TableGeneratorEditFormTestItem extends TestItem {
	/**
	 * コンストラクタ。
	 * @param condition テスト条件。
	 * @param expected 期待値。
	 */
	public TableGeneratorEditFormTestItem(final String condition, final String expected) {
		super(TableGeneratorPage.class, TableGeneratorEditForm.class, condition, expected);
	}
}

