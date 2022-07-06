package telas.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import excecoes.RegistroExistenteException;
import modelo.Canal;
import telas.TelaNovoCanal;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Persistencia;

public class OuvinteBotaoCadastrarCanal implements ActionListener {

	private TelaNovoCanal telaCanal;
	
	public OuvinteBotaoCadastrarCanal(TelaNovoCanal telaCanal) {
		this.telaCanal = telaCanal;
	}
	
	
	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral("central");
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String nomeCanal = telaCanal.getTfNome().getText();
		String tipoCanal = telaCanal.getTfTipo().getText();
		
		Canal canal = new Canal(nomeCanal, tipoCanal);
		
		try {
			central.adicionarCanal(canal);
			//System.out.println("Canal cadastrado com sucesso!\n");
			persistencia.salvarCentral(central, "central");
			Componentes.msgSucesso(telaCanal, "Canal cadastrado com sucesso!");
		} catch (RegistroExistenteException exception) {
			//System.out.println(exception.getMessage());
			Componentes.msgFalha(telaCanal, exception.getMessage());
		}
	}

	

}
