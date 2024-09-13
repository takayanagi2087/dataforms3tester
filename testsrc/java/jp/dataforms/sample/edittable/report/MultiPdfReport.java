package jp.dataforms.sample.edittable.report;

import jp.dataforms.fw.report.ReportTable;
import jp.dataforms.fw.report.XslFoReport;
import jp.dataforms.sample.edittable.dao.MultiTestTable;

/**
 * PDFレポートクラス。
 *
 */
public class MultiPdfReport extends XslFoReport {
	/**
	 * テーブルのID。
	 */
	public static final String ID_LIST = "list";

	/**
	 * コンストラクタ。
	 * @param template テンプレートのパス。
	 */
	public MultiPdfReport(final String template) {
		this.setTemplatePath(template);
		// MultiTestTableのフィールドを元にReportTableを作成。
		MultiTestTable table = new MultiTestTable();
		ReportTable rtable = new ReportTable(ID_LIST, table.getFieldList());
		// 行数によって改ページするテーブルのIDを指定。
		this.setMainTableId(ID_LIST);
		// 1ページの行数を8に設定。
		this.setRowsParPage(8);
		// 値が変化したタイミングで改ページをする項目を設定。
		this.addBreakField(table.getCode1Field());
		// レポートテーブル(ID;"list")を追加。
		this.addReportTable(rtable);
	}

}