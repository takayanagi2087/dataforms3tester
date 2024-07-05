package jp.dataforms.test.testitem.init.save;

import jp.dataforms.test.annotation.TestItemInfo;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.testitem.init.InitTestItem;

/**
 * プロジェクト初期化ページの確認ボタンテスト。
 */
@TestItemInfo(group = "init", seq = "001")
public class InitalDispTestItem extends InitTestItem {
	/**
	 * テスト条件。
	 */
	private static final String CONDITION = """
		空のWEBアプリケーションプロジェクトをブラウザからアクセスする。
		""";

	/**
	 * 期待値。
	 */
	private static final String EXPECTED = """
		プロジェクト初期化ページが表示されること。
		""";

	/**
	 * コンストラクタ。
	 */
	public InitalDispTestItem() {
		super(CONDITION, EXPECTED);
	}
	
	
	@Override
	protected ResultType test(Browser browser) throws Exception {
		return ResultType.SYSTEM_OK;
	}

}
