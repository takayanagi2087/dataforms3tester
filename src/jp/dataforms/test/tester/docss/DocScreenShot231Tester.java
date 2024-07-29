package jp.dataforms.test.tester.docss;

import jp.dataforms.fw.app.user.page.UserManagementPage;
import jp.dataforms.test.element.app.user.page.UserEditFormTestElement;
import jp.dataforms.test.element.app.user.page.UserManagementPageTestElement;
import jp.dataforms.test.element.app.user.page.UserQueryFormTestElement;
import jp.dataforms.test.element.htmltable.TableTestElement;
import jp.dataforms.test.proj.WebAppProject;
import jp.dataforms.test.selenium.Browser;

/**
 * プロジェクトの初期化のスクリーンショットを取得するツール。
 */
public class DocScreenShot231Tester extends DocScreenShotTester {

	/**
	 * コンストラクタ。
	 */
	public DocScreenShot231Tester() {
		super("2.3.customize");
	}
	
	/**
	 * ユーザの登録。
	 * @param browser ブラウザ。
	 * @param p ページテスト要素。
	 * @param user ユーザ。
	 * @param screenShot スクリーンショット取得フラグ。
	 * @throws Exception 例外。
	 */
	private void addUser(final Browser browser, final UserManagementPageTestElement p, final String user, final boolean screenShot) throws Exception {
		UserQueryFormTestElement qf = p.getUserQueryForm();
		qf.newData();
		UserEditFormTestElement ef = p.getUserEditForm();
		TestUser testUser = this.getConf().getTestUser(user);
		ef.getLoginId().setValue(testUser.getLoginId());
		ef.getPassword().setValue(testUser.getPassword());
		ef.getPasswordCheck().setValue(testUser.getPassword());
		ef.getUserName().setValue(user + " name");
		ef.getMailAddress().setValue(user + "@hogehoge.jp");
		TableTestElement table = ef.getAttTable();
		table.addRow();
		table.setValue(0, "userAttributeType", "userLevel");
		table.setValue(0, "userAttributeValue", user);
		table.getField(0, "userAttributeValue").click();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		if (screenShot) {
			this.saveScreenShot(browser, "userManagement2.png", false);
		}
		table.getField(0, "userAttributeValue").click();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		ef.confirm();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		ef.save();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		p.getAlertDialog().clickOkButton();
	}

	/**
	 * ユーザメンテナンス。
	 * @param browser ブラウザ。
	 * @throws Exception 例外。
	 */
	private void userMaint(final Browser browser) throws Exception {
		this.openPage(browser, UserManagementPage.class);
		UserManagementPageTestElement p = browser.getPageTestElement(UserManagementPageTestElement.class);
		UserQueryFormTestElement qf = p.getUserQueryForm();
		qf.query();
		this.saveScreenShot(browser, "userManagement.png");
		Browser.sleep(this.getConf().getTestApp().getShortWait());
		this.addUser(browser, p, "admin", true);
		this.addUser(browser, p, "user", false);
		this.addUser(browser, p, "guest", false);
	}
	
	@Override
	public void exec() throws Exception {
		WebAppProject proj = WebAppProject.newWebAppProject(this.getConf());
		proj.importDb("step01", "jp.dataforms.fw.app", "jp.dataforms.sample.edittable");
		proj.loadSnapshot("step01");
		this.reloadWebApp(this.getConf().getTestApp().getContextPath());
		Browser browser = this.getBrowser();
		this.login(browser, "developer");
		this.userMaint(browser);
		
/*		this.changeSystemName(browser, proj);
		this.editMenu(browser);
		this.editTable(browser);
		this.createTable(browser);
		this.createDaoAndPage(browser);
		this.createHtmlPage(browser);
		this.testSamplePage(browser);
*/
		proj.saveSnapshot("step02");
		browser.close();

	}
}
