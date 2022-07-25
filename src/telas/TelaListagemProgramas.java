package telas;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JTextField;

import modelo.usuario.Usuario;
import telas.ouvintes.OuvinteBotaoAdicionarPrograma;
import telas.ouvintes.OuvinteBotaoDetalhesPrograma;
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
	private JTable tabelaListagem;
	private JTextField pesquisa;
	private JButton botaoAddPrograma;
	private JButton botaoDetalhes;
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public TelaListagemProgramas(Usuario usuario) {
		super("Listagem de programas");
		this.usuario = usuario;
		addTabela();
	}
	
	public void adicionarComponentesGraficos() {
		adicionarBackground();
		adicionarBotoes();
		adicionarLabels();
		adicionarBotoes();
		addTextField();
	}

	private void adicionarBotoes() {
		
		botaoAddPrograma = Componentes.addJButton(this, "", Icones.ADICIONAR, 645, 70, 30, Medidas.ALTURA_30);
		OuvinteBotaoAdicionarPrograma addPrograma = new OuvinteBotaoAdicionarPrograma(this);
		botaoAddPrograma.addActionListener(addPrograma);
		botaoAddPrograma.setToolTipText("Novo Programa");
		
		botaoDetalhes = Componentes.addJButton(this,"detalhes",Icones.ADICIONAR, 685, 70, 30, Medidas.ALTURA_30);
		OuvinteBotaoDetalhesPrograma ouvinteDetalhes = new OuvinteBotaoDetalhesPrograma(this);
		botaoDetalhes.addActionListener(ouvinteDetalhes);
	}
	
	private void adicionarBackground() {
		JLabel background = new JLabel(Imagens.BACKGROUND_TELA_LISTA_DE_CANAIS);
		setContentPane(background);
	}
	
	private void addTextField() {
		pesquisa = Componentes.addJTextField(this, 30, 75, Medidas.COMPRIMENTO_310, 25);
		pesquisa.setForeground(Color.GRAY);
		pesquisa.setToolTipText("busque um programa");
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
	
	private void addTabela() {
		tabelaListagem = Componentes.addTabelaTodosProgramas(this, this.usuario,
				pesquisa, 30, 105, 685, 305);
	}	
}
