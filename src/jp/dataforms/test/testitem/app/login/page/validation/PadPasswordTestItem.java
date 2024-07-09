package jp.dataforms.test.testitem.app.login.page.validation;

import jp.dataforms.test.annotation.TestItemInfo;
import jp.dataforms.test.annotation.TestItemInfo.Type;
import jp.dataforms.test.element.controller.AlertDialogTestElement;
import jp.dataforms.test.element.controller.FormTestElement;
import jp.dataforms.test.element.controller.PageTestElement;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.testitem.app.login.page.LoginFormTestItem;

/**
 * LoginFormのバリデーション。
 */
@TestItemInfo(group = "validation", seq = "003", type = Type.ERROR)
public class PadPasswordTestItem extends LoginFormTestItem {
	/**
	 * Logger.
	 */
	// private static Logger logger = LogManager.getLogger(PadPasswordTestItem.class);

	/**
	 * テスト条件。
	 */
	private static final String CONDITION = """
		ユーザIDと間違ったパスワードを入力しログインボタンを押下する。
		""";

	/**
	 * 期待値。
	 */
	private static final String EXPECTED = """
		「ユーザIDまたはパスワードが違います。」というメッセージが表示されること。
		""";

	/**
	 * コンストラクタ。
	 */
	public PadPasswordTestItem() {
		super(CONDITION, EXPECTED);
	}
	
	
	@Override
	protected void start(final Browser browser) throws Exception {
		browser.reload();
	}
	
	@Override
	protected ResultType test(final Browser browser) throws Exception {
		PageTestElement pageTestElement = browser.getPageTestElement();
		FormTestElement f = pageTestElement.getForm("loginForm");
		f.getField("loginId").setValue("user");
		f.getField("password").setValue("PadPassword");
		f.getButton("loginButton").click();
		Browser.sleep(2);
		AlertDialogTestElement alertDialog = pageTestElement.getAlertDialog();
		String msg = alertDialog.getMessage();
		ResultType ret = null;
		if (msg.equals("ユーザIDまたはパスワードが違います。")) {
			ret = ResultType.SYSTEM_OK;
		} else {
			ret = ResultType.SYSTEM_NG;
		}
		return ret;
	}

	@Override
	protected void finish(final Browser browser) throws Exception {
		browser.getPageTestElement().getAlertDialog().clickOkButton();
	}
	
}
