package utilidades;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
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
	
	public static JMenuBar addJMenubar(JFrame janela,int x,int y, int comprimento, int altura) {
		JMenuBar barraMenu = new JMenuBar();
		barraMenu.setBounds(x, y, comprimento, altura);
		barraMenu.setBackground(Color.BLACK);
		barraMenu.setForeground(Color.black);
		janela.add(barraMenu);
		return barraMenu;
	}
	public static JMenu addJMenuComIcone(JMenuBar barraDeMenu,ImageIcon icone) {
		JMenu menu = new JMenu();
		menu.setIcon(icone);
		barraDeMenu.add(menu);
		return menu;
	}
	
	public static JMenuItem addItemNoMenu(JMenu menu, String nome) {
		JMenuItem item = new JMenuItem(nome);
		menu.add(item);
		return item;
		
	}
	public static void msgFalha(JFrame janela, String msg) {
		JOptionPane.showMessageDialog(janela, msg, "Erro", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void msgSucesso(JFrame janela, String msg) {
		JOptionPane.showMessageDialog(janela, msg, "Sucesso", JOptionPane.OK_OPTION,Icones.ENGRENAGEM); ////mudar icone(setinha)
	}
	
	public static JComboBox<String> inserirComboBox(JFrame tela, ArrayList<String> dados, int x,int y, int comprimento, int altura) {
		
		Vector<String> tiposDeProgramas = new Vector<String>(dados);
		
		JComboBox<String> cbTipos = new JComboBox<String>(tiposDeProgramas);
		cbTipos.setBounds(x, y, comprimento, altura);
		tela.add(cbTipos);
		return cbTipos;
	}
	
	public static JRadioButton addRadioButton(JFrame tela, String nome, int x, int y, int comprimento, int altura) {
		JRadioButton radioBotao = new JRadioButton(nome);
		radioBotao.setBounds(x,y,comprimento,altura);
		tela.add(radioBotao);
		return radioBotao;
		
	}
}
