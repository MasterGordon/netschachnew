package schach.client;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CanvasBrett extends Canvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1375846019352363516L;
	String figures = "";

	public CanvasBrett(String figures) {
		this.figures = figures;
		setSize(512, 512);
		setBackground(Color.white);
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.decode("#25274D"));
		g2.fillRect(64, 0, 64, 64);
		g2.fillRect(64 * 3, 0, 64, 64);
		g2.fillRect(64 * 5, 0, 64, 64);
		g2.fillRect(64 * 7, 0, 64, 64);
		g2.fillRect(64, 64 * 2, 64, 64);
		g2.fillRect(64 * 3, 64 * 2, 64, 64);
		g2.fillRect(64 * 5, 64 * 2, 64, 64);
		g2.fillRect(64 * 7, 64 * 2, 64, 64);
		g2.fillRect(64, 64 * 4, 64, 64);
		g2.fillRect(64 * 3, 64 * 4, 64, 64);
		g2.fillRect(64 * 5, 64 * 4, 64, 64);
		g2.fillRect(64 * 7, 64 * 4, 64, 64);
		g2.fillRect(64, 64 * 6, 64, 64);
		g2.fillRect(64 * 3, 64 * 6, 64, 64);
		g2.fillRect(64 * 5, 64 * 6, 64, 64);
		g2.fillRect(64 * 7, 64 * 6, 64, 64);

		g2.fillRect(0, 64, 64, 64);
		g2.fillRect(64 * 2, 64, 64, 64);
		g2.fillRect(64 * 4, 64, 64, 64);
		g2.fillRect(64 * 6, 64, 64, 64);
		g2.fillRect(0, 64 * 3, 64, 64);
		g2.fillRect(64 * 2, 64 * 3, 64, 64);
		g2.fillRect(64 * 4, 64 * 3, 64, 64);
		g2.fillRect(64 * 6, 64 * 3, 64, 64);
		g2.fillRect(0, 64 * 5, 64, 64);
		g2.fillRect(64 * 2, 64 * 5, 64, 64);
		g2.fillRect(64 * 4, 64 * 5, 64, 64);
		g2.fillRect(64 * 6, 64 * 5, 64, 64);
		g2.fillRect(0, 64 * 7, 64, 64);
		g2.fillRect(64 * 2, 64 * 7, 64, 64);
		g2.fillRect(64 * 4, 64 * 7, 64, 64);
		g2.fillRect(64 * 6, 64 * 7, 64, 64);

		int index = 0;
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				if (figures.charAt(index) != '0')
					if (Character.isUpperCase(figures.charAt(index))) {
						try {
							g2.drawImage(
									ImageIO.read(new File(getClass().getResource("/resources/white_"
											+ Character.toLowerCase(figures.charAt(index)) + ".png").toURI())),
									x * 64, y * 64, null);
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						try {
							g2.drawImage(
									ImageIO.read(new File(getClass().getResource("/resources/black_"
											+ Character.toLowerCase(figures.charAt(index)) + ".png").toURI())),
									x * 64, y * 64, null);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				index++;
			}
		}
	}
}
