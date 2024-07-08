package jp.dataforms.test.testitem.devtool.init.page;

import java.io.File;

import jp.dataforms.fw.controller.Page;
import jp.dataforms.fw.devtool.init.page.InitDevelopmentToolForm;
import jp.dataforms.fw.devtool.init.page.InitDevelopmentToolPage;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.testitem.TestItem;

/**
 * プロジェクト初期化ページのテスト。
 */
public  abstract class InitTestItem extends TestItem {
	/**
	 * コンストラクタ。
	 * @param condition テスト条件。
	 * @param expected 期待値。
	 */
	public InitTestItem(final String condition, final String expected) {
		super(InitDevelopmentToolPage.class, InitDevelopmentToolForm.class, condition, expected);
	}

	@Override
	protected  abstract ResultType test(Browser browser) throws Exception;

	@Override
	protected String saveAttachFile(final Page page, final Browser browser, final ResultType result) throws Exception {
		String imageFile =  this.getTestItemPath() + "/" + this.getFileName() + ".png";
		String path = browser.saveResizedScreenShot(imageFile);
		File f = new File(path);
		String ret = "<img src='" + f.getName() + "' width='1024'/>";
		return ret;
	}
}
