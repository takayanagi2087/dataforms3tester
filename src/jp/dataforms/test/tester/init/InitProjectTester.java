package jp.dataforms.test.tester.init;

import java.util.ArrayList;
import java.util.List;

import jp.dataforms.fw.devtool.init.page.InitDevelopmentToolForm;
import jp.dataforms.fw.devtool.init.page.InitDevelopmentToolPage;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.tester.PageTester;
import jp.dataforms.test.testitem.TestItem;

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
	
	
	@Override
	public void exec() throws Exception {
		TestItem.setTestResult(this.getConf().getTestApp().getTestResult());
		Browser browser = this.getBrowser();
		this.openPage(browser);
		List<TestItem> list = new ArrayList<TestItem>();
		list.addAll(this.testResponsive(browser, InitDevelopmentToolPage.class, InitDevelopmentToolForm.class));
		this.saveIndexHtml(list);
		browser.close();
	}

}
