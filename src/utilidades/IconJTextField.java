package utilidades;

import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * @author Maycon
 * @version 30/07/2022
 * 

 * 
 */	
public class IconJTextField extends JTextField {
	
	/**
	 * espacamento
	 */
	private static final int ICON_SPACING = 4;
	
	/**
	 * borda
	 */
	private Border mBorder;
	
	/**
	 * icone
	 */
	private Icon mIcon;

	@Override
	public void setBorder(Border border) {
		mBorder = border;

		if (mIcon == null) {
			super.setBorder(border);
		}

		else {
			Border margin = BorderFactory.createEmptyBorder(0, mIcon.getIconWidth() + ICON_SPACING, 0, 0);
			Border compoud = BorderFactory.createCompoundBorder(border, margin);
			super.setBorder(compoud);
		}
	}
	/**
	 * @param graphics
	 * graficos
	 */
	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		if (mIcon != null) {
			Insets iconInsets = mBorder.getBorderInsets(this);
			mIcon.paintIcon(this, graphics, iconInsets.left, iconInsets.top);
		}
	}
	/**
	 * @param icon
	 * icone que aparecera alinhado a esquerda no JTextField
	 */
	public void setIcon(Icon icon) {
		mIcon = icon;
		resetBorder();
	}

	private void resetBorder() {
		setBorder(mBorder);
	}
}
