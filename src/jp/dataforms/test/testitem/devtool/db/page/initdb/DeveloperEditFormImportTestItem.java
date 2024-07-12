package jp.dataforms.test.testitem.devtool.db.page.initdb;

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
	group = "import", 		// テスト項目を分類する文字列を指定します。
	seq = "001",			// テストの実行順を指定します。 
	type = Type.NORMAL, 	// Type.NORMAL or Type.ERROR or Type.BOUNDARY
	regression = false		// 回帰テストで使用する項目の場合trueを指定します。
)
public class DeveloperEditFormImportTestItem extends DeveloperEditFormTestItem {
	/**
	 * テスト条件。
	 */
	private static final String CONDITION = """
		「アプリケーションが用意したユーザをインポートする。」をチェックし、「確認」、「登録」ボタンを押下する。
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
	public DeveloperEditFormImportTestItem() {
		super(CONDITION, EXPECTED);
	}
	
	
	@Override
	protected ResultType test(Browser browser) throws Exception {
		InitializeDatabasePageTestElement p = browser.getPageTestElement(InitializeDatabasePageTestElement.class);
		DeveloperEditFormTestElement f = p.getDeveloperEditForm();
		f.getUserImportFlag().click();
		this.saveScreenShot(browser);
		f.getConfirmButton().click();
		this.saveScreenShot(browser);
		f.getSaveButton().click();
		p.waitVisibility("alertDialog");
		this.saveScreenShot(browser);
		p.getAlertDialog().clickOkButton();
		p.waitVisibility("loginForm");
		this.saveScreenShot(browser);
		ResultType ret = ResultType.SYSTEM_OK;
		return ret;
	}

}
