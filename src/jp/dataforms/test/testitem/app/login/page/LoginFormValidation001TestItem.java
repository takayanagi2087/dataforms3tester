package jp.dataforms.test.testitem.app.login.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.dataforms.test.annotation.TestItemInfo;
import jp.dataforms.test.annotation.TestItemInfo.Type;
import jp.dataforms.test.element.controller.FormTestElement;
import jp.dataforms.test.element.controller.PageTestElement;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.testitem.TestItem;

/**
 * LoginFormのバリデーション。
 */
@TestItemInfo(
	group = "validation",	// テスト項目を分類する文字列を指定します。
	seq = "001",			// テストの実行順を指定します。
	type = Type.ERROR,		// Type.NORMAL or Type.ERROR or Type.BOUNDARY
	regression = false		// 回帰テストで使用する項目の場合trueを指定します。
)
public class LoginFormValidation001TestItem extends LoginFormTestItem {
	/**
	 * Logger.
	 */
	private static Logger logger = LogManager.getLogger(LoginFormValidation001TestItem.class);

	/**
	 * テスト条件。
	 */
	private static final String CONDITION = """
		何も入力しないでログインボタンを押下する。
		""";

	/**
	 * 期待値。
	 */
	private static final String EXPECTED = """
		「ログインID.が入力されていません。」というメッセージが表示されること。				
		""";

	/**
	 * コンストラクタ。
	 */
	public LoginFormValidation001TestItem() {
		super(CONDITION, EXPECTED);
	}
	
	
	@Override
	protected ResultType test(final Browser browser) throws Exception {
		PageTestElement pageTestElement = browser.getPageTestElement();
		FormTestElement f = pageTestElement.getForm("loginForm");
		f.getButton("loginButton").click();
		Browser.sleep(TestItem.getConf().getTestApp().getShortWait());
		String message = pageTestElement.getErrorMessage();
		logger.debug("text=" + message);
		this.saveScreenShot(browser);
		if ("ログインID.が入力されていません。".equals(message)) {
			return ResultType.SYSTEM_OK;
		} else {
			return ResultType.SYSTEM_NG;
		}
	}

}
