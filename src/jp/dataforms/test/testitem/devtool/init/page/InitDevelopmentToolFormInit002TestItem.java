package jp.dataforms.test.testitem.devtool.init.page;

import jp.dataforms.test.annotation.TestItemInfo;
import jp.dataforms.test.element.devtool.init.page.InitDevelopmentToolFormTestElement;
import jp.dataforms.test.element.devtool.init.page.InitDevelopmentToolPageTestElement;
import jp.dataforms.test.selenium.Browser;

/**
 * プロジェクト初期化ページの初期表示テスト。
 */
@TestItemInfo(group = "init", seq = "002")
public class InitDevelopmentToolFormInit002TestItem extends InitDevelopmentToolFormTestItem {
	
	/**
	 * テスト条件。
	 */
	private static final String CONDITION = """
		プロジェクト初期化画面で確認ボタンを押下する。
		""";

	/**
	 * 期待値。
	 */
	private static final String EXPECTED = """
		画面がロックされること。
		""";

	/**
	 * コンストラクタ。
	 */
	public InitDevelopmentToolFormInit002TestItem() {
		super(CONDITION, EXPECTED);
	}
	
	
	@Override
	protected ResultType test(final Browser browser) throws Exception {
		InitDevelopmentToolPageTestElement p = browser.getPageTestElement(InitDevelopmentToolPageTestElement.class);
		InitDevelopmentToolFormTestElement f = p.getInitDevelopmentToolForm();
		f.getConfirmButton().click();
		Browser.sleep(2);
		return ResultType.SYSTEM_OK;
	}
}
