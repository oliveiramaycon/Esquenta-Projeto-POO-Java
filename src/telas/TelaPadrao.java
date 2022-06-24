package telas;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public abstract class TelaPadrao extends JFrame {

	public TelaPadrao(String titulo) {
		setTitle(titulo);
		setSize(766, 504);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		addLookAndFeel();
		adicionarComponentesGraficos();
		
		setVisible(true);
		
	}
	
	public abstract void adicionarComponentesGraficos();

	
	public void addLookAndFeel() {
		try {
			// AQUI VOCÊ SETA O NOME DA CLASSE REFERENTE A CADA TEMA !

			String tema = "com.jtattoo.plaf.mint.MintLookAndFeel";

			// AQUI VC SETA O LOOK AND FEEL
			UIManager.setLookAndFeel(tema);
		} catch (InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException
				| ClassNotFoundException e) {
			System.out.println("Erro LAF : " + e.getMessage());
		}
	}
	
	
	
	
}
