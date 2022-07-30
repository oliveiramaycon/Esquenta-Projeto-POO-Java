package telas.programa.ouvintes;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import telas.programa.TelaNovoPrograma;
import utilidades.Componentes;

public class OuvinteData implements FocusListener {

	TelaNovoPrograma tela;

	public OuvinteData(TelaNovoPrograma tela) {
		this.tela = tela;
	}

	public void focusGained(FocusEvent e) {

	}

	public void focusLost(FocusEvent e) {
		String dataAtual = tela.getDataRetorno().getText();

		SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date data = mascara.parse(dataAtual);
		} catch (Exception e2) {
			Componentes.msgFalha(tela, "Data inválida");
		}
		Componentes.testandoData(tela);
	}

}
