package telas.programa.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.util.ArrayList;

import telas.programa.TelaNovoPrograma;

public class OuvinteCheckBoxDiaDaSemana implements ActionListener{
	TelaNovoPrograma tela;
	
	public OuvinteCheckBoxDiaDaSemana(TelaNovoPrograma tela) {
		this.tela = tela;
	}
	
	DayOfWeek[] dia = new DayOfWeek[7];
	public void actionPerformed(ActionEvent e) {
		if(tela.getCBSegunda().isSelected()) {
			dia[0] = DayOfWeek.MONDAY;
		}
		if(tela.getTerca().isSelected()) {
			dia[1] = DayOfWeek.TUESDAY;
		}
		if(tela.getQuarta().isSelected()) {
			dia[2] = DayOfWeek.WEDNESDAY;
		}
		if(tela.getQuinta().isSelected()) {
			dia[3] = DayOfWeek.THURSDAY;
		}
		if(tela.getSexta().isSelected()) {
			dia[4] = DayOfWeek.FRIDAY;
		}		
		if(tela.getSabado().isSelected()) {
			dia[5] = DayOfWeek.SATURDAY;
		}
		if(tela.getDomingo().isSelected())
			dia[6] = DayOfWeek.SUNDAY;
		

		
	}
	public DayOfWeek[] retornaArray() {
		actionPerformed(null);
		return dia;
		
	}

}
