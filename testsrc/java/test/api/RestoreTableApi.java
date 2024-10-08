package test.api;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.dataforms.fw.annotation.WebMethod;
import jp.dataforms.fw.devtool.db.dao.TableManagerDao;
import jp.dataforms.fw.response.JsonResponse;
import jp.dataforms.fw.response.Response;

/**
 * リストアAPI。
 *
 */
public class RestoreTableApi extends TestWebApi {
	/**
	 * Logger.
	 */
	private static Logger logger = LogManager.getLogger(BackupTableApi.class);

	@WebMethod
	@Override
	public Response exec(Map<String, Object> p) throws Exception {
		logger.debug("start");
		@SuppressWarnings("unchecked")
		List<String> pkglist = (List<String>) p.get("packageList");
		String snapshot = (String) p.get("snapshot");
		logger.debug("snapshot=" + snapshot);
		try {
			TableManagerDao dao = new TableManagerDao(this);
			dao.dropAllForeignKeys();
			List<String> list = this.getTableList(dao, pkglist);
			for (String className: list) {
				logger.debug("classname=" + className);
				dao.deleteTableData(className);
				dao.importData(className, snapshot);
			}
			dao.createAllForeignKeys();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("finish");
		return new JsonResponse(JsonResponse.SUCCESS, "0");
	}

}
