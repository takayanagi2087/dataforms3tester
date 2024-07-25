package jp.dataforms.test.testitem.app.login.page;

import jp.dataforms.test.annotation.TestItemInfo;
import jp.dataforms.test.annotation.TestItemInfo.Type;
import jp.dataforms.test.selenium.Browser;

/**
 * ゲストログインテスト項目。
 */
@TestItemInfo(
	group = "login",		// テスト項目を分類する文字列を指定します。
	seq = "004",			// テストの実行順を指定します。
	type = Type.NORMAL, 	// Type.NORMAL or Type.ERROR or Type.BOUNDARY
	regression = true		// 回帰テストで使用する項目の場合trueを指定します。
)
public class LoginFormLogin004TestItem extends LoginTestItem {
	/**
	 * Logger.
	 */
	// private static Logger logger = LogManager.getLogger(PadPasswordTestItem.class);

	/**
	 * テスト条件。
	 */
	private static final String CONDITION = """
		ゲストユーザでログインする。
		""";

	/**
	 * 期待値。
	 */
	private static final String EXPECTED = """
		ゲストユーザのサイトマップが表示されること。
		""";

	/**
	 * コンストラクタ。
	 */
	public LoginFormLogin004TestItem() {
		super(CONDITION, EXPECTED);
	}
	
	@Override
	protected String getLoginId() {
		return "guest";
	}
	
	@Override
	protected ResultType checkSiteMap(final Browser browser) {
		ResultType ret = ResultType.SYSTEM_NG;
		if (!this.findLink(browser, "/app/user/page/ChangePasswordPage.html")) {
			// ユーザページが表示されていないことを確認。
			ret = ResultType.SYSTEM_OK;
		}
		return ret;
	}
	
}
