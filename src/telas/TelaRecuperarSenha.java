package telas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import telas.ouvintes.OuvinteDoButaoNovaSenha;
import utilidades.Componentes;
import utilidades.Medidas;

public class TelaRecuperarSenha extends TelaPadrao {
	TelaInicial tela;
	private JTextField tfSenha;
	private JTextField tfConfirmacaoSenha;
	private JTextField tfTestarLogin;
	
	
	// O FIZ ASSIM PARA SETAR O TAMANHO DA TELA DE FORMA DIFERENTE:
	public TelaRecuperarSenha() {
		super("Tela de Recuperar senha");
		setSize(500, 400);
		addLookAndFeel();
		adicionarComponentesGraficos();
		setVisible(true);
	}

	
	public void adicionarComponentesGraficos() {
		adicionarLabel();
		adicionarTextField();
		adicionarBotoes();
	}
	
	private void adicionarLabel() {
		Componentes.addJLabel(this, "Senha:", 110, 60, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Confirme a senha:", 110, 120, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Confirme login:", 110, 220, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		}
	
	private void adicionarTextField() {
		tfSenha = Componentes.addJTextField(this, 110, 85,Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		tfConfirmacaoSenha = Componentes.addJTextField(this, 110, 145,Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		tfTestarLogin =  Componentes.addJTextField(this, 110, 245,Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
	}

	private void adicionarBotoes() {
		OuvinteDoButaoNovaSenha novaSenha = new OuvinteDoButaoNovaSenha(this);
		JButton botaoCadastrar = Componentes.addJButton(this, "Senha Nova", 180, 280, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		botaoCadastrar.addActionListener(novaSenha);
	}
	
	public void addLookAndFeel() {
		try {
			 //AQUI VOCÊ SETA O NOME DA CLASSE REFERENTE A CADA TEMA !

			String tema = "com.jtattoo.plaf.mint.MintLookAndFeel";

			// AQUI VC SETA O LOOK AND FEEL
			UIManager.setLookAndFeel(tema);
		} catch (InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException
				| ClassNotFoundException e) {
			System.out.println("Erro LAF : " + e.getMessage());
		}
	}
	


	public JTextField getTfTestarLogin() {
		return tfTestarLogin;
	}


	public void setTfTestarLogin(JTextField tfTestarLogin) {
		this.tfTestarLogin = tfTestarLogin;
	}


	public JTextField getTfSenha() {
		return tfSenha;
	}

	public void setTfSenha(JTextField tfSenha) {
		this.tfSenha = tfSenha;
	}

	public JTextField getTfConfirmacaoSenha() {
		return tfConfirmacaoSenha;
	}

	public void setTfConfirmacaoSenha(JTextField tfConfirmacaoSenha) {
		this.tfConfirmacaoSenha = tfConfirmacaoSenha;
	}
// FIM DA CLASSE.
}
