package jp.dataforms.sample.edittable.report;

import jp.dataforms.fw.report.ExcelReport;
import jp.dataforms.sample.edittable.dao.SampleTable;

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
