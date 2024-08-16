package jp.dataforms.sample.edittable.report;

import jp.dataforms.fw.report.XslFoReport;
import jp.dataforms.sample.edittable.dao.SampleTable;

/**
 * Excelレポートクラス。
 *
 */
public class SamplePdfReport extends XslFoReport {
	/**
	 * コンストラクタ。
	 * @param template Excelテンプレートファイルのパス。
	 */
	public SamplePdfReport(final String template) {
		this.setTemplatePath(template);
		this.addTableFields(new SampleTable());
	}
}
