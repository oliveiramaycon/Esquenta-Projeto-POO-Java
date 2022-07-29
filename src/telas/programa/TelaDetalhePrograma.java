package telas.programa;

import java.time.DayOfWeek;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import modelo.programa.ProgramaDeTv;
import modelo.programa.ProgramasContinuos;
import modelo.programa.RealityShows;
import modelo.programa.SeriesRegulares;
import modelo.programa.enums.EnumFavorito;
import modelo.programa.enums.Genero;
import modelo.usuario.Usuario;
import telas.programa.ouvintes.OuvinteCheckBoxDiaDaSemana;

public class TelaDetalhePrograma extends TelaNovoPrograma{

	private int indexLinha;
	private ProgramaDeTv programaSelecionado;
	private Usuario usuarioAtivo;
	private JComboBox<String> generos;
	private JComboBox<String> estilos;
	private JLabel genero;
	private JLabel estilo;
	private JLabel apresentador;
	private JTextField apresentadores;
	
	
	public int getIndexLinha() {
		return indexLinha;
	}
	
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
		tfhorario.setText(programaSelecionado.getHorario());
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
		
		DayOfWeek[] dias = getDia();
		if(programaSelecionado.getDiasDaSemana().contains(DayOfWeek.MONDAY)) {
			cbSegunda.setSelected(true);
			dias[0] = DayOfWeek.MONDAY;
		}
		if(programaSelecionado.getDiasDaSemana().contains(DayOfWeek.TUESDAY)) {
			terca.setSelected(true);
			dias[1] = DayOfWeek.TUESDAY;
		}
		if(programaSelecionado.getDiasDaSemana().contains(DayOfWeek.WEDNESDAY)) {
			quarta.setSelected(true);
			dias[2] = DayOfWeek.WEDNESDAY;
		}
		if(programaSelecionado.getDiasDaSemana().contains(DayOfWeek.THURSDAY)) {
			quinta.setSelected(true);
			dias[3] = DayOfWeek.THURSDAY;
		}
		if(programaSelecionado.getDiasDaSemana().contains(DayOfWeek.FRIDAY)) {
			sexta.setSelected(true);
			dias[4] = DayOfWeek.FRIDAY;
		}
		if(programaSelecionado.getDiasDaSemana().contains(DayOfWeek.SATURDAY)) {
			sabado.setSelected(true);
			dias[5] = DayOfWeek.SATURDAY;
		}
		if(programaSelecionado.getDiasDaSemana().contains(DayOfWeek.SUNDAY)) {
			domingo.setSelected(true);
			dias[6] = DayOfWeek.SUNDAY;
		}
		
		if(programaSelecionado instanceof SeriesRegulares) {
			rb1.setSelected(true);
			rb2.setEnabled(false);
			rb3.setEnabled(false);
			apresentador.setVisible(false);
			apresentadores.setVisible(false);
			genero = getGenero();
		    generos = getGeneros();
			generos.setSelectedItem(((SeriesRegulares)programaSelecionado).getGenero());
			estilos = getEstilos();
			estilos.setSelectedItem(((SeriesRegulares)programaSelecionado).getEstilo());
			estilo = getEstilo();
		}
		else {
			if(programaSelecionado instanceof RealityShows) {
				rb2.setSelected(true);
				rb1.setEnabled(false);
				rb3.setEnabled(false);
				
			}
			if(programaSelecionado instanceof ProgramasContinuos) {
				rb3.setSelected(true);
				rb1.setEnabled(false);
				rb2.setEnabled(false);
			}
			apresentador = getApresentadores();
			genero.setVisible(false);
			generos.setVisible(false);
			estilo.setVisible(false);
			estilos.setVisible(false);
			apresentadores = getTfApresentadores();
			apresentadores.setText(getTfApresentadores().getText());
			apresentador.setVisible(true);
			apresentadores.setVisible(true);
		}
		
	}

}
