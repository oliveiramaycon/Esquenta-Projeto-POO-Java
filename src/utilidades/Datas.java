package utilidades;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import telas.programa.TelaNovoPrograma;

public class Datas {

	public static String obterDiaDaSemana() {

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());

		DateFormat formatter = new SimpleDateFormat("EEEE");
		String dayOfWeekString = formatter.format(cal.getTime());
		return dayOfWeekString;
	}

	public static String formatar(Date data) {
		DateFormat formater = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		return formater.format(data);
	}

	public static void testandoData(TelaNovoPrograma tela) {
		String dataTxt = tela.getDataRetorno().getText();
		SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yyyy");
		Date d = new Date();
		try {
			d = mascara.parse(dataTxt);
		} catch (ParseException e) {
		}
		Date dia = new Date();
		String[] dataSeparada = dataTxt.split("/");
		int diaData = Integer.parseInt(dataSeparada[0]);
		int mes = Integer.parseInt(dataSeparada[1]);
		String msgErro = "Data invalida";
		if (diaData > 31)
			Componentes.msgFalha(tela, msgErro);
		else if (diaData > 29 && mes == 2)
			Componentes.msgFalha(tela, msgErro);
		if (dia.after(d)) {
			Componentes.msgFalha(tela, msgErro);

		}
	}
}
