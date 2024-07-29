package jp.dataforms.sample.menu;

import jp.dataforms.fw.annotation.ApplicationFunctionMap;
import jp.dataforms.fw.menu.FunctionMap;

/**
 * アプリケーションの機能マップを定義するクラスです。
 */
@ApplicationFunctionMap
public class AppFunctionMap extends FunctionMap {
	/**
	 * アプリケーションのベースパッケージを返します。
	 */
	@Override
	public String getAppBasePackage() {
		return "jp.dataforms.sample";
	}
	
	/**
	 * アプリケーションのパスとパッケージの対応表を作成します。
	 */
	@Override
	protected void addAppPathPackage() {
		this.addPathPackage(new PathPackage("/edittable", "jp.dataforms.sample.edittable"));

	}
	
	/**
	 * アプリケーションのメニューを追加します。
	 */
	@Override
	protected void addAppMenu() {
		this.addMenu(new Menu("/edittable", "Edit table", "ja\tテーブル編集"));

	}
	
	/**
	 * ページ追加コード生成フラグを取得します。
	 * @return ページ追加コード生成フラグ。
	 */
	@Override
	public Boolean genAddPageCode() {
		return false;	
	}
	
	
	/**
	 * アプリケーションのページを追加します。
	 */
	public void addAppPage() {

		this.readAppPageList(); // 
	}
}
