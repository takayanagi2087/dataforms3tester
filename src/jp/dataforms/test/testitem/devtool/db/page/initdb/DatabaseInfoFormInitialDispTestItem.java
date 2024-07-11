package jp.dataforms.test.testitem.devtool.db.page.initdb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.dataforms.fw.dao.sqlgen.derby.DerbySqlGenerator;
import jp.dataforms.fw.dao.sqlgen.mssql.MssqlSqlGenerator;
import jp.dataforms.fw.dao.sqlgen.mysql.MariaDbSqlGenerator;
import jp.dataforms.fw.dao.sqlgen.mysql.MysqlSqlGenerator;
import jp.dataforms.fw.dao.sqlgen.oracle.OracleSqlGenerator;
import jp.dataforms.fw.dao.sqlgen.pgsql.PgsqlSqlGenerator;
import jp.dataforms.test.annotation.TestItemInfo;
import jp.dataforms.test.annotation.TestItemInfo.Type;
import jp.dataforms.test.element.devtool.db.page.DatabaseInfoFormTestElement;
import jp.dataforms.test.element.devtool.db.page.InitializeDatabasePageTestElement;
import jp.dataforms.test.selenium.Browser;


/**
 * DatabaseInfoFormのテスト項目。
 */
@TestItemInfo(
	// テスト項目の情報を記述します。
	group = "disp", 		// テスト項目を分類する文字列を指定します。
	seq = "001",			// テストの実行順を指定します。 
	type = Type.NORMAL, 	// Type.NORMAL or Type.ERROR or Type.BOUNDARY
	regression = false		// 回帰テストで使用する項目の場合trueを指定します。
)
public class DatabaseInfoFormInitialDispTestItem extends DatabaseInfoFormTestItem {
	
	/**
	 * Logger.
	 */
	private Logger logger = LogManager.getLogger(DatabaseInfoFormInitialDispTestItem.class);
	
	/**
	 * テスト条件。
	 */
	private static final String CONDITION = """
		データベースの初期化ページを表示する。
		""";

	/**
	 * 期待値。
	 */
	private static final String EXPECTED = """
		データベース製品名と接続URLが表示されること。
		""";

	/**
	 * コンストラクタ。
	 */
	public DatabaseInfoFormInitialDispTestItem() {
		super(CONDITION, EXPECTED);
	}
	
	@Override
	protected ResultType test(Browser browser) throws Exception {
		InitializeDatabasePageTestElement p = browser.getPageTestElement(InitializeDatabasePageTestElement.class);
		DatabaseInfoFormTestElement f = p.getDatabaseInfoForm();
		String dbServerName = f.getDbServerName().getText();
		String dbServerURL = f.getDbServerURL().getText();
		logger.debug("dbServerName=" + dbServerName + ", dbServerURL=" + dbServerURL);
		ResultType ret = ResultType.SYSTEM_NG;
		if (DerbySqlGenerator.DATABASE_PRODUCT_NAME.equals(dbServerName)) {
			if (dbServerURL.indexOf("jdbc:derby:") == 0) {
				ret = ResultType.SYSTEM_OK;
			}
		} else if (PgsqlSqlGenerator.DATABASE_PRODUCT_NAME.equals(dbServerName)) {
			if (dbServerURL.indexOf("jdbc:postgresql://") == 0) {
				ret = ResultType.SYSTEM_OK;
			}
		} else if (MariaDbSqlGenerator.DATABASE_PRODUCT_NAME.equals(dbServerName)) {
			if (dbServerURL.indexOf("jdbc:mariadb://") == 0) {
				ret = ResultType.SYSTEM_OK;
			}
		} else if (MysqlSqlGenerator.DATABASE_PRODUCT_NAME.equals(dbServerName)) {
			if (dbServerURL.indexOf("jdbc:mysql://") == 0) {
				ret = ResultType.SYSTEM_OK;
			}
		} else if (OracleSqlGenerator.DATABASE_PRODUCT_NAME.equals(dbServerName)) {
			if (dbServerURL.indexOf("jdbc:oracle:") == 0) {
				ret = ResultType.SYSTEM_OK;
			}
		} else if (MssqlSqlGenerator.DATABASE_PRODUCT_NAME.equals(dbServerName)) {
			if (dbServerURL.indexOf("jdbc:sqlserver://") == 0) {
				ret = ResultType.SYSTEM_OK;
			}
		}
		Browser.sleep(2);
		this.saveScreenShot(browser);
		return ret;
	}

}
