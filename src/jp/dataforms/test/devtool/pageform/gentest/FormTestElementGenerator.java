package jp.dataforms.test.devtool.pageform.gentest;

import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.dataforms.fw.controller.Form;
import jp.dataforms.fw.devtool.javasrc.JavaSrcGenerator;
import jp.dataforms.fw.field.base.Field;
import jp.dataforms.fw.field.base.FieldList;
import jp.dataforms.fw.htmltable.HtmlTable;
import jp.dataforms.fw.servlet.DataFormsServlet;
import jp.dataforms.fw.util.FileUtil;
import jp.dataforms.fw.util.StringUtil;
import jp.dataforms.test.devtool.pageform.page.TestSrcGeneratorEditForm;

/**
 * ページテスタージェネレータ。
 */
public class FormTestElementGenerator extends JavaSrcGenerator {
	/**
	 * Logger.
	 */
	private Logger logger = LogManager.getLogger(FormTestElementGenerator.class);
	
	/**
	 * フォーム。
	 */
	private Form form = null;
	
	/**
	 * コンストラクタ。
	 * @param form フォーム。
	 */
	public FormTestElementGenerator(final Form form) {
		this.form = form;
	}

	@Override
	protected Template getTemplate() throws Exception {
		Template tmp = new Template(this.getClass(), "template/FormTestElement.java.template");
		return tmp;
	}

	/**
	 * テスト要素のクラス名を取得する。
	 * @param superClass フォームクラス。
	 * @return テスト要素のクラス名。
	 */
	private String getTestElementClassName(final Class<?> superClass) {
		String classname = superClass.getName();
		if (classname.indexOf("jp.dataforms.fw.controller") == 0) {
			classname = classname.replaceAll("jp.dataforms.fw.controller", "jp.dataforms.test.element.controller");
		}
		classname += "TestElement";
		return classname;
	}
	
	/**
	 * 定数定義リストを作成します。
	 * @param form フォームクラス。
	 * @return 定数定義リスト。
	 */
	private String getConstantList(final Form form) {
		Set<String> idset = new HashSet<String>();
		StringBuilder sb = new StringBuilder();
		FieldList flist = form.getFieldList();
		for (Field<?> f: flist) {
			String id = f.getId();
			if (idset.contains(id)) {
				continue;
			}
			idset.add(id);
			String comment = f.getComment();
			if (comment == null) {
				comment = "";
			}
			sb.append("\t/**\n");
			sb.append("\t * " + comment + "。\n");
			sb.append("\t */\n");
			sb.append("\tpublic static final String ID_" + StringUtil.camelToSnake(id).toUpperCase() + " = \"" + id + "\";\n\n");
		}
		for (HtmlTable t: form.getHtmlTableList()) {
			String id = t.getId();
			if (idset.contains(id)) {
				continue;
			}
			idset.add(id);
			sb.append("\t// ----- テーブル関連定数 -----\n");
			sb.append("\t/**\n");
			sb.append("\t * テーブル。\n");
			sb.append("\t */\n");
			sb.append("\tpublic static final String ID_" + StringUtil.camelToSnake(id).toUpperCase() + " = \"" + id + "\";\n\n");
			for (Field<?> f: t.getFieldList()) {
				String fid = f.getId();
				if (idset.contains(fid)) {
					continue;
				}
				idset.add(fid);
				String comment = f.getComment();
				if (comment == null) {
					comment = "";
				}
				sb.append("\t/**\n");
				sb.append("\t * " + comment + "。\n");
				sb.append("\t */\n");
				sb.append("\tpublic static final String ID_" + StringUtil.camelToSnake(fid).toUpperCase() + " = \"" + fid + "\";\n\n");
			}
		}
		return sb.toString();
	}
	

	/**
	 * メソッドリストを作成します。
	 * @param form フォームクラス。
	 * @return 定数定義リスト。
	 */
	private String getMethodList(final Form form) {
		StringBuilder sb = new StringBuilder();
		FieldList flist = form.getFieldList();
		for (Field<?> f: flist) {
			String id = f.getId();
			String constName = "ID_" + StringUtil.camelToSnake(id).toUpperCase();
			String method = id.substring(0, 1).toUpperCase() + id.substring(1);
			String comment = f.getComment();
			sb.append("\t/**\n");
			sb.append("\t * " + comment + "のテスト要素を取得します。\n");
			sb.append("\t * @return " + comment + "のテスト要素。\n");
			sb.append("\t */\n");
			sb.append("\tpublic FieldTestElement get" + method + "() {\n");
			sb.append("\t\treturn this.getField(" + constName + ");\n");
			sb.append("\t}\n");
		}
		for (HtmlTable t: form.getHtmlTableList()) {
			String id = t.getId();
			String constName = "ID_" + StringUtil.camelToSnake(id).toUpperCase();
			String method = id.substring(0, 1).toUpperCase() + id.substring(1);
			sb.append("\t/**\n");
			sb.append("\t * テーブルのテスト要素を取得します。\n");
			sb.append("\t * @return テーブルのテスト要素。\n");
			sb.append("\t */\n");
			sb.append("\tpublic TableTestElement get" + method + "() {\n");
			sb.append("\t\treturn this.getTable(" + constName + ");\n");
			sb.append("\t}\n");
		}
		return sb.toString();
	}

	
	@Override
	public void generage(final Map<String, Object> data) throws Exception {
		String basePath = (String) data.get(TestSrcGeneratorEditForm.ID_TEST_TOOL_SRC_PATH);
		String testElementPackageName = (String) data.get(TestSrcGeneratorEditForm.ID_TEST_ELEMENT_PACKAGE_NAME);
		String testElementClassName = this.form.getClass().getSimpleName() + "TestElement";
		
		String srcFile = basePath + testElementPackageName.replaceAll("\\.", "/") + "/" + testElementClassName + ".java";
		String importList = "import " + this.getTestElementClassName(this.form.getClass().getSuperclass()) + ";\n";
		if (this.form.getFieldList().size() > 0) {
			importList += "import jp.dataforms.test.element.htmltable.TableTestElement;\n";
		}
		Template tmp = this.getTemplate();
		tmp.replace("importList", importList);
		tmp.replace("formId", this.form.getId());
		tmp.replace("formClass", this.form.getClass().getSimpleName());
		tmp.replace("superFormClass", this.form.getClass().getSuperclass().getSimpleName());
		tmp.replace("package", testElementPackageName);
		tmp.replace("constantList", this.getConstantList(this.form));
		tmp.replace("methodList", this.getMethodList(this.form));
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
