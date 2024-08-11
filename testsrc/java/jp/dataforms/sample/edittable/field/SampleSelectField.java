package jp.dataforms.sample.edittable.field;

import jp.dataforms.fw.field.common.EnumOptionSingleSelectField;


/**
 * SampleSelectFieldフィールドクラス。
 *
 */
public class SampleSelectField extends EnumOptionSingleSelectField {
	/**
	 * 列挙名称。
	 */
	private static final String ENUM_TYPE = "sampleSelect"; // 適切に修正して使用してください。

	/**
	 * フィールドコメント。
	 */
	private static final String COMMENT = "サンプル選択肢";

	/**
	 * コンストラクタ。
	 */
	public SampleSelectField() {
		this(null);
	}

	/**
	 * コンストラクタ。
	 * @param id フィールドID。
	 */
	public SampleSelectField(final String id) {
		super(id, ENUM_TYPE);
		this.setComment(COMMENT);
	}

	@Override
	protected void onBind() {
		super.onBind();

	}

	// 独自のWebメソッドを作成する場合は、以下のコードを参考にしてください。
	/**
	 * Webメソッドのサンプル。
	 * @param p 入力パラメータ。
	 * @return 応答情報。
	 * @throws Exception 例外。
	 */
/*
	@WebMethod
	public Response webMethod(final Map<String, Object> p) throws Exception {
		Object obj = p; // TODO:必要な処理を行い、結果オブジェクトを作成してください。
		Response resp = new JsonResponse(JsonResponse.SUCCESS, obj);
		return resp;
	}
*/

}
