package sample.report;

import dataforms.report.ExcelReport;
import sample.dao.SampleTable;

/**
 * Excelレポートクラス。
 *
 */
public class SampleExcelReport extends ExcelReport {
	/**
	 * コンストラクタ。
	 * @param template Excelテンプレートファイルのパス。
	 */
	public SampleExcelReport(final String template) {
		this.setTemplatePath(template);
		this.addTableFields(new SampleTable());

	}
}