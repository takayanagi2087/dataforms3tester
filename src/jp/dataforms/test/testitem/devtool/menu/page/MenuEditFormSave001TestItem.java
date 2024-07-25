package jp.dataforms.test.testitem.devtool.menu.page;

import jp.dataforms.test.annotation.TestItemInfo;
import jp.dataforms.test.annotation.TestItemInfo.Type;
import jp.dataforms.test.element.devtool.menu.page.MenuEditFormTestElement;
import jp.dataforms.test.element.devtool.menu.page.MenuEditPageTestElement;
import jp.dataforms.test.element.htmltable.TableTestElement;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.testitem.TestItem;


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
	 * Logger.
	 */
	// private static Logger logger = LogManager.getLogger(MenuEditFormSave001TestItem.class);
	
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
		this.saveScreenShot(browser, "メニュー情報を入力した状態");
		f.getConfirmButton().click();
		Browser.sleep(TestItem.getConf().getTestApp().getShortWait());
		this.saveScreenShot(browser, "「確認」ボタンを押した状態");
		f.getSaveButton().click();
		Browser.sleep(TestItem.getConf().getTestApp().getShortWait());
		this.saveScreenShot(browser, "「登録」ボタンした状態");
		p.getAlertDialog().clickOkButton();
		Browser.sleep(TestItem.getConf().getTestApp().getBuildWait());
		this.saveScreenShot(browser, "保存後のサイトマップ");
		browser.open(TestItem.getConf().getTestApp().getApplicationURL() + "dataforms/devtool/menu/page/MenuEditPage.html");
		this.saveScreenShot(browser, "メニュー作成画面の再表示");
		p = browser.getPageTestElement(MenuEditPageTestElement.class);
		f = p.getMenuEditForm();
		String basePackage = f.getAppBasePackage().getValue();
		ResultType ret = ResultType.SYSTEM_OK;
		if (!"jp.dataforms".equals(basePackage)) {
			ret = ResultType.SYSTEM_NG;
		}
		table = f.getMenuList();
		String path = table.getField(0, "path").getValue();
		if (!"/sample".equals(path)) {
			ret = ResultType.SYSTEM_NG;
		}
		String pkg = table.getField(0, "packageName").getValue();
		if (!"jp.dataforms.sample".equals(pkg)) {
			ret = ResultType.SYSTEM_NG;
		}
		String defaultName = table.getField(0, "defaultName").getValue();
		if (!"Sample".equals(defaultName)) {
			ret = ResultType.SYSTEM_NG;
		}
		String jaName = table.getField(0, "jaName").getValue();
		if (!"サンプル".equals(jaName)) {
			ret = ResultType.SYSTEM_NG;
		}
		return ret;
	}

}
