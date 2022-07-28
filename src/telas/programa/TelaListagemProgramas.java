package telas.programa;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import modelo.usuario.Usuario;
import telas.TelaHome;
import telas.TelaPadrao;
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
	private JRadioButton Favorito;
	private JTextField pesquisa;	
	private JTable tabelaListagem;
	
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
	}
	
	public void adicionarComponentesGraficos() {
		adicionarBackground();
		adicionarBotoes();
		adicionarLabels();
		addTextField();
	}

	private void adicionarBotoes() {
		
		botaoAddPrograma = Componentes.addJButton(this, "", Icones.ADICIONAR, 605, 70, 30, Medidas.ALTURA_30);
		OuvinteBotaoAdicionarPrograma addPrograma = new OuvinteBotaoAdicionarPrograma(this);
		botaoAddPrograma.addActionListener(addPrograma);
		botaoAddPrograma.setToolTipText("Novo Programa");
		
		botaoDetalhes = Componentes.addJButton(this,"detalhes",Icones.ADICIONAR, 645, 70, 100, Medidas.ALTURA_30);
		OuvinteBotaoDetalhesPrograma ouvinteDetalhes = new OuvinteBotaoDetalhesPrograma(this);
		botaoDetalhes.addActionListener(ouvinteDetalhes);
		JButton botaoVoltar = Componentes.addJButton(this, "Voltar", 580, 420, Medidas.COMPRIMENTO_130,
				Medidas.ALTURA_30);
		botaoVoltar.addActionListener(new OuvinteBotaoVoltar());
	
	}
	private class OuvinteBotaoVoltar implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			dispose();
			new TelaHome();
		}
		
	}
	private void adicionarBackground() {
		JLabel background = new JLabel(Imagens.BACKGROUND_TELA_LISTA_DE_CANAIS);
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
	
	private void addTabela() {
		tabelaListagem = Componentes.addTabelaTodosProgramas(this, this.usuario,
				pesquisa, 30, 105, 685, 305);
	}	
}
