package utilidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
}
