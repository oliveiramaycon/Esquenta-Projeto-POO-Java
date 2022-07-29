package telas.programa.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import telas.programa.TelaListagemProgramas;
import telas.programa.TelaNovoPrograma;

public class OuvinteBotaoAdicionarPrograma implements ActionListener{

	private TelaListagemProgramas telaListagem; 
	
	public OuvinteBotaoAdicionarPrograma(TelaListagemProgramas tela) {
		telaListagem = tela;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		telaListagem.dispose();
//		new TelaNovoPrograma(telaListagem.getUsuario());
		new TelaListagemProgramas(telaListagem.getUsuario());
	}

}
