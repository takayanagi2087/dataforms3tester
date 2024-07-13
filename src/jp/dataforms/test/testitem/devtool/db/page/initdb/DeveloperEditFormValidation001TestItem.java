package jp.dataforms.test.testitem.devtool.db.page.initdb;

import java.util.List;

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
	group = "validation", 		// テスト項目を分類する文字列を指定します。
	seq = "001",			// テストの実行順を指定します。 
	type = Type.ERROR, 	// Type.NORMAL or Type.ERROR or Type.BOUNDARY
	regression = false		// 回帰テストで使用する項目の場合trueを指定します。
)
public class DeveloperEditFormValidation001TestItem extends DeveloperEditFormTestItem {
	/**
	 * テスト条件。
	 */
	private static final String CONDITION = """
		何も入力せずに確認ボタンを押下する。
		""";

	/**
	 * 期待値。
	 */
	private static final String EXPECTED = """
		必須項目のチェックが行われること。
		""";

	/**
	 * コンストラクタ。
	 */
	public DeveloperEditFormValidation001TestItem() {
		super(CONDITION, EXPECTED);
	}
	
	/**
	 * メッセージリスト。
	 */
	private static final String[] MSG_LIST = {
		"ログインIDが入力されていません。",
		"パスワードが入力されていません。",
		"パスワード(確認)が入力されていません。",
		"氏名が入力されていません。",
	};
	
	
	@Override
	protected ResultType test(Browser browser) throws Exception {
		InitializeDatabasePageTestElement p = browser.getPageTestElement(InitializeDatabasePageTestElement.class);
		DeveloperEditFormTestElement f = p.getDeveloperEditForm();
		f.getLoginId().setValue("");;
		f.getUserName().setValue("");
		f.getPassword().setValue("");
		f.getPasswordCheck().setValue("");
		f.getConfirmButton().click();
		Browser.sleep(2);
		List<String> list = p.getErrorMessageList();
		ResultType ret = ResultType.SYSTEM_OK;
		for (String msg: MSG_LIST) {
			if (list.indexOf(msg) < 0) {
				ret = ResultType.SYSTEM_NG;
				break;
			}
		}
		this.saveScreenShot(browser);
		return ret;
	}

}
