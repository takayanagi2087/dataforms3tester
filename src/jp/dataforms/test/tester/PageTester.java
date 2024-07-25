package jp.dataforms.test.tester;

import java.io.File;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import jp.dataforms.fw.controller.Page;
import jp.dataforms.fw.controller.WebComponent;
import jp.dataforms.fw.devtool.javasrc.JavaSrcGenerator.Template;
import jp.dataforms.fw.menu.FunctionMap;
import jp.dataforms.fw.util.ClassFinder;
import jp.dataforms.fw.util.FileUtil;
import jp.dataforms.fw.util.JsonUtil;
import jp.dataforms.fw.util.WebClient;
import jp.dataforms.test.annotation.TestItemInfo;
import jp.dataforms.test.element.app.login.page.LoginFormTestElement;
import jp.dataforms.test.element.app.login.page.LoginPageTestElement;
import jp.dataforms.test.element.controller.PageTestElement;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.selenium.BrowserInfo;
import jp.dataforms.test.testitem.TestItem;
import jp.dataforms.test.testitem.TestItem.TestItemResult;
import jp.dataforms.test.testitem.page.responsive.ResponsiveTestItem;
import lombok.Data;
import lombok.Getter;


/**
 * テスト実行ツール。
 */
public abstract class PageTester {
	/**
	 * Logger.
	 */
	private static Logger logger = LogManager.getLogger(PageTester.class);
	
	/**
	 * 設定ファイルのパス。
	 */
//	private String confFile = null;

	/**
	 * 回帰テスト。
	 */
	private boolean regression = false;
	
	/**
	 * Selenium設定情報。
	 */
	@Data
	public static class Selenium {
		/**
		 * ドライバーのファイル名。
		 */
		private String driver = null;
		/**
		 * ドライバのフォルダ。
		 */
		private String driverFolder = null;
		/**
		 * headlessフラグ。
		 */
		private Boolean headless = null;
		/**
		 * ブラウザリスト。
		 */
		private List<BrowserInfo> driverList = null;
		
		
		/**
		 * コンストラクタ。
		 */
		public Selenium() {
			
		}
		
		private String getDriverPath() throws Exception {
			String ret = null;
			File dir = new File(this.getDriverFolder());
			File[] list = dir.listFiles();
			for (File f: list) {
				String name = f.getName();
				if (name.indexOf(this.driver) == 0) {
					ret = f.getAbsolutePath();
				}
			}
			return ret;
		}
		
		/**
		 * ブラウザ情報を取得します。
		 * @return ブラウザ情報。
		 */
		public BrowserInfo getBrowserInfo() throws Exception {
			String driverPath = this.getDriverPath();
			logger.debug("driverPath=" + driverPath);
			BrowserInfo ret = null;
			for (BrowserInfo bi: this.driverList) {
				if (bi.getDriver().equals(this.driver)) {
					ret = bi;
					ret.setDriver(driverPath);
					break;
				}
			}
			return ret;
		}
	}
	
	/**
	 * Webアプリケーション。
	 */
	@Data
	public static class WebApplication {
		/**
		 * コンテキストパス。
		 */
		private String contextPath = null;
		/**
		 *  WebアプリケーションのURL。
		 */
		private String applicationURL = null;
		/** 
		 * テスト結果の保存パス。
		 */
		private String testResult = null;
		/**
		 * ページ繊維などの短い待ち時間。
		 */
		private int shortWait = 2;
		/**
		 * DB更新等を含むサーバ処理の待ち時間。
		 */
		private int middleWait = 5;
		/**
		 * 重いDB更新等を含むサーバ処理の待ち時間。
		 */
		private int longWait = 10;
		/**
		 * プロジェクトのソースを更新→Eclipseの自動ビルド→Tomcatのリロードの待ち時間。
		 */
		private int buildWait = 30;
		
		/**
		 * コンストラクタ。
		 */
		public WebApplication() {
			
		}
	}
	
	/**
	 * テストに使用するUser。
	 */
	@Data
	public static class TestUser {
		/**
		 * LoginID。
		 */
		private  String loginId = null;
		/**
		 * パスワード。
		 */
		private String password = null;
		
		/**
		 * コンストラクタ。
		 */
		public TestUser() {
			
		}
	}

	
	/**
	 * プロジェクト。
	 */
	@Data
	public static class Project {
		/**
		 * Eclipseプロジェクトのパス。
		 */
		private String projectPath = null;
		/**
		 * Eclipseプロジェクトの設定パス。
		 */
		private String tomcatConfigPath = null;
		/**
		 * テストソース。
		 */
		private String testSrc = null;
		/**
		 * ソースのsnapshot。
		 */
		private String snapshot = null;
		
		/**
		 * コンストラクタ。
		 */
		public Project() {
			
		}
	}
	
	/**
	 * Tomcat関連情報。
	 */
	@Data
	public static class Tomcat {
		/**
		 * 管理者ユーザID。
		 */
		private String adminUser = null;
		/**
		 * 管理者パスワード。
		 */
		private String adminPassword = null;
		/**
		 * TomcatマネージャーのURL。
		 */
		private String managerUrl = null;
	}
	
	/**
	 * テスト設定情報。
	 */
	@Data
	public static class Conf {
		/**
		 * Selenium設定情報。
		 */
		private Selenium selenium = null;
		/**
		 * テスト対象アプリケーション情報。
		 */
		private WebApplication testApp = null;
		/**
		 * ユーザリスト。
		 */
		private List<TestUser> userList = null;
		
		/**
		 * Eclipseプロジェクト情報。
		 */
		private Project project = null;
		/**
		 * Tomcat関連設定。
		 */
		private Tomcat tomcat = null;
		/**
		 * コンストラクタ。
		 */
		public Conf() {
			
		}
		
		/**
		 * 設定ファイルを読み込みます。
		 * @param confFile 設定ファイル。
		 * @return テスト設定情報。
		 * @throws Exception 例外。
		 */
		public static Conf read(final String confFile) throws Exception {
			String json = FileUtil.readTextFile(confFile, "utf-8");
			return  (Conf) JsonUtil.decode(json, Conf.class);
			
		}
		
		/**
		 * テストするむユーザ情報を取得します。
		 * @param loginId ログインID。
		 * @return ユーザ情報。
		 */
		public TestUser getTestUser(final String loginId) {
			TestUser ret = null;
			for (TestUser u: this.userList) {
				if (u.getLoginId().equals(loginId)) {
					ret = u;
					break;
				}
			}
			return ret;
		}
	}
	
	/**
	 * 設定情報。
	 */
	@Getter
	private Conf conf = null;
	
	/**
	 * テスト対象のページクラス。
	 */
	private Class<? extends Page> pageClass = null;
	
	/**
	 * ページクラスを設定します。
	 * @param pageClass ページクラス。
	 */
	protected void setPageClass(final Class<? extends Page> pageClass) {
		this.pageClass = pageClass;
	}
	
	/**
	 * コンストラクタ。
	 * 
	 */
	public PageTester() {
	}
	
	
	
	/**
	 * コンストラクタ。
	 * @param pageClass ページクラス。
	 * 
	 */
	public PageTester(final Class<? extends Page> pageClass) {
		this.pageClass = pageClass;
	}
	
	
	/**
	 * テスト項目のインスタンスを取得します。
	 * @param cls テスト項目のクラス。
	 * @param pageClass ページクラス。
	 * @param compClass テスト対象コンポーネントクラス。
	 * @return テスト項目のインスタンス。
	 * @throws Exception 例外。
	 */
	private TestItem getTestItemInstance(Class<? extends TestItem> cls, final Class<? extends Page> pageClass, 
			final Class<? extends WebComponent> compClass) throws Exception {
		if (pageClass != null && compClass != null) {
			TestItem ci = (TestItem) cls.getConstructor(Class.class, Class.class).
					newInstance(pageClass, compClass);
			return ci;
		} else if (pageClass == null && compClass != null) {
			TestItem ci = (TestItem) cls.getConstructor(Class.class).
					newInstance(compClass);
			return ci;
		} else if (pageClass != null && compClass == null) {
			TestItem ci = (TestItem) cls.getConstructor(Class.class).
					newInstance(pageClass);
			return ci;
		} else if (pageClass == null && compClass == null) {
			TestItem ci = (TestItem) cls.getConstructor().
					newInstance();
			return ci;
		}
		return null;
	}
	
	
	
	/**
	 * 指定された条件のチェック項目を取得します。
	 * @param basePackage クラスを検索するパッケージ。
	 * @param baseCheckItem チェック項目の基本クラス。
	 * @param pageClass ページクラス。
	 * @param compClass ターゲットクラス。
	 * @return チェック項目リスト。
	 * @throws Exception 例外。
	 */
	public List<TestItem> queryCheckItem(
			final String basePackage,
			final Class<? extends TestItem> baseCheckItem, 
			final Class<? extends Page> pageClass, 
			final Class<? extends WebComponent> compClass) throws Exception  {
		
		List<TestItem> ret = new ArrayList<TestItem>();
		ClassFinder cf = new ClassFinder();
		List<Class<?>> list = cf.findClasses(basePackage, baseCheckItem);
		for (Class<?> cls: list) {
			TestItemInfo a = cls.getAnnotation(TestItemInfo.class);
			if (a != null) {
				logger.debug("TestItemClass=" + cls.getName());
				@SuppressWarnings("unchecked")
				TestItem ci = this.getTestItemInstance((Class<? extends TestItem>) cls, pageClass, compClass);
				ret.add(ci);
			}
		}
		this.sortCheckItem(ret);
		return ret;
	}
	
	/**
	 * 指定された条件のチェック項目を取得します。
	 * @param baseCheckItem チェック項目の基本クラス。
	 * @param pageClass ページクラス。
	 * @param compClass ターゲットクラス。
	 * @return チェック項目リスト。
	 * @throws Exception 例外。
	 */
	public List<TestItem> queryCheckItem(
			final Class<? extends TestItem> baseCheckItem, 
			final Class<? extends Page> pageClass, 
			final Class<? extends WebComponent> compClass) throws Exception  {
		List<TestItem> ret = this.queryCheckItem(baseCheckItem.getPackageName(), baseCheckItem, pageClass, compClass);
		return ret;
	}

	/**
	 * 指定された条件のチェック項目を取得します。
	 * @param baseCheckItem チェック項目の基本クラス。
	 * @return チェック項目リスト。
	 * @throws Exception 例外。
	 */
	public List<TestItem> queryCheckItem(final Class<? extends TestItem> baseCheckItem) throws Exception  {
		List<TestItem> ret = this.queryCheckItem(baseCheckItem, null, null);
		return ret;
	}
	/**
	 * 指定したグループのテスト項目を実行します。
	 * @param browser ブラウザ。
	 * @param list テスト項目リスト。
	 * @param group テストを実行するグループ。
	 * @return テストを実行したテスト項目。
	 * @throws Exception 例外。
	 */
	protected List<TestItem> execTestItemList(final Browser browser, final List<TestItem> list, final String group) throws Exception {
		List<TestItem> ret = new ArrayList<TestItem>();
		for (TestItem ci: list) {
			if (this.regression) {
				if (!ci.getRegression()) {
					continue;
				}
			}
			if (group == null) {
				logger.info("Exec:" + ci.getClass().getName());
				ci.exec(browser);
				ret.add(ci);
			} else {
				if (group.equals(ci.getGroup())) {
					logger.info("Exec:" + ci.getClass().getName());
					ci.exec(browser);
					ret.add(ci);
				}
			}
		}
		return ret;
	}

	/**
	 * 指定したグループのテスト項目を実行します。
	 * @param browser ブラウザ。
	 * @param list テスト項目リスト。
	 * @return テストを実行したテスト項目。
	 * @throws Exception 例外。
	 */
	protected List<TestItem> execTestItemList(final Browser browser, final List<TestItem> list) throws Exception {
		return this.execTestItemList(browser, list, null);
	}

	
	/**
	 * レスポンシブデザインテストを実行します。
	 * @param browser ブラウザ。
	 * @param pageClass ページクラス。
	 * @param compClass コンポーネントクラス。
	 * 
	 * @return レスポンシブデザインテストの結果リスト。
	 * @throws Exception 例外。
	 */
	protected List<TestItem> testResponsive(final Browser browser, final Class<? extends Page> pageClass, final Class<? extends WebComponent> compClass) throws Exception {
		ResponsiveTestItem.setHeight(540);
		List<TestItem> list = this.queryCheckItem("jp.dataforms.test.testitem.page", ResponsiveTestItem.class, pageClass, compClass);
		return this.execTestItemList(browser, list, null);
	}


	/**
	 * チェック項目リストをソートします。
	 * @param list チェック項目リスト。
	 */
	protected void sortCheckItem(List<TestItem> list) {
		// テスト項目をソート
		list.sort((a, b) -> {
			String ga = a.getGroup();
			String gb = b.getGroup();
			int cmp = ga.compareTo(gb);
			if (cmp == 0) {
				String sa = a.getSeq();
				String sb = b.getSeq();
				cmp = sa.compareTo(sb);
			}
			return cmp;
		});
	}

	
	/**
	 * ブラウザを取得します。
	 * @return ブラウザ。
	 * @throws Exception 例外。
	 */
	protected Browser getBrowser() throws Exception {
		BrowserInfo bi = this.conf.getSelenium().getBrowserInfo();
		Browser browser = new Browser(bi);
		return browser;
	}

	
	
	/**
	 * ページのテンプレートを取得します。
	 * @return ページテンプレート。
	 * @throws Exception 例外。
	 */
	protected Template getTemplate() throws Exception {
		Template tmp = new Template(PageTester.class, "template/index.html.template");
		return tmp;
	}

	/**
	 * ページのテスト結果情報のクラス。
	 */
	@Data
	public static class PageTestResult {
		/**
		 * ページ名称。
		 */
		public String pageName = null;
		/**
		 * ページクラス名。
		 */
		public String pageClassName = null;
		
		/**
		 * テスト項目リスト。
		 */
		private List<TestItemResult> testItemList = null;
		
		/**
		 * コンストラクタ。
		 */
		public PageTestResult() {
			this.testItemList = new ArrayList<TestItemResult>();
		}
		
		/**
		 * テスト結果を検索します。
		 * @param item テスト項目結果。
		 * @return ヒットしたインデックス。
		 */
		public int find(final TestItemResult item) {
			int ret = -1;
			for (int i = 0; i < this.testItemList.size(); i++) {
				TestItemResult r = this.testItemList.get(i);
				if (r.getLink().equals(item.getLink())) {
					ret = i;
					break;
				}
			}
			return ret;
		}
		
		/**
		 * テスト結果を更新します。
		 * @param list 新規テスト結果リスト。
		 */
		public void update(final List<TestItemResult> list) {
			for (int i = 0; i < list.size(); i++) {
				int idx = this.find(list.get(i));
				if (idx >= 0) {
					this.testItemList.set(idx, list.get(i));
				} else {
					this.testItemList.add(list.get(i));
				}
			}
			this.testItemList.sort((a, b) -> {
				String ga = a.getCompClass();
				String gb = b.getCompClass();
				int cmp = ga.compareTo(gb);
				if (cmp == 0) {
					String sa = a.getTestId();
					String sb = b.getTestId();
					cmp = sa.compareTo(sb);
				}
				return cmp;
			});

		}
	}
	
	
	/**
	 * index.htmlから既存のテスト結果を取得します。
	 * @return テスト結果のjson部分。
	 * @throws Exception 例外。
	 */
	protected PageTestResult readOldTestResult() throws Exception {
		String fn = TestItem.getTestResult() + "/" + this.pageClass.getName() + "/index.html";
		File f = new File(fn);
		PageTestResult ret = null;
		if (f.exists()) {
			String indexHtml = FileUtil.readTextFile(fn, "utf-8");
			logger.debug("indexHtml=" + indexHtml);
			Pattern p = Pattern.compile("// ### testResult begin([\\s\\S]*)// ### testResult end", Pattern.MULTILINE);
			Matcher m = p.matcher(indexHtml);
			if (m.find()) {
				String json = m.group(1);
				logger.debug("*** json=" + json);
				ret = (PageTestResult) JsonUtil.decode(json, PageTestResult.class);
			}
		}
		return ret;
	}
	
	
	
	/**
	 * 保存するページのテスト結果を作成します。
	 * @param pageName ページ名称。
	 * @param list テスト結果リスト。
	 * @return ページのテスト結果。
	 * @throws Exception 例外。
	 */
	protected PageTestResult getPageTestResult(final String pageName, final List<TestItem> list) throws Exception {
		List<TestItemResult> testItemList = new ArrayList<TestItemResult>();
		for (TestItem ti: list) {
			testItemList.add(ti.getTestItemResult());
		}
		PageTestResult result = new PageTestResult();
		result.setPageName(pageName);
		result.setPageClassName(this.pageClass.getName());
		result.setTestItemList(testItemList);
		return result;
	}
	
	
	/**
	 * テスト結果リストindex.htmlの作成。
	 * @param pageName ページ名。
	 * @param list テスト結果リスト。
	 * @throws Exception 例外。
	 */
	protected void saveIndexHtml(final String pageName, final List<TestItem> list) throws Exception {
		PageTestResult newResult = this.getPageTestResult(pageName, list);
		PageTestResult result = this.readOldTestResult();
		if (result == null) {
			result = newResult;
		} else {
			result.update(newResult.getTestItemList());
		}
		String json = JsonUtil.encode(result, true);
		
		Template indexTemplate = this.getTemplate();
		String source = indexTemplate.getSource();
		Pattern p = Pattern.compile("\\$\\{resultList\\}");
		Matcher m = p.matcher(indexTemplate.getSource());
		if (m.find()) {
			int s = m.start();
			int e = m.end();
			source = source.substring(0, s) + json + source.substring(e);
		}
		String fn = TestItem.getTestResult() + "/" + this.pageClass.getName() + "/index.html";
		FileUtil.writeTextFile(fn, source, "utf-8");
	}
	
	/**
	 * 設定ファイルを読み込みます。
	 * @param confFile 設定ファイル。
	 * @throws Exception 例外。　
	 */
	public void readConf(final String confFile) throws Exception {
		logger.debug("path=" + confFile);
		this.conf = Conf.read(confFile);
		logger.debug("conf=" + JsonUtil.encode(this.conf, true));
		Browser.setConf(this.conf);
		TestItem.setConf(this.conf);
	}
	
	/**
	 * ページをオープンします。
	 * @param browser ブラウザ。
	 * @param pageClass ページクラス。
	 * @return オープンしたページ要素。
	 * @throws Exception 例外。
	 */
	protected PageTestElement openPage(final Browser browser, final Class<? extends Page> pageClass) throws Exception {
		FunctionMap map = FunctionMap.getAppFunctionMap();
		String uri = map.getWebPath(pageClass.getName());
		logger.info("uri = " + uri);
		PageTestElement pt = (PageTestElement) browser.open(this.conf.getTestApp().getApplicationURL() + uri.substring(1) + ".html");
		return pt;
	}

	/**
	 * ページをオープンします。
	 * @param browser ブラウザ。
	 * @return オープンしたページ要素。
	 * @throws Exception 例外。
	 */
	protected PageTestElement openPage(final Browser browser) throws Exception {
		return this.openPage(browser, this.pageClass);
	}

	
	/**
	 * 指定したWebアプリケーションをリロードする。
	 * @param context コンテキストパース。
	 * @return HTTP ステータス。
	 * @throws Exception 例外。
	 */
	public int reloadWebApp(final String context) throws Exception {
		String url = this.conf.getTomcat().getManagerUrl();
		String user = this.conf.getTomcat().getAdminUser();
		String password = this.conf.getTomcat().getAdminPassword();
		String basicSource  = user + ":" + password;
		String basicCrypt = Base64.getEncoder().encodeToString(basicSource.getBytes());
		String reloadUrl = url + "/reload?path=" + context;
		logger.info("reloadURL=" + reloadUrl);
		WebClient client = new WebClient(reloadUrl, WebClient.METHOD_GET);
		client.addRequestHeader("Authorization", "basic " + basicCrypt);
		String resp = (String) client.call();
		logger.info("status=" + client.getHttpStatus());
		logger.info("resp=" + resp);
		return client.getHttpStatus();
	}
	
	/**
	 * APIを呼び出します。
	 * @param url URL。
	 * @param p パラメータ。
	 * @return 応答情報。
	 * @throws Exception 例外。
	 */
	public Object callApi(final String url, final Map<String, Object> p) throws Exception {
		WebClient client = new WebClient(url, WebClient.METHOD_POST);
		Object r =  client.call(p);
		return r;
	}
	
	/**
	 * 指定した更新系SQLを実行する。
	 * @param sqlList SQLのリスト。
	 * @throws Exception 例外。
	 */
	public void executeUpdateSql(final String ... sqlList) throws Exception {
		List<String> list = new ArrayList<String>();
		for (String sql: sqlList) {
			list.add(sql);
		}
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("sqlList", list);
		String url = this.getConf().getTestApp().getApplicationURL() + "test/api/UpdateTableApi.html";
		@SuppressWarnings("unchecked")
		Map<String, Object> response = (Map<String, Object>) this.callApi(url, p);
		logger.debug("status=" + response.get("status"));
	}
	
	
	/**
	 * テーブルを削除します。
	 * @param tables テーブル一覧。
	 * @throws Exception 例外。
	 */
	public void dropTables(String ...tables) throws Exception {
		List<String> tlist = new ArrayList<String>();
		for (String t: tables) {
			tlist.add(t);
		}
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("tableList", tlist);
		String url = this.getConf().getTestApp().getApplicationURL() + "test/api/DropTableApi.html";
		@SuppressWarnings("unchecked")
		Map<String, Object> response = (Map<String, Object>) this.callApi(url, p);
		logger.debug("status=" + response.get("status"));
	}
	
	/**
	 * データベースをクリアします。
	 * @throws Exception 例外。
	 */
	public void cleanDB() throws Exception {
		this.executeUpdateSql("drop index enum_index");
		this.executeUpdateSql("drop index login_id_index");
		this.executeUpdateSql("drop index user_authenticator_name_index");
		this.executeUpdateSql("alter table enum drop constraint fk_enum_table01");
		this.executeUpdateSql("alter table user_attribute drop constraint fk_user_attribute_table01");
		this.executeUpdateSql("alter table web_authn drop constraint fk_web_authn_table01");
		this.dropTables("web_authn", "user_attribute", "user_info", "enum_name", "enum");
	}

	
	/**
	 * ログインを行います。
	 * @param browser ブラウザ。
	 * @param loginId ログインID。
	 */
	protected void login(final Browser browser, final String loginId) {
		String password = this.getConf().getTestUser(loginId).getPassword();
		String appUrl = this.getConf().getTestApp().getApplicationURL() + "dataforms/app/login/page/LoginPage.html";
		LoginPageTestElement page = browser.open(appUrl, LoginPageTestElement.class);
		LoginFormTestElement form = page.getLoginForm();
		form.getLoginIdField().setValue(loginId);
		form.getPasswordField().setValue(password);
		form.getLoginButton().click();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
	}

	/**
	 * ログアウトを行います。
	 * @param browser ブラウザ。
	 */
	protected void logout(final Browser browser) {
		String id = "mainDiv.loginInfoForm.logoutButton";
		browser.findElement(By.id(id)).click();
		Browser.sleep(this.getConf().getTestApp().getShortWait());
	}
	
	/**
	 * テスト実行。
	 * @throws Exception 例外。
	 */
	public abstract void exec() throws Exception;

	/**
	 * 子マントライン引数。
	 */
	@Data
	private static class CmdArg {
		/**
		 * 回帰テストフラグ。
		 */
		private boolean	regression = false;
		/**
		 * 設定ファイル。
		 */
		private String conf = null;
		/**
		 * テスタークラス。
		 */
		private String testerClass = null;
	}
	
	/**
	 * コマンドライン引数情報を取得します。
	 * @param args コマンドライン引数。
	 * @return コマンドライン引数情報。 
	 */
	private static CmdArg getCmdArg(final String[] args) {
		CmdArg cmdArg = new CmdArg();
		for (String arg: args) {
			if ("-r".equals(arg)) {
				cmdArg.setRegression(true);
			} else {
				if (cmdArg.getConf() == null) {
					cmdArg.setConf(arg);
				} else {
					cmdArg.setTesterClass(arg);
				}
			}
		}
		return cmdArg;
	}
	
	
	
	/**
	 * メイン処理。
	 * @param args コマンドライン。
	 * <pre>
	 * args[0]	...	テスト設定ファイル。
	 * args[1]	...	テスタークラス名。
	 * </pre>
	 */
	public static void main(String[] args) {
		try {
			if (args.length >= 2) {
				CmdArg cmdArg = PageTester.getCmdArg(args);
				@SuppressWarnings("unchecked")
				Class<? extends PageTester> testerClass = (Class<? extends PageTester>) Class.forName(cmdArg.getTesterClass());
				PageTester exec = testerClass.getConstructor().newInstance();
				exec.regression = cmdArg.isRegression();
				exec.readConf(cmdArg.getConf());
				exec.exec();
			} else {
				System.out.println("使い方:java -jar df3tester.jar [option] <ConfFile> <PageTesterClass>\n");
				System.out.println("[option] \n");
				System.out.println("-r 回帰テスト(regression = trueと設定されたテスト項目のみを実行する。)\n");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
}
