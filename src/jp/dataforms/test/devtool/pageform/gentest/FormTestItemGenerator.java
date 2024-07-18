package jp.dataforms.test.devtool.pageform.gentest;

import java.io.File;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.dataforms.fw.controller.Form;
import jp.dataforms.fw.devtool.javasrc.JavaSrcGenerator;
import jp.dataforms.fw.servlet.DataFormsServlet;
import jp.dataforms.fw.util.FileUtil;
import jp.dataforms.test.devtool.pageform.page.TestSrcGeneratorEditForm;
import lombok.Getter;

/**
 * ページテスタージェネレータ。
 */
public class FormTestItemGenerator extends JavaSrcGenerator {
	/**
	 * Logger.
	 */
	private Logger logger = LogManager.getLogger(FormTestItemGenerator.class);
	
	/**
	 * フォーム。
	 */
	private Form form = null;
	
	/**
	 * コンストラクタ。
	 * @param form フォーム。
	 */
	public FormTestItemGenerator(final Form form) {
		this.form = form;
	}

	@Override
	protected Template getTemplate() throws Exception {
		Template tmp = new Template(this.getClass(), "template/FormTestItem.java.template");
		return tmp;
	}
	

	/**
	 * テスト項目情報。
	 */
	public static class TestItemClassInfo {
		/**
		 * テスト項目のパッケージ名。
		 */
		@Getter
		private String testItemPackageName = null;

		/**
		 * テスト項目クラス名。
		 */
		@Getter
		private String testItemClassName = null;
		
		/**
		 * フォームクラス名。
		 */
		@Getter
		private String formClassName = null;
		
		/**
		 * コンストラクタ。
		 * @param pkgname テスト項目のパッケージ名。
		 * @param itemClass テスト項目クラス名。
		 * @param formClass フォームクラス名。
		 */
		public TestItemClassInfo(final String pkgname, final String itemClass, final String formClass) {
			this.testItemPackageName = pkgname;
			this.testItemClassName = itemClass;
			this.formClassName = formClass;
		}
	}
	
	/**
	 * テスト項目情報。
	 */
	@Getter
	private TestItemClassInfo testItemInfo = null;
	
	@Override
	public void generage(final Form form, final Map<String, Object> data) throws Exception {
		String packageName = (String) data.get(TestSrcGeneratorEditForm.ID_PACKAGE_NAME);
		String pageClassName = (String) data.get(TestSrcGeneratorEditForm.ID_PAGE_CLASS_NAME);
		
		String basePath = (String) data.get(TestSrcGeneratorEditForm.ID_TEST_TOOL_SRC_PATH);
		String testItemPackageName = (String) data.get(TestSrcGeneratorEditForm.ID_TEST_ITEM_PACKAGE_NAME);
		String testItemClassName = this.form.getClass().getSimpleName() + "TestItem";
		
		String srcFile = basePath + testItemPackageName.replaceAll("\\.", "/") + "/" + testItemClassName + ".java";

		String importList = "import " + packageName + "." + pageClassName + ";\n";
		importList += "import " + this.form.getClass().getName() + ";\n";
		
		Template tmp = this.getTemplate();
		tmp.replace("package", testItemPackageName);
		tmp.replace("importList", importList);
		tmp.replace("pageClass", pageClassName);
		tmp.replace("formClass", this.form.getClass().getSimpleName());
		logger.debug("srcFile=" + srcFile);
		logger.debug("src=" + tmp.getSource());
		File sf = new File(srcFile);
		File pf = sf.getParentFile();
		if (!pf.exists()) {
			pf.mkdirs();
		}
		FileUtil.writeTextFileWithBackup(sf.getAbsolutePath(), tmp.getSource(), DataFormsServlet.getEncoding());
		this.testItemInfo = new TestItemClassInfo(testItemPackageName, testItemClassName, this.form.getClass().getSimpleName());
	}
}
