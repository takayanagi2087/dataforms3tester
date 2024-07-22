package jp.dataforms.test.element.devtool.pageform.page;


import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.TestElement;
import jp.dataforms.test.element.controller.EditFormTestElement;
import jp.dataforms.test.element.field.FieldTestElement;
import jp.dataforms.test.element.htmltable.TableTestElement;
import jp.dataforms.test.selenium.Browser;


/**
 * DaoAndPageGeneratorEditForm フォームテスト要素。 
 */
public class DaoAndPageGeneratorEditFormTestElement extends EditFormTestElement {
	/**
	 * フォームID。
	 */
	public static final String ID = "editForm";
	
	/**
	 * 保存モード。
	 */
	public static final String ID_SAVE_MODE = "saveMode";

	/**
	 * フォルダのパス。。
	 */
	public static final String ID_JAVA_SOURCE_PATH = "javaSourcePath";

	/**
	 * ページの動作。
	 */
	public static final String ID_PAGE_PATTERN = "pagePattern";

	/**
	 * 機能。
	 */
	public static final String ID_FUNCTION_SELECT = "functionSelect";

	/**
	 * ページ名。
	 */
	public static final String ID_PAGE_NAME = "pageName";

	/**
	 * 。
	 */
	public static final String ID_DESCRIPTION = "description";

	/**
	 * ページパッケージ名。
	 */
	public static final String ID_PACKAGE_NAME = "packageName";

	/**
	 * ページクラス名。
	 */
	public static final String ID_PAGE_CLASS_NAME = "pageClassName";

	/**
	 * 。
	 */
	public static final String ID_PAGE_CLASS_OVERWRITE_MODE = "pageClassOverwriteMode";

	/**
	 * DAOパッケージ名。
	 */
	public static final String ID_DAO_PACKAGE_NAME = "daoPackageName";

	/**
	 * DAOクラス名。
	 */
	public static final String ID_DAO_CLASS_NAME = "daoClassName";

	/**
	 * 。
	 */
	public static final String ID_DAO_CLASS_OVERWRITE_MODE = "daoClassOverwriteMode";

	/**
	 * フォームクラス名。
	 */
	public static final String ID_FORM_CLASS_NAME = "formClassName";

	/**
	 * 。
	 */
	public static final String ID_FORM_CLASS_OVERWRITE_MODE = "formClassOverwriteMode";

	/**
	 * フォームクラス名。
	 */
	public static final String ID_QUERY_FORM_CLASS_NAME = "queryFormClassName";

	/**
	 * 。
	 */
	public static final String ID_QUERY_FORM_CLASS_OVERWRITE_MODE = "queryFormClassOverwriteMode";

	/**
	 * フォームクラス名。
	 */
	public static final String ID_QUERY_RESULT_FORM_CLASS_NAME = "queryResultFormClassName";

	/**
	 * 。
	 */
	public static final String ID_QUERY_RESULT_FORM_CLASS_OVERWRITE_MODE = "queryResultFormClassOverwriteMode";

	/**
	 * 一覧問合せの機能。
	 */
	public static final String ID_LIST_QUERY_FUNCTION_SELECT = "listQueryFunctionSelect";

	/**
	 * 一覧問合せのパッケージ。
	 */
	public static final String ID_LIST_QUERY_PACKAGE_NAME = "listQueryPackageName";

	/**
	 * 問合せクラス名。
	 */
	public static final String ID_LIST_QUERY_CLASS_NAME = "listQueryClassName";

	/**
	 * 。
	 */
	public static final String ID_LIST_QUERY_CONFIG = "listQueryConfig";

	/**
	 * フォームクラス名。
	 */
	public static final String ID_EDIT_FORM_CLASS_NAME = "editFormClassName";

	/**
	 * 。
	 */
	public static final String ID_EDIT_FORM_CLASS_OVERWRITE_MODE = "editFormClassOverwriteMode";

	/**
	 * 単一レコード取得用問合せの機能。
	 */
	public static final String ID_EDIT_QUERY_FUNCTION_SELECT = "editQueryFunctionSelect";

	/**
	 * 単一レコード取得用問合せのパッケージ。
	 */
	public static final String ID_EDIT_QUERY_PACKAGE_NAME = "editQueryPackageName";

	/**
	 * 問合せクラス名。
	 */
	public static final String ID_EDIT_QUERY_CLASS_NAME = "editQueryClassName";

	/**
	 * 。
	 */
	public static final String ID_EDIT_QUERY_CONFIG = "editQueryConfig";

	// ----- テーブル関連定数 -----
	/**
	 * テーブル。
	 */
	public static final String ID_MULTI_RECORD_QUERY_LIST = "multiRecordQueryList";

	/**
	 * 問合せクラス名。
	 */
	public static final String ID_QUERY_CLASS_NAME = "queryClassName";

	/**
	 * 。
	 */
	public static final String ID_QUERY_CONFIG = "queryConfig";


	
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param parent 親コンポーネント。
	 * @param webElement FormのWebElement。
	 */
	public DaoAndPageGeneratorEditFormTestElement(final Browser browser, final TestElement parent, final WebElement webElement) {
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
	 * フォルダのパス。のテスト要素を取得します。
	 * @return フォルダのパス。のテスト要素。
	 */
	public FieldTestElement getJavaSourcePath() {
		return this.getField(ID_JAVA_SOURCE_PATH);
	}
	/**
	 * ページの動作のテスト要素を取得します。
	 * @return ページの動作のテスト要素。
	 */
	public FieldTestElement getPagePattern() {
		return this.getField(ID_PAGE_PATTERN);
	}
	/**
	 * 機能のテスト要素を取得します。
	 * @return 機能のテスト要素。
	 */
	public FieldTestElement getFunctionSelect() {
		return this.getField(ID_FUNCTION_SELECT);
	}
	/**
	 * ページ名のテスト要素を取得します。
	 * @return ページ名のテスト要素。
	 */
	public FieldTestElement getPageName() {
		return this.getField(ID_PAGE_NAME);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getDescription() {
		return this.getField(ID_DESCRIPTION);
	}
	/**
	 * ページパッケージ名のテスト要素を取得します。
	 * @return ページパッケージ名のテスト要素。
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
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getPageClassOverwriteMode() {
		return this.getField(ID_PAGE_CLASS_OVERWRITE_MODE);
	}
	/**
	 * DAOパッケージ名のテスト要素を取得します。
	 * @return DAOパッケージ名のテスト要素。
	 */
	public FieldTestElement getDaoPackageName() {
		return this.getField(ID_DAO_PACKAGE_NAME);
	}
	/**
	 * DAOクラス名のテスト要素を取得します。
	 * @return DAOクラス名のテスト要素。
	 */
	public FieldTestElement getDaoClassName() {
		return this.getField(ID_DAO_CLASS_NAME);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getDaoClassOverwriteMode() {
		return this.getField(ID_DAO_CLASS_OVERWRITE_MODE);
	}
	/**
	 * フォームクラス名のテスト要素を取得します。
	 * @return フォームクラス名のテスト要素。
	 */
	public FieldTestElement getFormClassName() {
		return this.getField(ID_FORM_CLASS_NAME);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getFormClassOverwriteMode() {
		return this.getField(ID_FORM_CLASS_OVERWRITE_MODE);
	}
	/**
	 * フォームクラス名のテスト要素を取得します。
	 * @return フォームクラス名のテスト要素。
	 */
	public FieldTestElement getQueryFormClassName() {
		return this.getField(ID_QUERY_FORM_CLASS_NAME);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getQueryFormClassOverwriteMode() {
		return this.getField(ID_QUERY_FORM_CLASS_OVERWRITE_MODE);
	}
	/**
	 * フォームクラス名のテスト要素を取得します。
	 * @return フォームクラス名のテスト要素。
	 */
	public FieldTestElement getQueryResultFormClassName() {
		return this.getField(ID_QUERY_RESULT_FORM_CLASS_NAME);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getQueryResultFormClassOverwriteMode() {
		return this.getField(ID_QUERY_RESULT_FORM_CLASS_OVERWRITE_MODE);
	}
	/**
	 * 一覧問合せの機能のテスト要素を取得します。
	 * @return 一覧問合せの機能のテスト要素。
	 */
	public FieldTestElement getListQueryFunctionSelect() {
		return this.getField(ID_LIST_QUERY_FUNCTION_SELECT);
	}
	/**
	 * 一覧問合せのパッケージのテスト要素を取得します。
	 * @return 一覧問合せのパッケージのテスト要素。
	 */
	public FieldTestElement getListQueryPackageName() {
		return this.getField(ID_LIST_QUERY_PACKAGE_NAME);
	}
	/**
	 * 問合せクラス名のテスト要素を取得します。
	 * @return 問合せクラス名のテスト要素。
	 */
	public FieldTestElement getListQueryClassName() {
		return this.getField(ID_LIST_QUERY_CLASS_NAME);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getListQueryConfig() {
		return this.getField(ID_LIST_QUERY_CONFIG);
	}
	/**
	 * フォームクラス名のテスト要素を取得します。
	 * @return フォームクラス名のテスト要素。
	 */
	public FieldTestElement getEditFormClassName() {
		return this.getField(ID_EDIT_FORM_CLASS_NAME);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getEditFormClassOverwriteMode() {
		return this.getField(ID_EDIT_FORM_CLASS_OVERWRITE_MODE);
	}
	/**
	 * 単一レコード取得用問合せの機能のテスト要素を取得します。
	 * @return 単一レコード取得用問合せの機能のテスト要素。
	 */
	public FieldTestElement getEditQueryFunctionSelect() {
		return this.getField(ID_EDIT_QUERY_FUNCTION_SELECT);
	}
	/**
	 * 単一レコード取得用問合せのパッケージのテスト要素を取得します。
	 * @return 単一レコード取得用問合せのパッケージのテスト要素。
	 */
	public FieldTestElement getEditQueryPackageName() {
		return this.getField(ID_EDIT_QUERY_PACKAGE_NAME);
	}
	/**
	 * 問合せクラス名のテスト要素を取得します。
	 * @return 問合せクラス名のテスト要素。
	 */
	public FieldTestElement getEditQueryClassName() {
		return this.getField(ID_EDIT_QUERY_CLASS_NAME);
	}
	/**
	 * nullのテスト要素を取得します。
	 * @return nullのテスト要素。
	 */
	public FieldTestElement getEditQueryConfig() {
		return this.getField(ID_EDIT_QUERY_CONFIG);
	}
	/**
	 * テーブルのテスト要素を取得します。
	 * @return テーブルのテスト要素。
	 */
	public TableTestElement getMultiRecordQueryList() {
		return this.getTable(ID_MULTI_RECORD_QUERY_LIST);
	}
	
}
