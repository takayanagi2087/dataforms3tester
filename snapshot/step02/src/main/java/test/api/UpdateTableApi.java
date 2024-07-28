package test.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.dataforms.fw.annotation.WebMethod;
import jp.dataforms.fw.dao.Dao;
import jp.dataforms.fw.dao.JDBCConnectableObject;
import jp.dataforms.fw.response.JsonResponse;
import jp.dataforms.fw.response.Response;

/**
 * 更新系SQL実行API。
 *
 */
public class UpdateTableApi extends TestWebApi {
	/**
	 * Logger.
	 */
	private static Logger logger = LogManager.getLogger(DropTableApi.class);

	/**
	 * テーブル削除Dao。
	 */
	private static class DropTableDao extends Dao {
		/**
		 * コンストラクタ。
		 * @param obj JDBC接続可能オブジェクト。
		 * @throws Exception 例外。
		 */
		public DropTableDao(final JDBCConnectableObject obj) throws Exception {
			super(obj);
		}

		/**
		 * テーブル更新SQLを実行します。。
		 * @param sql SQL。
		 * @throws Exception 例外。
		 */
		public void execute(final String sql) throws Exception {
			logger.debug("sql=" + sql);
			this.executeUpdate(sql, new HashMap<String, Object>());
		}
	}

	@WebMethod
	@Override
	public Response exec(Map<String, Object> p) throws Exception {
		logger.debug("start");
		@SuppressWarnings("unchecked")
		List<String> sqlList = (List<String>) p.get("sqlList");
		try {
			DropTableDao dao = new DropTableDao(this);
			for (String sql: sqlList) {
				logger.debug("sql=" + sql);
				dao.execute(sql);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("finish");
		return new JsonResponse(JsonResponse.SUCCESS, "0");
	}

}
