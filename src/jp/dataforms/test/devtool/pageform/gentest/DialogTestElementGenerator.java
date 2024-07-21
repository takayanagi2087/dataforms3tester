package jp.dataforms.test.devtool.pageform.gentest;

import java.io.File;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.dataforms.fw.controller.Dialog;
import jp.dataforms.fw.controller.Form;
import jp.dataforms.fw.servlet.DataFormsServlet;
import jp.dataforms.fw.util.FileUtil;
import jp.dataforms.test.devtool.pageform.page.TestSrcGeneratorEditForm;

/**
 * ダイアログテスタージェネレータ。
 */
public class DialogTestElementGenerator extends DataFormsTestElementGenerator<Dialog> {
	/**
	 * Logger.
	 */
	private Logger logger = LogManager.getLogger(DialogTestElementGenerator.class);
	
	
	/**
	 * コンストラクタ。
	 * @param dialog ページ。
	 */
	public DialogTestElementGenerator(final Dialog dialog) {
		super(dialog);
	}

	@Override
	protected Template getTemplate() throws Exception {
		Template tmp = new Template(this.getClass(), "template/DialogTestElement.java.template");
		return tmp;
	}

	
	@Override
	public void generage(final Form form, final Map<String, Object> data) throws Exception {
		String basePath = (String) data.get(TestSrcGeneratorEditForm.ID_TEST_TOOL_SRC_PATH);
		String testElementPackageName = (String) data.get(TestSrcGeneratorEditForm.ID_TEST_ELEMENT_PACKAGE_NAME);
		String testElementClassName = this.getDataForms().getClass().getSimpleName() + "TestElement";

		String dialogClass = this.getDataForms().getClass().getSimpleName();
		String srcFile = basePath + testElementPackageName.replaceAll("\\.", "/") + "/" + testElementClassName + ".java";
		Template tmp = this.getTemplate();
		tmp.replace("package", testElementPackageName);
		tmp.replace("dialogClass", dialogClass);
		tmp.replace("methodList", this.getMethodList(this.getFormList()));
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
