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
import utilidades.Icones;
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
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");
		usuarioAtivo = central.getUsuariosCadastrados().get(0);
		System.out.println("Cadastro: " + usuarioAtivo);
	
	}

	public TelaNovoPrograma(ProgramaDeTv programa) {
		super("Novo Programa");
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");
		usuarioAtivo = central.getUsuariosCadastrados().get(0);
		dia = new DayOfWeek[7];
		System.out.println("Cadastro: " + usuarioAtivo);
	}

	public TelaNovoPrograma() {
		super("Detalhes Programa");
		dia = new DayOfWeek[7];
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");
		usuarioAtivo = central.getUsuariosCadastrados().get(0);
		System.out.println("Cadastro: " + usuarioAtivo);
	}

	@Override
	public void adicionarComponentesGraficos() {
		adicionarBackground();
		adicionarBotoes();
		adicionarMenu();
		adiconarLabels();
		adicionarTextFields();
		adicionarRadios();
		adicionandoComboBox();
		adicionarCheckBox();
	}

	public void adicionarMenu() {
		Componentes.addMenuPadrao(this);
	}

	private void adicionarCheckBox() {
		cbSegunda = Componentes.addCheckBox(this, "Segunda-Feira", 250, 360, 120, Medidas.ALTURA_30);
		terca = Componentes.addCheckBox(this, "Terca-Feira", 370, 360, 120, Medidas.ALTURA_30);
		quarta = Componentes.addCheckBox(this, "Quarta-Feira", 490, 360, 120, Medidas.ALTURA_30);
		quinta = Componentes.addCheckBox(this, "Quinta-Feira", 250, 390, 120, Medidas.ALTURA_30);
		sexta = Componentes.addCheckBox(this, "Sexta-Feira", 370, 390, 120, Medidas.ALTURA_30);
		sabado = Componentes.addCheckBox(this, "Sabado", 490, 390, 120, Medidas.ALTURA_30);
		domingo = Componentes.addCheckBox(this, "Domingo", 250, 420, 360, Medidas.ALTURA_30);
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
		JLabel background = new JLabel(Imagens.BACKGROUND_TELA_CADASTRO);
		setContentPane(background);
	}

	private void adicionarBotoes() {
		JButton botaoVoltar = Componentes.addJButton(this, "Voltar", Icones.VOLTAR, 20, 20, Medidas.COMPRIMENTO_50,
				Medidas.ALTURA_30);
		OuvinteBotaoVoltar ouvinteBotaoVoltar = new OuvinteBotaoVoltar();
		botaoVoltar.addActionListener(ouvinteBotaoVoltar);

		botaoCadastrar = Componentes.addJButton(this, "Cadastrar", 700, 450, Medidas.COMPRIMENTO_130,
				Medidas.ALTURA_30);
		OuvinteBotaoCadastrarPrograma ouvinteCadastrarPrograma = new OuvinteBotaoCadastrarPrograma(this);
		botaoCadastrar.addActionListener(ouvinteCadastrarPrograma);

	}

	private class OuvinteBotaoVoltar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			dispose();
			new TelaListagemProgramas(usuarioAtivo);
		}
	}

	private void adicionarRadios() {
		rb1 = Componentes.addRadioButton(this, "Series Regulares", 250, 165, 125, Medidas.ALTURA_30);
		rb1.setSelected(true);
		rb2 = Componentes.addRadioButton(this, "Reality Show", 375, 165, 100, Medidas.ALTURA_30);
		rb3 = Componentes.addRadioButton(this, "Programa Continuo", 475, 165, 145, Medidas.ALTURA_30);

		favoritado = Componentes.addRadioButton(this, "Favoritado", 530, 225, 90, Medidas.ALTURA_30);

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
		Componentes.addJLabel(this, "Novo Programa", 368, 20, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Nome", 250, 102, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Canal", 250, 195, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Horario", 250, 270, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Status", 395, 195, 110, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Temporada", 510, 270, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Dias de Transmissao", 250, 330, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		genero = Componentes.addJLabel(this, "Genero", 500, 450, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		estilo = Componentes.addJLabel(this, "Estilo", 250, 450, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		data = Componentes.addJLabel(this, "Data de retorno", 360, 270, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		data.setVisible(false);

		apresentadores = Componentes.addJLabel(this, "Apresentadores", 250, 455, Medidas.COMPRIMENTO_255,
				Medidas.ALTURA_30);
		apresentadores.setVisible(false);
	}

	private void adicionarTextFields() {
		try {
			MaskFormatter mascaraHorario = new MaskFormatter("##:##");
			mascaraHorario.setValidCharacters("0123456789");
			tfhorario = new JFormattedTextField(mascaraHorario);
			tfhorario.setBounds(250, 300, 90, Medidas.ALTURA_30);
			add(tfhorario);
			tfhorario.setHorizontalAlignment(JLabel.CENTER);
		} catch (ParseException e) {
		}
		try {
			MaskFormatter mascaraData = new MaskFormatter("##/##/####");
			mascaraData.setValidCharacters("0123456789");
			dataRetorno = new JFormattedTextField(mascaraData);
			dataRetorno.setBounds(360, 300, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
			add(dataRetorno);
			dataRetorno.setVisible(false);
			dataRetorno.setHorizontalAlignment(JLabel.CENTER);
			OuvinteData ouvinteData = new OuvinteData(this);
			dataRetorno.addFocusListener(ouvinteData);

		} catch (ParseException e) {
		}
		tfNome = Componentes.addJTextField(this, 250, 130, 370, Medidas.ALTURA_30);
		try {
			MaskFormatter mascaraTemporada = new MaskFormatter("###");
			mascaraTemporada.setValidCharacters("0123456789");
			tfTemporada = new JFormattedTextField(mascaraTemporada);
			tfTemporada.setBounds(510, 300, 100, Medidas.ALTURA_30);
			add(tfTemporada);
			tfTemporada.setHorizontalAlignment(JLabel.CENTER);
		} catch (Exception e) {
		}
		tfApresentadores = Componentes.addJTextField(this, 250, 485, 360, Medidas.ALTURA_30);
		OuvinteFocoApresentadores ouvinteFocoApresentadores = new OuvinteFocoApresentadores(this);
		tfApresentadores.addFocusListener(ouvinteFocoApresentadores);
		tfApresentadores.setVisible(false);
	}

	private void adicionandoComboBox() {
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral("central");

		ArrayList<String> canaisTxt = Componentes.passandoArrayCanalParaString(central.getCanais());
		canais = Componentes.inserirComboBox(this, canaisTxt, 250, 225, 130, Medidas.ALTURA_30);

		ArrayList<String> statusTxt = central.obterTiposDeStatus();
		status = Componentes.inserirComboBox(this, statusTxt, 395, 225, 115, Medidas.ALTURA_30);
		OuvinteComboBoxHiato ouvinteComboBoxHiato = new OuvinteComboBoxHiato(this);
		status.addActionListener(ouvinteComboBoxHiato);

		ArrayList<String> generosTxt = central.obterGeneroDePrograma();
		generos = Componentes.inserirComboBox(this, generosTxt, 500, 480, 150, Medidas.ALTURA_30);

		ArrayList<String> estilosTxt = central.obterEstilosDePrograma();
		estilos = Componentes.inserirComboBox(this, estilosTxt, 250, 480, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);

	}
}
