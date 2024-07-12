package jp.dataforms.test.testitem.app.login.page.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.dataforms.test.annotation.TestItemInfo;
import jp.dataforms.test.annotation.TestItemInfo.Type;
import jp.dataforms.test.element.controller.FormTestElement;
import jp.dataforms.test.element.controller.PageTestElement;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.testitem.app.login.page.LoginFormTestItem;

/**
 * LoginFormのバリデーション。
 */
@TestItemInfo(group = "validation", seq = "001", type = Type.ERROR)
public class EnptyValidationTestItem extends LoginFormTestItem {
	/**
	 * Logger.
	 */
	private static Logger logger = LogManager.getLogger(EnptyValidationTestItem.class);

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
	public EnptyValidationTestItem() {
		super(CONDITION, EXPECTED);
	}
	
	
	@Override
	protected ResultType test(final Browser browser) throws Exception {
		PageTestElement pageTestElement = browser.getPageTestElement();
		FormTestElement f = pageTestElement.getForm("loginForm");
		f.getButton("loginButton").click();
		Browser.sleep(2);
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
