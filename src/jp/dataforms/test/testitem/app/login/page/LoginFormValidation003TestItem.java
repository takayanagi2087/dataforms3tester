package jp.dataforms.test.testitem.app.login.page;

import org.openqa.selenium.Dimension;

import jp.dataforms.test.annotation.TestItemInfo;
import jp.dataforms.test.annotation.TestItemInfo.Type;
import jp.dataforms.test.element.controller.AlertDialogTestElement;
import jp.dataforms.test.element.controller.FormTestElement;
import jp.dataforms.test.element.controller.PageTestElement;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.testitem.TestItem;

/**
 * LoginFormのバリデーション。
 */
@TestItemInfo(
	group = "validation",	// テスト項目を分類する文字列を指定します。
	seq = "003",			// テストの実行順を指定します。
	type = Type.ERROR,		// Type.NORMAL or Type.ERROR or Type.BOUNDARY
	regression = false		// 回帰テストで使用する項目の場合trueを指定します。
)
public class LoginFormValidation003TestItem extends LoginFormTestItem {
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
	public LoginFormValidation003TestItem() {
		super(CONDITION, EXPECTED);
	}
	
	
	@Override
	protected void start(final Browser browser) throws Exception {
		browser.reload();
	}
	
	@Override
	protected ResultType test(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(1024, 400));
		PageTestElement pageTestElement = browser.getPageTestElement();
		FormTestElement f = pageTestElement.getForm("loginForm");
		f.getField("loginId").setValue("user");
		f.getField("password").setValue("PadPassword");
		f.getButton("loginButton").click();
		Browser.sleep(TestItem.getConf().getTestApp().getShortWait());
		AlertDialogTestElement alertDialog = pageTestElement.getAlertDialog();
		String msg = alertDialog.getMessage();
		this.saveScreenShot(browser, "認証エラーメッセージ");
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
