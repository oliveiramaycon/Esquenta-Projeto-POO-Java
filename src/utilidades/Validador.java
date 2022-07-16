package utilidades;

import modelo.canal.exceptions.CamposIncompletosException;
import telas.TelaNovoCanal;

public class Validador {

	public static boolean validarPreenchimentoCanal(TelaNovoCanal telaNovoCanal)
			throws CamposIncompletosException, NumberFormatException {

		String nome = telaNovoCanal.getTfNome().getText().trim();
		String numeroCanal = telaNovoCanal.getTfNumeroOuLink().getText().trim();
		String link = telaNovoCanal.getLinkBroadcasting().getText().trim();

		if (nome.isEmpty()) {
			throw new CamposIncompletosException();
		}

		if (numeroCanal.isEmpty() && link.isEmpty()) {
			throw new CamposIncompletosException();
		}
		if (!numeroCanal.isEmpty() && !textoIsNumerico(numeroCanal)) {
			throw new NumberFormatException("informe um valor numérico ao campo Número do canal!");
		}
		
		return true;

	}

	public static boolean textoIsNumerico(String texto) {
		System.out.println(texto.chars().allMatch(Character::isDigit));

        System.out.println(texto + "aaaaaaaaaaaaaaaaaaaaa");
		return texto.chars().allMatch(Character::isDigit);

	}
}
