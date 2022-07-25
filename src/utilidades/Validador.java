package utilidades;

import modelo.canal.exceptions.CamposIncompletosException;
import telas.canal.TelaNovoCanal;

public class Validador {

	public static boolean validarPreenchimentoCanal(TelaNovoCanal telaNovoCanal)
			throws CamposIncompletosException, NumberFormatException {

		String nome = telaNovoCanal.getTfNome().getText().trim();
		String tipo = telaNovoCanal.obterTipoSelecionado().toString();
		String numeroOuLink = telaNovoCanal.getTfNumeroOuLink().getText().trim();
		

		if (nome.isEmpty() || numeroOuLink.isEmpty()) {
			throw new CamposIncompletosException();
		}

		if (tipo.toString().endsWith("TELEVISAO") && !textoIsNumerico(numeroOuLink)) {
			throw new NumberFormatException("informe um valor numérico ao campo Número do canal!");
		}
		
		return true;
	}

	public static boolean textoIsNumerico(String texto) {
		return texto.chars().allMatch(Character::isDigit);
	}
}
