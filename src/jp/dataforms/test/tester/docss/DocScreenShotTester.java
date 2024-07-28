package jp.dataforms.test.tester.docss;

import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.tester.PageTester;
import lombok.Getter;
import lombok.Setter;

/**
 * ドキュメントスクリーンショット取得ツール。
 */
public abstract class DocScreenShotTester extends PageTester {

	/**
	 * Documentのペースパス。
	 */
	public static final String DOC_BASE = "C:/eclipse/workspaceDataforms3/dataforms3/src/main/java/META-INF/resources/dataforms/doc";

	/**
	 * ドキュメントバス。
	 */
	@Getter
	@Setter
	private String documentPath = null;
	
	/**
	 * コンストラクタ。
	 * @param documentPath ドキュメント。
	 */
	public DocScreenShotTester(final String documentPath) {
		this.documentPath = documentPath;
	}

	/**
	 * スクリーンショットを取得します。
	 * @param browser ブラウザ。
	 * @param filename ファイル名。
	 * @param resize リサイズフラグ。
	 * @return 保存したファイル名。
	 * @throws Exception 例外。
	 */
	public String saveScreenShot(final Browser browser, final String filename, final boolean resize) throws Exception {
		if (resize) {
			return browser.saveResizedScreenShot(DOC_BASE + "/" + this.documentPath + "/" + filename);
		} else {
			return browser.saveScreenShot(DOC_BASE + "/" + this.documentPath + "/" + filename);
		}
	}

	/**
	 * スクリーンショットを取得します。
	 * @param browser ブラウザ。
	 * @param filename ファイル名。
	 * @return 保存したファイル名。
	 * @throws Exception 例外。
	 */
	public String saveScreenShot(final Browser browser, final String filename) throws Exception {
		return this.saveScreenShot(browser, filename, true);
	}

}

