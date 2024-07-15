package jp.dataforms.test.testitem.devtool.init.page;

import jp.dataforms.test.annotation.TestItemInfo;
import jp.dataforms.test.annotation.TestItemInfo.Type;
import jp.dataforms.test.element.devtool.init.page.InitDevelopmentToolFormTestElement;
import jp.dataforms.test.element.devtool.init.page.InitDevelopmentToolPageTestElement;
import jp.dataforms.test.selenium.Browser;

/**
 * プロジェクト初期化ページの初期表示テスト。
 */
@TestItemInfo(
	group = "init",			// テスト項目を分類する文字列を指定します。
	seq = "002",			// テストの実行順を指定します。 
	type = Type.NORMAL, 	// Type.NORMAL or Type.ERROR or Type.BOUNDARY
	regression = true		// 回帰テストで使用する項目の場合trueを指定します。
)
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
		ResultType ret = ResultType.SYSTEM_OK;
		if (!f.isLocked()) {
			ret = ResultType.SYSTEM_NG;
		}
		this.saveScreenShot(browser);
		return ret;
	}
}
