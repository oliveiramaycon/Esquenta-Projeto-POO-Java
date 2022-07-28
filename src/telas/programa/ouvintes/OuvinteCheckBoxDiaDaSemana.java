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
	
	public void actionPerformed(ActionEvent e) {
		DayOfWeek[] diaCb = tela.getDia();

		if(tela.getCBSegunda().isSelected()) {
			diaCb[0] = DayOfWeek.MONDAY;
		}
		else
			diaCb[0] = null;
		
		if(tela.getTerca().isSelected()) {
			diaCb[1] = DayOfWeek.TUESDAY;
		}
		else
			diaCb[1] = null;
		
		if(tela.getQuarta().isSelected()) {
			diaCb[2] = DayOfWeek.WEDNESDAY;
		}
		else
			diaCb[2] = null;
		
		if(tela.getQuinta().isSelected()) {
			diaCb[3] = DayOfWeek.THURSDAY;
		}
		else
			diaCb[3] = null;
		
		if(tela.getSexta().isSelected()) {
			diaCb[4] = DayOfWeek.FRIDAY;
		}		
		else
			diaCb[4] = null;
		
		if(tela.getSabado().isSelected()) {
			diaCb[5] = DayOfWeek.SATURDAY;
		}
		else
			diaCb[5] = null;
		
		if(tela.getDomingo().isSelected())
			diaCb[6] = DayOfWeek.SUNDAY;
		
		else
			diaCb[6] = null;

	}

}
