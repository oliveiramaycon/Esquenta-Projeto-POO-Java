package telas.ouvintes;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class OuvinteHandCursor implements MouseListener {

	private JButton botao;

	public OuvinteHandCursor(JButton botao) {
		super();
		this.botao = botao;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		botao.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

	}

}
