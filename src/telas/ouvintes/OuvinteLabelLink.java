package telas.ouvintes;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;




public class OuvinteLabelLink implements MouseListener {

	private JFrame tela;
	private JLabel label;
	private String labelTextFlag;
	
	public OuvinteLabelLink(JFrame tela, JLabel label) {
		this.tela = tela;
		this.label = label;
		this.labelTextFlag = label.getText();
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//todo: lógica executada ao clicar no label
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        tela.setCursor(cursor);
        
		label.setText("<html><u>"+labelTextFlag+"</u></html>");
	}

	
	@Override
	public void mouseExited(MouseEvent e) {
		Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
        tela.setCursor(cursor);
        
		label.setText(labelTextFlag);
	}

}
