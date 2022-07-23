package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.canal.Canal;
import modelo.programa.ProgramaDeTv;
import modelo.programa.enums.EnumFavorito;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Icones;
import utilidades.Medidas;
import utilidades.Persistencia;

public class TelaListagemCanal extends TelaPadrao {
	
	private JComboBox<String> combo;
	private DefaultTableModel modeloTabela;
	private String tipoCanal;
	
	public TelaListagemCanal() {
		super("Canais");
	}

	public void adicionarComponentesGraficos() {
		addBotoes();
		addLabels();
		addComboBoxFiltro();
		addTabela();
	}
	private void addBotoes() {
		JButton botaoVoltar = Componentes.addJButton(this, "Voltar", 20,
				20, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		JMenuBar barraMenu = Componentes.addJMenubar(this,  640, 80, 30, 80);
		JMenu menu = Componentes.addJMenuComIcone(barraMenu, Icones.ENGRENAGEM);
		menu.setToolTipText("opcoes");

		JMenuItem novoPrograma = Componentes.addItemNoMenu(menu, "Novo Canal");
		JMenuItem perfil = Componentes.addItemNoMenu(menu, "Sair");
	}
	private void addLabels() {
		Componentes.addJLabel(this, "Canais", 318, 85, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Filtrar", 20, 120, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
	}

	private void addComboBoxFiltro() {
		CentralDeInformacoes central = new CentralDeInformacoes();
		OuvinteFiltrarTipoCanal ouvinte = new OuvinteFiltrarTipoCanal();
		combo = Componentes.inserirComboBox(this, central.obterTiposDeCanais(), 20, 150,
				Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		combo.addActionListener(ouvinte);
	}
	

	private void addTabela() {
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral("central");
		ArrayList<Canal> ListaCanais = central.getCanais();
		modeloTabela = new DefaultTableModel();
		modeloTabela.addColumn("Canais");
		modeloTabela.addColumn("Quantidade de Programas");
		modeloTabela.addColumn("Quantidade de favoritos");
		for(Canal c : ListaCanais) {
			int contadorFavorito = 0;
			Object[] linha = new Object[3];
			linha[0] = c.getNome();
			linha[1] = c.getProgramas().size();
			for(ProgramaDeTv programa : c.getProgramas()) {
				if(programa.getFavorito() == EnumFavorito.FAVORITO)
					contadorFavorito++;
			}
			linha[2] = contadorFavorito;
			modeloTabela.addRow(linha);
		}
		
		JTable jTable = new JTable(modeloTabela);
		JScrollPane tabela = new JScrollPane(jTable);
		tabela.setBounds(275,190, 365, 200);
		add(tabela);		
	}
	private void filtro(Object filtroTipo) {
		String tipo = (String) filtroTipo;
		if(tipo.equals("")) {
			
		}
		else {
			
		int numeroLinhas = modeloTabela.getRowCount();
		for(int c = 0; c < numeroLinhas;c++)
			modeloTabela.removeRow(0);
		
		}
	}
	private class OuvinteFiltrarTipoCanal implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			filtro(combo.getSelectedItem());
				
				
//			JOptionPane.showMessageDialog(null, "vai tomar no cu cleyton");
		}

	
	}
}
