package jp.dataforms.test.testitem.app.login.page;

import jp.dataforms.test.annotation.TestItemInfo;
import jp.dataforms.test.annotation.TestItemInfo.Type;
import jp.dataforms.test.selenium.Browser;

/**
 * 管理者ログインテスト項目。
 */
@TestItemInfo(
	group = "login",		// テスト項目を分類する文字列を指定します。
	seq = "003",			// テストの実行順を指定します。
	type = Type.NORMAL, 	// Type.NORMAL or Type.ERROR or Type.BOUNDARY
	regression = true		// 回帰テストで使用する項目の場合trueを指定します。
)
public class LoginFormLogin003TestItem extends LoginTestItem {
	/**
	 * Logger.
	 */
	// private static Logger logger = LogManager.getLogger(PadPasswordTestItem.class);

	/**
	 * テスト条件。
	 */
	private static final String CONDITION = """
		一般ユーザでログインする。
		""";

	/**
	 * 期待値。
	 */
	private static final String EXPECTED = """
		一般ユーザのサイトマップが表示されること。
		""";

	/**
	 * コンストラクタ。
	 */
	public LoginFormLogin003TestItem() {
		super(CONDITION, EXPECTED);
	}
	
	@Override
	protected String getLoginId() {
		return "user";
	}
	
	@Override
	protected ResultType checkSiteMap(final Browser browser) {
		ResultType ret = ResultType.SYSTEM_NG;
		if (!this.findLink(browser, "/app/user/page/UserManagementPage.df")) {
			// 管理者ページが表示されていないことを確認。
			ret = ResultType.SYSTEM_OK;
		}
		return ret;
	}
	
}
