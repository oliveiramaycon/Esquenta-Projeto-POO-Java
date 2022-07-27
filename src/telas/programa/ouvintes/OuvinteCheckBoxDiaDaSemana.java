package telas.programa.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.util.ArrayList;

import telas.programa.TelaNovoPrograma;

public class OuvinteCheckBoxDiaDaSemana implements ActionListener{
	TelaNovoPrograma tela;
	ArrayList<DayOfWeek> dia = new ArrayList<>();
	public void actionPerformed(ActionEvent e) {
		if(tela.getCBSegunda().isSelected()) {
			dia.add(DayOfWeek.MONDAY);
		}
		if(tela.getTerca().isSelected()) {
			dia.add(DayOfWeek.TUESDAY);
		}
		if(tela.getQuarta().isSelected()) {
			dia.add(DayOfWeek.WEDNESDAY);
		}
		if(tela.getQuinta().isSelected()) {
			dia.add(DayOfWeek.THURSDAY);
		}
		if(tela.getSexta().isSelected()) {
			dia.add(DayOfWeek.FRIDAY);
		}		
		if(tela.getSabado().isSelected()) {
			dia.add(DayOfWeek.SATURDAY);
		}

		
	}
	public ArrayList<DayOfWeek> retornaArray() {
		
		return dia;
		
	}

}
