package jp.dataforms.test.element.devtool.query.page;

import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.controller.PageTestElement;
import jp.dataforms.test.selenium.Browser;

/**
 *  ページのテスト要素。
 */
public class QueryGeneratorPageTestElement extends PageTestElement {
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param element WebElement。
	 */
	public QueryGeneratorPageTestElement(final Browser browser, final WebElement element) {
		super(browser, element);
	}
	
	/**
	 * QueryGeneratorEditFormのテスト要素を取得します。
	 * @return QueryGeneratorEditFormのテスト要素。
	 */
	public QueryGeneratorEditFormTestElement getQueryGeneratorEditForm() {
		return this.getForm(QueryGeneratorEditFormTestElement.ID, QueryGeneratorEditFormTestElement.class);
	}

	/**
	 * QueryGeneratorQueryFormのテスト要素を取得します。
	 * @return QueryGeneratorQueryFormのテスト要素。
	 */
	public QueryGeneratorQueryFormTestElement getQueryGeneratorQueryForm() {
		return this.getForm(QueryGeneratorQueryFormTestElement.ID, QueryGeneratorQueryFormTestElement.class);
	}

	/**
	 * QueryGeneratorQueryResultFormのテスト要素を取得します。
	 * @return QueryGeneratorQueryResultFormのテスト要素。
	 */
	public QueryGeneratorQueryResultFormTestElement getQueryGeneratorQueryResultForm() {
		return this.getForm(QueryGeneratorQueryResultFormTestElement.ID, QueryGeneratorQueryResultFormTestElement.class);
	}


}
