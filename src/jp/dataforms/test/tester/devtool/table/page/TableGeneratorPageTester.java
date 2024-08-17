package jp.dataforms.test.tester.devtool.table.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Dimension;

import jp.dataforms.fw.devtool.table.page.TableGeneratorPage;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.tester.PageTester;
import jp.dataforms.test.testitem.TestItem;
import jp.dataforms.test.testitem.devtool.table.page.TableGeneratorEditFormTestItem;
import jp.dataforms.test.testitem.devtool.table.page.TableGeneratorQueryFormTestItem;
import jp.dataforms.test.testitem.devtool.table.page.TableGeneratorQueryResultFormTestItem;


/**
 *  ページテスター。
 */
public class TableGeneratorPageTester extends PageTester {
	/**
	 * Logger.
	 */
	// private static Logger logger = LogManager.getLogger(TableGeneratorPageTester.class);
	
	/**
	 * コンストラクタ。
	 */
	public TableGeneratorPageTester() {
		super(TableGeneratorPage.class);
	}
	
		/**
	 * TableGeneratorEditFormのテストを行います。
	 * @param browser ブラウザ。
	 * @return テスト結果リスト。
	 * @throws Exception 例外。
	 */
	private List<TestItem> testTableGeneratorEditForm(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(1024, 540));
		// TableGeneratorEditFormのテスト項目のリストを取得する。
		List<TestItem> list = this.queryCheckItem(TableGeneratorEditFormTestItem.class);
		List<TestItem> testResult = new ArrayList<TestItem>();
		// TableGeneratorEditFormのテスト項目を実行し、その結果をtestResultに保存
		testResult.addAll(this.execTestItemList(browser, list));
		return testResult;
	}

	/**
	 * TableGeneratorQueryFormのテストを行います。
	 * @param browser ブラウザ。
	 * @return テスト結果リスト。
	 * @throws Exception 例外。
	 */
	private List<TestItem> testTableGeneratorQueryForm(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(1024, 540));
		// TableGeneratorQueryFormのテスト項目のリストを取得する。
		List<TestItem> list = this.queryCheckItem(TableGeneratorQueryFormTestItem.class);
		List<TestItem> testResult = new ArrayList<TestItem>();
		// TableGeneratorQueryFormのテスト項目を実行し、その結果をtestResultに保存
		testResult.addAll(this.execTestItemList(browser, list));
		return testResult;
	}

	/**
	 * TableGeneratorQueryResultFormのテストを行います。
	 * @param browser ブラウザ。
	 * @return テスト結果リスト。
	 * @throws Exception 例外。
	 */
	private List<TestItem> testTableGeneratorQueryResultForm(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(1024, 540));
		// TableGeneratorQueryResultFormのテスト項目のリストを取得する。
		List<TestItem> list = this.queryCheckItem(TableGeneratorQueryResultFormTestItem.class);
		List<TestItem> testResult = new ArrayList<TestItem>();
		// TableGeneratorQueryResultFormのテスト項目を実行し、その結果をtestResultに保存
		testResult.addAll(this.execTestItemList(browser, list));
		return testResult;
	}


	
	@Override
	public void exec() throws Exception {
		TestItem.setTestResult(this.getConf().getTestApp().getTestResult());
		Browser browser = this.getBrowser();
		browser.open(getPageClass());
		String pageName = browser.getTitle();
		List<TestItem> resultList = new ArrayList<TestItem>();
		
		// resultList.addAll(this.testSomething(browser));
		resultList.addAll(this.testTableGeneratorEditForm(browser));
		resultList.addAll(this.testTableGeneratorQueryForm(browser));
		resultList.addAll(this.testTableGeneratorQueryResultForm(browser));

		this.saveIndexHtml(pageName, resultList);
		browser.close();
	}
	
}
