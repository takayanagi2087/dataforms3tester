package sample.dao;

import java.util.Map;

import dataforms.dao.Query;
import dataforms.field.base.FieldList;
import dataforms.field.sqlfunc.CountField;
import dataforms.field.sqltype.BigintField;
import dataforms.util.NumberUtil;
import sample.field.Code1Field;




/**
 * 問い合わせクラスです。
 *
 */
public class MultiTestCode1Query extends Query {
	/**
	 * 複数レコード編集テスト。
	 */
	private MultiTestTable multiTestTable = null;

	/**
	 * 複数レコード編集テストを取得します。
	 * @return 複数レコード編集テスト。
	 */
	public MultiTestTable getMultiTestTable() {
		return this.multiTestTable;
	}


	/**
	 * コンストラクタ.
	 */
	public MultiTestCode1Query() {
		this.setComment("Code1の一覧を取得する問い合わせ");
		this.setDistinct(false);
		this.multiTestTable = new MultiTestTable();
		this.multiTestTable.setAlias("m");

		this.setFieldList(new FieldList(
			this.multiTestTable.getCode1Field()
			, new CountField("multiTestId", this.multiTestTable.getMultiTestIdField())
		));
		this.setMainTable(multiTestTable);

	}

	/**
	 * Entity操作クラスです。
	 */
	public static class Entity extends dataforms.dao.Entity {
		/** レコードIDのフィールドID。 */
		public static final String ID_MULTI_TEST_ID = "multiTestId";
		/** コード1のフィールドID。 */
		public static final String ID_CODE1 = "code1";

		/**
		 * コンストラクタ。
		 */
		public Entity() {

		}
		/**
		 * コンストラクタ。
		 * @param map 操作対象マップ。
		 */
		public Entity(final Map<String, Object> map) {
			super(map);
		}
		/**
		 * レコードIDを取得します。
		 * @return レコードID。
		 */
		public java.lang.Long getMultiTestId() {
			return NumberUtil.longValueObject(this.getMap().get(Entity.ID_MULTI_TEST_ID));
		}

		/**
		 * レコードIDを設定します。
		 * @param multiTestId レコードID。
		 */
		public void setMultiTestId(final java.lang.Long multiTestId) {
			this.getMap().put(Entity.ID_MULTI_TEST_ID, multiTestId);
		}

		/**
		 * コード1を取得します。
		 * @return コード1。
		 */
		public java.lang.String getCode1() {
			return (java.lang.String) this.getMap().get(Entity.ID_CODE1);
		}

		/**
		 * コード1を設定します。
		 * @param code1 コード1。
		 */
		public void setCode1(final java.lang.String code1) {
			this.getMap().put(Entity.ID_CODE1, code1);
		}


	}

	/**
	 * レコードIDフィールドを取得します。
	 * @return レコードIDフィールド。
	 */
	public BigintField getMultiTestIdField() {
		return (BigintField) this.getField(Entity.ID_MULTI_TEST_ID);
	}

	/**
	 * コード1フィールドを取得します。
	 * @return コード1フィールド。
	 */
	public Code1Field getCode1Field() {
		return (Code1Field) this.getField(Entity.ID_CODE1);
	}


}