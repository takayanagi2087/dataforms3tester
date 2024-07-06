package jp.dataforms.test.testitem.devtool.init.page.save;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.dataforms.test.annotation.TestItemInfo;
import jp.dataforms.test.element.devtool.init.page.InitDevelopmentToolFormTestElement;
import jp.dataforms.test.element.devtool.init.page.InitDevelopmentToolPageTestElement;
import jp.dataforms.test.selenium.Browser;
import jp.dataforms.test.tester.PageTester.Conf;
import jp.dataforms.test.testitem.TestItem;
import jp.dataforms.test.testitem.devtool.init.page.InitTestItem;

/**
 * プロジェクト初期化ページの確認ボタンテスト。
 */
@TestItemInfo(group = "init", seq = "001")
public class InitalDispTestItem extends InitTestItem {
	/**
	 * Logger.
	 */
	private static Logger logger = LogManager.getLogger(InitalDispTestItem.class);

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
	public InitalDispTestItem() {
		super(CONDITION, EXPECTED);
	}
	
	
	@Override
	protected ResultType test(Browser browser) throws Exception {
		InitDevelopmentToolPageTestElement p = this.getInitDevelopmentToolPageTestElement(browser);
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
		return ret;
	}

}
