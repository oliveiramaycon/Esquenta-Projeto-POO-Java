package telas.programa.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.programa.ProgramaDeTv;
import telas.programa.TelaDetalhePrograma;
import telas.programa.TelaListagemProgramas;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Persistencia;

public class OuvinteBotaoDetalhesPrograma implements ActionListener {

	private TelaListagemProgramas tela;

	public OuvinteBotaoDetalhesPrograma(TelaListagemProgramas tela) {

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
			p.salvarCentral(central, "central");
			tela.dispose();
			new TelaDetalhePrograma(indexLinha, programa, tela.getUsuario());

		}
	}

}
