package jp.dataforms.test.element.devtool.db.page;

import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.controller.PageTestElement;
import jp.dataforms.test.selenium.Browser;

/**
 * データベース初期化 ページのテスト要素。
 */
public class InitializeDatabasePageTestElement extends PageTestElement {
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param element WebElement。
	 */
	public InitializeDatabasePageTestElement(final Browser browser, final WebElement element) {
		super(browser, element);
	}
	
	/**
	 * DatabaseInfoFormのテスト要素を取得します。
	 * @return DatabaseInfoFormのテスト要素。
	 */
	public DatabaseInfoFormTestElement getDatabaseInfoForm() {
		return this.getForm(DatabaseInfoFormTestElement.ID, DatabaseInfoFormTestElement.class);
	}

	/**
	 * DeveloperEditFormのテスト要素を取得します。
	 * @return DeveloperEditFormのテスト要素。
	 */
	public DeveloperEditFormTestElement getDeveloperEditForm() {
		return this.getForm(DeveloperEditFormTestElement.ID, DeveloperEditFormTestElement.class);
	}


}
