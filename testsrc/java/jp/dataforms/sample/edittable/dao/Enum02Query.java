package jp.dataforms.sample.edittable.dao;

import java.util.Map;

import jp.dataforms.fw.app.enumtype.dao.EnumNameTable;
import jp.dataforms.fw.app.enumtype.dao.EnumTable;
import jp.dataforms.fw.app.enumtype.field.EnumCodeField;
import jp.dataforms.fw.app.enumtype.field.EnumGroupCodeField;
import jp.dataforms.fw.app.enumtype.field.EnumIdField;
import jp.dataforms.fw.app.enumtype.field.EnumNameField;
import jp.dataforms.fw.app.enumtype.field.MemoField;
import jp.dataforms.fw.app.enumtype.field.ParentIdField;
import jp.dataforms.fw.dao.Query;
import jp.dataforms.fw.dao.Table;
import jp.dataforms.fw.field.base.FieldList;
import jp.dataforms.fw.field.common.CreateTimestampField;
import jp.dataforms.fw.field.common.CreateUserIdField;
import jp.dataforms.fw.field.common.LangCodeField;
import jp.dataforms.fw.field.common.SortOrderField;
import jp.dataforms.fw.field.common.UpdateTimestampField;
import jp.dataforms.fw.field.common.UpdateUserIdField;
import jp.dataforms.fw.field.sqlfunc.AliasField;
import jp.dataforms.fw.util.NumberUtil;


/**
 * 複雑な結合問合わせクラスです。
 *
 */
public class Enum02Query extends Query {
	/**
	 * 列挙型テーブルを取得します。
	 * @return 列挙型テーブル。
	 */
	public EnumTable getEnumTable() {
		return (EnumTable) this.getTable(EnumTable.class, "m");
	}

	/**
	 * 列挙型テーブルを取得します。
	 * @return 列挙型テーブル。
	 */
	public EnumTable getEnumTableP() {
		return (EnumTable) this.getTable(EnumTable.class, "p");
	}

	/**
	 * 列挙型名称テーブルを取得します。
	 * @return 列挙型名称テーブル。
	 */
	public EnumNameTable getEnumNameTableNm() {
		return (EnumNameTable) this.getTable(EnumNameTable.class, "nm");
	}

	/**
	 * 列挙型名称テーブルを取得します。
	 * @return 列挙型名称テーブル。
	 */
	public EnumNameTable getEnumNameTablePnm() {
		return (EnumNameTable) this.getTable(EnumNameTable.class, "pnm");
	}


	/**
	 * コンストラクタ.
	 */
	public Enum02Query() 	{
		this.setComment("複雑な結合問合わせ");
		this.setDistinct(false);
		EnumTable enumTable = new EnumTable();
		enumTable.setAlias("m");
		EnumTable enumTableP = new EnumTable();
		enumTableP.setAlias("p");
		EnumNameTable enumNameTableNm = new EnumNameTable();
		enumNameTableNm.setAlias("nm");
		EnumNameTable enumNameTablePnm = new EnumNameTable();
		enumNameTablePnm.setAlias("pnm");

		this.setFieldList(new FieldList(
			enumTable.getEnumIdField()
			, enumTable.getParentIdField()
			, enumTable.getSortOrderField()
			, enumTable.getEnumCodeField()
			, enumTable.getEnumGroupCodeField()
			, enumTable.getMemoField()
			, enumTable.getCreateUserIdField()
			, enumTable.getCreateTimestampField()
			, enumTable.getUpdateUserIdField()
			, enumTable.getUpdateTimestampField()
			, new AliasField("parentCode", enumTableP.getEnumCodeField())
			, enumNameTableNm.getLangCodeField()
			, enumNameTableNm.getEnumNameField()
			, new AliasField("parentName", enumNameTablePnm.getEnumNameField())
		));
		this.setMainTable(enumTable);
		this.addInnerJoin(enumTableP);
		this.addInnerJoin(enumNameTableNm);
		this.addInnerJoin(enumNameTablePnm, (Table table) -> {
			return this.getEnumTableP().getLinkFieldCondition(EnumTable.Entity.ID_ENUM_ID, table);
		});

	}

	/**
	 * Entity操作クラスです。
	 */
	public static class Entity extends jp.dataforms.fw.dao.Entity {
		/** 列挙型IDのフィールドID。 */
		public static final String ID_ENUM_ID = "enumId";
		/** 親IDフィールドのフィールドID。 */
		public static final String ID_PARENT_ID = "parentId";
		/** ソート順のフィールドID。 */
		public static final String ID_SORT_ORDER = "sortOrder";
		/** 列挙型コードのフィールドID。 */
		public static final String ID_ENUM_CODE = "enumCode";
		/** 列挙型グループコード.のフィールドID。 */
		public static final String ID_ENUM_GROUP_CODE = "enumGroupCode";
		/** メモのフィールドID。 */
		public static final String ID_MEMO = "memo";
		/** 作成者IDのフィールドID。 */
		public static final String ID_CREATE_USER_ID = "createUserId";
		/** 作成日時のフィールドID。 */
		public static final String ID_CREATE_TIMESTAMP = "createTimestamp";
		/** 更新者IDのフィールドID。 */
		public static final String ID_UPDATE_USER_ID = "updateUserId";
		/** 更新日時のフィールドID。 */
		public static final String ID_UPDATE_TIMESTAMP = "updateTimestamp";
		/** 列挙型コードのフィールドID。 */
		public static final String ID_PARENT_CODE = "parentCode";
		/** 言語コードのフィールドID。 */
		public static final String ID_LANG_CODE = "langCode";
		/** 列挙型名称のフィールドID。 */
		public static final String ID_ENUM_NAME = "enumName";
		/** 列挙型名称のフィールドID。 */
		public static final String ID_PARENT_NAME = "parentName";

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
		 * 列挙型IDを取得します。
		 * @return 列挙型ID。
		 */
		public java.lang.Long getEnumId() {
			return NumberUtil.longValueObject(this.getMap().get(Entity.ID_ENUM_ID));
		}

		/**
		 * 列挙型IDを設定します。
		 * @param enumId 列挙型ID。
		 */
		public void setEnumId(final java.lang.Long enumId) {
			this.getMap().put(Entity.ID_ENUM_ID, enumId);
		}

		/**
		 * 親IDフィールドを取得します。
		 * @return 親IDフィールド。
		 */
		public java.lang.Long getParentId() {
			return NumberUtil.longValueObject(this.getMap().get(Entity.ID_PARENT_ID));
		}

		/**
		 * 親IDフィールドを設定します。
		 * @param parentId 親IDフィールド。
		 */
		public void setParentId(final java.lang.Long parentId) {
			this.getMap().put(Entity.ID_PARENT_ID, parentId);
		}

		/**
		 * ソート順を取得します。
		 * @return ソート順。
		 */
		public java.lang.Short getSortOrder() {
			return NumberUtil.shortValueObject(this.getMap().get(Entity.ID_SORT_ORDER));
		}

		/**
		 * ソート順を設定します。
		 * @param sortOrder ソート順。
		 */
		public void setSortOrder(final java.lang.Short sortOrder) {
			this.getMap().put(Entity.ID_SORT_ORDER, sortOrder);
		}

		/**
		 * 列挙型コードを取得します。
		 * @return 列挙型コード。
		 */
		public java.lang.String getEnumCode() {
			return (java.lang.String) this.getMap().get(Entity.ID_ENUM_CODE);
		}

		/**
		 * 列挙型コードを設定します。
		 * @param enumCode 列挙型コード。
		 */
		public void setEnumCode(final java.lang.String enumCode) {
			this.getMap().put(Entity.ID_ENUM_CODE, enumCode);
		}

		/**
		 * 列挙型グループコード.を取得します。
		 * @return 列挙型グループコード.。
		 */
		public java.lang.String getEnumGroupCode() {
			return (java.lang.String) this.getMap().get(Entity.ID_ENUM_GROUP_CODE);
		}

		/**
		 * 列挙型グループコード.を設定します。
		 * @param enumGroupCode 列挙型グループコード.。
		 */
		public void setEnumGroupCode(final java.lang.String enumGroupCode) {
			this.getMap().put(Entity.ID_ENUM_GROUP_CODE, enumGroupCode);
		}

		/**
		 * メモを取得します。
		 * @return メモ。
		 */
		public java.lang.String getMemo() {
			return (java.lang.String) this.getMap().get(Entity.ID_MEMO);
		}

		/**
		 * メモを設定します。
		 * @param memo メモ。
		 */
		public void setMemo(final java.lang.String memo) {
			this.getMap().put(Entity.ID_MEMO, memo);
		}

		/**
		 * 作成者IDを取得します。
		 * @return 作成者ID。
		 */
		public java.lang.Long getCreateUserId() {
			return NumberUtil.longValueObject(this.getMap().get(Entity.ID_CREATE_USER_ID));
		}

		/**
		 * 作成者IDを設定します。
		 * @param createUserId 作成者ID。
		 */
		public void setCreateUserId(final java.lang.Long createUserId) {
			this.getMap().put(Entity.ID_CREATE_USER_ID, createUserId);
		}

		/**
		 * 作成日時を取得します。
		 * @return 作成日時。
		 */
		public java.sql.Timestamp getCreateTimestamp() {
			return (java.sql.Timestamp) this.getMap().get(Entity.ID_CREATE_TIMESTAMP);
		}

		/**
		 * 作成日時を設定します。
		 * @param createTimestamp 作成日時。
		 */
		public void setCreateTimestamp(final java.sql.Timestamp createTimestamp) {
			this.getMap().put(Entity.ID_CREATE_TIMESTAMP, createTimestamp);
		}

		/**
		 * 更新者IDを取得します。
		 * @return 更新者ID。
		 */
		public java.lang.Long getUpdateUserId() {
			return NumberUtil.longValueObject(this.getMap().get(Entity.ID_UPDATE_USER_ID));
		}

		/**
		 * 更新者IDを設定します。
		 * @param updateUserId 更新者ID。
		 */
		public void setUpdateUserId(final java.lang.Long updateUserId) {
			this.getMap().put(Entity.ID_UPDATE_USER_ID, updateUserId);
		}

		/**
		 * 更新日時を取得します。
		 * @return 更新日時。
		 */
		public java.sql.Timestamp getUpdateTimestamp() {
			return (java.sql.Timestamp) this.getMap().get(Entity.ID_UPDATE_TIMESTAMP);
		}

		/**
		 * 更新日時を設定します。
		 * @param updateTimestamp 更新日時。
		 */
		public void setUpdateTimestamp(final java.sql.Timestamp updateTimestamp) {
			this.getMap().put(Entity.ID_UPDATE_TIMESTAMP, updateTimestamp);
		}

		/**
		 * 列挙型コードを取得します。
		 * @return 列挙型コード。
		 */
		public java.lang.String getParentCode() {
			return (java.lang.String) this.getMap().get(Entity.ID_PARENT_CODE);
		}

		/**
		 * 列挙型コードを設定します。
		 * @param parentCode 列挙型コード。
		 */
		public void setParentCode(final java.lang.String parentCode) {
			this.getMap().put(Entity.ID_PARENT_CODE, parentCode);
		}

		/**
		 * 言語コードを取得します。
		 * @return 言語コード。
		 */
		public java.lang.String getLangCode() {
			return (java.lang.String) this.getMap().get(Entity.ID_LANG_CODE);
		}

		/**
		 * 言語コードを設定します。
		 * @param langCode 言語コード。
		 */
		public void setLangCode(final java.lang.String langCode) {
			this.getMap().put(Entity.ID_LANG_CODE, langCode);
		}

		/**
		 * 列挙型名称を取得します。
		 * @return 列挙型名称。
		 */
		public java.lang.String getEnumName() {
			return (java.lang.String) this.getMap().get(Entity.ID_ENUM_NAME);
		}

		/**
		 * 列挙型名称を設定します。
		 * @param enumName 列挙型名称。
		 */
		public void setEnumName(final java.lang.String enumName) {
			this.getMap().put(Entity.ID_ENUM_NAME, enumName);
		}

		/**
		 * 列挙型名称を取得します。
		 * @return 列挙型名称。
		 */
		public java.lang.String getParentName() {
			return (java.lang.String) this.getMap().get(Entity.ID_PARENT_NAME);
		}

		/**
		 * 列挙型名称を設定します。
		 * @param parentName 列挙型名称。
		 */
		public void setParentName(final java.lang.String parentName) {
			this.getMap().put(Entity.ID_PARENT_NAME, parentName);
		}


	}

	/**
	 * 列挙型IDフィールドを取得します。
	 * @return 列挙型IDフィールド。
	 */
	public EnumIdField getEnumIdField() {
		return (EnumIdField) this.getField(Entity.ID_ENUM_ID);
	}

	/**
	 * 親IDフィールドフィールドを取得します。
	 * @return 親IDフィールドフィールド。
	 */
	public ParentIdField getParentIdField() {
		return (ParentIdField) this.getField(Entity.ID_PARENT_ID);
	}

	/**
	 * ソート順フィールドを取得します。
	 * @return ソート順フィールド。
	 */
	public SortOrderField getSortOrderField() {
		return (SortOrderField) this.getField(Entity.ID_SORT_ORDER);
	}

	/**
	 * 列挙型コードフィールドを取得します。
	 * @return 列挙型コードフィールド。
	 */
	public EnumCodeField getEnumCodeField() {
		return (EnumCodeField) this.getField(Entity.ID_ENUM_CODE);
	}

	/**
	 * 列挙型グループコード.フィールドを取得します。
	 * @return 列挙型グループコード.フィールド。
	 */
	public EnumGroupCodeField getEnumGroupCodeField() {
		return (EnumGroupCodeField) this.getField(Entity.ID_ENUM_GROUP_CODE);
	}

	/**
	 * メモフィールドを取得します。
	 * @return メモフィールド。
	 */
	public MemoField getMemoField() {
		return (MemoField) this.getField(Entity.ID_MEMO);
	}

	/**
	 * 作成者IDフィールドを取得します。
	 * @return 作成者IDフィールド。
	 */
	public CreateUserIdField getCreateUserIdField() {
		return (CreateUserIdField) this.getField(Entity.ID_CREATE_USER_ID);
	}

	/**
	 * 作成日時フィールドを取得します。
	 * @return 作成日時フィールド。
	 */
	public CreateTimestampField getCreateTimestampField() {
		return (CreateTimestampField) this.getField(Entity.ID_CREATE_TIMESTAMP);
	}

	/**
	 * 更新者IDフィールドを取得します。
	 * @return 更新者IDフィールド。
	 */
	public UpdateUserIdField getUpdateUserIdField() {
		return (UpdateUserIdField) this.getField(Entity.ID_UPDATE_USER_ID);
	}

	/**
	 * 更新日時フィールドを取得します。
	 * @return 更新日時フィールド。
	 */
	public UpdateTimestampField getUpdateTimestampField() {
		return (UpdateTimestampField) this.getField(Entity.ID_UPDATE_TIMESTAMP);
	}

	/**
	 * 列挙型コードフィールドを取得します。
	 * @return 列挙型コードフィールド。
	 */
	public EnumCodeField getParentCodeField() {
		return (EnumCodeField) this.getField(Entity.ID_PARENT_CODE);
	}

	/**
	 * 言語コードフィールドを取得します。
	 * @return 言語コードフィールド。
	 */
	public LangCodeField getLangCodeField() {
		return (LangCodeField) this.getField(Entity.ID_LANG_CODE);
	}

	/**
	 * 列挙型名称フィールドを取得します。
	 * @return 列挙型名称フィールド。
	 */
	public EnumNameField getEnumNameField() {
		return (EnumNameField) this.getField(Entity.ID_ENUM_NAME);
	}

	/**
	 * 列挙型名称フィールドを取得します。
	 * @return 列挙型名称フィールド。
	 */
	public EnumNameField getParentNameField() {
		return (EnumNameField) this.getField(Entity.ID_PARENT_NAME);
	}



}