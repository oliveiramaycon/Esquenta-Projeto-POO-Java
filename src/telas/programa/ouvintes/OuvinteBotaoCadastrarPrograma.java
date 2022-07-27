package telas.programa.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;

import modelo.canal.Canal;
import modelo.exceptions.FalhaNoCadastroException;
import modelo.exceptions.RegistroNaoEncontradoException;
import modelo.programa.ProgramaDeTv;
import modelo.programa.ProgramasContinuos;
import modelo.programa.RealityShows;
import modelo.programa.SeriesRegulares;
import modelo.programa.enums.EnumFavorito;
import modelo.programa.enums.Genero;
import modelo.programa.enums.Status;
import modelo.programa.enums.TipoPrograma;
import telas.programa.TelaNovoPrograma;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Persistencia;

public class OuvinteBotaoCadastrarPrograma implements ActionListener{

	private TelaNovoPrograma telaPrograma;
	
	public OuvinteBotaoCadastrarPrograma(TelaNovoPrograma telaPrograma) {
		this.telaPrograma = telaPrograma;
	}
	
	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral("central");
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//COLOCANDO OS VALORES DO PROGRAMA DE TV
		TipoPrograma tipoPrograma = null;
		String nomeDoPrograma = telaPrograma.getTfNome().getText();
		String canalDeTransmissao = (String) telaPrograma.getCanais().getSelectedItem();
		Genero genero = (Genero) telaPrograma.getGeneros().getSelectedItem();
		Status status = (Status) telaPrograma.getStatus().getSelectedItem();
		ArrayList<String> apresentadores = new ArrayList<>();
		Canal canal = null;
		try {
			canal= central.recuperarCanalPeloNome(canalDeTransmissao);
		} catch (RegistroNaoEncontradoException e1) {
			Componentes.msgFalha(telaPrograma, e1.getMessage());
		}
		
		EnumFavorito favoritado = EnumFavorito.NAO_FAVORITO;
		if(telaPrograma.getFavoritado().isSelected()) {
			favoritado = EnumFavorito.FAVORITO;
		}
		String[] apresentadoresArray = telaPrograma.getApresentadores().getText().split(", ");
		for(String nome: apresentadoresArray)
			apresentadores.add(nome);
		
		String temporada =  telaPrograma.getTfTemporada().getText();
		ProgramaDeTv programa = null;
		if(telaPrograma.getRb1().isSelected()) {
			tipoPrograma = TipoPrograma.SERIES_REGULARES;
//		 programa = new SeriesRegulares(nomeDoPrograma,
//				null, canal, genero, status, temporada);
		 }
		else if(telaPrograma.getRb2().isSelected()) {
			tipoPrograma = TipoPrograma.REALITY_SHOW;
//			programa = new RealityShows(nomeDoPrograma, null, canal, canalDeTransmissao,
//					status, temporada,apresentadores );
		}
		else {
			tipoPrograma = TipoPrograma.PROGRAMA_CONTINUO;
//			programa = new ProgramasContinuos (nomeDoPrograma, null, canal, canalDeTransmissao,
//					status, temporada,apresentadores );
		}
		programa.setFavorito(favoritado);
		try {
			central.AdicionarProgramaDeTv(programa);
			persistencia.salvarCentral(central, "central");
			Componentes.msgSucesso(telaPrograma, "Canal cadastrado com sucesso!");
		} catch (FalhaNoCadastroException exception) {
			Componentes.msgFalha(telaPrograma, exception.getMessage());
		}
	}

}
