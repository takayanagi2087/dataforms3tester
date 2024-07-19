package jp.dataforms.test.testitem.devtool.init.page;

import jp.dataforms.test.annotation.TestItemInfo;
import jp.dataforms.test.annotation.TestItemInfo.Type;
import jp.dataforms.test.element.devtool.init.page.InitDevelopmentToolFormTestElement;
import jp.dataforms.test.element.devtool.init.page.InitDevelopmentToolPageTestElement;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.testitem.TestItem;

/**
 * プロジェクト初期化ページの初期表示テスト。
 */
@TestItemInfo(
	group = "initproj",			// テスト項目を分類する文字列を指定します。
	seq = "003",			// テストの実行順を指定します。
	type = Type.NORMAL, 	// Type.NORMAL or Type.ERROR or Type.BOUNDARY
	regression = true		// 回帰テストで使用する項目の場合trueを指定します。
)
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
		Browser.sleep(TestItem.getConf().getTestApp().getShortWait());
		// TODO:チェック条件を追加
		ResultType ret = ResultType.SYSTEM_NG;
		if (f.getField("nextMessage").getWebElement().isDisplayed()) {
			ret = ResultType.SYSTEM_OK;
		}
		this.saveScreenShot(browser, "プロジェクト初期化完了時の表示");
		return ret;
	}
}
