package HerancaPrograma;

import java.time.DayOfWeek;
import java.util.ArrayList;

import EnumsPrograma.EnumFavorito;
import EnumsPrograma.Status;
import EnumsPrograma.TipoPrograma;
import excecoes.ApresentadorJaCadastrado;
import modelo.Canal;
import modelo.ProgramaDeTv;

public class ProgramasContinuos extends ProgramaDeTv {
	private ArrayList<String> apresentadores;

	public ProgramasContinuos(String nome, Canal canal, ArrayList<DayOfWeek> dia,
			String horario, Status status) {
		super(nome, canal, dia, status, horario);
		setFavorito(EnumFavorito.NAO_FAVORITO);
		setTipo(TipoPrograma.PROGRAMA_CONTINUO);
	}

	public void setApresentadores(String apresentador) throws ApresentadorJaCadastrado {
		boolean achouApresentador = false;
		for (String a : apresentadores) {
			if (a.equals(apresentador)) {
				achouApresentador = true;
				throw new ApresentadorJaCadastrado();
			}
		}
		if (!achouApresentador)
			apresentadores.add(apresentador);
	}

	public ArrayList<String> getApresentadores() {
		return apresentadores;
	}

}
