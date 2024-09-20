package jp.dataforms.test.tester.docss;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.dataforms.test.proj.WebAppProject;
import jp.dataforms.test.selenium.Browser;

/**
 * 「3.4.Report」のスクリーンショットを取得するツール。
 */
public class DocScreenShot341Tester extends DocScreenShotTester {
	
	/**
	 * Logger.
	 */
	private static Logger logger = LogManager.getLogger(DocScreenShot251Tester.class);

	/**
	 * コンストラクタ。
	 */
	public DocScreenShot341Tester() {
		super("3.4.report");
	}


	/**
	 * レポート関連ソースをコピーする。
	 * @throws Exception 例外。
	 */
	private void copyReportSrc() throws Exception {
		WebAppProject proj = WebAppProject.newWebAppProject(this.getConf());
		
		proj.copyWebappSrc("/edittable/page/MultiTestPage.html", "/edittable/page/MultiTestPage.html");
		proj.copyWebappSrc("/edittable/page/MultiTestQueryForm.js", "/edittable/page/MultiTestQueryForm.js");
		proj.copyWebappSrc("/exceltemplate/multi.xlsx", "/exceltemplate/multi.xlsx");
		
		proj.copyJavaSrc("/jp/dataforms/sample/edittable/page/MultiTestQueryForm.java", "/jp/dataforms/sample/edittable/page/MultiTestQueryForm.java");
		proj.copyJavaSrc("/jp/dataforms/sample/edittable/report/MultiExcelReport.java", "/jp/dataforms/sample/edittable/report/MultiExcelReport.java");
		proj.copyJavaSrc("/jp/dataforms/sample/edittable/report/MultiPdfReport.java", "/jp/dataforms/sample/edittable/report/MultiPdfReport.java");
	}
	
	
	@Override
	public void exec() throws Exception {
		WebAppProject proj = WebAppProject.newWebAppProject(this.getConf());
		proj.loadSnapshot("step04");
		this.copyReportSrc();
		Browser browser = this.getBrowser();
		Browser.sleep(this.getConf().getTestApp().getBuildWait());
		this.reloadWebApp(this.getConf().getTestApp().getContextPath());
		this.login(browser, "developer");
		logger.info(this.getDocumentPath() + "取得終了");
		browser.close();
	}
}
