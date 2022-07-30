package telas.programa;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import modelo.usuario.Usuario;
import telas.TelaPadrao;
import telas.ouvintes.OuvinteBotaoVoltarParaHome;
import telas.programa.ouvintes.OuvinteBotaoAdicionarPrograma;
import telas.programa.ouvintes.OuvinteBotaoDetalhesPrograma;
import telas.programa.ouvintes.OuvinteMenu;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Icones;
import utilidades.Imagens;
import utilidades.Medidas;
import utilidades.OutlineJLabel;
import utilidades.Persistencia;

public class TelaListagemProgramas extends TelaPadrao {

	private Usuario usuario;
	private OutlineJLabel lbTitulo;
	private JButton botaoAddPrograma;
	private JButton botaoDetalhes;
	private JRadioButton favorito;
	private JComboBox<String> canais;
	private JComboBox<String> tipo;
	private JComboBox<String> status;
	private JTextField pesquisa;
	private JTable tabelaListagem;
	private DefaultTableModel modelo;

	public OutlineJLabel getLbTitulo() {
		return lbTitulo;
	}

	public JButton getBotaoAddPrograma() {
		return botaoAddPrograma;
	}

	public JButton getBotaoDetalhes() {
		return botaoDetalhes;
	}

	public JTextField getPesquisa() {
		return pesquisa;
	}

	public JTable getTabelaListagem() {
		return tabelaListagem;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public TelaListagemProgramas(Usuario usuario) {
		super("Listagem de programas");
		this.usuario = usuario;
		addTabela();
		adicionarBotoes();
	}

	public void adicionarComponentesGraficos() {
		adicionarBackground();
		adicionarMenu();
		adicionarLabels();
		addTextField();
		addRadioButton();
		addComboBox();
	}

	private void adicionarMenu() {
		JMenuBar menuBar = Componentes.addMenuPadrao(this);
		JMenu menu = menuBar.getMenu(0);

		OuvinteMenu ouvinteMenu = new OuvinteMenu(this);

		JMenuItem programacao = Componentes.addItemNoMenu(menu, "Receber programacao");
		programacao.addActionListener(ouvinteMenu);

		JMenuItem relatorio = Componentes.addItemNoMenu(menu, "Emitir Relatorio");
		relatorio.addActionListener(ouvinteMenu);
	}

	private void adicionarBotoes() {

		botaoAddPrograma = Componentes.addJButton(this, "Programa", Icones.ADICIONAR, 760, 490, 100, Medidas.ALTURA_30);
		OuvinteBotaoAdicionarPrograma addPrograma = new OuvinteBotaoAdicionarPrograma(this);
		botaoAddPrograma.addActionListener(addPrograma);

		botaoDetalhes = Componentes.addJButton(this, "detalhes", 600, 490, 100, Medidas.ALTURA_30);
		OuvinteBotaoDetalhesPrograma ouvinteDetalhes = new OuvinteBotaoDetalhesPrograma(this);
		botaoDetalhes.addActionListener(ouvinteDetalhes);

		JButton botaoVoltar = Componentes.addJButton(this, "Voltar", Icones.VOLTAR, 20, 20, Medidas.COMPRIMENTO_50,
				Medidas.ALTURA_30);
		botaoVoltar.addActionListener(new OuvinteBotaoVoltarParaHome(this, usuario));

	}

	private void adicionarBackground() {
		JLabel background = new JLabel(Imagens.BACKGROUND_TELA_LISTAGEM);
		setContentPane(background);
	}

	private void addTextField() {
		pesquisa = Componentes.addJTextFieldComIcone(this, Icones.LUPA, 30, 100, Medidas.COMPRIMENTO_310, 25);
		pesquisa.setForeground(Color.GRAY);
	}

	private void adicionarLabels() {
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral("central");
		lbTitulo = Componentes.addJLabel(this, "Programas", 390, 20, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		lbTitulo.setOutlineColor(Color.WHITE);
		Componentes.addJLabel(this, "Programas cadastrados: " + central.getProgramas().size(), 30, 490, 400,
				Medidas.ALTURA_30);
	}

	private void addComboBox() {
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral("central");
		String espacoVazio = "";
		ArrayList<String> statusTxt = central.obterTiposDeStatus();
		statusTxt.add(0, espacoVazio);
		status = Componentes.inserirComboBox(this, statusTxt, 520, 95, 100, Medidas.ALTURA_30);
		ArrayList<String> tiposTxt = central.obterTiposDeProgramas();
		tiposTxt.add(0, espacoVazio);
		tipo = Componentes.inserirComboBox(this, tiposTxt, 635, 95, 120, 30);
		ArrayList<String> canaisTxt = central.obterCanaisNome();
		canaisTxt.add(0, espacoVazio);
		canais = Componentes.inserirComboBox(this, canaisTxt, 635, 65, 120, 30);

	}

	private void addRadioButton() {
		favorito = Componentes.addRadioButton(this, "favoritos", 430, 95, 80, Medidas.ALTURA_30);
	}

	private void addTabela() {
		this.tabelaListagem = Componentes.addTabelaTodosProgramas(this, this.usuario, this.pesquisa, 30, 130, 790, 305);
	}
}
