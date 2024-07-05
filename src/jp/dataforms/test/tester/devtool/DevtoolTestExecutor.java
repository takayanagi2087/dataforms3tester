package jp.dataforms.test.tester.devtool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.dataforms.fw.controller.Page;
import jp.dataforms.fw.util.FileUtil;
import jp.dataforms.fw.util.JsonUtil;
import jp.dataforms.test.tester.PageTester;
import lombok.Data;
import lombok.Getter;

/**
 * 開発ツールのテスト実行ツール。
 */
public class DevtoolTestExecutor extends PageTester {
	
	/**
	 * Logger.
	 */
	private static Logger logger = LogManager.getLogger(DevtoolTestExecutor.class);
	
	/**
	 * プロジェクト。
	 */
	@Data
	public static class Project {
		/**
		 * Eclipseプロジェクトのパス。
		 */
		private String applicationURL = null;
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
		
		/**
		 * 設定ファイルを読み込みます。
		 * @param confFile 設定ファイル。
		 * @return プロジェクト設定情報。
		 * @throws Exception 例外。
		 */
		public static Project read(final String confFile) throws Exception {
			logger.info("projectConfFile=" + confFile);
			String json = FileUtil.readTextFile(confFile, "utf-8");
			logger.debug("project conf=" + json);
			return (Project) JsonUtil.decode(json, Project.class);
		}
	}

	/**
	 * プロジェクト設定ファイルのパス。
	 */
	private String projectConf = null;
	
	
	/**
	 * 対象プロジェクトの情報。
	 */
	@Getter
	private Project project = null;
	
	
	/**
	 * コンストラクタ。
	 */
	public DevtoolTestExecutor() {
		super(Page.class);
		
	}
	
	
	@Override
	public void exec() throws Exception {
		this.project = Project.read(this.projectConf);
	}
	

}
