package telas;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.usuario.Usuario;
import telas.ouvintes.OuvinteTelaHome;
import telas.programa.TelaListagemProgramas;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Imagens;
import utilidades.Medidas;
import utilidades.OutlineJLabel;
import utilidades.Persistencia;

public class TelaHome extends TelaPadrao {

	private Usuario usuarioLogado;

	public TelaHome(Usuario usuarioLogado) {
		super("Home");
		this.usuarioLogado = usuarioLogado;
		setSize(770, 700);
		adiconarLabels();
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
		adicionarMenu();
		adicionarBotoes();

	}

	private void adicionarBackground() {
		JLabel background = new JLabel(Imagens.BACKGROUND_TELA_HOME);
		setContentPane(background);
	}

	private void adicionarMenu() {
		Componentes.addMenuPadrao(this).setBounds(719, 0, 45, 30);
	}

	private void adicionarBotoes() {

		JPanel painel = new JPanel(new GridLayout(2, 4, 1, 5));
		painel.setBackground(Color.decode("#fff4e2"));

		OuvinteTelaHome ouvinteTelaHome = new OuvinteTelaHome(this);
		JButton botaoProgramas = Componentes.adicionarJButton(painel, "Programas", Imagens.BANNER_PROGRAMA, 0, 0, 0, 0);
		botaoProgramas.addActionListener(ouvinteTelaHome);
		JButton botaoCanais = Componentes.adicionarJButton(painel, "Canais", Imagens.BANNER_CANAL, 0, 0, 0, 0);
		botaoCanais.addActionListener(ouvinteTelaHome);

		painel.setBounds(130, 100, 528, 520);
		add(painel);
	}

	private class OuvinteBotaoPrograma implements ActionListener {
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral("central");

		public void actionPerformed(ActionEvent e) {
			dispose();
			new TelaListagemProgramas(central.getUsuariosCadastrados().get(0));
		}

	}

	private void adiconarLabels() {

		Componentes.addJLabel(this, "BEM VINDO (a)", 318, 20, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30)
				.setOutlineColor(Color.WHITE);
		OutlineJLabel lbUsuario = Componentes.addJLabel(this, usuarioLogado.getNome(), 318, 40, Medidas.COMPRIMENTO_310,
				Medidas.ALTURA_30);
		lbUsuario.setOutlineColor(Color.WHITE);

	}
}
