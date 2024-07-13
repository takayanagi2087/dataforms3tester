package jp.dataforms.test.testitem.devtool.init.page;

import jp.dataforms.test.annotation.TestItemInfo;
import jp.dataforms.test.element.devtool.init.page.InitDevelopmentToolFormTestElement;
import jp.dataforms.test.element.devtool.init.page.InitDevelopmentToolPageTestElement;
import jp.dataforms.test.selenium.Browser;

/**
 * プロジェクト初期化ページの初期表示テスト。
 */
@TestItemInfo(group = "init", seq = "003")
public class InitDevelopmentToolFormInit003TestItem extends InitDevelopmentToolFormTestItem {
	/**
	 * テスト条件。
	 */
	private static final String CONDITION = """
		プロジェクト初期化画面で保存ボタンを押下する。
		""";

	/**
	 * 期待値。
	 */
	private static final String EXPECTED = """
		DBの初期化ページへのリンクが表示されること。
		""";

	/**
	 * コンストラクタ。
	 */
	public InitDevelopmentToolFormInit003TestItem() {
		super(CONDITION, EXPECTED);
	}
	
	
	@Override
	protected ResultType test(Browser browser) throws Exception {
		// プロジェクトの初期化画面。
		InitDevelopmentToolPageTestElement p = browser.getPageTestElement(InitDevelopmentToolPageTestElement.class);
		InitDevelopmentToolFormTestElement f = p.getInitDevelopmentToolForm();
		f.getSaveButton().click();
		Browser.sleep(2);
		return ResultType.SYSTEM_OK;
	}
}
