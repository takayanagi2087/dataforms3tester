package jp.dataforms.sample.edittable.dao;

import jp.dataforms.fw.dao.JDBCConnectableObject;
import jp.dataforms.fw.dao.QuerySetDao;


/**
 * サンプルテーブル編集用DAOクラスです。
 *
 */
public class SampleDao extends QuerySetDao {
	/**
	 * サンプルテーブル。
	 */
	private SampleTable sampleTable = null;

	/**
	 * サンプルテーブルを取得します。
	 * @return サンプルテーブル。
	 */
	public SampleTable getSampleTable() {
		return this.sampleTable;
	}


	/**
	 * コンストラクタ。
	 * @throws Exception 例外。
	 */
	public SampleDao() {
		this.setComment("サンプルテーブル編集用DAOクラス");
		this.setListQuery(this.sampleTable = new SampleTable());
		this.setSingleRecordQuery(this.sampleTable);

	}

	/**
	 * コンストラクタ。
	 * @param cobj JDBC接続可能Object。
	 * @throws Exception 例外。
	 */
	public SampleDao(final JDBCConnectableObject cobj) throws Exception {
		this();
		this.init(cobj);
	}

	/**
	 * 主テーブルを取得します。
	 * @return 主テーブル。
	 */
	public SampleTable getMainTable() {
		if (this.getSingleRecordQuery() != null) {
			return (SampleTable) this.getSingleRecordQuery().getMainTable();
		} else {
			if (this.getMultiRecordQueryList() != null) {
				return (SampleTable) this.getMultiRecordQueryList().get(0).getMainTable();
			}
		}
		return null;
	}

	//
	// 追加、更新、削除処理を改造する場合は以下のメソッドをオーバーライドしてください。
	// QuerySetDaoクラスではsingleRecordQuery,multiRecordQueryListに登録された各問合せ
	// のmainTableのみ操作するようになっています。
	//
	/**
	 * テーブル群を追加します。
	 * @param data データ。
	 * @throws Exception 例外。
	 */
/*
	@Override
	public void insert(final Map<String, Object> data) throws Exception {
		super.insert(data);
	}
*/

	/**
	 * テーブル群を更新します。
	 * @param data 更新データ。
	 * @throws Exception 例外。
	 */
/*
	@Override
	public void update(final Map<String, Object> data) throws Exception {
		super.update(data);
	}
*/

	/**
	 * データを削除します。
	 * @param data データ。
	 * @throws Exception 例外。
	 */
/*
	@Override
	public void delete(final Map<String, Object> data) throws Exception {
		super.delete(data);
	}
*/

}
