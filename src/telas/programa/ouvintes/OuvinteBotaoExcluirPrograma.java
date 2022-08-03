package telas.programa.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.programa.ProgramaDeTv;
import telas.programa.TelaListagemProgramas;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Persistencia;

public class OuvinteBotaoExcluirPrograma implements ActionListener {
	TelaListagemProgramas tela;
	JTable tabela;
	DefaultTableModel modelo;

	public OuvinteBotaoExcluirPrograma(TelaListagemProgramas tela) {

		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		int indexLinha = tela.getTabelaListagem().getSelectedRow();

		if (indexLinha == -1) {
			Componentes.msgFalha(tela, "Selecione um programa!");
		} else {

			Persistencia p = new Persistencia();
			CentralDeInformacoes central = p.recuperarCentral("central");
			ProgramaDeTv programa = central.getProgramas().get(indexLinha);
			central.getProgramas().remove(indexLinha);
			modelo = tela.getModelo();
			tabela = tela.getTabelaListagem();
			modelo.removeRow(indexLinha);
			tabela.repaint();
			p.salvarCentral(central, "central");
		}
	}

}
