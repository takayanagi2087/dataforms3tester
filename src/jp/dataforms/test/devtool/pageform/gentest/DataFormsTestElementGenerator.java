package jp.dataforms.test.devtool.pageform.gentest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jp.dataforms.fw.app.login.page.LoginInfoForm;
import jp.dataforms.fw.app.menu.page.SideMenuForm;
import jp.dataforms.fw.controller.DataForms;
import jp.dataforms.fw.controller.Form;
import jp.dataforms.fw.controller.WebComponent;
import jp.dataforms.fw.devtool.javasrc.JavaSrcGenerator;
import lombok.Getter;

/**
 * DataFormsテスト要素ジェネレータ。
 * @param <T> 対象クラス。
 */
public abstract class DataFormsTestElementGenerator<T extends DataForms> extends JavaSrcGenerator {

	/**
	 * DataForms。
	 * 
	 */
	@Getter
	private T dataForms = null;

	/**
	 * コンストラクタ。
	 * @param dataForms
	 */
	public DataFormsTestElementGenerator(final T dataForms) {
		this.dataForms = dataForms;
	}
	
	/**
	 * フォームのリストを取得します。
	 * @return フォームのリスト。
	 */
	public List<Form> getFormList() {
		List<Form> list = new ArrayList<Form>();
		Set<String> set = dataForms.getFormMap().keySet();
		for (String key: set) {
			WebComponent cmp = dataForms.getFormMap().get(key);
			if (cmp instanceof Form) {
				if (cmp instanceof SideMenuForm) {
					continue;
				}
				if (cmp instanceof LoginInfoForm) {
					continue;
				}
				Form f = (Form) dataForms.getFormMap().get(key);
				list.add(f);
			}
		}
		return list;
	}
	
	
	/**
	 * フォーム取得メソッドリストを作成します。
	 * @param formList フォームクラス。
	 * @return 定数定義リスト。
	 */
	protected String getFormMethodList(final List<Form> formList) {
		StringBuilder sb = new StringBuilder();
		for (Form f: formList) {
			String testElementClass = f.getClass().getSimpleName() + "TestElement";
			sb.append("\t/**\n");
			sb.append("\t * " + f.getClass().getSimpleName() + "のテスト要素を取得します。\n");
			sb.append("\t * @return " + f.getClass().getSimpleName() + "のテスト要素。\n");
			sb.append("\t */\n");
			sb.append("\tpublic " + testElementClass + " get" + f.getClass().getSimpleName() + "() {\n");
			sb.append("\t\treturn this.getForm(" + testElementClass + ".ID, " + testElementClass + ".class);\n");
			sb.append("\t}\n\n");
		}
		return sb.toString();
	}


}
