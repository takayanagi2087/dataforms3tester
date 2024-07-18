package jp.dataforms.test.element.devtool.table.page;

import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.controller.PageTestElement;
import jp.dataforms.test.selenium.Browser;

/**
 *  ページのテスト要素。
 */
public class TableGeneratorPageTestElement extends PageTestElement {
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param element WebElement。
	 */
	public TableGeneratorPageTestElement(final Browser browser, final WebElement element) {
		super(browser, null, element);
	}
	
	/**
	 * TableGeneratorEditFormのテスト要素を取得します。
	 * @return TableGeneratorEditFormのテスト要素。
	 */
	public TableGeneratorEditFormTestElement getTableGeneratorEditForm() {
		return this.getForm(TableGeneratorEditFormTestElement.ID, TableGeneratorEditFormTestElement.class);
	}

	/**
	 * TableGeneratorQueryFormのテスト要素を取得します。
	 * @return TableGeneratorQueryFormのテスト要素。
	 */
	public TableGeneratorQueryFormTestElement getTableGeneratorQueryForm() {
		return this.getForm(TableGeneratorQueryFormTestElement.ID, TableGeneratorQueryFormTestElement.class);
	}

	/**
	 * TableGeneratorQueryResultFormのテスト要素を取得します。
	 * @return TableGeneratorQueryResultFormのテスト要素。
	 */
	public TableGeneratorQueryResultFormTestElement getTableGeneratorQueryResultForm() {
		return this.getForm(TableGeneratorQueryResultFormTestElement.ID, TableGeneratorQueryResultFormTestElement.class);
	}


}
