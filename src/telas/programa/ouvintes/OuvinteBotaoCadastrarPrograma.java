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
import modelo.programa.exceptions.ProgramaJaAdicionado;
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
		boolean validandoHorario= false;
		
		//TESTANDO SE HORA É VALIDA
		if(!horario.trim().isEmpty()) {
			String[] hora = horario.split(":");
			int horas= Integer.parseInt(hora[0]);
			int minutos = Integer.parseInt(hora[1]);
			if(horas < 24 && minutos <= 59)
				validandoHorario = true;
			else
				Componentes.msgFalha(telaPrograma, "Horario Invalido");
			}
		EnumFavorito favoritado = EnumFavorito.NAO_FAVORITO;
		if(telaPrograma.getFavoritado().isSelected()) {
			favoritado = EnumFavorito.FAVORITO;
		}
		String[] apresentadoresArray = telaPrograma.getTfApresentadores().getText().split(", ");
		for(String nome: apresentadoresArray)
			apresentadores.add(nome);
		boolean temData = false;
		String dataRetorno = telaPrograma.getDataRetorno().getText();
		ProgramaDeTv programa = null;
		boolean temDia = false;
		DayOfWeek[] dia = telaPrograma.getDia();
		ArrayList<DayOfWeek> dias = new ArrayList<>();
		for(int c = 0; c < 7;c++) {
			if(dia[c] == null) {
				continue;
			}
			if(dia[c] != null){
				dias.add(dia[c]);
		}
		if(dias.size() > 0) {
			temDia= true;
		}
		Boolean campoPreenchido = false;
		boolean apresentadorPreenchido = false;
		if(!nomeDoPrograma.trim().isEmpty()|| !horario.trim().isEmpty()|| !temporada.trim().isEmpty()) {
			campoPreenchido = true;
		}
		if(apresentadores.size()> 0) {
			apresentadorPreenchido = true;	
		}
		if(telaPrograma.getRb1().isSelected()) {
			tipoPrograma = TipoPrograma.SERIES_REGULARES;
		 programa = new SeriesRegulares(nomeDoPrograma,
				dias, canal, status, horario, temporada,genero,estilo);
		 apresentadorPreenchido = true; 
		 programa.setFavorito(favoritado); 
		 }
		else if(telaPrograma.getRb2().isSelected()) {
			tipoPrograma = TipoPrograma.REALITY_SHOW;
			programa = new RealityShows(nomeDoPrograma, dias, canal,
					horario,status, temporada);
			programa.setFavorito(favoritado); 
		}
		
		else {
			tipoPrograma = TipoPrograma.PROGRAMA_CONTINUO;
			System.out.println(temporada);
			programa = new ProgramasContinuos (nomeDoPrograma, dias, canal,
					horario,status, temporada);
			programa.setFavorito(favoritado); 
		}
			
			
		if(status == Status.HIATO && !dataRetorno.isEmpty())
			temData = true;
		else if(status != Status.HIATO)
			temData = true;
		
		if(programa instanceof ProgramasContinuos|| programa instanceof RealityShows) {
			for(String apresentador:apresentadores) {
				try {
					((ProgramasContinuos) programa).setApresentadores(apresentador);
				} catch (ApresentadorJaCadastrado e1) {
					Componentes.msgFalha(telaPrograma, e1.getMessage());
				}
			
			}
		}
		
		if(temDia && apresentadorPreenchido && temData && campoPreenchido && validandoHorario) {
			
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
		else {
			Componentes.msgFalha(telaPrograma, "campos vazios, por favor adicione o texto");
		}
		
	}
}
	}
