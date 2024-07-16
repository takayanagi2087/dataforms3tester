package jp.dataforms.test.testitem.devtool.db.page;

import jp.dataforms.test.annotation.TestItemInfo;
import jp.dataforms.test.annotation.TestItemInfo.Type;
import jp.dataforms.test.element.devtool.db.page.DeveloperEditFormTestElement;
import jp.dataforms.test.element.devtool.db.page.InitializeDatabasePageTestElement;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.testitem.TestItem;


/**
 * DatabaseInfoFormのテスト項目。
 */
@TestItemInfo(
	// テスト項目の情報を記述します。
	group = "disp", 		// テスト項目を分類する文字列を指定します。
	seq = "001",			// テストの実行順を指定します。 
	type = Type.NORMAL, 	// Type.NORMAL or Type.ERROR or Type.BOUNDARY
	regression = true		// 回帰テストで使用する項目の場合trueを指定します。
)
public class DeveloperEditFormDisp001TestItem extends DeveloperEditFormTestItem {
	/**
	 * テスト条件。
	 */
	private static final String CONDITION = """
		データベースの初期化ページを表示する。
		""";

	/**
	 * 期待値。
	 */
	private static final String EXPECTED = """
		ログインID,氏名にdeveloperまたはadminが表示されること。
		""";

	/**
	 * コンストラクタ。
	 */
	public DeveloperEditFormDisp001TestItem() {
		super(CONDITION, EXPECTED);
	}
	
	@Override
	protected ResultType test(Browser browser) throws Exception {
		InitializeDatabasePageTestElement p = browser.getPageTestElement(InitializeDatabasePageTestElement.class);
		DeveloperEditFormTestElement f = p.getDeveloperEditForm();
		String loginId = f.getLoginId().getValue();
		String userName = f.getUserName().getValue();
		ResultType ret = ResultType.SYSTEM_NG;
		if ("developer".equals(loginId) || "admin".equals(userName)) {
			ret = ResultType.SYSTEM_OK;
		}
//		Browser.sleep(2);
		Browser.sleep(TestItem.getConf().getTestApp().getShortWait());
		this.saveScreenShot(browser);
		return ret;
	}

}
