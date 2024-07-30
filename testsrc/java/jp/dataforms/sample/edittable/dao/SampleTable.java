package sample.dao;

import java.util.Map;
import dataforms.dao.Table;
import sample.field.SampleDateField;
import sample.field.SampleTextField;
import sample.field.SampleNumericField;
import dataforms.util.NumberUtil;
import sample.field.SampleIdField;


/**
 * サンプルテーブルクラス。
 *
 */
public class SampleTable extends Table {
	/**
	 * コンストラクタ。
	 */
	public SampleTable() {
		this.setAutoIncrementId(true);
		this.setComment("サンプルテーブル");
		this.addPkField(new SampleIdField()).setNotNull(true); //レコードID
		this.addField(new SampleTextField()); //文字列
		this.addField(new SampleNumericField()); //数字
		this.addField(new SampleDateField()); //日付
		this.addUpdateInfoFields();
	}

	@Override
	public String getJoinCondition(final Table joinTable, final String alias) {
		SampleTableRelation r = new SampleTableRelation(this);
		return r.getJoinCondition(joinTable, alias);
	}

	/**
	 * Entity操作クラスです。
	 */
	public static class Entity extends dataforms.dao.Entity {
		/** レコードIDのフィールドID。 */
		public static final String ID_SAMPLE_ID = "sampleId";
		/** 文字列のフィールドID。 */
		public static final String ID_SAMPLE_TEXT = "sampleText";
		/** 数字のフィールドID。 */
		public static final String ID_SAMPLE_NUMERIC = "sampleNumeric";
		/** 日付のフィールドID。 */
		public static final String ID_SAMPLE_DATE = "sampleDate";

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
		public java.lang.Long getSampleId() {
			return NumberUtil.longValueObject(this.getMap().get(Entity.ID_SAMPLE_ID));
		}

		/**
		 * レコードIDを設定します。
		 * @param sampleId レコードID。
		 */
		public void setSampleId(final java.lang.Long sampleId) {
			this.getMap().put(Entity.ID_SAMPLE_ID, sampleId);
		}

		/**
		 * 文字列を取得します。
		 * @return 文字列。
		 */
		public java.lang.String getSampleText() {
			return (java.lang.String) this.getMap().get(Entity.ID_SAMPLE_TEXT);
		}

		/**
		 * 文字列を設定します。
		 * @param sampleText 文字列。
		 */
		public void setSampleText(final java.lang.String sampleText) {
			this.getMap().put(Entity.ID_SAMPLE_TEXT, sampleText);
		}

		/**
		 * 数字を取得します。
		 * @return 数字。
		 */
		public java.math.BigDecimal getSampleNumeric() {
			return (java.math.BigDecimal) this.getMap().get(Entity.ID_SAMPLE_NUMERIC);
		}

		/**
		 * 数字を設定します。
		 * @param sampleNumeric 数字。
		 */
		public void setSampleNumeric(final java.math.BigDecimal sampleNumeric) {
			this.getMap().put(Entity.ID_SAMPLE_NUMERIC, sampleNumeric);
		}

		/**
		 * 日付を取得します。
		 * @return 日付。
		 */
		public java.sql.Date getSampleDate() {
			return (java.sql.Date) this.getMap().get(Entity.ID_SAMPLE_DATE);
		}

		/**
		 * 日付を設定します。
		 * @param sampleDate 日付。
		 */
		public void setSampleDate(final java.sql.Date sampleDate) {
			this.getMap().put(Entity.ID_SAMPLE_DATE, sampleDate);
		}


	}
	/**
	 * レコードIDフィールドを取得します。
	 * @return レコードIDフィールド。
	 */
	public SampleIdField getSampleIdField() {
		return (SampleIdField) this.getField(Entity.ID_SAMPLE_ID);
	}

	/**
	 * 文字列フィールドを取得します。
	 * @return 文字列フィールド。
	 */
	public SampleTextField getSampleTextField() {
		return (SampleTextField) this.getField(Entity.ID_SAMPLE_TEXT);
	}

	/**
	 * 数字フィールドを取得します。
	 * @return 数字フィールド。
	 */
	public SampleNumericField getSampleNumericField() {
		return (SampleNumericField) this.getField(Entity.ID_SAMPLE_NUMERIC);
	}

	/**
	 * 日付フィールドを取得します。
	 * @return 日付フィールド。
	 */
	public SampleDateField getSampleDateField() {
		return (SampleDateField) this.getField(Entity.ID_SAMPLE_DATE);
	}


}
