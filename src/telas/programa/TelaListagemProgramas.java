package telas.programa;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import modelo.usuario.Usuario;
import telas.TelaPadrao;
import telas.ouvintes.OuvinteBotaoVoltarParaHome;
import telas.programa.ouvintes.OuvinteBotaoAdicionarPrograma;
import telas.programa.ouvintes.OuvinteBotaoDetalhesPrograma;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Icones;
import utilidades.Imagens;
import utilidades.Medidas;
import utilidades.OutlineJLabel;
import utilidades.Persistencia;

public class TelaListagemProgramas extends TelaPadrao{
	
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
		adicionarLabels();
		addTextField();
		addRadioButton();
		addComboBox();
	}

	private void adicionarBotoes() {
		
		botaoAddPrograma = Componentes.addJButton(this, "Programa", Icones.ADICIONAR, 330, 420, 100, Medidas.ALTURA_30);
		OuvinteBotaoAdicionarPrograma addPrograma = new OuvinteBotaoAdicionarPrograma(this);
		botaoAddPrograma.addActionListener(addPrograma);
		
		botaoDetalhes = Componentes.addJButton(this,"detalhes",Icones.ADICIONAR, 450, 420, 100, Medidas.ALTURA_30);
		OuvinteBotaoDetalhesPrograma ouvinteDetalhes = new OuvinteBotaoDetalhesPrograma(this);
		botaoDetalhes.addActionListener(ouvinteDetalhes);
		JButton botaoVoltar = Componentes.addJButton(this, "Voltar",Icones.VOLTAR, 580, 420, Medidas.COMPRIMENTO_130,
				Medidas.ALTURA_30);
		botaoVoltar.addActionListener(new OuvinteBotaoVoltarParaHome(this, usuario));
		
	
	}
	
	private void adicionarBackground() {
		JLabel background = new JLabel(Imagens.BACKGROUND_TELA_LISTAGEM);
		setContentPane(background);
	}
	
	private void addTextField() {
		pesquisa = Componentes.addJTextFieldComIcone(this, Icones.LUPA,30, 75, Medidas.COMPRIMENTO_310, 25);
		pesquisa.setForeground(Color.GRAY);
	}
	
	private void adicionarLabels() {
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral("central");
		lbTitulo = Componentes.addJLabel(this, "Programas", 330, 20, 
				Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		lbTitulo.setOutlineColor(Color.WHITE);
		Componentes.addJLabel(this, "Programas cadastrados: " + central.getProgramas().size(),
				30, 420, 400,Medidas.ALTURA_30);
	}
	
	private void addComboBox() {
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral("central");
		String espacoVazio = "";
		ArrayList<String> statusTxt = central.obterTiposDeStatus();
		statusTxt.add(0, espacoVazio);
		status = Componentes.inserirComboBox(this,statusTxt, 530, 70, 80, Medidas.ALTURA_30);
		ArrayList<String> tiposTxt= central.obterTiposDeProgramas();
		tiposTxt.add(0, espacoVazio);
		tipo = Componentes.inserirComboBox(this, tiposTxt, 625, 70, 120, 30);
		ArrayList<String> canaisTxt= central.obterCanaisNome();
		canaisTxt.add(0, espacoVazio);
		canais = Componentes.inserirComboBox(this, canaisTxt, 625, 40, 120, 30);
		
	}
	private void addRadioButton() {
		favorito  = Componentes.addRadioButton(this, "favoritos", 430, 70, 80, Medidas.ALTURA_30);
	}
	private void addTabela() {
		this.tabelaListagem = Componentes.addTabelaTodosProgramas(this, this.usuario, this.pesquisa, 30, 105, 685, 305);		}
	}	
