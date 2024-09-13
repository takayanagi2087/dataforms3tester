/**
 * @fileOverview {@link MultiTestQueryForm}クラスを記述したファイルです。
 */

'use strict';

import { QueryForm } from '../../dataforms/controller/QueryForm.js';

/**
 * @class MultiTestQueryForm
 *
 * @extends QueryForm
 */
export class MultiTestQueryForm extends QueryForm {
	/**
	 * コンストラクタ。
	 */
	constructor() {
		super();
	}

	/**
	 * HTMLエレメントとの対応付けを行います。
	 */
	attach() {
		super.attach();
		this.get("excelButton").click(() => {
			this.print();
			return false;
		});
		this.get("pdfButton").click(() => {
			this.printPdf();
			return false;
		});
	}

	/**
	 * Excel出力処理。
	 */
	async print() {
		if (this.validate()) {
			let r = await this.submit("print");
			this.parent.resetErrorStatus();
			if (r != null) { // downloadが正常に行われた場合nullになっている
				if (r.status == JsonResponse.SUCCESS) {
					// TODO:成功時の処理を記述します。
					// 応答情報をログ表示
					logger.dir(r);
				} else {
					this.parent.setErrorInfo(this.getValidationResult(r), this);
				}
			}
		}
	}
	
	/**
	 * PDF出力処理を呼び出します。
	 */
	async printPdf() {
		if (this.validate()) {
			let r = await this.submit("printPdf");
			this.parent.resetErrorStatus();
			if (r != null) { // downloadが正常に行われた場合nullになっている
				if (r.status == JsonResponse.SUCCESS) {
					// TODO:成功時の処理を記述します。
					// 応答情報をログ表示
					logger.dir(r);
				} else {
					this.parent.setErrorInfo(this.getValidationResult(r), this);
				}
			}
		}
	}
	
	// 独自のWebメソッドを呼び出す場合は、以下のコードを参考にしてください。
	/**
	 * Webメソッドの呼び出しサンプル。
	 *
	 */
/*
	async callWebMethod() {
		try {
			if (this.validate()) {
				let r = await this.submit("webMethod");
				this.parent.resetErrorStatus();
				if (r.status == JsonResponse.SUCCESS) {
					// TODO:成功時の処理を記述します。
					// 応答情報をログ表示
					logger.dir(r);
				} else {
					this.parent.setErrorInfo(this.getValidationResult(r), this);
				}
			}
		} catch (e) {
			currentPage.reportError(e);
		}
	}
*/


	// フォーム単位のバリデーションを行う場合は以下のコメントを参考に実装してください。
	/**
	 * フォームのバリデーション。
	 * <pre>
	 * フォーム内のフィールド関連チェックを実装します。
	 * </pre>
	 */
/*
	validateForm() {
		let list = super.validateForm();
		if (list.length == 0) {
			if (エラー判定) {
				list.push(new ValidationError("fieldId", MessagesUtil.getMessage("error.messagekey")));
			}
		}
		return list;
	}
*/

	// フォームの計算処理を行う場合、以下の処理を参考にしてください。
	/**
	 * 計算イベント処理を行います。
	 * <pre>
	 * 計算イベントフィールドが更新された場合、このメソッドが呼び出されます。
	 * データ入力時の自動計算が必要な場合このメソッドをオーバーライドしてください。
	 * </pre>
	 * @param {jQuery} element イベントが発生した要素。初期表示の時等特定フィールドが要因でない場合はnullが設定されます。
	 *
	 */
/*
	onCalc(element) {
	}
*/


	// フォームの各種動作をカスタマイズするには以下のメソッドをオーバーライドしてください。

	/**
	 * 各フィールドにデータを設定します。
	 * <pre>
	 * 新規モードの場合、削除ボタンを隠します。
	 * </pre>
	 * @param {Object} data フォームデータ.
	 *
	 */
/*
	setFormData(data) {
		super.setFormData(data);
	}
*/

	/**
	 * 問合せを行います。
	 */
/*
	query() {
		// TODO:問合せの前処理を実装してください。
		super.query();
	}
*/

	/**
	 * リセットを行います。
	 */
/*
	reset() {
		// TODO:リセットの前処理を実装してください。
		super.reset();
	}
*/


	/**
	 * エクスポートを行います。
	 */
/*
	exportData() {
		// TODO:エクスポートの前処理を実装してください。
		super.exportData();
	}
*/

}

