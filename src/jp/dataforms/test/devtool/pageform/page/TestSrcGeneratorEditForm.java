package jp.dataforms.test.devtool.pageform.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.dataforms.fw.controller.EditForm;
import jp.dataforms.fw.controller.Form;
import jp.dataforms.fw.controller.Page;
import jp.dataforms.fw.devtool.field.OverwriteModeField;
import jp.dataforms.fw.field.base.FieldList;
import jp.dataforms.fw.field.base.TextField;
import jp.dataforms.fw.field.common.RowNoField;
import jp.dataforms.fw.htmltable.HtmlTable;
import jp.dataforms.fw.menu.FunctionMap;
import jp.dataforms.fw.servlet.DataFormsServlet;
import jp.dataforms.fw.util.JsonUtil;
import jp.dataforms.test.devtool.pageform.gentest.FormTestElementGenerator;
import jp.dataforms.test.devtool.pageform.gentest.FormTestItemGenerator;
import jp.dataforms.test.devtool.pageform.gentest.FormTestItemGenerator.TestItemClassInfo;
import jp.dataforms.test.devtool.pageform.gentest.PageTestElementGenerator;
import jp.dataforms.test.devtool.pageform.gentest.PageTesterGenerator;
import jp.dataforms.test.devtool.pageform.gentest.SampleFormTestItemGenerator;

/**
 * テストソース生成フォーム。
 */
public class TestSrcGeneratorEditForm extends EditForm {
	/**
	 * Logger.
	 */
	private Logger logger = LogManager.getLogger(TestSrcGeneratorEditForm.class);

	/**
	 * ページパッケージ名フィールドID。
	 */
	public static final String ID_PACKAGE_NAME = "packageName";

	/**
	 * テストツールソースパス。
	 */
	public static final String ID_TEST_TOOL_SRC_PATH = "testToolSrcPath";

	/**
	 * ページクラス名のフィールドID。
	 */
	public static final String ID_PAGE_CLASS_NAME = "pageClassName";
	
	/**
	 * 出力パッケージ名。
	 */
	public static final String ID_TESTER_PACKAGE_NAME = "testerPackageName";

	/**
	 * ページテスタークラス名のフィールドID。
	 */
	public static final String ID_PAGE_TESTER_CLASS_NAME = "pageTesterClassName";

	/**
	 * ページテスター上書きモードのフィールドID。
	 */
	public static final String ID_PAGE_TESTER_OVERWRITE_MODE = "pageTesterOverwriteMode";
	
	/**
	 * テスト要素パッケージのフィールドID。
	 */
	public static final String ID_TEST_ELEMENT_PACKAGE_NAME = "testElementPackageName";

	/**
	 * テスト項目パッケージのフィールドID。
	 */
	public static final String ID_TEST_ITEM_PACKAGE_NAME = "testItemPackageName";

	
	/**
	 * ページテスト要素クラス名のフィールドID。
	 */
	public static final String ID_PAGE_TEST_ELEMENT_CLASS_NAME = "pageTestElementClassName";

	/**
	 * ページテスト要素上書きモードフィールドID。
	 */
	public static final String ID_PAGE_TEST_ELEMENT_OVERWRITE_MODE = "pageTestElementOverwriteMode";

	/**
	 * フォームクラス名。
	 */
	public static final String ID_FORM_CLASS_NAME = "formClassName";

	/**
	 * フォームテスト要素クラス名。
	 */
	public static final String ID_FORM_TEST_ELEMENT_CLASS_NAME = "formTestElementClassName";

	/**
	 * フォームテスト要素クラス名。
	 */
	public static final String ID_FORM_TEST_ITEM_CLASS_NAME = "formTestItemClassName";

	/**
	 * フォームテスト要素クラス名。
	 */
	public static final String ID_FORM_SAMPLE_TEST_ITEM_CLASS_NAME = "formSampleTestItemClassName";
	
	/**
	 * フォームテスト要素クラス名。
	 */
	public  static final String ID_FORM_TEST_ELEMENT_OVERWRITE_MODE = "formTestElementOverwriteMode";

	/**
	 * コンストラクタ。
	 */
	public TestSrcGeneratorEditForm() {
		this.addField(new TextField(ID_TEST_TOOL_SRC_PATH)).setComment("テストツールソースパス").setReadonly(true);
		this.addField(new TextField(ID_PACKAGE_NAME)).setReadonly(true);
		this.addField(new TextField(ID_PAGE_CLASS_NAME)).setComment("ページクラス名").setReadonly(true);

		this.addField(new TextField(ID_TESTER_PACKAGE_NAME)).setReadonly(true).setComment("出力パッケージ名");
		this.addField(new TextField(ID_PAGE_TESTER_CLASS_NAME)).setReadonly(true).setComment("ページテスタークラス名");
		this.addField(new OverwriteModeField(ID_PAGE_TESTER_OVERWRITE_MODE)).setComment("ページテスター上書きモード");
		
		this.addField(new TextField(ID_TEST_ELEMENT_PACKAGE_NAME)).setReadonly(true).setComment("テスト要素パッケージ");
		this.addField(new TextField(ID_PAGE_TEST_ELEMENT_CLASS_NAME)).setReadonly(true).setComment("ページテスト要素クラス名");
		this.addField(new OverwriteModeField(ID_PAGE_TEST_ELEMENT_OVERWRITE_MODE)).setComment("ページテスト要素上書きモード");
		this.addField(new TextField(ID_TEST_ITEM_PACKAGE_NAME)).setReadonly(true).setComment("テスト項目パッケージ");

		FieldList flist = new FieldList();
		flist.addField(new RowNoField()).setReadonly(true);
		flist.addField(new TextField(ID_FORM_CLASS_NAME)).setReadonly(true).setComment("フォームクラス名");
		flist.addField(new TextField(ID_FORM_TEST_ELEMENT_CLASS_NAME)).setReadonly(true).setComment("フォームテスト要素クラス名");
		flist.addField(new TextField(ID_FORM_TEST_ITEM_CLASS_NAME)).setReadonly(true).setComment("テスト項目基本クラス名");
		flist.addField(new TextField(ID_FORM_SAMPLE_TEST_ITEM_CLASS_NAME)).setReadonly(true).setComment("サンプルテスト項目クラス名");
		flist.addField(new OverwriteModeField(ID_FORM_TEST_ELEMENT_OVERWRITE_MODE)).setComment("フォームテスト要素上書きモード");

		HtmlTable formTable = new HtmlTable("formTable", flist);
		this.addHtmlTable(formTable);
	}
	
	/**
	 * ページのインスタンスを作成します。
	 * @param classname クラス名。
	 * @return ページのインスタンス。
	 * @throws Exception 例外。
	 */
	private Page newPageInstance(final String classname) throws Exception {
		Class<?> clazz = Class.forName(classname);
		Page p = (Page) clazz.getDeclaredConstructor().newInstance();
		return p;
	}
	
	/**
	 * ページ中のフォームクラスの一覧を取得します。
	 * @param page ページ・
	 * @return フォームクラスの一覧。
	 */
/*	private List<Form> getFormList(final Page page) {
		List<Form> list = new ArrayList<Form>();
		Set<String> set = page.getFormMap().keySet();
		for (String key: set) {
			WebComponent cmp = page.getFormMap().get(key);
			if (cmp instanceof Form) {
				if (cmp instanceof SideMenuForm) {
					continue;
				}
				if (cmp instanceof LoginInfoForm) {
					continue;
				}
				Form f = (Form) page.getFormMap().get(key);
				list.add(f);
			}
		}
		return list;
	}
*/	
	@Override
	protected Map<String, Object> queryData(Map<String, Object> data) throws Exception {
		String basePackage = FunctionMap.getAppFunctionMap().getAppBasePackage();
		
		basePackage = "jp.dataforms.test";
		
		String pkg = (String) data.get(ID_PACKAGE_NAME);
		String cls = (String) data.get(ID_PAGE_CLASS_NAME);
		String classname = pkg + "." + cls;

		logger.debug("classname=" + classname);
		logger.debug("data=" + JsonUtil.encode(data, true));
		Page p = this.newPageInstance(classname);

		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put(ID_TEST_TOOL_SRC_PATH, DataFormsServlet.getConf().getDevelopmentTool().getTestSourcePath());
		ret.put(ID_PACKAGE_NAME, pkg);
		String spkg = "";
		if (pkg.indexOf("jp.dataforms.fw") == 0) {
			spkg = pkg.substring("jp.dataforms.fw".length());
		} else if (pkg.indexOf(basePackage) == 0) {
			spkg = pkg.substring(basePackage.length());
		}
		
		ret.put(ID_PAGE_CLASS_NAME, cls);
		ret.put(ID_TESTER_PACKAGE_NAME, basePackage + ".tester" + spkg);
		ret.put(ID_PAGE_TESTER_CLASS_NAME, p.getClass().getSimpleName() + "Tester");
		ret.put(ID_PAGE_TESTER_OVERWRITE_MODE, OverwriteModeField.ERROR);
		ret.put(ID_TEST_ELEMENT_PACKAGE_NAME, basePackage + ".element" + spkg);
		ret.put(ID_PAGE_TEST_ELEMENT_CLASS_NAME, p.getClass().getSimpleName() + "TestElement");
		ret.put(ID_PAGE_TEST_ELEMENT_OVERWRITE_MODE, OverwriteModeField.ERROR);
		ret.put(ID_TEST_ITEM_PACKAGE_NAME, basePackage + ".testitem" + spkg);
		
		PageTestElementGenerator pgen = new PageTestElementGenerator(p);
		List<Form> flist = pgen.getFormList();
		int no = 1;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (Form f: flist) {
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("rowNo",  no++);
			m.put(ID_FORM_CLASS_NAME, f.getClass().getSimpleName());
			m.put(ID_FORM_TEST_ELEMENT_CLASS_NAME, f.getClass().getSimpleName() + "TestElement");
			m.put(ID_FORM_TEST_ITEM_CLASS_NAME, f.getClass().getSimpleName() + "TestItem");
			m.put(ID_FORM_SAMPLE_TEST_ITEM_CLASS_NAME, f.getClass().getSimpleName() + "SampleTestItem");
			m.put(ID_FORM_TEST_ELEMENT_OVERWRITE_MODE, OverwriteModeField.ERROR);
			list.add(m);
		}
		ret.put("formTable", list);
		return ret;
	}

	@Override
	protected boolean isUpdate(Map<String, Object> data) throws Exception {
		return false;
	}

	@Override
	protected void insertData(Map<String, Object> data) throws Exception {
		String pkg = (String) data.get(ID_PACKAGE_NAME);
		String cls = (String) data.get(ID_PAGE_CLASS_NAME);
		String classname = pkg + "." + cls;
		Page page = this.newPageInstance(classname);
		// PageTestElementクラス
		PageTestElementGenerator ptgen = new PageTestElementGenerator(page);
		List<Form> flist = ptgen.getFormList();
		List<TestItemClassInfo> testItemList = new ArrayList<TestItemClassInfo>();
		for (Form f: flist) {
			String formClassName = f.getClass().getSimpleName();
			String formSuperClassName = f.getClass().getSuperclass().getSimpleName();
			logger.debug("form=" + formClassName + ", " + formSuperClassName);
			// FormTestElementクラスの生成。
			{
				FormTestElementGenerator fgen = new FormTestElementGenerator(f);
				fgen.generage(this, data);
			}
			// FormTestItemクラスの生成。
			{
				FormTestItemGenerator fgen = new FormTestItemGenerator(f);
				fgen.generage(this, data);
				testItemList.add(fgen.getTestItemInfo());
			}
			// SampleFormTestItemクラスの生成。
			{
				SampleFormTestItemGenerator fgen = new SampleFormTestItemGenerator(f);
				fgen.generage(this, data);
			}
		}
		ptgen.generage(this, data);
		// PageTesterクラスの生成。
		PageTesterGenerator gen = new PageTesterGenerator(page, testItemList);
		gen.generage(this, data);
	}

	@Override
	protected void updateData(Map<String, Object> data) throws Exception {
	}

	@Override
	public void deleteData(Map<String, Object> data) throws Exception {
	}

}
