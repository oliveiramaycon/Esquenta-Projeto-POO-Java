package telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import telas.ouvintes.OuvintBotoesTelaInicial;
import telas.ouvintes.OuvinteBotaoEntrar;
import telas.ouvintes.OuvinteDaLabellRecuperarSenha;
import telas.ouvintes.OuvinteLabelLink;
import utilidades.Componentes;
import utilidades.Imagens;
import utilidades.Medidas;

public class TelaInicial extends TelaPadrao {
	private JTextField tfLogin;
	
	public JTextField getTfLogin() {
		return tfLogin;
	}

	public void setTfLogin(JTextField tfLogin) {
		this.tfLogin = tfLogin;
	}
		
	// CRIAR ATRIBUTO SENHA
	
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
		JButton b = Componentes.addJButton(this, "Catálogo", 130, 360, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		//b.setFont(new Font("Arial", Font.BOLD, 20));
		OuvintBotoesTelaInicial ouvinteBotoesTelaInicial = new OuvintBotoesTelaInicial(this);
		OuvinteBotaoEntrar ouvinteBotaoEntrar = new OuvinteBotaoEntrar(this);
		
		JButton botaoEntrar = Componentes.addJButton(this, "Entrar", 575, 310, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		botaoEntrar.addActionListener(ouvinteBotaoEntrar);
		JButton botaoCadastrese = Componentes.addJButton(this, "Cadastre-se", 513, 415, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		botaoCadastrese.addActionListener(ouvinteBotoesTelaInicial);
	}
	
	
	private void adicionarLabels() {
		Componentes.addJLabel(this, "Login", 450, 125, 70, 30);		
		Componentes.addJLabel(this, "Senha", 450, 197, 70, 30);
		
		
		JLabel label = Componentes.addJLabel(this, "Esqueceu a senha?", 450, 267, 200, Medidas.ALTURA_30);
		OuvinteLabelLink ouvinteLink = new OuvinteLabelLink(this, label);
		OuvinteDaLabellRecuperarSenha entradaTelaNovaSenha = new OuvinteDaLabellRecuperarSenha(this);
		label.addMouseListener(ouvinteLink);
		label.addMouseListener(entradaTelaNovaSenha);
	}
	
	
	public void adicionarTextFields() {
	tfLogin = Componentes.addJTextField(this, 450, 162,Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		Componentes.addJTextField(this, 450, 232,Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
	}
	//TODO: fazer as alterações necessárias

		
	
}