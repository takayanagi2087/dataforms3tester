package jp.dataforms.test.tester.devtool.init.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Dimension;

import jp.dataforms.fw.devtool.init.page.InitDevelopmentToolForm;
import jp.dataforms.fw.devtool.init.page.InitDevelopmentToolPage;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.tester.PageTester;
import jp.dataforms.test.testitem.TestItem;
import jp.dataforms.test.testitem.devtool.init.page.InitDevelopmentToolFormTestItem;

/**
 * プロジェクトの初期化テスター。
 */
public class InitProjectTester extends PageTester {
	/**
	 * Logger.
	 */
//	private static Logger logger = LogManager.getLogger(InitProjectTester.class);

	/**
	 * コンストラクタ。
	 */
	public InitProjectTester() {
		super(InitDevelopmentToolPage.class);
	}
	
	/**
	 * プロジェクト初期化テスト。
	 * @param browser ブラウザ。
	 * @return レスポンシブデザインテストの結果リスト。
	 * @throws Exception 例外。
	 */
	protected List<TestItem> testInit(final Browser browser) throws Exception {
		List<TestItem> list = this.queryCheckItem(InitDevelopmentToolFormTestItem.class);
		this.execTestItemList(browser, list);
		return list;
	}
	
	
	@Override
	public void exec() throws Exception {
		TestItem.setTestResult(this.getConf().getTestApp().getTestResult());
		Browser browser = this.getBrowser();
		browser.open(getPageClass());
		String pageName = browser.getTitle();
		List<TestItem> list = new ArrayList<TestItem>();
		list.addAll(this.testResponsive(browser, InitDevelopmentToolPage.class, InitDevelopmentToolForm.class));
		browser.setClientSize(new Dimension(1024, 768));
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		list.addAll(this.testInit(browser));
		this.saveIndexHtml(pageName, list);
		browser.close();
		this.reloadWebApp(this.getConf().getTestApp().getContextPath());
	}

}
