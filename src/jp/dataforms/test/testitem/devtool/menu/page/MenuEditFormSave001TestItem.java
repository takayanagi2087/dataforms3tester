package jp.dataforms.test.testitem.devtool.menu.page;

import jp.dataforms.test.annotation.TestItemInfo;
import jp.dataforms.test.annotation.TestItemInfo.Type;
import jp.dataforms.test.element.devtool.menu.page.MenuEditFormTestElement;
import jp.dataforms.test.element.devtool.menu.page.MenuEditPageTestElement;
import jp.dataforms.test.element.htmltable.TableTestElement;
import jp.dataforms.test.selenium.Browser;


/**
 * DatabaseInfoFormのテスト項目。
 */
@TestItemInfo(
	// テスト項目の情報を記述します。
	group = "save", 	// テスト項目を分類する文字列を指定します。
	seq = "001",			// テストの実行順を指定します。 
	type = Type.NORMAL, 	// Type.NORMAL or Type.ERROR or Type.BOUNDARY
	regression = true		// 回帰テストで使用する項目の場合trueを指定します。
)
public class MenuEditFormSave001TestItem extends MenuEditFormTestItem {
	/**
	 * テスト条件。
	 */
	private static final String CONDITION = """
		適切に情報を入力し、「確認」「登録」ボタンを押下する。
		""";

	/**
	 * 期待値。
	 */
	private static final String EXPECTED = """
		適切なメニューのソースが生成されること。
		""";

	/**
	 * コンストラクタ。
	 */
	public MenuEditFormSave001TestItem() {
		super(CONDITION, EXPECTED);
	}
	
	
	
	@Override
	protected ResultType test(Browser browser) throws Exception {
		browser.reload();
		MenuEditPageTestElement p = browser.getPageTestElement(MenuEditPageTestElement.class);
		MenuEditFormTestElement f = p.getMenuEditForm();
		f.getAppBasePackage().setValue("jp.dataforms");
		TableTestElement table = f.getMenuList();
		table.addRow(0);
		table.setValue(0, "path", "/sample");
		table.setValue(0, "defaultName", "Sample");
		table.setValue(0, "jaName", "サンプル");
		this.saveScreenShot(browser);
		f.getConfirmButton().click();
		Browser.sleep(2);
		this.saveScreenShot(browser);
		f.getSaveButton().click();
		Browser.sleep(2);
		this.saveScreenShot(browser);
		p.getAlertDialog().clickOkButton();
		this.saveScreenShot(browser);
		ResultType ret = ResultType.SYSTEM_OK;
		return ret;
	}

}
