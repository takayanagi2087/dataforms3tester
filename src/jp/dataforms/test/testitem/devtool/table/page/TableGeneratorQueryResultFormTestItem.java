package jp.dataforms.test.testitem.devtool.table.page;

import jp.dataforms.fw.devtool.table.page.TableGeneratorPage;
import jp.dataforms.fw.devtool.table.page.TableGeneratorQueryResultForm;
import jp.dataforms.test.testitem.TestItem;


/**
 * TableGeneratorQueryResultFormテスト項目基本クラス。
 */
public abstract class TableGeneratorQueryResultFormTestItem extends TestItem {
	/**
	 * コンストラクタ。
	 * @param condition テスト条件。
	 * @param expected 期待値。
	 */
	public TableGeneratorQueryResultFormTestItem(final String condition, final String expected) {
		super(TableGeneratorPage.class, TableGeneratorQueryResultForm.class, condition, expected);
	}
}

