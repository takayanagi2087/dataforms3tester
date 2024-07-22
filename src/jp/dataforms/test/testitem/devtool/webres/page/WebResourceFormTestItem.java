package jp.dataforms.test.testitem.devtool.webres.page;

import jp.dataforms.test.testitem.TestItem;
import jp.dataforms.fw.devtool.webres.page.WebResourcePage;
import jp.dataforms.fw.devtool.webres.page.WebResourceForm;


/**
 * WebResourceFormテスト項目基本クラス。
 */
public abstract class WebResourceFormTestItem extends TestItem {
	/**
	 * コンストラクタ。
	 * @param condition テスト条件。
	 * @param expected 期待値。
	 */
	public WebResourceFormTestItem(final String condition, final String expected) {
		super(WebResourcePage.class, WebResourceForm.class, condition, expected);
	}
}

