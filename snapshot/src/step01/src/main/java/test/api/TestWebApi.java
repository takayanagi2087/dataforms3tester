package test.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.dataforms.fw.controller.WebApi;
import jp.dataforms.fw.devtool.db.dao.TableManagerDao;
import jp.dataforms.fw.util.JsonUtil;

/**
 * テスト用のAPI。
 */
public abstract class TestWebApi extends WebApi {

	/**
	 * Logger.
	 */
	private static Logger logger = LogManager.getLogger(TestWebApi.class);

	/**
	 * テーブルリストを取得します。
	 * @param dao DAO。
	 * @param tlist テーブルリスト。
	 * @return テーブルリスト。
	 */
	protected List<String> getTableList(final TableManagerDao dao, final List<String> tlist) throws Exception {
		List<String> ret = new ArrayList<String>();
		List<Map<String, Object>> tbllist = new ArrayList<Map<String, Object>>();
		for (String pkg: tlist) {
			tbllist.addAll(dao.queryTableClass(pkg, ""));
		}
		for (Map<String, Object> m: tbllist) {
			String className = (String) m.get("className");
			ret.add(className);
		}
		String json = JsonUtil.encode(ret, true);
		logger.debug("json=" + json);
		return ret;
	}
	
	
	@Override
	public boolean isAuthenticated(Map<String, Object> params) throws Exception {
		String rhost = this.getRequest().getRemoteAddr();
		logger.debug(() -> "rhost=" + rhost);
		if ("0:0:0:0:0:0:0:1".equals(rhost) || "127.0.0.1".equals(rhost)) {
			return true;
		} else {
			return false;
		}
	}
}
