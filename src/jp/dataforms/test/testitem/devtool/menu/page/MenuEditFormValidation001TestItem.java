package jp.dataforms.test.testitem.devtool.menu.page;

import java.util.List;

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
	group = "validation", 	// テスト項目を分類する文字列を指定します。
	seq = "001",			// テストの実行順を指定します。 
	type = Type.ERROR, 		// Type.NORMAL or Type.ERROR or Type.BOUNDARY
	regression = false		// 回帰テストで使用する項目の場合trueを指定します。
)
public class MenuEditFormValidation001TestItem extends MenuEditFormTestItem {
	/**
	 * テスト条件。
	 */
	private static final String CONDITION = """
		メニューを1行追加し、何も入力しないで確認ボタンを押下する。
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
	public MenuEditFormValidation001TestItem() {
		super(CONDITION, EXPECTED);
	}
	
	
	/**
	 * メッセージリスト。
	 */
	private static final String[] MSG_LIST = {
		"基本パッケージが入力されていません。",
		"パス が入力されていません。",
		"パッケージ名 が入力されていません。",
		"名称(default) が入力されていません。"
	};

	
	@Override
	protected ResultType test(Browser browser) throws Exception {
		browser.reload();
		MenuEditPageTestElement p = browser.getPageTestElement(MenuEditPageTestElement.class);
		MenuEditFormTestElement f = p.getMenuEditForm();
		TableTestElement table = f.getMenuList();
		table.addRow(0);
		f.getConfirmButton().click();
		Browser.sleep(TestItem.getConf().getTestApp().getShortWait());
		this.saveScreenShot(browser);
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
