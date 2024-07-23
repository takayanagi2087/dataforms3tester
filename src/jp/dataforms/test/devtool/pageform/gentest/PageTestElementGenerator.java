package jp.dataforms.test.devtool.pageform.gentest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.dataforms.fw.controller.AlertDialog;
import jp.dataforms.fw.controller.ConfirmDialog;
import jp.dataforms.fw.controller.Dialog;
import jp.dataforms.fw.controller.Form;
import jp.dataforms.fw.controller.Page;
import jp.dataforms.fw.servlet.DataFormsServlet;
import jp.dataforms.fw.util.FileUtil;
import jp.dataforms.test.devtool.pageform.gentest.FormTestItemGenerator.TestItemClassInfo;
import jp.dataforms.test.devtool.pageform.page.TestSrcGeneratorEditForm;
import lombok.Getter;

/**
 * ページテスタージェネレータ。
 */
public class PageTestElementGenerator extends DataFormsTestElementGenerator<Page> {
	/**
	 * Logger.
	 */
	private Logger logger = LogManager.getLogger(PageTestElementGenerator.class);
	
	/**
	 * テスト項目リスト。
	 */
	@Getter
	private List<TestItemClassInfo> testItemList = new ArrayList<TestItemClassInfo>();
	
	/**
	 * コンストラクタ。
	 * @param page ページ。
	 */
	public PageTestElementGenerator(final Page page) {
		super(page);
	}

	@Override
	protected Template getTemplate() throws Exception {
		Template tmp = new Template(this.getClass(), "template/PageTestElement.java.template");
		return tmp;
	}

	/**
	 * ダイアログリストを取得します。
	 * @return ダイアログリスト。
	 * 
	 */
	protected List<Dialog> getDialogList() {
		Map<String, Dialog> dlgmap = this.getDataForms().getDialogMap();
		List<Dialog> list = new ArrayList<Dialog>();
		for (String key: dlgmap.keySet()) {
			Dialog dlg = dlgmap.get(key);
			if ((dlg instanceof AlertDialog) || (dlg instanceof ConfirmDialog)) {
				continue;
			}
			logger.debug("daialog = " + dlg.getClass().getName());
			list.add(dlgmap.get(key));
		}
		return list;
	}
	
	@Override
	public List<Form> getFormList() {
		List<Form> list = super.getFormList();
		// ダイアログ内のフォームを追加。
		List<Dialog> dlist = this.getDialogList();
		for (Dialog dlg: dlist) {
			DialogTestElementGenerator dgen = new DialogTestElementGenerator(dlg);
			list.addAll(dgen.getFormList());
		}
		return list;
	}
	
	/**
	 * ダイアログのテスト要素生成します。
	 * @param data POSTされたデータ。
	 * @return ダイアログリスト。
	 */
	protected List<Dialog> generateDialogTestElement(final Map<String, Object> data) throws Exception {
		List<Dialog> list = this.getDialogList();
		for (Dialog dlg: list) {
			DialogTestElementGenerator dgen = new DialogTestElementGenerator(dlg);
			List<Form> flist = dgen.getFormList();
			for (Form f: flist) {
				{
					FormTestElementGenerator fgen = new FormTestElementGenerator(f);
					fgen.generage(data);
				}
				// FormTestItemクラスの生成。
				{
					FormTestItemGenerator fgen = new FormTestItemGenerator(f);
					fgen.generage(data);
					this.testItemList.add(fgen.getTestItemInfo());
				}
				// SampleFormTestItemクラスの生成。
				{
					SampleFormTestItemGenerator fgen = new SampleFormTestItemGenerator(f, dlg);
					fgen.generage(data);
				}
			}
			dgen.generage(data);
		}
		return list;
	}
	
	
	/**
	 * ダイアログ取得メソッドリストを作成します。
	 * @param dialogList ダイアログリスト。
	 * @return 定数定義リスト。
	 */
	protected String getDialogMethodList(final List<Dialog> dialogList) {
		StringBuilder sb = new StringBuilder();
		for (Dialog f: dialogList) {
			String testElementClass = f.getClass().getSimpleName() + "TestElement";
			sb.append("\t/**\n");
			sb.append("\t * " + f.getClass().getSimpleName() + "のテスト要素を取得します。\n");
			sb.append("\t * @return " + f.getClass().getSimpleName() + "のテスト要素。\n");
			sb.append("\t */\n");
			sb.append("\tpublic " + testElementClass + " get" + f.getClass().getSimpleName() + "() {\n");
			sb.append("\t\treturn this.getDialog(" + testElementClass + ".ID, " + testElementClass + ".class);\n");
			sb.append("\t}\n\n");
		}
		return sb.toString();
	}

	@Override
	public void generage(final Map<String, Object> data) throws Exception {
		String basePath = (String) data.get(TestSrcGeneratorEditForm.ID_TEST_TOOL_SRC_PATH);
		String testElementPackageName = (String) data.get(TestSrcGeneratorEditForm.ID_TEST_ELEMENT_PACKAGE_NAME);
		String testElementClassName = this.getDataForms().getClass().getSimpleName() + "TestElement";
		String pageName = this.getDataForms().getPageName();
		String srcFile = basePath + testElementPackageName.replaceAll("\\.", "/") + "/" + testElementClassName + ".java";

		List<Dialog> dlist = this.generateDialogTestElement(data);
		
		Template tmp = this.getTemplate();
		tmp.replace("package", testElementPackageName);
		tmp.replace("pageName", pageName);
		tmp.replace("pageClass", this.getDataForms().getClass().getSimpleName());
		String methods = this.getFormMethodList(this.getFormList());
		methods += this.getDialogMethodList(dlist);
		tmp.replace("methodList", methods);
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
