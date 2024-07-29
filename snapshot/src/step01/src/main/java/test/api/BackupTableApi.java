package test.api;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.dataforms.fw.annotation.WebMethod;
import jp.dataforms.fw.devtool.db.dao.TableManagerDao;
import jp.dataforms.fw.response.JsonResponse;
import jp.dataforms.fw.response.Response;
import jp.dataforms.fw.util.JsonUtil;

/**
 * バックアップAPI。
 *
 */
public class BackupTableApi extends TestWebApi {
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
		logger.debug("p=" + JsonUtil.encode(p, true));
		try {
			TableManagerDao dao = new TableManagerDao(this);
			List<String> list = this.getTableList(dao, pkglist);
			for (String className: list) {
				logger.debug("classname=" + className);
				dao.exportData(className, snapshot);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("finish");
		return new JsonResponse(JsonResponse.SUCCESS, "0");
	}

}
