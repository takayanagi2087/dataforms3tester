package jp.dataforms.test.element.devtool.init.page;


import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.TestElement;
import jp.dataforms.test.element.controller.EditFormTestElement;
import jp.dataforms.test.element.field.FieldTestElement;
import jp.dataforms.test.selenium.Browser;

/**
 * 開発ツール初期化フォームのテスト要素。 
 */
public class InitDevelopmentToolFormTestElement extends EditFormTestElement {
	/**
	 * プロジェクトパスのフィールドID。
	 */
	public static final String ID_PROJECT_PATH = "projectPath";
	/**
	 * JAVAのソースパスのフィールドID。
	 */
	public static final String ID_JAVA_SRC_PATH = "javaSrcPath";
	/**
	 * WEBソースパスのフィールドID。
	 */
	public static final String ID_WEB_SRC_PATH = "webSrcPath";
	/**
	 * JNDI 接頭辞のフィールドID。
	 */
	public static final String ID_JNDI_PREFIX = "jndiPrefix";
	/**
	 * データソース名のフィールドID。
	 */
	public static final String ID_DATA_SOURCE = "dataSource";
	/**
	 * DerbyのデータパスのフィールドID。
	 */
	public static final String ID_DERBY_DB_PATH = "derbyDbPath";
	
	
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param parent 親コンポーネント。
	 * @param webElement FormのWebElement。
	 */
	public InitDevelopmentToolFormTestElement(final Browser browser, final TestElement parent, final WebElement webElement) {
		super(browser, parent, webElement);
	}
	
	/**
	 * プロジェクトパスのテスト要素を取得します。
	 * @return プロジェクトパスのテスト要素。
	 */
	public FieldTestElement getProjectPath() {
		return this.getField(ID_PROJECT_PATH);
	}

	/**
	 * JAVAのソースパスのフィールドのテスト要素を取得します。
	 * @return JAVAのソースパスのフィールドのテスト要素。
	 */
	public FieldTestElement getJavaSrcPath() {
		return this.getField(ID_JAVA_SRC_PATH);
	}

	/**
	 *  WEBソースパスのフィールドのテスト要素を取得します。
	 * @return WEBソースパスのフィールドのテスト要素。
	 */
	public FieldTestElement getWebSrcPath() {
		return this.getField(ID_WEB_SRC_PATH);
	}

	/**
	 * JNDI 接頭辞のフィールドのテスト要素を取得します。
	 * @return JNDI 接頭辞のフィールドのテスト要素。
	 */
	public FieldTestElement getJndiPrefix() {
		return this.getField(ID_JNDI_PREFIX);
	}

	/**
	 * データソース名のフィールドのテスト要素を取得します。
	 * @return JNDI データソース名のフィールドのテスト要素。
	 */
	public FieldTestElement getDataSource() {
		return this.getField(ID_DATA_SOURCE);
	}

	/**
	 * Derbyのデータパスのフィールドのテスト要素を取得します。
	 * @return Derbyのデータパスのフィールドのテスト要素。
	 */
	public FieldTestElement getDerbyDbPath() {
		return this.getField(ID_DERBY_DB_PATH);
	}

}
