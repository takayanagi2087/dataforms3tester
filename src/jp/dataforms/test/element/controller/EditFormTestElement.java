package jp.dataforms.test.element.controller;

import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.TestElement;
import jp.dataforms.test.element.field.ButtonTestElement;
import jp.dataforms.test.element.field.FieldTestElement;
import jp.dataforms.test.selenium.Browser;

/**
 * EditFormのテスト要素。
 */
public class EditFormTestElement extends FormTestElement {
	/**
	 * Logger.
	 */
//	private static Logger logger = LogManager.getLogger(EditFormTestElement.class);
	/**
	 * フォームID。
	 */
	public static final String ID = "editForm";
	
	/**
	 * 確認ボタンのID。
	 */
	public static final String ID_CONFIRM_BUTTON = "confirmButton";
	
	/**
	 * 保存ボタンのID。
	 */
	public static final String ID_SAVE_BUTTON = "saveButton";

	/**
	 * リセットボタンのID。
	 */
	public static final String ID_RESET_BUTTON = "resetButton";

	/**
	 * 戻るボタンのID。
	 */
	public static final String ID_BACK_BUTTON = "backButton";
	
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param parent 親コンポーネント。
	 * @param webElement FormのWebElement。
	 */
	public EditFormTestElement(final Browser browser, final TestElement parent, final WebElement webElement) {
		super(browser, parent, webElement);
	}

	/**
	 * 値を指定したフィールドに設定します。
	 * @param id フィールドID。
	 * @param value 値。
	 */
	public void setValue(final String id, final String value) {
		FieldTestElement field = this.getField(id);
		field.setValue(value);
	}
	
	/**
	 * 確認ボタンを取得します。
	 * @return 確認ボタンのテスト要素。
	 */
	public ButtonTestElement getConfirmButton() {
		return this.getButton(ID_CONFIRM_BUTTON);
	}

	/**
	 * 保存ボタンのテスト要素を取得します。
	 * @return 保存ボタンのテスト要素。
	 */
	public ButtonTestElement getSaveButton() {
		return this.getButton(ID_SAVE_BUTTON);
	}

	/**
	 * 戻るボタンのテスト要素を取得します。
	 * @return 戻るボタンのテスト要素。
	 */
	public ButtonTestElement getBackButton() {
		return this.getButton(ID_BACK_BUTTON);
	}

	/**
	 * 確認ボタンの処理を行ないます。
	 */
	public void confirm() {
		this.getConfirmButton().click();
	}
	
	/**
	 * 保存ボタンの処理を行ないます。
	 */
	public void save() {
		this.getSaveButton().click();
	}

}
