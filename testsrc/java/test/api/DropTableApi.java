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
 * テーブル削除API。
 *
 */
public class DropTableApi extends TestWebApi {
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
		 * テーブルを削除します。
		 * @param table テーブル。
		 * @throws Exception 例外。
		 */
		public void dropTable(final String table) throws Exception {
			String sql = "drop table " + table;
			logger.debug("sql=" + sql);
			this.executeUpdate(sql, new HashMap<String, Object>());
		}
	}

	@WebMethod
	@Override
	public Response exec(Map<String, Object> p) throws Exception {
		logger.debug("start");
		@SuppressWarnings("unchecked")
		List<String> tlist = (List<String>) p.get("tableList");
		try {
			DropTableDao dao = new DropTableDao(this);
			for (String t: tlist) {
				logger.debug("t=" + t);
				dao.dropTable(t);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("finish");
		return new JsonResponse(JsonResponse.SUCCESS, "0");
	}

}
