package jp.dataforms.test.testitem.devtool.pageform.page;

import jp.dataforms.test.annotation.TestItemInfo;
import jp.dataforms.test.annotation.TestItemInfo.Type;
import jp.dataforms.test.selenium.Browser;

import jp.dataforms.test.element.devtool.pageform.page.DaoAndPageGeneratorPageTestElement;
import jp.dataforms.test.element.devtool.pageform.page.PageGeneratorQueryFormTestElement;


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
public class PageGeneratorQueryFormSample001TestItem extends PageGeneratorQueryFormTestItem {
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
	public PageGeneratorQueryFormSample001TestItem() {
		super(CONDITION, EXPECTED);
	}
	
	@Override
	protected ResultType test(Browser browser) throws Exception {
		DaoAndPageGeneratorPageTestElement p = browser.getPageTestElement(DaoAndPageGeneratorPageTestElement.class);
		PageGeneratorQueryFormTestElement f = p.getPageGeneratorQueryForm();
		// TODO:指定した条件で処理を行い、期待した結果になっていることを確認する処理を記述してください。
		Browser.sleep(2);
		return ResultType.SYSTEM_OK;
	}

}
