package jp.dataforms.test.testitem.app.login.page.validation;

import java.util.List;

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
@TestItemInfo(group = "validation", seq = "002", type = Type.ERROR)
public class LoginIdOnlyValidationTestItem extends LoginFormTestItem {
	/**
	 * Logger.
	 */
	private static Logger logger = LogManager.getLogger(LoginIdOnlyValidationTestItem.class);

	/**
	 * テスト条件。
	 */
	private static final String CONDITION = """
		ログインIDのみを入力しログインボタンを押下する。
		""";

	/**
	 * 期待値。
	 */
	private static final String EXPECTED = """
		「パスワードが入力されていません。」「パスキーが入力されていません。」というメッセージが表示されること。
		""";

	/**
	 * コンストラクタ。
	 */
	public LoginIdOnlyValidationTestItem() {
		super(CONDITION, EXPECTED);
	}
	
	
	@Override
	protected ResultType test(final Browser browser) throws Exception {
		PageTestElement pageTestElement = browser.getPageTestElement();
		FormTestElement f = pageTestElement.getForm("loginForm");
		f.getField("loginId").setValue("user");
		f.getButton("loginButton").click();
		Browser.sleep(2);
	//	String message = pageTestElement.findWebElement(By.id("errorMessages")).getText().trim();
		List<String> messageList = pageTestElement.getErrorMessageList();
		logger.debug("text=" + messageList);
		this.saveScreenShot(browser);
		if (messageList.indexOf("パスワードが入力されていません。") >= 0 
			&& messageList.indexOf("パスキーが入力されていません。") >= 0) {
			return ResultType.SYSTEM_OK;
		} else {
			return ResultType.SYSTEM_NG;
		}
	}
}
