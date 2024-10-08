package jp.dataforms.sample.edittable.page;

import jp.dataforms.fw.app.base.page.GuestPage;
import jp.dataforms.fw.dao.Dao;
import jp.dataforms.sample.edittable.dao.SampleDao;

/**
 * ページクラス。
 */
public class SamplePage extends GuestPage {
	/**
	 * コンストラクタ。
	 */
	public SamplePage() {
		this.addForm(new SampleQueryForm());
		this.addForm(new SampleQueryResultForm());
		this.addForm(new SampleEditForm());

	}

	/**
	 * Pageが配置されるパスを返します。
	 *
	 * @return Pageが配置されるパス。
	 */
	public String getFunctionPath() {
		return "/sample";
	}

	/**
	 * テーブルを操作するためのDaoクラスを取得します。
	 * <pre>
	 * ページjavaクラス作成用のメソッドです。
	 * </pre>
	 * @return Daoクラス。
	 */
	public Class<? extends Dao> getDaoClass() {
		return SampleDao.class;
	}


	// 独自のWebメソッドを作成する場合は、以下のコードを参考にしてください。
	/**
	 * Webメソッドのサンプル。
	 *
	 * @param p パラメータ。
	 * @return 処理結果。
	 * @throws Exception 例外。
	 */
/*
	@WebMethod
	public Response webMethod(final Map<String, Object> p) throws Exception {
		// TODO:何らかの処理を行い、応答情報を作成します。
		Object obj = p; // 作成したオブジェクト
		Response ret = new JsonResponse(JsonResponse.SUCCESS, obj);
		return ret;
	}
*/

}
