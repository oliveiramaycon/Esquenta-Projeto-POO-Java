package telas.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import telas.TelaHome;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Persistencia;

public class OuvinteBotaoExcluirUsuario implements ActionListener {
	
	private TelaHome telaHome;

	
		public OuvinteBotaoExcluirUsuario(TelaHome telaHome) {
			this.telaHome = telaHome;
		}
	
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral("central");
	
	public void actionPerformed(ActionEvent e) {
		
		central.removerDados(0);
		p.salvarCentral(central, "central");
		Componentes.msgSucesso(telaHome, "Usuario Excluido com Sucesso!!");
	} 
	
	
}
