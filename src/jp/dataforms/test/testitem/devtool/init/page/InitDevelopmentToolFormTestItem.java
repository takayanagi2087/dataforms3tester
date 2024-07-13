package jp.dataforms.test.testitem.devtool.init.page;

import jp.dataforms.fw.devtool.init.page.InitDevelopmentToolForm;
import jp.dataforms.fw.devtool.init.page.InitDevelopmentToolPage;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.testitem.TestItem;

/**
 * プロジェクト初期化ページのテスト。
 */
public  abstract class InitDevelopmentToolFormTestItem extends TestItem {
	/**
	 * コンストラクタ。
	 * @param condition テスト条件。
	 * @param expected 期待値。
	 */
	public InitDevelopmentToolFormTestItem(final String condition, final String expected) {
		super(InitDevelopmentToolPage.class, InitDevelopmentToolForm.class, condition, expected);
	}

	@Override
	protected  abstract ResultType test(Browser browser) throws Exception;

}
