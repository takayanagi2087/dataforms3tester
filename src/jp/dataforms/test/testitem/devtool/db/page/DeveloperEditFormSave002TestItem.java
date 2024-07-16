package jp.dataforms.test.testitem.devtool.db.page;

import jp.dataforms.test.annotation.TestItemInfo;
import jp.dataforms.test.annotation.TestItemInfo.Type;
import jp.dataforms.test.element.devtool.db.page.DeveloperEditFormTestElement;
import jp.dataforms.test.element.devtool.db.page.InitializeDatabasePageTestElement;
import jp.dataforms.test.selenium.Browser;


/**
 * DatabaseInfoFormのテスト項目。
 */
@TestItemInfo(
	// テスト項目の情報を記述します。
	group = "save", 		// テスト項目を分類する文字列を指定します。
	seq = "002",			// テストの実行順を指定します。 
	type = Type.NORMAL, 	// Type.NORMAL or Type.ERROR or Type.BOUNDARY
	regression = true		// 回帰テストで使用する項目の場合trueを指定します。
)
public class DeveloperEditFormSave002TestItem extends DeveloperEditFormTestItem {
	/**
	 * テスト条件。
	 */
	private static final String CONDITION = """
		save-001の状態で、登録ボタンを押下する。
		""";

	/**
	 * 期待値。
	 */
	private static final String EXPECTED = """
		データベースの初期化御Alertダイアログが表示され、OKボタンの押下でログイン画面に遷移すること。
		""";

	/**
	 * コンストラクタ。
	 */
	public DeveloperEditFormSave002TestItem() {
		super(CONDITION, EXPECTED);
	}
	
	
	@Override
	protected ResultType test(Browser browser) throws Exception {
		InitializeDatabasePageTestElement p = browser.getPageTestElement(InitializeDatabasePageTestElement.class);
		DeveloperEditFormTestElement f = p.getDeveloperEditForm();
		this.saveScreenShot(browser, "「確認」ボタンの押下前の状態");
		f.getSaveButton().click();
		p.waitVisibility("alertDialog");
		this.saveScreenShot(browser, "データベース初期化後の状態");
		p.getAlertDialog().clickOkButton();
		p.waitVisibility("loginForm");
		this.saveScreenShot(browser, "データベース作成後のログイン画面");
		String title = browser.getTitle();
		ResultType ret = ResultType.SYSTEM_NG;
		if ("ログイン".equals(title) || "Login".equals(title)) {
			ret = ResultType.SYSTEM_OK;
		}
		return ret;
	}

}
