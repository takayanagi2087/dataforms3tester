package jp.dataforms.test.element.devtool.pageform.page;

import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.controller.PageTestElement;
import jp.dataforms.test.selenium.Browser;

/**
 *  ページのテスト要素。
 */
public class DaoAndPageGeneratorPageTestElement extends PageTestElement {
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param element WebElement。
	 */
	public DaoAndPageGeneratorPageTestElement(final Browser browser, final WebElement element) {
		super(browser, null, element);
	}
	
	/**
	 * DaoAndPageGeneratorEditFormのテスト要素を取得します。
	 * @return DaoAndPageGeneratorEditFormのテスト要素。
	 */
	public DaoAndPageGeneratorEditFormTestElement getDaoAndPageGeneratorEditForm() {
		return this.getForm(DaoAndPageGeneratorEditFormTestElement.ID, DaoAndPageGeneratorEditFormTestElement.class);
	}

	/**
	 * PageGeneratorQueryFormのテスト要素を取得します。
	 * @return PageGeneratorQueryFormのテスト要素。
	 */
	public PageGeneratorQueryFormTestElement getPageGeneratorQueryForm() {
		return this.getForm(PageGeneratorQueryFormTestElement.ID, PageGeneratorQueryFormTestElement.class);
	}

	/**
	 * PageGeneratorQueryResultFormのテスト要素を取得します。
	 * @return PageGeneratorQueryResultFormのテスト要素。
	 */
	public PageGeneratorQueryResultFormTestElement getPageGeneratorQueryResultForm() {
		return this.getForm(PageGeneratorQueryResultFormTestElement.ID, PageGeneratorQueryResultFormTestElement.class);
	}


}
