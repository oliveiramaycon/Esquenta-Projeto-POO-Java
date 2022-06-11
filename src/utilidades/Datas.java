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
	
	
	
	private void validarFormatoData(String data) {
		
		String[] arrayData = data.split("/");
		
		if(arrayData.length > 3) {
			//TODO: EXCEÇÃO
		}
		if(arrayData[0].length() != 2 || arrayData[1].length() != 2 || arrayData[3].length() != 4) {
			//TODO: exceção
		}
		
		
	}
}
