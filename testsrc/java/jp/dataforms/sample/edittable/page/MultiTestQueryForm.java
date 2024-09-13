package jp.dataforms.sample.edittable.page;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.dataforms.exeltoxslfo.ExcelToXSLFO;
import jp.dataforms.fw.annotation.WebMethod;
import jp.dataforms.fw.controller.QueryForm;
import jp.dataforms.fw.dao.Dao;
import jp.dataforms.fw.dao.SingleTableQuery;
import jp.dataforms.fw.field.base.Field.MatchType;
import jp.dataforms.fw.field.base.FieldList;
import jp.dataforms.fw.report.ExportDataFile;
import jp.dataforms.fw.response.BinaryResponse;
import jp.dataforms.fw.response.JsonResponse;
import jp.dataforms.fw.response.Response;
import jp.dataforms.fw.validator.ValidationError;
import jp.dataforms.sample.edittable.dao.MultiTestDao;
import jp.dataforms.sample.edittable.dao.MultiTestTable;
import jp.dataforms.sample.edittable.report.MultiExcelReport;
import jp.dataforms.sample.edittable.report.MultiPdfReport;
import sample.field.Code1Field;


/**
 * 複数レコード編集ページ用問合せフォームクラス。
 */
public class MultiTestQueryForm extends QueryForm {
	/**
	 * コンストラクタ。
	 */
	public MultiTestQueryForm() {
		this.addField(new Code1Field(MultiTestTable.Entity.ID_CODE1)).setMatchType(MatchType.PART).setComment("コード1");

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
		MultiTestDao dao = new MultiTestDao(this);
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
		MultiTestDao dao = new MultiTestDao(this);
		return dao.query(data, this.getFieldList());
	}

	
	/**
	 * 印刷処理。
	 * @param p パラメータ。
	 * @return 応答情報。
	 * @throws Exception 例外。
	 */
	@WebMethod
	public Response print(final Map<String, Object> p) throws Exception {
		Response ret = null;
		// Formから送信されたデータを確認します。
		List<ValidationError> list = this.validate(p);
		if (list.size() == 0) {
			// MultiTestTableを取得するQueryを作成
			MultiTestTable table = new MultiTestTable();
			SingleTableQuery query = new SingleTableQuery(table);
			// ソート順をcode1, code2の設定。
			query.setOrderByFieldList(new FieldList(table.getCode1Field(), table.getCode2Field()));
			// 問合せの実行
			Dao dao = new Dao(this);
			List<Map<String, Object>> mlist = dao.executeQuery(query);
			// 印刷用データマップの作製
			Map<String, Object> data = new HashMap<String, Object>();
			data.put(MultiExcelReport.ID_LIST, mlist);
			// テンプレートファイルパスを取得
			String template = SampleEditForm.getServlet().getServletContext().getRealPath("/exceltemplate/multi.xlsx");
			// レポートのクラスを作成。
			MultiExcelReport rep = new MultiExcelReport(template);
			// Excelファイルを応答する。
			BinaryResponse bresp = new BinaryResponse(rep.print(data));
			bresp.setFileName("sample.xlsx");
			return bresp;
		} else {
			// 確認で問題があった場合その情報を返信します。
			ret = new JsonResponse(JsonResponse.INVALID, list);
		}
		return ret;
	}
	
	/**
	 * PDFの出力処理。
	 * @param p パラメータ。
	 * @return 応答情報。
	 * @throws Exception 例外。
	 */
	@WebMethod
	public Response printPdf(final Map<String, Object> p) throws Exception {
		Response ret = null;
		// Formから送信されたデータを確認します。
		List<ValidationError> list = this.validate(p);
		if (list.size() == 0) {
			// MultiTestTableを取得するQueryを作成
			MultiTestTable table = new MultiTestTable();
			SingleTableQuery query = new SingleTableQuery(table);
			// ソート順をcode1, code2の設定。
			query.setOrderByFieldList(new FieldList(table.getCode1Field(), table.getCode2Field()));
			// 問合せの実行
			Dao dao = new Dao(this);
			List<Map<String, Object>> mlist = dao.executeQuery(query);
			// 印刷用データマップの作製
			Map<String, Object> data = new HashMap<String, Object>();
			data.put(MultiExcelReport.ID_LIST, mlist);
			
			// Excelテンプレートファイルパスを取得
			File excelTemplate = new File(SampleEditForm.getServlet().getServletContext().getRealPath("/exceltemplate/multi.xlsx"));
			// ExcelテンプレートからFo点ブレードの作成
			File template = new File(SampleEditForm.getServlet().getServletContext().getRealPath("/exceltemplate/multi.fo"));
			if ((!template.exists()) || excelTemplate.lastModified() > template.lastModified()) {
				// *.xlsxファイルを*.foに変換する。
				ExcelToXSLFO conv = new ExcelToXSLFO();
				conv.setExcelFile(excelTemplate.getAbsolutePath());
				conv.setXslFoFile(template.getAbsolutePath());
				conv.convert();
			}
			// レポートのクラスを作成。
			MultiPdfReport rep = new MultiPdfReport(template.getAbsolutePath());
			// Excelファイルを応答する。
			BinaryResponse bresp = new BinaryResponse(rep.print(data));
			bresp.setFileName("sample.pdf");
			return bresp;
		} else {
			// 確認で問題があった場合その情報を返信します。
			ret = new JsonResponse(JsonResponse.INVALID, list);
		}
		return ret;

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
