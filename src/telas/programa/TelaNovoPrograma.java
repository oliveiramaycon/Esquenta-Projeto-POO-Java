package telas.programa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.DayOfWeek;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import modelo.programa.ProgramaDeTv;
import modelo.usuario.Usuario;
import telas.TelaPadrao;
import telas.programa.ouvintes.OuvinteBotaoCadastrarPrograma;
import telas.programa.ouvintes.OuvinteCheckBoxDiaDaSemana;
import telas.programa.ouvintes.OuvinteComboBoxHiato;
import telas.programa.ouvintes.OuvinteData;
import telas.programa.ouvintes.OuvinteFocoApresentadores;
import telas.programa.ouvintes.OuvinteRadioButtonFiltroPrograma;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Imagens;
import utilidades.Medidas;
import utilidades.Persistencia;

public class TelaNovoPrograma extends TelaPadrao {

	private JTextField tfNome;
	private JTextField tfhorario;
	private JTextField tfTemporada;
	private JTextField tfApresentadores;
	private JTextField dataRetorno;
	private JButton botaoCadastrar;
	private JLabel genero;
	private JLabel estilo;
	private JLabel apresentadores;
	private JLabel data;
	private JComboBox<String> status;
	private JComboBox<String> canais;
	private JComboBox<String> generos;
	private JComboBox<String> estilos;
	private Usuario usuarioAtivo;
	private ProgramaDeTv programa;
	private JRadioButton rb1;
	private JRadioButton rb2;
	private JRadioButton rb3;
	private JRadioButton favoritado;
	private JCheckBox cbSegunda;
	private JCheckBox terca;
	private JCheckBox quarta;
	private JCheckBox quinta;
	private JCheckBox sexta;
	private JCheckBox sabado;
	private JCheckBox domingo;
	private DayOfWeek[] dia;

	public JLabel getData() {
		return data;
	}

	public JTextField getDataRetorno() {
		return dataRetorno;
	}
	
	public void setDia(DayOfWeek[] dia) {
		this.dia = dia;
	}
	
	public DayOfWeek[] getDia() {
		return dia;
	}
	
	public JTextField getTfApresentadores() {
		return tfApresentadores;
	}

	public JLabel getApresentadores() {
		return apresentadores;
	}

	public JCheckBox getCBSegunda() {
		return cbSegunda;
	}

	public JCheckBox getTerca() {
		return terca;
	}

	public JCheckBox getQuarta() {
		return quarta;
	}

	public JCheckBox getQuinta() {
		return quinta;
	}

	public JCheckBox getSexta() {
		return sexta;
	}

	public JCheckBox getSabado() {
		return sabado;
	}

	public JCheckBox getDomingo() {
		return domingo;
	}

	public JLabel getEstilo() {
		return estilo;
	}

	public JLabel getGenero() {
		return genero;
	}

	public JComboBox<String> getEstilos() {
		return estilos;
	}

	public JComboBox<String> getGeneros() {
		return generos;
	}

	public JTextField getTfNome() {
		return tfNome;
	}

	public JTextField getTfhorario() {
		return tfhorario;
	}

	public JTextField getTfTemporada() {
		return tfTemporada;
	}

	public JButton getBotaoCadastrar() {
		return botaoCadastrar;
	}

	public JComboBox<String> getStatus() {
		return status;
	}

	public JComboBox<String> getCanais() {
		return canais;
	}

	public ProgramaDeTv getPrograma() {
		return programa;
	}

	public JRadioButton getRb1() {
		return rb1;
	}

	public JRadioButton getRb2() {
		return rb2;
	}

	public JRadioButton getRb3() {
		return rb3;
	}

	public JRadioButton getFavoritado() {
		return favoritado;
	}

	public Usuario getUsuarioAtivo() {
		return usuarioAtivo;
	}

	public TelaNovoPrograma(Usuario usuario) {
		super("Novo Programa");
		usuarioAtivo = usuario;
		this.programa = null;
		dia = new DayOfWeek[7];
	}

	public TelaNovoPrograma(ProgramaDeTv programa, Usuario usuario) {
		super("Novo Programa");
		this.programa = programa;
		usuarioAtivo = usuario;
		dia = new DayOfWeek[7];
	}
	public  TelaNovoPrograma() {
		super("Detalhes Programa");
		dia = new DayOfWeek[7];
	}

	@Override
	public void adicionarComponentesGraficos() {
		adicionarBackground();
		adicionarBotoes();
		adiconarLabels();
		adicionarTextFields();
		adicionarRadios();
		adicionandoComboBox();
		adicionarCheckBox();
	}

	private void adicionarCheckBox() {
		cbSegunda = Componentes.addCheckBox(this, "Segunda-Feira", 190, 300, 120, Medidas.ALTURA_30);
		terca = Componentes.addCheckBox(this, "Terca-Feira", 310, 300, 120, Medidas.ALTURA_30);
		quarta = Componentes.addCheckBox(this, "Quarta-Feira", 430, 300, 120, Medidas.ALTURA_30);
		quinta = Componentes.addCheckBox(this, "Quinta-Feira", 190, 330, 120, Medidas.ALTURA_30);
		sexta = Componentes.addCheckBox(this, "Sexta-Feira", 310, 330, 120, Medidas.ALTURA_30);
		sabado = Componentes.addCheckBox(this, "Sábado", 430, 330, 120, Medidas.ALTURA_30);
		domingo = Componentes.addCheckBox(this, "Domingo", 190, 360, 360, Medidas.ALTURA_30);
		OuvinteCheckBoxDiaDaSemana ouvinte = new OuvinteCheckBoxDiaDaSemana(this);
		cbSegunda.addActionListener(ouvinte);
		terca.addActionListener(ouvinte);
		quarta.addActionListener(ouvinte);
		quinta.addActionListener(ouvinte);
		sexta.addActionListener(ouvinte);
		sabado.addActionListener(ouvinte);
		domingo.addActionListener(ouvinte);
	}

	private void adicionarBackground() {
		JLabel background = new JLabel(Imagens.BACKGROUND_TELA_CADASTRO_DE_CANAL);
		setContentPane(background);
	}

	private void adicionarBotoes() {
		JButton botaoVoltar = Componentes.addJButton(this, "Voltar", 20, 20, Medidas.COMPRIMENTO_130,
				Medidas.ALTURA_30);
		OuvinteBotaoVoltar ouvinteBotaoVoltar = new OuvinteBotaoVoltar();
		botaoVoltar.addActionListener(ouvinteBotaoVoltar);

		botaoCadastrar = Componentes.addJButton(this, "Cadastrar", 590, 400, Medidas.COMPRIMENTO_130,
				Medidas.ALTURA_30);
		OuvinteBotaoCadastrarPrograma ouvinteCadastrarPrograma = new OuvinteBotaoCadastrarPrograma(this);
		botaoCadastrar.addActionListener(ouvinteCadastrarPrograma);
		
	}
	private class OuvinteBotaoVoltar implements ActionListener  {

		public void actionPerformed(ActionEvent e) {
			dispose();
			new TelaListagemProgramas(usuarioAtivo);
		}
	}
	
	private void adicionarRadios() {
		rb1 = Componentes.addRadioButton(this, "Series Regulares", 190, 135, 125, Medidas.ALTURA_30);
		rb1.setSelected(true);
		rb2 = Componentes.addRadioButton(this, "Reality Show", 315, 135, 100, Medidas.ALTURA_30);
		rb3 = Componentes.addRadioButton(this, "Programa Continuo", 415, 135, 145, Medidas.ALTURA_30);

		favoritado = Componentes.addRadioButton(this, "Favoritado", 455, 190, 90, Medidas.ALTURA_30);

		OuvinteRadioButtonFiltroPrograma ouvinteRadioBotao = new OuvinteRadioButtonFiltroPrograma(this);

		rb1.addActionListener(ouvinteRadioBotao);
		rb2.addActionListener(ouvinteRadioBotao);
		rb3.addActionListener(ouvinteRadioBotao);

		ButtonGroup group = new ButtonGroup();
		group.add(rb1);
		group.add(rb2);
		group.add(rb3);
	}

	public void adiconarLabels() {
		Componentes.addJLabel(this, "Novo Programa", 318, 20, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Nome", 190, 72, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Canal", 190, 165, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Horario", 190, 220, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Status", 330, 165, 110, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Temporada", 430, 220, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Dias de Transmissão", 190, 275, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		genero = Componentes.addJLabel(this, "Genero", 400, 390, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		estilo = Componentes.addJLabel(this, "Estilo", 190, 390, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		data = Componentes.addJLabel(this, "Data de retorno", 290, 220, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		data.setVisible(false);

		apresentadores = Componentes.addJLabel(this, "Apresentadores", 190, 390, Medidas.COMPRIMENTO_255,
				Medidas.ALTURA_30);
		apresentadores.setVisible(false);
	}

	private void adicionarTextFields() {
		try {
			MaskFormatter mascaraHorario = new MaskFormatter("##:##");
			mascaraHorario.setValidCharacters("0123456789");
			tfhorario = new JFormattedTextField(mascaraHorario);
			tfhorario.setBounds(190, 245, 90, Medidas.ALTURA_30);
			add(tfhorario);
			tfhorario.setHorizontalAlignment(JLabel.CENTER);
		} catch (ParseException e) {
		}
		try {
			MaskFormatter mascaraData = new MaskFormatter("##/##/####");
			mascaraData.setValidCharacters("0123456789");
			dataRetorno = new JFormattedTextField(mascaraData);
			dataRetorno.setBounds(290, 245, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
			add(dataRetorno);
			dataRetorno.setVisible(false);
			dataRetorno.setHorizontalAlignment(JLabel.CENTER);
			OuvinteData ouvinteData = new OuvinteData(this);
			dataRetorno.addFocusListener(ouvinteData);
			
		} catch (ParseException e) {
		}
		tfNome = Componentes.addJTextField(this, 190, 100, 370, Medidas.ALTURA_30);
		try {
			MaskFormatter mascaraTemporada = new MaskFormatter("###");
			mascaraTemporada.setValidCharacters("0123456789");
			tfTemporada = new JFormattedTextField(mascaraTemporada);
			tfTemporada.setBounds(430, 245, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
			add(tfTemporada);
			tfTemporada.setHorizontalAlignment(JLabel.CENTER);
		} catch (Exception e) {
			// TODO: handle exception
		}
		tfApresentadores = Componentes.addJTextField(this, 190, 415, 360, Medidas.ALTURA_30);
		OuvinteFocoApresentadores ouvinteFocoApresentadores = new OuvinteFocoApresentadores(this);
		tfApresentadores.addFocusListener(ouvinteFocoApresentadores);
		tfApresentadores.setVisible(false);
	}

	private void adicionandoComboBox() {
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral("central");

		ArrayList<String> canaisTxt = Componentes.passandoArrayCanalParaString(central.getCanais());
		canais = Componentes.inserirComboBox(this, canaisTxt, 190, 190, 130, Medidas.ALTURA_30);

		ArrayList<String> statusTxt = central.obterTiposDeStatus();
		status = Componentes.inserirComboBox(this, statusTxt, 330, 190, 115, Medidas.ALTURA_30);
		OuvinteComboBoxHiato ouvinteComboBoxHiato = new OuvinteComboBoxHiato(this);
		status.addActionListener(ouvinteComboBoxHiato);

		ArrayList<String> generosTxt = central.obterGeneroDePrograma();
		generos = Componentes.inserirComboBox(this, generosTxt, 400, 415, 150, Medidas.ALTURA_30);

		ArrayList<String> estilosTxt = central.obterEstilosDePrograma();
		estilos = Componentes.inserirComboBox(this, estilosTxt, 190, 415, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);

	}
}
