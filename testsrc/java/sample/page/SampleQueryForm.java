package sample.page;

import dataforms.controller.QueryForm;
import dataforms.field.base.Field.MatchType;
import sample.field.SampleDateField;
import java.util.List;
import dataforms.field.base.FieldList;
import sample.field.SampleTextField;
import sample.field.SampleNumericField;
import java.util.Map;
import sample.dao.SampleTable;
import dataforms.report.ExportDataFile;

import sample.dao.SampleDao;


/**
 * 問い合わせフォームクラス。
 */
public class SampleQueryForm extends QueryForm {
	/**
	 * コンストラクタ。
	 */
	public SampleQueryForm() {
		this.addField(new SampleTextField(SampleTable.Entity.ID_SAMPLE_TEXT)).setMatchType(MatchType.PART).setComment("文字列");
		this.addField(new SampleNumericField(SampleTable.Entity.ID_SAMPLE_NUMERIC + "From")).setMatchType(MatchType.RANGE_FROM).setComment("数字(from)");
		this.addField(new SampleNumericField(SampleTable.Entity.ID_SAMPLE_NUMERIC + "To")).setMatchType(MatchType.RANGE_TO).setComment("数字(to)");
		this.addField(new SampleDateField(SampleTable.Entity.ID_SAMPLE_DATE + "From")).setMatchType(MatchType.RANGE_FROM).setComment("日付(from)");
		this.addField(new SampleDateField(SampleTable.Entity.ID_SAMPLE_DATE + "To")).setMatchType(MatchType.RANGE_TO).setComment("日付(to)");

	}

	@Override
	public void init() throws Exception {
		super.init();
		// フィールドに初期値を設定する場合は以下の様にしてください。
		// this.setFormData("fieldId", "初期値");
	}

	/**
	 * エクスポートデータのフィールドリストを作成します。
	 * @return フィールドリスト。
	 */
	@Override
	protected FieldList getExportDataFieldList(final Map<String, Object> data) throws Exception {
		SampleDao dao = new SampleDao(this);
		return dao.getListQuery().getFieldList();
	}

	/**
	 * エクスポートデータファイルのインスタンスを返します。
	 * @return エクスポートデータファイルのインスタンス。
	 */
	@Override
	protected ExportDataFile getExportDataFile() {
		ExportDataFile file = super.getExportDataFile();
		file.setFileName("export.xlsx");
		return file;
	}

	/**
	 * エクスポートするデータを返します。
	 * @param data 条件データ。
	 * @return エクスポートデータ。
	 */
	@Override
	protected List<Map<String, Object>> queryExportData(final Map<String, Object> data) throws Exception {
		SampleDao dao = new SampleDao(this);
		return dao.query(data, this.getFieldList());
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
