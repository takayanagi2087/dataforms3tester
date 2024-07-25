package jp.dataforms.test.testitem.app.login.page;

import org.openqa.selenium.Dimension;

import jp.dataforms.test.annotation.TestItemInfo;
import jp.dataforms.test.annotation.TestItemInfo.Type;
import jp.dataforms.test.selenium.Browser;

/**
 * 開発者ログインテスト項目。
 */
@TestItemInfo(
	// テスト項目の情報を記述します。
	group = "login",		// テスト項目を分類する文字列を指定します。
	seq = "001", 			// テストの実行順を指定します。 
	type = Type.NORMAL, 	// Type.NORMAL or Type.ERROR or Type.BOUNDARY
	regression = true		// 回帰テストで使用する項目の場合trueを指定します。
)
public class LoginFormLogin001TestItem extends LoginTestItem {
	/**
	 * Logger.
	 */
	 // private static Logger logger = LogManager.getLogger(DeveloperLoginTestItem.class);

	/**
	 * テスト条件。
	 */
	private static final String CONDITION = """
		開発者でログインする。
		""";

	/**
	 * 期待値。
	 */
	private static final String EXPECTED = """
		開発者のサイトマップが表示されること。
		""";

	/**
	 * コンストラクタ。
	 */
	public LoginFormLogin001TestItem() {
		super(CONDITION, EXPECTED);
	}
	
	@Override
	protected String getLoginId() {
		return "developer";
	}
	
	@Override
	protected void saveResult(Browser browser, ResultType result) throws Exception {
		browser.setClientSize(new Dimension(1024, 800));
		super.saveResult(browser, result);
	}
	
	@Override
	protected ResultType checkSiteMap(final Browser browser) {
		ResultType ret = ResultType.SYSTEM_NG;
		if (this.findLink(browser, "/devtool/menu/page/MenuEditPage.html")) {
			ret = ResultType.SYSTEM_OK;
		}
		return ret;
	}
	
}
