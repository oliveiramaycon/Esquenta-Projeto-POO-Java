package utilidades;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Componentes {

	public static JButton addJButton(JFrame tela, String nome, int x, int y, int comprimento, int altura) {
		JButton botao = new JButton(nome);
		botao.setBounds(x, y, comprimento, altura);
		tela.add(botao);
		return botao;
	}
	
	
	public static JLabel addJLabel(JFrame tela, String nome, int x, int y, int comprimento, int altura) {
		JLabel label = new JLabel(nome);
		label.setBounds(x, y, comprimento, altura);
		label.setFont(new Font("Arial", Font.BOLD, 18));
		tela.add(label);
		return label;
	}
	
	
	public static JTextField addJTextField(JFrame tela, int x, int y, int comprimento, int altura) {
		JTextField field = new JTextField();
		field.setBounds(x, y, comprimento, altura);
		tela.add(field);
		return field;
	}
}
