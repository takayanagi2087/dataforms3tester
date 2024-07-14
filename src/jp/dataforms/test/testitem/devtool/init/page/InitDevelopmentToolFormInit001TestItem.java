package jp.dataforms.test.testitem.devtool.init.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.dataforms.test.annotation.TestItemInfo;
import jp.dataforms.test.annotation.TestItemInfo.Type;
import jp.dataforms.test.element.devtool.init.page.InitDevelopmentToolFormTestElement;
import jp.dataforms.test.element.devtool.init.page.InitDevelopmentToolPageTestElement;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.tester.PageTester.Conf;
import jp.dataforms.test.testitem.TestItem;

/**
 * プロジェクト初期化ページの確認ボタンテスト。
 */
@TestItemInfo(
	group = "init",			// テスト項目を分類する文字列を指定します。
	seq = "001",			// テストの実行順を指定します。
	type = Type.NORMAL, 	// Type.NORMAL or Type.ERROR or Type.BOUNDARY
	regression = true		// 回帰テストで使用する項目の場合trueを指定します。
)
public class InitDevelopmentToolFormInit001TestItem extends InitDevelopmentToolFormTestItem {
	/**
	 * Logger.
	 */
	private static Logger logger = LogManager.getLogger(InitDevelopmentToolFormInit001TestItem.class);

	/**
	 * テスト条件。
	 */
	private static final String CONDITION = """
		空のWEBアプリケーションプロジェクトをブラウザからアクセスする。
		""";

	/**
	 * 期待値。
	 */
	private static final String EXPECTED = """
		プロジェクト初期化ページが表示されること。
		""";

	/**
	 * コンストラクタ。
	 */
	public InitDevelopmentToolFormInit001TestItem() {
		super(CONDITION, EXPECTED);
	}
	
	
	@Override
	protected ResultType test(Browser browser) throws Exception {
		InitDevelopmentToolPageTestElement p = browser.getPageTestElement(InitDevelopmentToolPageTestElement.class);
		InitDevelopmentToolFormTestElement f = p.getInitDevelopmentToolForm();
		String projectPath = f.getProjectPath().getValue();
		String javaSrcPath = f.getJavaSrcPath().getValue();
		String webSrcPath = f.getWebSrcPath().getValue();
		String jndiPrefix = f.getJndiPrefix().getValue();
		String dataSource = f.getDataSource().getValue();
		String dbPath = f.getDerbyDbPath().getValue();
		logger.debug("projectPath=" + projectPath);
		logger.debug("javaSrcPath=" + javaSrcPath);
		logger.debug("webSrcPath=" + webSrcPath);
		logger.debug("jndiPrefix=" + jndiPrefix);
		logger.debug("dataSource=" + dataSource);
		logger.debug("dbPath=" + dbPath);

		ResultType ret = ResultType.SYSTEM_OK;
		Conf conf = TestItem.getConf();
		if (!conf.getProject().getProjectPath().equals(projectPath)) {
			ret = ResultType.SYSTEM_NG;
		}
		String javapath = conf.getProject().getProjectPath() + "/src/main/java";
		if (!javapath.equals(javaSrcPath)) {
			ret = ResultType.SYSTEM_NG;
		}
		String webpath = conf.getProject().getProjectPath() + "/src/main/webapp";
		if (!webpath.equals(webSrcPath)) {
			ret = ResultType.SYSTEM_NG;
		}
		if (!"java:/comp/env/".equals(jndiPrefix)) {
			ret = ResultType.SYSTEM_NG;
		}
		String[] sp = projectPath.split("/");
		String context = sp[sp.length - 1];
		if (!("jdbc/" + context).equals(dataSource)) {
			ret = ResultType.SYSTEM_NG;
		}
		String dbpath = conf.getProject().getProjectPath() + "/javadb";
		if (!dbpath.equals(dbPath)) {
			ret = ResultType.SYSTEM_NG;
		}
		this.saveScreenShot(browser);
		return ret;
	}

}
