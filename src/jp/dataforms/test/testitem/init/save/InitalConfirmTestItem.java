package jp.dataforms.test.testitem.init.save;

import jp.dataforms.test.annotation.TestItemInfo;
import jp.dataforms.test.devtool.InitDevelopmentToolFormTestElement;
import jp.dataforms.test.devtool.InitDevelopmentToolPageTestElement;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.testitem.init.InitTestItem;

/**
 * プロジェクト初期化ページの初期表示テスト。
 */
@TestItemInfo(group = "init", seq = "002")
public class InitalConfirmTestItem extends InitTestItem {
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
	public InitalConfirmTestItem() {
		super(CONDITION, EXPECTED);
	}
	
	
	@Override
	protected ResultType test(Browser browser) throws Exception {
		InitDevelopmentToolPageTestElement p = this.getInitDevelopmentToolPageTestElement(browser);
		InitDevelopmentToolFormTestElement f = p.getInitDevelopmentToolForm();
		f.getConfirmButton().click();
		Browser.sleep(2);
		return ResultType.SYSTEM_OK;
	}
}
