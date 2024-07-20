package jp.dataforms.test.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * 画像編集ユーティリティ。
 *
 */
public class ImageEditor {
	/**
	 * コンストラクタ。
	 */
	private ImageEditor() {
		
	}
	
	
	/**
	 * 画像ファイルに四角を追加する。
	 * @param imageFile 画像ファイル。
	 * @param x0 X座標開始。
	 * @param y0 Y座標終了。
	 * @param x1 X座標終了。
	 * @param y1 Y座標終了。
	 * @throws Exception
	 */
	public static void addMarkRect(final String imageFile, final int x0, final int y0, final int x1, final int y1) throws Exception {
		BufferedImage bi = ImageIO.read(new File(imageFile));
		Graphics2D g = (Graphics2D) bi.getGraphics();
		g.setColor(Color.RED);
		g.setStroke(new BasicStroke(4));
		g.drawRect(x0, y0, x1 - x0 + 1, y1 - y0 + 1);
		ImageIO.write(bi, "png", new File(imageFile));
	}
}
