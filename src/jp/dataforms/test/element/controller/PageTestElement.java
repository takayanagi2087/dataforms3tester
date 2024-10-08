package jp.dataforms.test.element.controller;


import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import jp.dataforms.test.element.TestElement;
import jp.dataforms.test.element.field.ButtonTestElement;
import jp.dataforms.test.selenium.Browser;

/**
 * ページのテスト要素。
 */
public class PageTestElement extends DataFormsTestElement {
	/**
	 * ログアウトボタンのID。
	 */
	private static final String ID_LOGOUT_BUTTON = "logoutButton";
	
	/**
	 * Logger.
	 */
	private static Logger logger = LogManager.getLogger(PageTestElement.class);

	
	/**
	 * コンストラクタ。
	 * @param browser ブラウザ。
	 * @param element 要素。
	 */
	public PageTestElement(final Browser browser, final WebElement element) {
		super(browser, null, element); // ページなので親要素無
	}

	@Override
	protected String getXPathRange() {
		return "";
	}

	/**
	 * 指定されたコンポーネントが表示されるのを待ちます。
	 * @param id コンポーネントID。
	 * @throws Exception 例外。
	 */
	public void waitVisivility(final String id) throws Exception {
		this.getBrowser().waitVisibility(By.xpath("//div[@data-id='" + id + "']"));
	}
	
	/**
	 * ダイアログのテスターを取得します。
	 * @param <T> ダイアログテストツール。
	 * @param id ID。
	 * @param cls ダイアログクラス。
	 * @return ダイアログ。
	 */
	public <T extends DialogTestElement> T getDialog(final String id, final Class<T> cls) {
		try {
			WebElement element = this.getWebElement().findElement(By.xpath("//div[@data-id='" + id + "']"));
			T dialog = cls
					.getConstructor(Browser.class, TestElement.class, WebElement.class)
					.newInstance(this.getBrowser(), this, element);
			return dialog;
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return null;
	}

	/**
	 * ダイアログのテスターを取得します。
	 * @param id ID。
	 * @return ダイアログ。
	 */
	public DialogTestElement getDialog(final String id) {
		return this.getDialog(id, DialogTestElement.class);
	}

	/**
	 * AlertDialogを取得します。
	 * @return AlertDialog。
	 */
	public AlertDialogTestElement getAlertDialog() {
		return this.getDialog(AlertDialogTestElement.ID, AlertDialogTestElement.class);
	}
	
	/**
	 * ConfirmDialogを所得します。
	 * @return ConfirmDialog。
	 */
	public ConfirmDialogTestElement getConfirmDialog() {
		return this.getDialog(ConfirmDialogTestElement.ID, ConfirmDialogTestElement.class);
	}
	
	/**
	 * 全てのサイドメニューグループをクリックします。
	 */
	public void clickAllMenuGroup() {
		WebDriver driver = this.getBrowser().getWebDriver();
		List<WebElement> list = driver.findElements(By.xpath("//p[@class='sideMenuGroup']"));
		for (WebElement e: list) {
			e.click();
		}
	}

	/**
	 * 全てのサイドメニューグループをクリックします。
	 * @param name メニューグループ名称。
	 */
	public void clickMenuGroup(final String name) {
		WebDriver driver = this.getBrowser().getWebDriver();
		WebElement element = driver.findElement(By.xpath("//p[contains(text(), '" + name + "')]"));
		element.click();
	}

	/**
	 * エラーメッセージを取得します。
	 * @return エラーメッセージ。
	 */
	public String getErrorMessage() {
		String message = this.findWebElement(By.id("errorMessages")).getText().trim();
		return message;
	}
	
	/**
	 * エラーメッセージリストを取得します。
	 * @return エラーメッセージリスト。
	 */
	public List<String> getErrorMessageList() {
		List<String> list = new ArrayList<String>();
		String message = this.findWebElement(By.id("errorMessages")).getText().trim();
		String[] sp = message.split("\n");
		for (int i = 0; i < sp.length; i++) {
			list.add(sp[i].trim());
		}
		return list;
	}
	
	
	/**
	 * ログアウトボタンを取得します。
	 * @return ログアウトボタン。
	 */
	public ButtonTestElement getLogoutButton() {
		return this.getButton(ID_LOGOUT_BUTTON);
	}
}
