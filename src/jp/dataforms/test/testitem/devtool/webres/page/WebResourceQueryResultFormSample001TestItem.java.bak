package jp.dataforms.test.testitem.devtool.webres.page;

import jp.dataforms.test.annotation.TestItemInfo;
import jp.dataforms.test.annotation.TestItemInfo.Type;
import jp.dataforms.test.selenium.Browser;

import jp.dataforms.test.element.devtool.webres.page.WebResourcePageTestElement;
import jp.dataforms.test.element.devtool.webres.page.WebResourceQueryResultFormTestElement;


/**
 * DatabaseInfoFormのテスト項目。
 */
@TestItemInfo(
	// テスト項目の情報を記述します。
	group = "sample", 		// テスト項目を分類する文字列を指定します。
	seq = "001",			// テストの実行順を指定します。 
	type = Type.NORMAL, 	// Type.NORMAL or Type.ERROR or Type.BOUNDARY
	regression = false		// 回帰テストで使用する項目の場合trueを指定します。
)
public class WebResourceQueryResultFormSample001TestItem extends WebResourceQueryResultFormTestItem {
	/**
	 * テスト条件。
	 */
	private static final String CONDITION = """
		// TODO:テストの条件を記述してください。
		""";

	/**
	 * 期待値。
	 */
	private static final String EXPECTED = """
		// TODO:期待する結果を記述してください。
		""";

	/**
	 * コンストラクタ。
	 */
	public WebResourceQueryResultFormSample001TestItem() {
		super(CONDITION, EXPECTED);
	}
	
	@Override
	protected ResultType test(Browser browser) throws Exception {
		WebResourcePageTestElement p = browser.getPageTestElement(WebResourcePageTestElement.class);
		WebResourceQueryResultFormTestElement f = p.getWebResourceQueryResultForm();
		// TODO:指定した条件で処理を行い、期待した結果になっていることを確認する処理を記述してください。
		Browser.sleep(2);
		return ResultType.SYSTEM_OK;
	}

}
