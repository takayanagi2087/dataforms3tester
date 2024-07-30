package jp.dataforms.sample.edittable.page;

import java.util.Map;

import jp.dataforms.fw.controller.EditForm;
import jp.dataforms.fw.dao.Table;
import jp.dataforms.fw.field.base.Field.Display;
import jp.dataforms.fw.validator.RequiredValidator;
import jp.dataforms.sample.edittable.dao.SampleDao;

/**
 * サンプルテーブル編集用編集フォームクラス。
 */
public class SampleEditForm extends EditForm {
	/**
	 * コンストラクタ。
	 */
	public SampleEditForm() {
		SampleDao dao = new SampleDao();
		// 各フィールドの設定処理。
		dao.getSampleTable().getSampleIdField().setEditFormDisplay(Display.INPUT_HIDDEN);
		dao.getSampleTable().getSampleTextField().setEditFormDisplay(Display.INPUT).addValidator(new RequiredValidator());
		dao.getSampleTable().getSampleNumericField().setEditFormDisplay(Display.INPUT);
		dao.getSampleTable().getSampleDateField().setEditFormDisplay(Display.INPUT);
		dao.getSampleTable().getCreateUserIdField().setEditFormDisplay(Display.INPUT_HIDDEN);
		dao.getSampleTable().getCreateTimestampField().setEditFormDisplay(Display.INPUT_HIDDEN);
		dao.getSampleTable().getUpdateUserIdField().setEditFormDisplay(Display.INPUT_HIDDEN);
		dao.getSampleTable().getUpdateTimestampField().setEditFormDisplay(Display.INPUT_HIDDEN);
		// このメソッドでdaoに設定された編集対象取得問合せのフィールドをフォームに展開します。
		// 複数レコード問合せを指定した場合、そのフィールドを持つHtmlTableフォームに配置します。
		this.addFields(dao);
	}

	/**
	 * フォームの初期化を行います。
	 * <pre>
	 * DBを使用した初期化処理はここに記述します。
	 * </pre>
	 */
	@Override
	public void init() throws Exception {
		super.init();
		// フィールドに初期値を設定する場合は以下の様にしてください。
		// this.setFormData("fieldId", "初期値");
	}

	/**
	 * 編集対象のデータを取得します。
	 * <pre>
	 * 問い合わせ結果フォームに表示されたデータを選択した際に呼び出されます。
	 * dataには最低編集対象レコードのPKのマップが入ってきます。
	 * </pre>
	 * @param data 取得するデータのPKの値が入ってきます。
	 * @return 編集対象データ。
	 */
	@Override
	protected Map<String, Object> queryData(final Map<String, Object> data) throws Exception {
		SampleDao dao = new SampleDao(this);
		return dao.query(data);
	}

	/**
	 * 参照登録対象対象のデータを取得します。
	 * <pre>
	 * queryDataから取得したデータから、PK項目を削除します。
	 * </pre>
	 * @param data 取得するデータのPKの値が入ってきます。
	 * @return 編集対象データ。
	 */
	@Override
	protected Map<String, Object> queryReferData(final Map<String, Object> data) throws Exception {
		Map<String, Object> ret = this.queryData(data);
		SampleDao dao = new SampleDao(this);
		removeKeyData(dao, ret);
		return ret;
	}

	/**
	 * ポストされたデータが更新するのか新規追加するのかを判定します。
	 * <pre>
	 * 編集対象データにPKの入力があった場合、更新すべきと判断します。
	 * </pre>
	 * @param data 入力データ。
	 * @return 更新対象データの場合true。
	 */
	@Override
	protected boolean isUpdate(final Map<String, Object> data) throws Exception {
		SampleDao dao = new SampleDao(this);
		Table table = dao.getMainTable();
		boolean ret = this.isUpdate(table, data);
		return ret;
	}

	/**
	 * データを新規追加します。
	 * @param data ポストされたデータ。
	 */
	@Override
	protected void insertData(final Map<String, Object> data) throws Exception {
		SampleDao dao = new SampleDao(this);
		this.setUserInfo(data); // 更新を行うユーザIDを設定する.
		dao.insert(data);
	}

	/**
	 * データを更新します。
	 * @param data ポストされたデータ。
	 */
	@Override
	protected void updateData(final Map<String, Object> data) throws Exception {
		SampleDao dao = new SampleDao(this);
		this.setUserInfo(data); // 更新を行うユーザIDを設定する.
		dao.update(data);
	}

	/**
	 * データを削除します。
	 * @param data ポストされたデータ。
	 */
	@Override
	public void deleteData(final Map<String, Object> data) throws Exception {
		SampleDao dao = new SampleDao(this);
		this.setUserInfo(data); // 更新を行うユーザIDを設定する.
		dao.delete(data);
	}

	// フォームの各フィールドの関連チェックを行う場合は、以下のvalidateFormメソッドを実装してください。
	/**
	 * フォームのデータをチェックします。
	 * @param p パラメータ。
	 * @return 判定結果リスト。
	 * @throws Exception 例外。
	 */
/*
	@Override
	protected List<ValidationError> validateForm(final Map<String, Object> data) throws Exception {
		List<ValidationError> list = super.validateForm(data);
		if (list.size() == 0) {
			if ( エラー判定 ) {
				list.add(new ValidationError(HogeTable.Entity.ID_FIELD_ID, MessagesUtil.getMessage(this.getPage(), "error.messagekey")));
			}
		}
		return list;
	}
*/


	// 独自のWebメソッドを作成する場合は、以下のコードを参考にしてください。
	/**
	 * Webメソッドのサンプル。
	 * @param p パラメータ。
	 * @return 応答情報。
	 * @throws Exception 例外。
	 */
/*
	@WebMethod
	public Response webMethod(final Map<String, Object> p) throws Exception {
		Response ret = null;
		// Formから送信されたデータを確認します。
		List<ValidationError> list = this.validate(p);
		if (list.size() == 0) {
			// Formから送信されたデータをサーバーサイドで処理しやすいデータ型に変換します。
			Map<String, Object> data = this.convertToServerData(p);
			ret = new JsonResponse(JsonResponse.SUCCESS, data);	// TODO:何らかの処理を行いResponseのインスタンスを作成してください。
		} else {
			// 確認で問題があった場合その情報を返信します。
			ret = new JsonResponse(JsonResponse.INVALID, list);
		}
		return ret;
	}
*/

}
