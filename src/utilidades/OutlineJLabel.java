package utilidades;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

/**
 * @author Maycon
 * @version 30/07/2022
 * 
 * 
 * 
 */
public class OutlineJLabel extends JLabel {

	/**
	 * serial id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * cor de contorno
	 */
	private Color outlineColor = Color.GRAY.brighter();

	/**
	 * flag que marca se a contorno esta colorida
	 */
	private boolean isPaintingOutline = false;

	/**
	 * flag que marca a transparencia
	 */
	private boolean forceTransparent = false;

	/**
	 * 
	 */
	public OutlineJLabel() {
		super();
	}

	/**
	 * @param text texto do componente
	 * 
	 */
	public OutlineJLabel(String text) {
		super(text);
	}

	/**
	 * @param text                texto do componente
	 * 
	 * @param horizontalAlignment alinhamento
	 */
	public OutlineJLabel(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
	}

	/**
	 * @return retorna a cor de contorno
	 */
	public Color getOutlineColor() {
		return outlineColor;
	}

	/**
	 * @param outlineColor cor do contorno
	 */
	public void setOutlineColor(Color outlineColor) {
		this.outlineColor = outlineColor;
		this.invalidate();
	}

	@Override
	public Color getForeground() {
		if (isPaintingOutline) {
			return outlineColor;
		} else {
			return super.getForeground();
		}
	}

	@Override
	public boolean isOpaque() {
		if (forceTransparent) {
			return false;
		} else {
			return super.isOpaque();
		}
	}

	@Override
	public void paint(Graphics g) {

		String text = getText();
		if (text == null || text.length() == 0) {
			super.paint(g);
			return;
		}

		// 1 2 3
		// 8 9 4
		// 7 6 5

		if (isOpaque())
			super.paint(g);

		forceTransparent = true;
		isPaintingOutline = true;
		g.translate(-1, -1);
		super.paint(g); // 1
		g.translate(1, 0);
		super.paint(g); // 2
		g.translate(1, 0);
		super.paint(g); // 3
		g.translate(0, 1);
		super.paint(g); // 4
		g.translate(0, 1);
		super.paint(g); // 5
		g.translate(-1, 0);
		super.paint(g); // 6
		g.translate(-1, 0);
		super.paint(g); // 7
		g.translate(0, -1);
		super.paint(g); // 8
		g.translate(1, 0); // 9
		isPaintingOutline = false;

		super.paint(g);
		forceTransparent = false;

	}

}