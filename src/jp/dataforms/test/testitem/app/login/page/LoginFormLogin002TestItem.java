package jp.dataforms.test.testitem.app.login.page;

import jp.dataforms.test.annotation.TestItemInfo;
import jp.dataforms.test.annotation.TestItemInfo.Type;
import jp.dataforms.test.selenium.Browser;

/**
 * 管理者ログインテスト項目。
 */
@TestItemInfo(
	group = "login",		// テスト項目を分類する文字列を指定します。
	seq = "002",			// テストの実行順を指定します。
	type = Type.NORMAL, 	// Type.NORMAL or Type.ERROR or Type.BOUNDARY
	regression = true		// 回帰テストで使用する項目の場合trueを指定します。
)
public class LoginFormLogin002TestItem extends LoginTestItem {
	/**
	 * Logger.
	 */
	// private static Logger logger = LogManager.getLogger(PadPasswordTestItem.class);

	/**
	 * テスト条件。
	 */
	private static final String CONDITION = """
		管理者でログインする。
		""";

	/**
	 * 期待値。
	 */
	private static final String EXPECTED = """
		管理者のサイトマップが表示されること。
		""";

	/**
	 * コンストラクタ。
	 */
	public LoginFormLogin002TestItem() {
		super(CONDITION, EXPECTED);
	}
	
	@Override
	protected String getLoginId() {
		return "admin";
	}
	
	@Override
	protected ResultType checkSiteMap(final Browser browser) {
		ResultType ret = ResultType.SYSTEM_NG;
		if (!this.findLink(browser, "/devtool/menu/page/MenuEditPage.df")) {
			// 開発者ページが表示されていないことを確認。
			ret = ResultType.SYSTEM_OK;
		}
		return ret;
	}

}
