package jp.dataforms.test.element.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.TestElement;
import jp.dataforms.test.element.field.FieldTestElement;
import jp.dataforms.test.element.htmltable.TableTestElement;
import jp.dataforms.test.selenium.Browser;

/**
 * フォームのテスター。
 */
public class FormTestElement extends TestElement {
	/**
	 * Logger.
	 */
	 private static Logger logger = LogManager.getLogger(FormTestElement.class);

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
	public FormTestElement(final Browser browser, final TestElement parent, final WebElement webElement) {
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
	 * テーブルを取得します。
	 * @param id ID。
	 * @return テーブルのインスタンス。
	 */
	public TableTestElement getTable(final String id) {
		String xpath = this.getXPathRange() + "//table[@data-id='" + id + "']";
		List<WebElement> elements = this.findWebElements(By.xpath(xpath));
		logger.debug("*** input elements=" + elements.size());
		if (elements.size() == 1) {
			return new TableTestElement(this.getBrowser(), this, elements.get(0));
		}
		return null;
	}

	
	/**
	 * フォームがロックされているかどうかを確認します。
	 * @return ロックされている場合true。
	 */
	public boolean isLocked() {
		boolean ret = true;
		{
			List<WebElement> list = this.findWebElements(By.cssSelector("input[type='text']"));
			for (WebElement we: list) {
				String readonly = we.getAttribute("readonly");
				if (!"true".equals(readonly)) {
					ret = false;
					break;
				}
			}
		}
		{
			List<WebElement> list = this.findWebElements(By.cssSelector("input[type='checkbox']"));
			for (WebElement we: list) {
				if (we.isDisplayed()) {
					ret = false;
					break;
				}
			}
		}
		{
			List<WebElement> list = this.findWebElements(By.cssSelector("input[type='radio']"));
			for (WebElement we: list) {
				if (we.isDisplayed()) {
					ret = false;
					break;
				}
			}
		}
		{
			List<WebElement> list = this.findWebElements(By.cssSelector("select"));
			for (WebElement we: list) {
				if (we.isDisplayed()) {
					ret = false;
					break;
				}
			}
		}
		{
			List<WebElement> list = this.findWebElements(By.cssSelector(".fileFieldButton"));
			for (WebElement we: list) {
				if (we.isDisplayed()) {
					ret = false;
					break;
				}
			}
		}
		return ret;
	}
}
