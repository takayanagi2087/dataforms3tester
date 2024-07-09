package jp.dataforms.test.element.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.TestElement;
import jp.dataforms.test.selenium.Browser;

/**
 * DataFormsのテスト要素。
 */
public class DataFormsTestElement extends TestElement {
	/**
	 * Logger.
	 */
	private static Logger logger = LogManager.getLogger(DataFormsTestElement.class);

	/**
	 * 問い合わせフォーム。
	 */
	public static final String ID_QUERY_FORM = "queryForm";

	/**
	 * 問い合わせ結果フォーム。
	 */
	public static final String ID_QUERY_RESULT_FORM = "queryResultForm";

	/**
	 * 編集フォーム。
	 */
	public static final String ID_EDIT_FORM = "editForm";

	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param parent 親コンポーネント。
	 * @param element Web要素。
	 */
	public DataFormsTestElement(final Browser browser, final TestElement parent, final WebElement element) {
		super(browser, parent, element);
	}

	/**
	 * フォームを取得します。
	 * @param <T> フォームテスト要素型。
	 * @param id フォームID。
	 * @param cls フォームクラス。
	 * @return フォーム。
	 */
	public <T extends FormTestElement> T getForm(final String id, final Class<T> cls) {
		try {
			WebElement element = this.getWebElement().findElement(By.xpath("//form[@data-id='" + id + "']"));
			T form = cls.getConstructor(Browser.class, TestElement.class, WebElement.class).newInstance(this.getBrowser(), this, element);
			return form;
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return null;
	}

	/**
	 * フォームを取得します。
	 * @param <T> フォームテスト要素型。
	 * @param cls フォームクラス。
	 * @return フォーム。
	 */
	public <T extends FormTestElement> T getForm(final Class<T> cls) {
		try {
			java.lang.reflect.Field field = cls.getField("ID");
			String id = (String) field.get(null);
			WebElement element = this.getWebElement().findElement(By.xpath("//form[@data-id='" + id + "']"));
			T form = cls.getConstructor(Browser.class, TestElement.class, WebElement.class).newInstance(this.getBrowser(), this, element);
			return form;
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return null;
	}

	/**
	 * フォームを取得します。
	 * @param id フォームID。
	 * @return フォーム。
	 */
	public FormTestElement getForm(final String id) {
		return this.getForm(id, FormTestElement.class);
	}


	/**
	 * 問い合わせフォームを取得します。
	 * @return 問い合わせフォーム。
	 */
	public QueryFormTestElement getQueryForm() {
		QueryFormTestElement f = (QueryFormTestElement) this.getForm(QueryFormTestElement.class);
		return f;
	}

	/**
	 * 問い合わせフォームを取得します。
	 * @param <T> フォームテスト要素型。
	 * @param cls フォームクラス。
	 * @return 問い合わせフォーム。
	 */
	public <T extends QueryFormTestElement> T getQueryForm(final Class<T> cls) {
		T f =  this.getForm(cls);
		return f;
	}


	/**
	 * 問い合わせ結果フォームを取得します。
	 * @return 問い合わせフォーム。
	 */
	public QueryResultFormTestElement getQueryResultForm() {
		QueryResultFormTestElement f = (QueryResultFormTestElement) this.getForm(QueryResultFormTestElement.class);
		return f;
	}

	/**
	 * 問い合わせ結果フォームを取得します。
	 * @param <T> フォームテスト要素型。
	 * @param cls フォームクラス。
	 * @return 問い合わせ結果フォーム。
	 */
	public <T extends QueryResultFormTestElement> T getQueryResultForm(final Class<T> cls) {
		T f = this.getForm(cls);
		return f;
	}

	
	/**
	 * 編集フォームを取得します。
	 * @return 編集フォーム。
	 */
	public EditFormTestElement getEditForm() {
		EditFormTestElement f = (EditFormTestElement) this.getForm(EditFormTestElement.class);
		return f;
	}

	
	/**
	 * 編集フォームを取得します。
	 * @param <T> フォームテスト要素型。
	 * @param cls フォームクラス。
	 * @return 編集フォームフォーム。
	 */
	public <T extends EditFormTestElement> T getEditForm(final Class<T> cls) {
		T f = (T) this.getForm(cls);
		return f;
	}

	/**
	 * ログインフォームを取得します。
	 * @return ログインフォーム。
	 */
/*	public LoginFormTestElement getLoginForm() {
		LoginFormTestElement f = (LoginFormTestElement) this.getForm(LoginFormTestElement.class);
		return f;
	}*/

}
