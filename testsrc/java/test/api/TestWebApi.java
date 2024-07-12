package test.api;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.dataforms.fw.controller.WebApi;

/**
 * テスト用のAPI。
 */
public abstract class TestWebApi extends WebApi {

	/**
	 * Logger.
	 */
	private static Logger logger = LogManager.getLogger(TestWebApi.class);

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
