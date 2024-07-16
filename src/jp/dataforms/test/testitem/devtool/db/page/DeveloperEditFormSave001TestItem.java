package jp.dataforms.test.testitem.devtool.db.page;

import jp.dataforms.test.annotation.TestItemInfo;
import jp.dataforms.test.annotation.TestItemInfo.Type;
import jp.dataforms.test.element.devtool.db.page.DeveloperEditFormTestElement;
import jp.dataforms.test.element.devtool.db.page.InitializeDatabasePageTestElement;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.tester.PageTester.Conf;
import jp.dataforms.test.testitem.TestItem;


/**
 * DatabaseInfoFormのテスト項目。
 */
@TestItemInfo(
	// テスト項目の情報を記述します。
	group = "save", 		// テスト項目を分類する文字列を指定します。
	seq = "001",			// テストの実行順を指定します。 
	type = Type.NORMAL, 	// Type.NORMAL or Type.ERROR or Type.BOUNDARY
	regression = true		// 回帰テストで使用する項目の場合trueを指定します。
)
public class DeveloperEditFormSave001TestItem extends DeveloperEditFormTestItem {
	/**
	 * テスト条件。
	 */
	private static final String CONDITION = """
		パスワードとメールアドレスを入力し確認ボタンを押下する。
		""";

	/**
	 * 期待値。
	 */
	private static final String EXPECTED = """
		画面がロックされ保存ボタンが表示されること。
		""";

	/**
	 * コンストラクタ。
	 */
	public DeveloperEditFormSave001TestItem() {
		super(CONDITION, EXPECTED);
	}
	
	
	@Override
	protected ResultType test(Browser browser) throws Exception {
		browser.reload();
		InitializeDatabasePageTestElement p = browser.getPageTestElement(InitializeDatabasePageTestElement.class);
		DeveloperEditFormTestElement f = p.getDeveloperEditForm();
		Conf conf = TestItem.getConf();
		String loginId = f.getLoginId().getValue();
		String password = conf.getTestUser(loginId).getPassword();
		f.getPassword().setValue(password);
		f.getPasswordCheck().setValue(password);
		f.getMailAddress().setValue("hoge@hoge.jp");
		this.saveScreenShot(browser);
		f.getConfirmButton().click();
//		Browser.sleep(2);
		Browser.sleep(TestItem.getConf().getTestApp().getShortWait());
		this.saveScreenShot(browser);
		ResultType ret = ResultType.SYSTEM_NG;
		if (f.getSaveButton().getWebElement().isDisplayed()) {
			ret = ResultType.SYSTEM_OK;
		}
		return ret;
	}

}
