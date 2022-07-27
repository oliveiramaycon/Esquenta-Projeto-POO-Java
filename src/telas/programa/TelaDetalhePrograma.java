package telas.programa;

import java.time.DayOfWeek;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import modelo.programa.ProgramaDeTv;
import modelo.programa.ProgramasContinuos;
import modelo.programa.RealityShows;
import modelo.programa.SeriesRegulares;
import modelo.programa.enums.EnumFavorito;
import modelo.usuario.Usuario;

public class TelaDetalhePrograma extends TelaNovoPrograma{

	private int indexLinha;
	private ProgramaDeTv programaSelecionado;
	private Usuario usuarioAtivo;
	public int getIndexLinha() {
		return indexLinha;
	}
	
	/*
	 * 
	*/
	public ProgramaDeTv getProgramaSelecionado() {
		return programaSelecionado;
	}
	public Usuario getUsuarioAtivo() {
		return super.getUsuarioAtivo();
	}
	public TelaDetalhePrograma(int indexLinha, ProgramaDeTv programaSelecionado) {
		this.indexLinha = indexLinha;
		usuarioAtivo = getUsuarioAtivo();
		this.programaSelecionado = programaSelecionado;
		deixarPreenchido();
		repaint();
	}
	private void deixarPreenchido() {
		//SETANDO TEXTO
		JTextField tfNome = getTfNome();
		tfNome.setText(programaSelecionado.getNome());
		JTextField tfhorario = getTfhorario();
		tfhorario.setText(programaSelecionado.getNome());
		JTextField tftemporada = getTfTemporada();
		tftemporada.setText(programaSelecionado.getTemporadas());
		JTextField dataRetorno = getTfApresentadores();
		dataRetorno.setText(programaSelecionado.getData());
		
		JComboBox<String> status = getStatus();
		status.setSelectedItem(programaSelecionado.getStatus());
		JComboBox<String> canais = getCanais();
		canais.setSelectedItem(programaSelecionado.getCanal());
		JRadioButton rb1 = getRb1();
		JRadioButton rb2 = getRb2();
		JRadioButton rb3 = getRb3();
		JRadioButton favorito = getFavoritado();
		if(programaSelecionado.getFavorito() == EnumFavorito.FAVORITO)
			favorito.setSelected(true);
		JCheckBox cbSegunda = getCBSegunda();
		JCheckBox terca = getTerca();
		JCheckBox quarta = getQuarta();
		JCheckBox quinta = getQuinta();
		JCheckBox sexta = getSexta();
		JCheckBox sabado = getSabado();
		JCheckBox domingo = getDomingo();
		
		if(programaSelecionado.getDiasDaSemana().contains(DayOfWeek.MONDAY))
			cbSegunda.setSelected(true);
		if(programaSelecionado.getDiasDaSemana().contains(DayOfWeek.TUESDAY))
			terca.setSelected(true);
		if(programaSelecionado.getDiasDaSemana().contains(DayOfWeek.WEDNESDAY))
			quarta.setSelected(true);
		if(programaSelecionado.getDiasDaSemana().contains(DayOfWeek.THURSDAY))
			quinta.setSelected(true);
		if(programaSelecionado.getDiasDaSemana().contains(DayOfWeek.FRIDAY))
			sexta.setSelected(true);
		if(programaSelecionado.getDiasDaSemana().contains(DayOfWeek.SATURDAY))
			sabado.setSelected(true);
		if(programaSelecionado.getDiasDaSemana().contains(DayOfWeek.SUNDAY))
			domingo.setSelected(true);
		
		if(programaSelecionado instanceof SeriesRegulares) {
			JComboBox<String> generos = getGeneros();
			generos.setSelectedItem(((SeriesRegulares)programaSelecionado).getGenero());
			JComboBox<String> estilo = getEstilos();
			estilo.setSelectedItem(((SeriesRegulares)programaSelecionado).getEstilo());
			rb1.setSelected(true);
			rb2.setEnabled(false);
			rb3.setEnabled(false);
		}
		else {
			if(programaSelecionado instanceof RealityShows)
			rb2.setSelected(true);
			rb1.setEnabled(false);
			rb3.setEnabled(false);
			
			if(programaSelecionado instanceof ProgramasContinuos)
				rb3.setSelected(true);
				rb1.setEnabled(false);
				rb2.setEnabled(false);
			JTextField tfApresentadores = getTfApresentadores();
			tfApresentadores.setText(programaSelecionado.getTemporadas());
		}
		
	}

}
