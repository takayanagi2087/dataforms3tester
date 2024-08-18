package jp.dataforms.test.element.devtool.query.page;

import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.controller.PageTestElement;
import jp.dataforms.test.selenium.Browser;

/**
 *  ページのテスト要素。
 */
public class QueryExecutorPageTestElement extends PageTestElement {
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param element WebElement。
	 */
	public QueryExecutorPageTestElement(final Browser browser, final WebElement element) {
		super(browser, element);
	}
	
	/**
	 * QueryExecutorQueryFormのテスト要素を取得します。
	 * @return QueryExecutorQueryFormのテスト要素。
	 */
	public QueryExecutorQueryFormTestElement getQueryExecutorQueryForm() {
		return this.getForm(QueryExecutorQueryFormTestElement.ID, QueryExecutorQueryFormTestElement.class);
	}

	/**
	 * QueryExecutorQueryResultFormのテスト要素を取得します。
	 * @return QueryExecutorQueryResultFormのテスト要素。
	 */
	public QueryExecutorQueryResultFormTestElement getQueryExecutorQueryResultForm() {
		return this.getForm(QueryExecutorQueryResultFormTestElement.ID, QueryExecutorQueryResultFormTestElement.class);
	}


}
