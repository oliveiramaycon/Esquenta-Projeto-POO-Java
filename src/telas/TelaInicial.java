package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import telas.ouvintes.OuvintBotoesTelaInicial;
import telas.ouvintes.OuvinteBotaoEntrar;
import telas.ouvintes.OuvinteLabelLink;
import telas.usuario.TelaCadastroDeUsuario;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Imagens;
import utilidades.Medidas;
import utilidades.OutlineJLabel;
import utilidades.Persistencia;

public class TelaInicial extends TelaPadrao {
	private JTextField tfLogin;
	private JPasswordField tfSenha;

	public JTextField getTfLogin() {
		return tfLogin;
	}

	public void setTfLogin(JTextField tfLogin) {
		this.tfLogin = tfLogin;
	}

	
	
	
	public JPasswordField getTfSenha() {
		return tfSenha;
	}

	public void setTfSenha(JPasswordField tfSenha) {
		this.tfSenha = tfSenha;
	}

	
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
		JLabel background = new JLabel(Imagens.BACKGROUND_TELA_LOGIN);
		setContentPane(background);
	}

	public class OuvinteTelaCadastro implements ActionListener{
		TelaInicial telaInicial;
		
		public OuvinteTelaCadastro(TelaInicial telaInicial) {
			this.telaInicial = telaInicial;
			
		}


		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");
		
		
		public void actionPerformed(ActionEvent e) {
			
			if(central.getUsuariosCadastrados().size() == 0) {
				telaInicial.dispose();
				new TelaCadastroDeUsuario();
			}
			}
			
		
		
	}
	
	
	public void adicionarBotoes() {
		OuvinteBotaoEntrar ouvinteBotaoEntrar = new OuvinteBotaoEntrar(this);
		JButton botaoEntrar = Componentes.addJButton(this, "Entrar", 575, 490, Medidas.COMPRIMENTO_130,
				Medidas.ALTURA_30);
		botaoEntrar.addActionListener(ouvinteBotaoEntrar);

		OuvinteTelaCadastro ouvinteTelaCadastro = new OuvinteTelaCadastro(this);
		OuvintBotoesTelaInicial ouvinteBotoesTelaInicial = new OuvintBotoesTelaInicial(this);
		JButton botaoCadastrese = Componentes.addJButton(this, "Cadastre-se", 713, 410, Medidas.COMPRIMENTO_130,
				Medidas.ALTURA_30);
		botaoCadastrese.addActionListener(ouvinteTelaCadastro);
	}

	private void adicionarLabels() {
		Componentes.addJLabel(this, "Login", 550, 205, 70, 30);
		Componentes.addJLabel(this, "Senha", 550, 297, 70, 30);

		OutlineJLabel label = Componentes.addJLabel(this, "Esqueceu a senha?", 550, 367, 200, Medidas.ALTURA_30);
		OuvinteLabelLink ouvinteLink = new OuvinteLabelLink(this, label);
		label.addMouseListener(ouvinteLink);
		
	}

	public void adicionarTextFields() {
		
		tfLogin = Componentes.addJTextField(this, 550, 232, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		
		tfSenha  = Componentes.addJPswordField(this, 550, 332, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
	}

}

