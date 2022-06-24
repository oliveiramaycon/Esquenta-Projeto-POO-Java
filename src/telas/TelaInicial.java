package telas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import telas.ouvintes.OuvinteLabelLink;
import utilidades.Componentes;
import utilidades.Imagens;
import utilidades.Medidas;

public class TelaInicial extends TelaPadrao {


	public TelaInicial() {
		super("Bem Vindo");		
	}

	@Override
	public void adicionarComponentesGraficos() {
		adicionarBackground();
		adicionarBotoes();
		adicionarLabels();
		adicionarTextFields();
	}
	
	
	public void adicionarBackground() {
		JLabel background = new JLabel(Imagens.BACKGROUND_TELA_INICIAL);
		setContentPane(background);
	}

	
	public void adicionarBotoes() {
//		JButton botaoCatalogo = new JButton("Catálogo");
//		botaoCatalogo.setBounds(130, 360, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
//		add(botaoCatalogo);
		
	//toda essa lógica acima foi abstraída na classe Componentes
		
		Componentes.addJButton(this, "Catálogo", 130, 360, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJButton(this, "Entrar", 575, 310, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJButton(this, "Cadastre-se", 513, 415, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
	}
	
	
	private void adicionarLabels() {
		Componentes.addJLabel(this, "Login", 450, 125, 70, 30);		
		Componentes.addJLabel(this, "Senha", 450, 197, 70, 30);
		
		
		JLabel label = Componentes.addJLabel(this, "Esqueceu a senha?", 450, 267, 200, Medidas.ALTURA_30);
		OuvinteLabelLink ouvinteLink = new OuvinteLabelLink(this, label);
		label.addMouseListener(ouvinteLink);
	}
	
	
	public void adicionarTextFields() {
		Componentes.addJTextField(this, 450, 162,Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		Componentes.addJTextField(this, 450, 232,Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
	}

	
	
	
	
	
}