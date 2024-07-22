package jp.dataforms.test.element.devtool.pageform.page;


import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.TestElement;
import jp.dataforms.test.element.controller.EditFormTestElement;
import jp.dataforms.test.element.field.FieldTestElement;
import jp.dataforms.test.element.htmltable.TableTestElement;
import jp.dataforms.test.selenium.Browser;


/**
 * TestSrcGeneratorEditForm フォームテスト要素。 
 */
public class TestSrcGeneratorEditFormTestElement extends EditFormTestElement {
	/**
	 * フォームID。
	 */
	public static final String ID = "editForm";
	
	/**
	 * 保存モード。
	 */
	public static final String ID_SAVE_MODE = "saveMode";

	/**
	 * テストツールソースパス。
	 */
	public static final String ID_TEST_TOOL_SRC_PATH = "testToolSrcPath";

	/**
	 * 。
	 */
	public static final String ID_PACKAGE_NAME = "packageName";

	/**
	 * ページクラス名。
	 */
	public static final String ID_PAGE_CLASS_NAME = "pageClassName";

	/**
	 * 出力パッケージ名。
	 */
	public static final String ID_TESTER_PACKAGE_NAME = "testerPackageName";

	/**
	 * ページテスタークラス名。
	 */
	public static final String ID_PAGE_TESTER_CLASS_NAME = "pageTesterClassName";

	/**
	 * ページテスター上書きモード。
	 */
	public static final String ID_PAGE_TESTER_OVERWRITE_MODE = "pageTesterOverwriteMode";

	/**
	 * テスト要素パッケージ。
	 */
	public static final String ID_TEST_ELEMENT_PACKAGE_NAME = "testElementPackageName";

	/**
	 * ページテスト要素クラス名。
	 */
	public static final String ID_PAGE_TEST_ELEMENT_CLASS_NAME = "pageTestElementClassName";

	/**
	 * ページテスト要素上書きモード。
	 */
	public static final String ID_PAGE_TEST_ELEMENT_OVERWRITE_MODE = "pageTestElementOverwriteMode";

	/**
	 * テスト項目パッケージ。
	 */
	public static final String ID_TEST_ITEM_PACKAGE_NAME = "testItemPackageName";

	// ----- テーブル関連定数 -----
	/**
	 * テーブル。
	 */
	public static final String ID_FORM_TABLE = "formTable";

	/**
	 * No.。
	 */
	public static final String ID_ROW_NO = "rowNo";

	/**
	 * フォームクラス名。
	 */
	public static final String ID_FORM_CLASS_NAME = "formClassName";

	/**
	 * フォームテスト要素クラス名。
	 */
	public static final String ID_FORM_TEST_ELEMENT_CLASS_NAME = "formTestElementClassName";

	/**
	 * テスト項目基本クラス名。
	 */
	public static final String ID_FORM_TEST_ITEM_CLASS_NAME = "formTestItemClassName";

	/**
	 * サンプルテスト項目クラス名。
	 */
	public static final String ID_FORM_SAMPLE_TEST_ITEM_CLASS_NAME = "formSampleTestItemClassName";

	/**
	 * フォームテスト要素上書きモード。
	 */
	public static final String ID_FORM_TEST_ELEMENT_OVERWRITE_MODE = "formTestElementOverwriteMode";


	
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param parent 親コンポーネント。
	 * @param webElement FormのWebElement。
	 */
	public TestSrcGeneratorEditFormTestElement(final Browser browser, final TestElement parent, final WebElement webElement) {
		super(browser, parent, webElement);
	}
	
	/**
	 * 保存モードのテスト要素を取得します。
	 * @return 保存モードのテスト要素。
	 */
	public FieldTestElement getSaveMode() {
		return this.getField(ID_SAVE_MODE);
	}
	/**
	 * テストツールソースパスのテスト要素を取得します。
	 * @return テストツールソースパスのテスト要素。
	 */
	public FieldTestElement getTestToolSrcPath() {
		return this.getField(ID_TEST_TOOL_SRC_PATH);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getPackageName() {
		return this.getField(ID_PACKAGE_NAME);
	}
	/**
	 * ページクラス名のテスト要素を取得します。
	 * @return ページクラス名のテスト要素。
	 */
	public FieldTestElement getPageClassName() {
		return this.getField(ID_PAGE_CLASS_NAME);
	}
	/**
	 * 出力パッケージ名のテスト要素を取得します。
	 * @return 出力パッケージ名のテスト要素。
	 */
	public FieldTestElement getTesterPackageName() {
		return this.getField(ID_TESTER_PACKAGE_NAME);
	}
	/**
	 * ページテスタークラス名のテスト要素を取得します。
	 * @return ページテスタークラス名のテスト要素。
	 */
	public FieldTestElement getPageTesterClassName() {
		return this.getField(ID_PAGE_TESTER_CLASS_NAME);
	}
	/**
	 * ページテスター上書きモードのテスト要素を取得します。
	 * @return ページテスター上書きモードのテスト要素。
	 */
	public FieldTestElement getPageTesterOverwriteMode() {
		return this.getField(ID_PAGE_TESTER_OVERWRITE_MODE);
	}
	/**
	 * テスト要素パッケージのテスト要素を取得します。
	 * @return テスト要素パッケージのテスト要素。
	 */
	public FieldTestElement getTestElementPackageName() {
		return this.getField(ID_TEST_ELEMENT_PACKAGE_NAME);
	}
	/**
	 * ページテスト要素クラス名のテスト要素を取得します。
	 * @return ページテスト要素クラス名のテスト要素。
	 */
	public FieldTestElement getPageTestElementClassName() {
		return this.getField(ID_PAGE_TEST_ELEMENT_CLASS_NAME);
	}
	/**
	 * ページテスト要素上書きモードのテスト要素を取得します。
	 * @return ページテスト要素上書きモードのテスト要素。
	 */
	public FieldTestElement getPageTestElementOverwriteMode() {
		return this.getField(ID_PAGE_TEST_ELEMENT_OVERWRITE_MODE);
	}
	/**
	 * テスト項目パッケージのテスト要素を取得します。
	 * @return テスト項目パッケージのテスト要素。
	 */
	public FieldTestElement getTestItemPackageName() {
		return this.getField(ID_TEST_ITEM_PACKAGE_NAME);
	}
	/**
	 * テーブルのテスト要素を取得します。
	 * @return テーブルのテスト要素。
	 */
	public TableTestElement getFormTable() {
		return this.getTable(ID_FORM_TABLE);
	}
	
}
