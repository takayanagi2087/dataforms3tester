package jp.dataforms.test.element.devtool.pageform.page;

import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.controller.PageTestElement;
import jp.dataforms.test.selenium.Browser;

/**
 *  ページのテスト要素。
 */
public class TestSrcGeneratorPageTestElement extends PageTestElement {
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param element WebElement。
	 */
	public TestSrcGeneratorPageTestElement(final Browser browser, final WebElement element) {
		super(browser, null, element);
	}
	
	/**
	 * TestSrcGeneratorEditFormのテスト要素を取得します。
	 * @return TestSrcGeneratorEditFormのテスト要素。
	 */
	public TestSrcGeneratorEditFormTestElement getTestSrcGeneratorEditForm() {
		return this.getForm(TestSrcGeneratorEditFormTestElement.ID, TestSrcGeneratorEditFormTestElement.class);
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
