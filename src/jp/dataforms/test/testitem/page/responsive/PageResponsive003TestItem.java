package jp.dataforms.test.testitem.page.responsive;

import org.openqa.selenium.Dimension;

import jp.dataforms.fw.controller.Page;
import jp.dataforms.fw.controller.WebComponent;
import jp.dataforms.test.annotation.TestItemInfo;
import jp.dataforms.test.annotation.TestItemInfo.Type;
import jp.dataforms.test.selenium.Browser;

/**
 * ページの全面表示テスト。
 */
@TestItemInfo(
	group = ResponsiveTestItem.GROUP,	// テスト項目を分類する文字列を指定します。
	seq = "003",			// テストの実行順を指定します。
	type = Type.NORMAL, 	// Type.NORMAL or Type.ERROR or Type.BOUNDARY
	regression = false		// 回帰テストで使用する項目の場合trueを指定します。
)
public class PageResponsive003TestItem extends ResponsiveTestItem {
	/**
	 * テスト条件。
	 */
	private static final String CONDITION = """
		タブレットレイアウトの最大幅で表示。
		""";
	
	/**
	 * テストの期待値。
	 */
	private static final String EXPECTED = """
		タブレットレイアウトとなること。
		""";
	/**
	 * コンストラクタ。
	 * @param pageClass ページクラス。
	 * @param compClass ページクラス。
	 */
	public PageResponsive003TestItem(final Class<? extends Page> pageClass, final Class<? extends WebComponent> compClass) {
		super(pageClass, compClass, CONDITION, EXPECTED);
	}
	
	@Override
	protected ResultType test(final Browser browser) throws Exception {
		browser.setClientSize(new Dimension(TAB_MAX_WIDTH, ResponsiveTestItem.getHeight()));
		this.saveScreenShot(browser);
		return ResultType.USER_CHECK;
	}
}