package jp.dataforms.test.proj;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.io.Files;

import jp.dataforms.fw.util.ConfUtil;
import jp.dataforms.fw.util.FileUtil;
import jp.dataforms.fw.util.JsonUtil;
import jp.dataforms.fw.util.SequentialProperties;
import jp.dataforms.fw.util.WebClient;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.tester.PageTester.Conf;
import jp.dataforms.test.tester.PageTester.Project;
import jp.dataforms.test.xml.ServerXml;
import jp.dataforms.test.xml.TomcatUsersXml;
import lombok.Getter;
import lombok.Setter;

/**
 * Webアプレケーションプロジェクトクラス。
 *
 */
public class WebAppProject {
	/**
	 * Logger.
	 */
	private static Logger logger = LogManager.getLogger(WebAppProject.class);
	
	
	/**
	 * Javaのソースパス。
	 */
	public static final String JAVA_SRC = "/src/main/java";
	
	/**
	 * Webのソースパス。
	 */
	public static final String WEB_SRC = "/src/main/webapp";
	
	/**
	 * EclipseのWebアプリケーションプロジェクトのパス。
	 */
	@Getter
	private String path = null;
	
	/**
	 * WebプロジェクトのURL。
	 */
	@Getter
	private String url = null;

	/**
	 * Tomcatのconfフォルダのパス。
	 */
	@Getter
	@Setter
	private String tomcatConfigPath = null;
	
	/**
	 * スナップショットのパス。
	 */
	@Getter
	@Setter
	private String snapshot = null;
	
	/**
	 * テストソース。
	 */
	@Getter
	@Setter
	private String testSrc = null;
	
	/**
	 * 設定情報。
	 */
	private Conf conf = null;
	
	/**
	 * コンストラクタ。
	 * @param path Webアプリケーションプロジェクトのパス。
	 * @param url WebアプリケーションのURL。
	 */
	public WebAppProject(final String path, final String url) {
		this.path = path;
		this.url = url;
	}
	

	/**
	 * プロジェクトが有効かどうかを確認する。
	 * @return 有効なプロジェクトの場合true。
	 */
	public boolean isValid() {
		boolean ret = true;
		File javaSrc = new File(this.path + "/src/main/java");
		if (!javaSrc.exists()) {
			logger.error(() -> javaSrc + " が存在しません。");
			ret = false;
		} else {
			File webSrc = new File(this.path + "/src/main/webapp");
			if (!webSrc.exists()) {
				logger.error(() -> webSrc + " が存在しません。");
				ret = false;
			} else {
				File pomxml = new File(this.path + "/pom.xml");
				if (!pomxml.exists()) {
					logger.error(() -> pomxml + " が存在しません。");
					ret = false;
				}
			}
		}
		return ret;
	}


	/**
	 * Javaソースを削除します。
	 * @throws Exception 例外。
	 */
	private void cleanJavaSrc() throws Exception {
		File javaSrc = new File(this.path + "/src/main/java");
		if (javaSrc.exists()) {
			FileUtils.deleteDirectory(javaSrc);
			logger.info("Javacソースクリアしました。");
		}
		javaSrc.mkdirs();
	}


	/**
	 * MANIFEST.MFの内容。
	 */
	private static final String MANIFEST_MF = """
			Manifest-Version: 1.0
			Class-Path: 			
			""";
	
	/**
	 * WebApp以下を初期化します。
	 * @throws Exception 例外。
	 */
	private void cleanWebapp() throws Exception {
		File initialData = new File(this.path + "/src/main/webapp");
		if (initialData.exists()) {
			FileUtils.deleteDirectory(initialData);
			logger.info("webappをクリアしました。");
		}
		File metaInf = new File(this.path + "/src/main/webapp/META-INF");
		metaInf.mkdirs();
		FileUtil.writeTextFile(this.path + "/src/main/webapp/META-INF/MANIFEST.MF", MANIFEST_MF, "utf-8");
		File webInf = new File(this.path + "/src/main/webapp/WEB-INF/lib");
		webInf.mkdirs();
	}
	
	/**
	 * $TOMCAT_HOME/conf/server.xmlの初期化。
	 * @throws Exception 例外。
	 */
	private void initServerXml() throws Exception {
		ServerXml serverXml = new ServerXml(new File(this.tomcatConfigPath + "/server.xml"));
		serverXml.setAppContext(this.url);
		serverXml.save();
	}
	
	/**
	 * $TOMCAT_HOME/conf/server.xmlの初期化。
	 * @throws Exception 例外。
	 */
	private void initTomcatUsersXml() throws Exception {
		String user = this.conf.getTomcat().getAdminUser();
		String password = this.conf.getTomcat().getAdminPassword();
		TomcatUsersXml tomcatUsersXml = new TomcatUsersXml(new File(this.tomcatConfigPath + "/tomcat-users.xml"));
		tomcatUsersXml.addRole("admin-script");
		tomcatUsersXml.addRole("manager-script");
		tomcatUsersXml.addUser(user, password, "admin-script,manager-script");
		tomcatUsersXml.save();
	}


	
	/**
	 * データベースを初期化します。
	 * @throws Exception 例外。
	 */
	private void initDB() throws Exception {
		try {
			File dbpath = new File(this.path + "/javadb");
			if (dbpath.exists()) {
				FileUtils.cleanDirectory(dbpath);
				dbpath.delete();
				logger.info("データベースをクリアしました。");
			}
		} catch (Exception e) {
			logger.error("データベースファイルがロックされています。Tomcatを停止してください。");
			throw e;
		}
	}



	/**
	 * プロジェクトを初期状態にリセットします。
	 * @throws Exception 例外。
	 */
	public void resetProject() throws Exception {
		this.initDB();
		this.cleanJavaSrc();
		this.cleanWebapp();
		this.initServerXml();
		this.initTomcatUsersXml();
		this.copyTestApi();
	}
	

	/**
	 * DB初期化直後のプロジェクトに戻す。
	 * @throws Exception 例外。
	 */
	public void initSrc() throws Exception {
//		this.setSystemName("dataforms3.jar", "dataforms3.jar");
		jp.dataforms.fw.util.ConfUtil util = new jp.dataforms.fw.util.ConfUtil();
		String webSrcPath = this.path + "/src/main/webapp";
		File p = new File(webSrcPath + "/frame/messages");
		{
			String prop = util.getConfFile("./conf/AppClientMessages_ja.properties");
			FileUtil.writeTextFile(p + "/AppClientMessages_ja.properties", prop, "utf-8");
		}
		{
			String prop = util.getConfFile("./conf/AppClientMessages.properties");
			FileUtil.writeTextFile(p + "/AppClientMessages.properties", prop, "utf-8");
		}
		{
			String prop = util.getConfFile("./conf/AppMessages_ja.properties");
			FileUtil.writeTextFile(p + "/AppMessages_ja.properties", prop, "utf-8");
		}
		{
			String prop = util.getConfFile("./conf/AppMessages.properties");
			FileUtil.writeTextFile(p + "/AppMessages.properties", prop, "utf-8");
		}
		this.cleanPackage("jp");
		this.cleanWebSrc("/edittable");
	}
	
	/**
	 * プロジェクト中のweb.xmlを取得します。
	 * @return プロジェクト中のweb.xml。
	 */
	public File getWebXmlFile() {
		return new File(this.path + "/src/main/webapp/WEB-INF/web.xml");
	}
	
	/**
	 * プロジェクト中のdataforms.conf.jsoncを取得します。
	 * @return プロジェクト中のdataforms.conf.jsonc。
	 */
	public File getDataformsConfJsonc() {
		return new File(this.path + "/src/main/webapp/WEB-INF/dataforms.conf.jsonc");
	}
	

	/**
	 * web.xmlを初期状態に戻します。
	 * @throws Exception 例外。
	 */
/*	private void restoreWebXml() throws Exception {
		File orgFile = new File(this.path + "/src/main/webapp/WEB-INF/web.xml.org");
		if (orgFile.exists()) {
			File webXml = new File(this.path + "/src/main/webapp/WEB-INF/web.xml");
			FileUtils.copyFile(orgFile, webXml);
			orgFile.delete();
		}
	}
*/	

	/**
	 * dataforms.conf.jsoncをリリースモードに設定する。
	 * @throws Exception 例外。
	 */
	public void setReleaseMode() throws Exception {
		File confFile = this.getDataformsConfJsonc();
		ConfUtil.Conf webAppConf = ConfUtil.Conf.read(confFile.getAbsolutePath());
		List<String> pkglist = webAppConf.getInitialize().getDatabasePackageList();
		pkglist.add("jp.dataforms.sample");
		webAppConf.getInitialize().setDatabasePackageList(pkglist);
		webAppConf.getInitialize().setUserLevel("admin");
		webAppConf.getDevelopmentTool().setDisableCodeGenerationTool(true);
		webAppConf.getApplication().setJsonDebug(false);
		webAppConf.getApplication().setClientLogLevel("info");
		String json = JsonUtil.encode(webAppConf, true);
		logger.debug("json=" + json);
		FileUtil.writeTextFile(confFile.getAbsolutePath(), json, "utf-8");
		logger.info("dataforms.conf.jsoncをreleaseモードに更新しました。");
	}
	

	/**
	 * dataforms.conf.jsoncを開発モードに設定する。
	 * @throws Exception 例外。
	 */
	public void setDevelopMode() throws Exception {
		File confFile = this.getDataformsConfJsonc();
		ConfUtil.Conf webAppConf = ConfUtil.Conf.read(confFile.getAbsolutePath());
		List<String> pkglist = webAppConf.getInitialize().getDatabasePackageList();
		pkglist.add("jp.dataforms.sample");
		webAppConf.getInitialize().setUserLevel("developer");
		webAppConf.getDevelopmentTool().setDisableCodeGenerationTool(false);
		webAppConf.getApplication().setJsonDebug(true);
		webAppConf.getApplication().setClientLogLevel("debug");
		String json = JsonUtil.encode(webAppConf, true);
		logger.debug("json=" + json);
		FileUtil.writeTextFile(confFile.getAbsolutePath(), json, "utf-8");
		logger.info("dataforms.conf.jsoncをdevelopモードに更新しました。");
	}

	/**
	 * プロジェクト中のcontext.xmlを取得します。
	 * @return プロジェクト中のcontext.xml。
	 */
	public File getContextXmlFile() {
		return new File(this.path + "/src/main/webapp/META-INF/context.xml");
	}

	/**
	 * プロパティファイルに値を設定します。
	 * @param file プロパティファイル。
	 * @param prop プロパティ。
	 * @param value 値。
	 * @throws Exception 例外。
	 */
	public void setProperty(final String file, final String prop, final String value) throws Exception {
		SequentialProperties p = new SequentialProperties();
		p.loadFile(file);
		p.put(prop, value);
		p.saveFile(file);
	}
	
	/**
	 * システム名称を設定する。
	 * @param jpname 日本語名称。
	 * @param name 英語名称。
	 * @throws Exception 例外。
	 */
	public void setSystemName(final String jpname, final String name) throws Exception {
		String jpfile = this.path + "/src/main/webapp/frame/messages/AppClientMessages_ja.properties";
		this.setProperty(jpfile, "message.systemname", jpname);
		String defaultfile = this.path + "/src/main/webapp/frame/messages/AppClientMessages.properties";
		this.setProperty(defaultfile, "message.systemname", name);
		logger.info("システムの名称を" + jpname + "に設定しました。");
	}
	
	/**
	 * ソースファイルをプロジェクトにコピーする。
	 * @param src コピー元ファイル。
	 * @param dst コピー先ファイル。
	 * @throws Exception 例外。
	 */
	public void copyJavaSrc(final String src, final String dst) throws Exception {
		File srcFile = new File(this.testSrc + "/java" +  src);
		File dstFile = new File(this.path + "/src/main/java" + dst);
		if (!dstFile.getParentFile().exists()) {
			dstFile.getParentFile().mkdirs();
		}
		Files.copy(srcFile, dstFile);
	}
	

	/**
	 * Javaソースファイルを削除します。
	 * @param src ソース。
	 * @throws Exception 例外。
	 */
	public void deleteJavaSrc(final String src) throws Exception {
		File dstFile = new File(this.path + "/src/main/java" + src);
		if (dstFile.exists()) {
			dstFile.delete();
		}
	}
	
	
	/**
	 * ソースファイルをプロジェクトにコピーする。
	 * @param src コピー元ファイル。
	 * @param dst コピー先ファイル。
	 * @throws Exception 例外。
	 */
	public void copyWebappSrc(final String src, final String dst) throws Exception {
		File srcFile = new File(this.testSrc + "/webapp" +  src);
		File dstFile = new File(this.path + "/src/main/webapp" + dst);
		if (!dstFile.getParentFile().exists()) {
			dstFile.getParentFile().mkdirs();
		}
		Files.copy(srcFile, dstFile);
	}

	/**
	 * Webappソースファイルを削除します。
	 * @param src ソース。
	 * @throws Exception 例外。
	 */
	public void deleteWebappSrc(final String src) throws Exception {
		File dstFile = new File(this.path + "/src/main/webapp" + src);
		if (dstFile.exists()) {
			if (dstFile.isFile()) {
				dstFile.delete();
			} else {
				FileUtils.deleteDirectory(dstFile);
			}
		}
	}
	
	
	/**
	 * オリジナルJavaソースを保存する。
	 * @param src ソースファイル。
	 * @throws Exception 例外。
	 */
	public void saveOrgJavaSrc(final String src) throws Exception {
		File srcFile = new File(this.path + "/src/main/java" + src);
		File dstFile = new File(this.path + "/src/main/java" + src + ".org");
		if (!dstFile.exists()) {
			Files.copy(srcFile, dstFile);
		}
	}
	
	/**
	 * オリジナルJavaソースを保存する。
	 * @param src ソースファイル。
	 * @throws Exception 例外。
	 */
	public void saveOrgWebappSrc(final String src) throws Exception {
		File srcFile = new File(this.path + "/src/main/webapp" + src);
		File dstFile = new File(this.path + "/src/main/webapp" + src + ".org");
		if (!dstFile.exists()) {
			Files.copy(srcFile, dstFile);
		}
	}
	

	/**
	 * テスト用APIのソースをコピーする。
	 * @throws Exception 例外。
	 */
	public void copyTestApi() throws Exception  {
		this.copyJavaSrc("/test/api/TestWebApi.java", "/test/api/TestWebApi.java");
		this.copyJavaSrc("/test/api/DropTableApi.java", "/test/api/DropTableApi.java");
		this.copyJavaSrc("/test/api/UpdateTableApi.java", "/test/api/UpdateTableApi.java");
		this.copyJavaSrc("/test/api/BackupTableApi.java", "/test/api/BackupTableApi.java");
		this.copyJavaSrc("/test/api/RestoreTableApi.java", "/test/api/RestoreTableApi.java");
		logger.info("テストに必要なAPIを作成しました。");
	}
	
	/**
	 * テスト用のユーザ初期化データを作成します。
	 * @throws Exception 例外。
	 */
	public void copyUserInitialData() throws Exception {
		this.copyWebappSrc("/WEB-INF/initialdata/jp/dataforms/fw/app/user/dao/UserAttributeTable.data.json", "/WEB-INF/initialdata/jp/dataforms/fw/app/user/dao/UserAttributeTable.data.json");
		this.copyWebappSrc("/WEB-INF/initialdata/jp/dataforms/fw/app/user/dao/UserInfoTable.data.json", "/WEB-INF/initialdata/jp/dataforms/fw/app/user/dao/UserInfoTable.data.json");
	}
	
	/**
	 * Excel templateを削除します。
	 * @throws Exception 例外。
	 */
/*	private void cleanExcelTemplate() throws Exception {
		File exceltemplate = new File(this.path + "/src/main/webapp/exceltemplate");
		if (exceltemplate.exists()) {
			FileUtils.deleteDirectory(exceltemplate);
			logger.info("Excelテンプレートをクリアします。");
		}
	}
*/	
	/**
	 * プロジェクトを初期化します。
	 * @param deleteDBFile DBファイルの物理削除を行う。
	 * @throws Exception 例外。
	 */
	public void initProject(final boolean deleteDBFile) throws Exception {
/*		this.copyTestApi();
		this.initDB(deleteDBFile);
		this.cleanPackage("/sample");
		this.cleanInitialData();
		this.cleanExcelTemplate();
		this.initWebXml();
		this.setDevelopMode();
		this.initServerXml();
		this.setSystemName("dataforms2.jar", "dataforms2.jar");*/
	}
	
	/**
	 * テスト用APIのソースを更新し、プロジェクトをリロードします。
	 * @throws Exception 例外。
	 */
	public void update() throws Exception {
		this.copyTestApi();
		// Tomcatの自動リロードが終わるのを待つ。
		Browser.sleep(this.conf.getTestApp().getBuildWait());
	}
	
	/**
	 * プロジェクトのJavaのソースパスを取得します。
	 * @return プロジェクトのJavaのソースパス。
	 */
	public String getJavaSrcPath() {
		String basePath = this.path.replaceAll("\\\\", "/");
		String javaSrc = basePath + WebAppProject.JAVA_SRC;
		return javaSrc;
	}
	
	/**
	 * プロジェクトのWebソースパスを取得します。
	 * @return プロジェクトのWebソースパス。
	 */
	public String getWebSrcPath() {
		String basePath = this.path.replaceAll("\\\\", "/");
		String webSrc = basePath + WebAppProject.WEB_SRC;
		return webSrc;
	}
	
	/**
	 * Sampleパッケージを削除する。
	 * @param path パッケージのパス。
	 * @throws Exception　例外。
	 */
	public void cleanPackage(final String path) throws Exception {
		{
			File javaPath = new File(this.getJavaSrcPath() + "/" + path);
			logger.debug("javaPath=" + javaPath.getAbsolutePath());
			if (javaPath.exists()) {
				FileUtils.cleanDirectory(javaPath);
				javaPath.delete();
			}
		}
		logger.info(path + "パッケージをクリアしました。");
	}
	
	/**
	 * Webソースを削除します。
	 * @param path 削除するPath。
	 * @throws Exception 例外。
	 */
	public void cleanWebSrc(final String path) throws Exception {
		{
			File webPath = new File(this.getWebSrcPath()  + "/" +  path);
			logger.debug("webPath=" + webPath.getAbsolutePath());
			if (webPath.exists()) {
				FileUtils.cleanDirectory(webPath);
				webPath.delete();
			}
		}
		logger.info(path + "パッケージをクリアしました。");
	}
	

	/**
	 * 現在のソースを*.orgファイルにコピーします。
	 * @param file コピー元フォルダ。
	 * @param pat ファイル名パターン。
	 * @throws Exception 例外。
	 */
	public void copyOrgSrc(final File file, final String pat) throws Exception {
		logger.debug("file=" + file.getAbsolutePath());
		File[] list = file.listFiles();
		for (File f: list) {
			if (f.isDirectory()) {
				this.copyOrgSrc(f, pat);
			} else {
				String fname = f.getName();
				logger.debug("filename=" + fname);
				if (Pattern.matches(pat, fname)) {
					logger.debug("f=" + fname);
					String to = f.getAbsolutePath() + ".org";
					File orgfile = new File(to);
					if (!orgfile.exists()) {
						Files.copy(f, new File(to));
					}
				}
			}
		}
	}
	
	/**
	 * 現在のソースを*.orgファイルにコピーします。
	 * @throws Exception 例外。
	 */
	public void saveOrgFile() throws Exception {
		this.copyOrgSrc(new File(this.getJavaSrcPath()), "^.+\\.java$");
		this.copyOrgSrc(new File(this.getWebSrcPath()), "^.+\\.html$");
		this.copyOrgSrc(new File(this.getWebSrcPath()), "^.+\\.js$");
	}
	
	/**
	 * 指定したパス以下のソースをリセットする。
	 * @param file ソースのパス。
	 * @throws Exception 例外。
	 */
	public void resetSource(final File file) throws Exception {
		logger.debug("file=" + file.getAbsolutePath());
		File[] list = file.listFiles();
		for (File f: list) {
			if (f.isDirectory()) {
				this.resetSource(f);
			} else {
				String fname = f.getName();
				logger.debug("filename=" + fname);
				if (Pattern.matches("^.*\\.org$", fname)) {
					logger.debug("f=" + fname);
					String to = f.getAbsolutePath().replaceAll("\\.org$", "");
					Files.copy(f, new File(to));
					f.delete();
				}
			}
		}
	}
	
	/**
	 * スナップショットを保存します。
	 * @param name スナップショット名。
	 * @param javaPath 保存するパッケージ。
	 * @param path 保存するパス。
	 * @throws Exception 例外。
	 */
	private void saveSnapshot(final String name, final String javaPath, final String path) throws Exception {
		logger.debug("shapshot=" + this.snapshot);
		File webSrc = this.getProjectWebSrcDirectory(path);
		File webDst = this.getSnapshotWebSrcDirectory(name, path);
		logger.debug(webSrc + " -> " + webDst);
		FileUtils.copyDirectory(webSrc, webDst);
		
		File javaSrc = this.getProjectJavaSrcDirectory(javaPath);
		File javaDst = this.getSnapshotJavaSrcDirectory(name, javaPath);
		logger.debug(javaSrc + " -> " + javaDst);
		if (!javaDst.exists()) {
			javaDst.mkdirs();
		}
		FileUtils.copyDirectory(javaSrc, javaDst);
	}

	/**
	 * スナップショットを保存します。
	 * @param name スナップショット名。
	 * @throws Exception 例外。
	 */
	public void saveSnapshot(final String name) throws Exception {
		this.saveSnapshot(name, "/", "/");
	}
	
	/**
	 * スナップショットをロードします。
	 * @param name スナップショット名。
	 * @throws Exception 例外。
	 */
	public void loadSnapshot(final String name) throws Exception {
		logger.debug("shapshot=" + this.snapshot);
		String pkg = "/";
		File javaSrc = getProjectJavaSrcDirectory(pkg);
		if (javaSrc.exists()) {
			FileUtil.deleteDirectory(javaSrc.getAbsolutePath());
		}
		javaSrc.mkdirs();
		File javaDst = getSnapshotJavaSrcDirectory(name, pkg);
		logger.debug(javaSrc + " <- " + javaDst);
		FileUtils.copyDirectory(javaDst, javaSrc);
		
		File webSrc = getProjectWebSrcDirectory(pkg);
		if (webSrc.exists()) {
			FileUtil.deleteDirectory(webSrc.getAbsolutePath());
		}
		javaSrc.mkdirs();
		File webDst = getSnapshotWebSrcDirectory(name, pkg);
		logger.debug(webSrc + " <- " + webDst);
		FileUtils.copyDirectory(webDst, webSrc);
		Browser.sleep(this.conf.getTestApp().getBuildWait());
	}

	/**
	 * DBのエクスポートを行う。
	 * @param name スナップショット名。
	 * @param pkg パッケージリスト。
	 * @return HTTPステータス。
	 * @throws Exception 例外。
	 */
	public int exportDb(final String name, final String... pkg) throws Exception {
		String url = this.conf.getTestApp().getApplicationURL() + "test/api/BackupTableApi.api";
		String dbstore = this.conf.getProject().getSnapshot() + "/db/" + name;
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("packageList", pkg);
		p.put("snapshot", dbstore);
		logger.debug("conf=" + JsonUtil.encode(p, true));
		WebClient client = new WebClient(url, WebClient.METHOD_POST);
		@SuppressWarnings("unchecked")
		Map<String, Object> resp = (Map<String, Object>) client.call(p);
		logger.info("status=" + client.getHttpStatus());
		logger.info("resp=" + resp);
		return client.getHttpStatus();
	}
	
	/**
	 * DBのインポートを行う。
	 * @param name スナップショット名。
	 * @param pkg パッケージリスト。
	 * @return HTTPステータス。
	 * @throws Exception 例外。
	 */
	public int importDb(final String name, final String... pkg) throws Exception {
		String url = this.conf.getTestApp().getApplicationURL() + "test/api/RestoreTableApi.api";
		String dbstore = this.conf.getProject().getSnapshot() + "/db/" + name;
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("packageList", pkg);
		p.put("snapshot", dbstore);
		logger.debug("conf=" + JsonUtil.encode(p, true));
		WebClient client = new WebClient(url, WebClient.METHOD_POST);
		@SuppressWarnings("unchecked")
		Map<String, Object> resp = (Map<String, Object>) client.call(p);
		logger.info("status=" + client.getHttpStatus());
		logger.info("resp=" + resp);
		return client.getHttpStatus();
	}
	
	/**
	 * プロジェクトのJavaのソースディレクトリを取得します。
	 * @param pkg パッケージ。
	 * @return プロジェクトのJavaのソースディレクトリ。
	 */
	public File getProjectJavaSrcDirectory(final String pkg) {
		File javaSrc = new File(this.path.replaceAll("\\\\", "/") + WebAppProject.JAVA_SRC + pkg);
		return javaSrc;
	}

	/**
	 * スナップショットのJavaソースディレクトリを取得します。
	 * @param name スナップショット名称。
	 * @param pkg パッケージ。
	 * @return スナップショットのJavaソースディレクトリ。
	 */
	public File getSnapshotJavaSrcDirectory(final String name, final String pkg) {
		File javaDst = new File(this.snapshot.replaceAll("\\\\", "/") + "/src/" + name + WebAppProject.JAVA_SRC + pkg);
		return javaDst;
	}

	/**
	 * プロジェクトのWebソースディレクトリを取得します。
	 * @param pkg パッケージ。
	 * @return プロジェクトのWebソースディレクトリ。
	 */
	public File getProjectWebSrcDirectory(final String pkg) {
		File webSrc = new File(this.path.replaceAll("\\\\", "/") + WebAppProject.WEB_SRC + "/" + pkg);
		return webSrc;
	}

	/**
	 * スナップショットのWebソースディレクトリを取得します。
	 * @param name スナップショット名。
	 * @param pkg パッケージ。
	 * @return スナップショットのWebソースディレクトリ。
	 */
	public File getSnapshotWebSrcDirectory(final String name, final String pkg) {
		File webDst = new File(this.snapshot.replaceAll("\\\\", "/") + "/src/" + name + WebAppProject.WEB_SRC + "/" + pkg);
		return webDst;
	}


	/**
	 * WebAppProjectのインスタンスを取得します。
	 * @param conf プロジェクト設定ファイル。
	 * @return WebAppProjectのインスタンス。
	 */
	public static WebAppProject newWebAppProject(final jp.dataforms.test.tester.PageTester.Conf conf) {
		Project projectConf = conf.getProject();
		WebAppProject prj = new WebAppProject(projectConf.getProjectPath(), conf.getTestApp().getApplicationURL());
		prj.conf = conf;
		prj.setTestSrc(projectConf.getTestSrc());
		prj.setTomcatConfigPath(projectConf.getTomcatConfigPath());
		prj.setSnapshot(projectConf.getSnapshot());
		return prj;
	}
	
	/**
	 * ソースファイルをリセットする。
	 * @throws Exception 例外。
	 */
/*	public void resetSource() throws Exception {
		logger.debug("this.path=" + this.path);
		this.resetSource(new File(this.getJavaSrcPath()));
		this.resetSource(new File(this.getWebSrcPath()));
		new File(this.path + "/src/main/webapp/sample/page/SampleEditForm.js").delete();
		new File(this.path + "/src/main/webapp/sample/page/SamplePage.properties").delete();
	}
	*/

}
