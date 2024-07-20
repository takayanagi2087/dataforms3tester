package jp.dataforms.test.element.devtool.db.page;

import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.controller.PageTestElement;
import jp.dataforms.test.selenium.Browser;

/**
 *  ページのテスト要素。
 */
public class TableManagementPageTestElement extends PageTestElement {
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param element WebElement。
	 */
	public TableManagementPageTestElement(final Browser browser, final WebElement element) {
		super(browser, null, element);
	}
	
	/**
	 * DatabaseInfoFormのテスト要素を取得します。
	 * @return DatabaseInfoFormのテスト要素。
	 */
	public DatabaseInfoFormTestElement getDatabaseInfoForm() {
		return this.getForm(DatabaseInfoFormTestElement.ID, DatabaseInfoFormTestElement.class);
	}

	/**
	 * TableManagementQueryFormのテスト要素を取得します。
	 * @return TableManagementQueryFormのテスト要素。
	 */
	public TableManagementQueryFormTestElement getTableManagementQueryForm() {
		return this.getForm(TableManagementQueryFormTestElement.ID, TableManagementQueryFormTestElement.class);
	}

	/**
	 * TableManagementQueryResultFormのテスト要素を取得します。
	 * @return TableManagementQueryResultFormのテスト要素。
	 */
	public TableManagementQueryResultFormTestElement getTableManagementQueryResultForm() {
		return this.getForm(TableManagementQueryResultFormTestElement.ID, TableManagementQueryResultFormTestElement.class);
	}


}
