package telas.programa.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;

import modelo.canal.Canal;
import modelo.exceptions.ApresentadorJaCadastrado;
import modelo.exceptions.FalhaNoCadastroException;
import modelo.exceptions.RegistroNaoEncontradoException;
import modelo.programa.ProgramaDeTv;
import modelo.programa.ProgramasContinuos;
import modelo.programa.RealityShows;
import modelo.programa.SeriesRegulares;
import modelo.programa.enums.EnumFavorito;
import modelo.programa.enums.Estilo;
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
		
		TipoPrograma tipoPrograma = null;
		String nomeDoPrograma = telaPrograma.getTfNome().getText();
		String canalDeTransmissao = (String) telaPrograma.getCanais().getSelectedItem();
		Genero genero = Genero.valueOf((String) telaPrograma.getGeneros().getSelectedItem());
		Status status = Status.valueOf((String) telaPrograma.getStatus().getSelectedItem());
		Estilo estilo =  Estilo.valueOf((String)telaPrograma.getEstilos().getSelectedItem());
		ArrayList<String> apresentadores = new ArrayList<>();
		String temporada =  telaPrograma.getTfTemporada().getText();
		String horario = telaPrograma.getTfhorario().getText();

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
		
		String[] apresentadoresArray = telaPrograma.getTfApresentadores().getText().split(", ");
		for(String nome: apresentadoresArray)
			apresentadores.add(nome);
		
		String dataRetorno = telaPrograma.getDataRetorno().getText();
		ProgramaDeTv programa = null;
		DayOfWeek[] dia = telaPrograma.getDia();
		ArrayList<DayOfWeek> dias = new ArrayList<>();
		for(int c = 0; c < 7;c++) {
			if(dia[c] == null) {
				continue;
			}
			if(dia[c] != null)
				dias.add(dia[c]);
		}
		if(telaPrograma.getRb1().isSelected()) {
			tipoPrograma = TipoPrograma.SERIES_REGULARES;
		 programa = new SeriesRegulares(nomeDoPrograma,
				dias, canal, status, horario, temporada,genero,estilo);
		 }
		else if(telaPrograma.getRb2().isSelected()) {
			tipoPrograma = TipoPrograma.REALITY_SHOW;
			programa = new RealityShows(nomeDoPrograma, dias, canal,
					horario,status, temporada);
		}
		
		else {
			tipoPrograma = TipoPrograma.PROGRAMA_CONTINUO;
			System.out.println(temporada);
			programa = new ProgramasContinuos (nomeDoPrograma, dias, canal,
					horario,status, temporada);
			System.out.println(programa.getTemporadas() +"programa temporada");
		}
		programa.setFavorito(favoritado);
		if(programa instanceof ProgramasContinuos|| programa instanceof RealityShows) {
			for(String apresentador:apresentadores) {
				try {
					((ProgramasContinuos) programa).setApresentadores(apresentador);
				} catch (ApresentadorJaCadastrado e1) {
					Componentes.msgFalha(telaPrograma, e1.getMessage());
				}
			
			}
		}
		try {
			central.AdicionarProgramaDeTv(programa);
			persistencia.salvarCentral(central, "central");
			Componentes.msgSucesso(telaPrograma, "Programa cadastrado com sucesso!");
			telaPrograma.dispose();
			new TelaNovoPrograma(telaPrograma.getUsuarioAtivo());
		} catch (FalhaNoCadastroException exception) {
			Componentes.msgFalha(telaPrograma, exception.getMessage());
		}
	}

}
