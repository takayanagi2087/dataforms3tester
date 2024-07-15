package jp.dataforms.test.element.devtool.menu.page;


import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.TestElement;
import jp.dataforms.test.element.controller.EditFormTestElement;
import jp.dataforms.test.element.field.FieldTestElement;
import jp.dataforms.test.element.htmltable.TableTestElement;
import jp.dataforms.test.selenium.Browser;

/**
 * MenuEditForm フォームテスト要素。 
 */
public class MenuEditFormTestElement extends EditFormTestElement {
	/**
	 * フォームID。
	 */
	public static final String ID = "editForm";
	
	/**
	 * 保存モード。
	 */
	public static final String ID_SAVE_MODE = "saveMode";

	/**
	 * アプリケーションパッケージフィールドID。
	 */
	public static final String ID_APP_BASE_PACKAGE = "appBasePackage";

	/**
	 * 「ページクラスの追加コードを生成する。」チェックボックス。
	 */
	public static final String ID_GEN_ADD_PAGE_CODE = "genAddPageCode";

	/**
	 * メニューリストのテーブルID・
	 */
	public static final String ID_MENU_LIST = "menuList";
	
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param parent 親コンポーネント。
	 * @param webElement FormのWebElement。
	 */
	public MenuEditFormTestElement(final Browser browser, final TestElement parent, final WebElement webElement) {
		super(browser, parent, webElement);
	}
	
	/**
	 * 保存モードのテスト要素を取得します。
	 * @return 保存モードのテスト要素。
	 */
	public FieldTestElement getSaveMode() {
		return this.getField(ID_SAVE_MODE);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getAppBasePackage() {
		return this.getField(ID_APP_BASE_PACKAGE);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getGenAddPageCode() {
		return this.getField(ID_GEN_ADD_PAGE_CODE);
	}
	
	/**
	 * メニューリストテーブルを取得します。
	 * @return メニューリストテーブル。
	 */
	public TableTestElement getMenuList() {
		return this.getTable(ID_MENU_LIST);
	}
}
