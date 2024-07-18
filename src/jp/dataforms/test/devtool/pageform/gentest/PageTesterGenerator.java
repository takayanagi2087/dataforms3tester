package jp.dataforms.test.devtool.pageform.gentest;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.dataforms.fw.controller.Form;
import jp.dataforms.fw.controller.Page;
import jp.dataforms.fw.devtool.javasrc.JavaSrcGenerator;
import jp.dataforms.fw.servlet.DataFormsServlet;
import jp.dataforms.fw.util.FileUtil;
import jp.dataforms.test.devtool.pageform.gentest.FormTestItemGenerator.TestItemClassInfo;
import jp.dataforms.test.devtool.pageform.page.TestSrcGeneratorEditForm;

/**
 * ページテスタージェネレータ。
 */
public class PageTesterGenerator extends JavaSrcGenerator {
	/**
	 * Logger.
	 */
	private Logger logger = LogManager.getLogger(PageTesterGenerator.class);
	
	/**
	 * ページ。
	 * 
	 */
	private Page page = null;
	
	/**
	 * テスト項目クラス情報。
	 */
	private List<TestItemClassInfo> testItemList = null;
	
	/**
	 * コンストラクタ。
	 * @param page ページ。
	 * @param testItemList テスト項目リスト。
	 */
	public PageTesterGenerator(final Page page,final List<TestItemClassInfo> testItemList) {
		this.page = page;
		this.testItemList = testItemList;
	}

	@Override
	protected Template getTemplate() throws Exception {
		Template tmp = new Template(this.getClass(), "template/PageTester.java.templete");
		return tmp;
	}
	
	/**
	 * フォームのテストメソッドのテンプレート。
	 */
	private static String FORM_TEST_METHOD = """
				/**
				 * ${formClassName}のテストを行います。
				 * @param browser ブラウザ。
				 * @return テスト結果リスト。
				 * @throws Exception 例外。
				 */
				private List<TestItem> test${formClassName}(final Browser browser) throws Exception {
					browser.setClientSize(new Dimension(1024, 540));
					// ${formClassName}のテスト項目のリストを取得する。
					List<TestItem> list = this.queryCheckItem(${testItemClassName}.class);
					List<TestItem> testResult = new ArrayList<TestItem>();
					// ${formClassName}のテスト項目を実行し、その結果をtestResultに保存
					testResult.addAll(this.execTestItemList(browser, list));
					return testResult;
				}
			
			""";

	/**
	 * フォームのテストメソッドを作成する。
	 * @param testItemInfo テスト項目情報。
	 * @return フォームのテストメソッド。
	 */
	private String getFormTestMethod(final TestItemClassInfo testItemInfo) {
		Template templ = new Template(FORM_TEST_METHOD);
		templ.replace("testItemPackageName", testItemInfo.getTestItemPackageName());
		templ.replace("testItemClassName", testItemInfo.getTestItemClassName());
		templ.replace("formClassName", testItemInfo.getFormClassName());
		return templ.getSource();
	}
	
	/**
	 * フォームテストメソッドリスト。
	 * @param list テスト項目リスト。
	 * @return フォームテストメソッド。
	 */
	private String getFormTestMethods(final List<TestItemClassInfo> list) {
		StringBuilder sb = new StringBuilder();
		for (TestItemClassInfo info: list) {
			sb.append(this.getFormTestMethod(info));
		}
		return sb.toString();
	}
	
	/**
	 * Importリストを作成します。
	 * @param testItemList テスト項目クラスリスト。
	 * @return Importリスト。
	 */
	private String getImportList(final List<TestItemClassInfo> testItemList) {
		StringBuilder sb = new StringBuilder();
		for (TestItemClassInfo info: testItemList) {
			sb.append("import " + info.getTestItemPackageName() + "." + info.getTestItemClassName() + ";\n");
		}
		return sb.toString();
	}
	
	/**
	 * テスト項目実行メソッドの呼び出しコードを作成します。
	 * @param testItemList テスト項目リスト。
	 * @return テスト項目実行メソッドの呼び出しコード。
	 */
	private String getCallTestMethods(final List<TestItemClassInfo> testItemList) {
		StringBuilder sb = new StringBuilder();
		for (TestItemClassInfo info: testItemList) {
			sb.append("\t\tresultList.addAll(this.test" + info.getFormClassName() + "(browser));\n");
		}
		return sb.toString();
	}
	
	@Override
	public void generage(final Form form, final Map<String, Object> data) throws Exception {
		String basePath = (String) data.get(TestSrcGeneratorEditForm.ID_TEST_TOOL_SRC_PATH);
		String packageName = (String) data.get(TestSrcGeneratorEditForm.ID_PACKAGE_NAME);
		String testerPackageName = (String) data.get(TestSrcGeneratorEditForm.ID_TESTER_PACKAGE_NAME);
		String pageClass = (String) data.get(TestSrcGeneratorEditForm.ID_PAGE_CLASS_NAME);
		String pageTesterClass = (String) data.get(TestSrcGeneratorEditForm.ID_PAGE_TESTER_CLASS_NAME);
		String pageName = this.page.getPageName();
		String srcFile = basePath + testerPackageName.replaceAll("\\.", "/") + "/" + pageTesterClass + ".java";
		String importList = "import " + packageName  + "." + pageClass + ";\n";
		importList += this.getImportList(this.testItemList);
		Template tmp = this.getTemplate();
		tmp.replace("formTestMethods", this.getFormTestMethods(this.testItemList));
		tmp.replace("importList", importList);
		tmp.replace("pageName", pageName);
		tmp.replace("pageTesterClass", pageTesterClass);
		tmp.replace("pageClass", pageClass);
		tmp.replace("package", testerPackageName);
		tmp.replace("callTestMethod", this.getCallTestMethods(testItemList));
		logger.debug("srcFile=" + srcFile);
		logger.debug("src=" + tmp.getSource());
		File sf = new File(srcFile);
		File pf = sf.getParentFile();
		if (!pf.exists()) {
			pf.mkdirs();
		}
		FileUtil.writeTextFileWithBackup(sf.getAbsolutePath(), tmp.getSource(), DataFormsServlet.getEncoding());
	}
}
