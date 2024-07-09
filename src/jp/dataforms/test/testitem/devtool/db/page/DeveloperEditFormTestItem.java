package jp.dataforms.test.testitem.devtool.db.page;

import jp.dataforms.fw.devtool.init.page.InitDevelopmentToolForm;
import jp.dataforms.fw.devtool.init.page.InitDevelopmentToolPage;
import jp.dataforms.test.testitem.TestItem;

public abstract class DeveloperEditFormTestItem extends TestItem {
	public DeveloperEditFormTestItem(final String condition, final String expected) {
		super(InitDevelopmentToolPage.class, InitDevelopmentToolForm.class, condition, expected);
	}
	
	
}
