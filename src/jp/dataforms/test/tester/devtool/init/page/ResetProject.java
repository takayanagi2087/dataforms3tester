package jp.dataforms.test.tester.devtool.init.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.dataforms.test.proj.WebAppProject;
import jp.dataforms.test.tester.PageTester;

/**
 * プロジェクトのリセット。
 */
public class ResetProject extends PageTester {
	/**
	 * Logger.
	 */
	private static Logger logger = LogManager.getLogger(ResetProject.class);
	
	
	/**
	 * コンストラクタ。
	 */
	public ResetProject() {
		super(null);
	}
	
	/**
	 * 処理の実行。
	 * @throws Exception 例外。
	 */
	public void exec() throws Exception {
		WebAppProject prj = WebAppProject.newWebAppProject(this.getConf());
		if (!prj.isValid()) {
			logger.error(prj.getPath() + " はWebアプリケーションプロジェクトのパスではありません。");
		}
		prj.resetProject();
		logger.info("Tomcatを起動して、他のテストを実行してください。");
	}
}
