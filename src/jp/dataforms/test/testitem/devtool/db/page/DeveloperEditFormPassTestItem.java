package jp.dataforms.test.testitem.devtool.db.page;

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
	group = "validation", 	// テスト項目を分類する文字列を指定します。
	seq = "002",			// テストの実行順を指定します。 
	type = Type.NORMAL, 	// Type.NORMAL or Type.ERROR or Type.BOUNDARY
	regression = false		// 回帰テストで使用する項目の場合trueを指定します。
)
public class DeveloperEditFormPassTestItem extends DeveloperEditFormTestItem {
	/**
	 * テスト条件。
	 */
	private static final String CONDITION = """
		パスワードとパスワード(確認)に異なる値を入力し確認ボタンを押下する。
		""";

	/**
	 * 期待値。
	 */
	private static final String EXPECTED = """
		「パスワードが一致しません。」というメッセージが表示されること。
		""";

	/**
	 * コンストラクタ。
	 */
	public DeveloperEditFormPassTestItem() {
		super(CONDITION, EXPECTED);
	}
	
	/**
	 * メッセージリスト。
	 */
	private static final String[] MSG_LIST = {
		"パスワードが一致しません。"
	};
	
	
	@Override
	protected ResultType test(Browser browser) throws Exception {
		browser.reload();
		InitializeDatabasePageTestElement p = browser.getPageTestElement(InitializeDatabasePageTestElement.class);
		DeveloperEditFormTestElement f = p.getDeveloperEditForm();
		f.getPassword().setValue("abcdef");
		f.getPasswordCheck().setValue("123456");
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
		return ret;
	}

}
