package telas;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import modelo.usuario.Usuario;
import telas.ouvintes.OuvinteTelaHome;
import telas.programa.TelaListagemProgramas;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.GeradorDePdf;
import utilidades.Icones;
import utilidades.Imagens;
import utilidades.Medidas;
import utilidades.Mensageiro;
import utilidades.Persistencia;

public class TelaHome extends TelaPadrao {

	private Usuario usuarioLogado;

	public TelaHome(Usuario usuarioLogado) {
		super("Home");
		this.usuarioLogado = usuarioLogado;
		setSize(770, 700);
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	@Override
	public void adicionarComponentesGraficos() {
		adicionarBackground();
		adicionarBotoes();
		adiconarLabels();

	}

	private void adicionarBackground() {
		JLabel background = new JLabel(Imagens.BACKGROUND_TELA_HOME);
		setContentPane(background);
	}

	public void adicionarBotoes() {

		JMenuBar barraMenu = Componentes.addJMenubar(this, 600, 0, 80, 80);
		JMenu menu = Componentes.addJMenuComIcone(barraMenu, Icones.ENGRENAGEM);
		menu.setToolTipText("op��es");

		JMenuItem perfil = Componentes.addItemNoMenu(menu, "Sair");

		JPanel painel = new JPanel(new GridLayout(2, 4, 1, 5));
		painel.setBackground(Color.decode("#fff4e2"));

		OuvinteTelaHome ouvinteTelaHome = new OuvinteTelaHome(this);
		JButton botaoProgramas = Componentes.adicionarJButton(painel, "Programas", Imagens.BANNER_PROGRAMA, 0, 0, 0, 0);
		botaoProgramas.addActionListener(ouvinteTelaHome);
		JButton botaoCanais = Componentes.adicionarJButton(painel, "Canais", Imagens.BANNER_CANAL, 0, 0, 0, 0);
		botaoCanais.addActionListener(ouvinteTelaHome);
		
		JButton botaoEnviarEmail = Componentes.addJButton(this, "Enviar E-mail", 130, 40, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		botaoEnviarEmail.addActionListener(new OuvinteBotaoEmail());
		
		painel.setBounds(130, 100, 528, 520);
		add(painel);
	}
	private class OuvinteBotaoEmail implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			GeradorDePdf geradorDePdf = new GeradorDePdf();
			geradorDePdf.ObterProgramacao(usuarioLogado);
			Mensageiro.enviarEmail(usuarioLogado);
		}
		
	}
	private class OuvinteBotaoPrograma implements ActionListener {
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral("central");

		public void actionPerformed(ActionEvent e) {
			// TODO: ACHAR UMA FORMA DE RESGATAR O USUARIO ATIVO
			dispose();
			new TelaListagemProgramas(central.getUsuariosCadastrados().get(0));
		}

	}

	public void adiconarLabels() {
		Componentes.addJLabel(this, "BEM VINDO(a)", 318, 20, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "User Name Here", 318, 40, Medidas.COMPRIMENTO_310, Medidas.ALTURA_30);

	}
	// remover caso seja necess�rio e utilizar outro esquema

}
