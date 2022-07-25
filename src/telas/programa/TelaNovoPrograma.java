package telas.programa;

import java.text.ParseException;
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
import telas.canal.ouvintes.OuvinteRadioButton;
import telas.programa.ouvintes.OuvinteBotaoCadastrarPrograma;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Imagens;
import utilidades.Medidas;
import utilidades.Persistencia;

public class TelaNovoPrograma extends TelaPadrao {

	private JTextField tfNome;
	private JTextField tfCanalDeTransmissao;
	private JTextField tfhorario;
	private JTextField tfTemporada;
	private JTextField tfdiasDeTransmissao;
	
	private JButton botaoCadastrar;

	private JComboBox<String> tfTipo;
	private JComboBox<String> status;
	private JComboBox<String> canais;

	private Usuario usuarioAtivo;
	
	private ProgramaDeTv programa;
	
	private JRadioButton rb1;
	private JRadioButton rb2;
	private JRadioButton rb3;
	private JRadioButton favoritado;
	
	
	Persistencia p = new Persistencia();
	CentralDeInformacoes central = p.recuperarCentral("central");

	public Usuario getUsuarioAtivo() {
		return usuarioAtivo;
	}

	public TelaNovoPrograma(Usuario usuario) {
		super("Novo Programa");
		usuarioAtivo = usuario;
		this.programa = null;
	}
	
	public TelaNovoPrograma(ProgramaDeTv programa, Usuario usuario) {
		super("Novo Programa");
		this.programa = programa;
		usuarioAtivo = usuario;
	}
	
	
	@Override
	public void adicionarComponentesGraficos() {
		adicionarBackground();
		adicionarBotoes();
		adiconarLabels();
		adicionarTextFields();
		adicionarRadios();
		adicionandoComboBox();
	}
	
	private void adicionarBackground() {
		JLabel background = new JLabel(Imagens.BACKGROUND_TELA_CADASTRO_DE_CANAL);
		setContentPane(background);
	}

	private void adicionarBotoes() {
		JButton botaoVoltar = Componentes.addJButton(this, "Voltar",
				20, 20, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		//TODO:ouvinte voltar
		
		botaoCadastrar = Componentes.addJButton(this, "Cadastrar", 590, 400, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
//		OuvinteBotaoCadastrarPrograma ouvinteCadastrarPrograma = new OuvinteBotaoCadastrarPrograma(this);
//		botaoCadastrar.addActionListener(ouvinteCadastrarPrograma);
	}
	private void adicionarRadios() {
		rb1 = Componentes.addRadioButton(this, "Series Regulares", 190, 135, 125, Medidas.ALTURA_30);
		rb1.setSelected(true);
		rb2 = Componentes.addRadioButton(this, "Reality Show", 315, 135, 100, Medidas.ALTURA_30);
		rb3 = Componentes.addRadioButton(this, "Programa Continuo", 415, 135, 145, Medidas.ALTURA_30);
		
		favoritado = Componentes.addRadioButton(this, "Favoritado", 455,190, 90, Medidas.ALTURA_30);
//		OuvinteRadioButton ouvinteRadioBotao = new OuvinteRadioButton(this);

//		rb1.addActionListener(ouvinteRadioBotao);
//		rb2.addActionListener(ouvinteRadioBotao);
		ButtonGroup group = new ButtonGroup();
		group.add(rb1);
		group.add(rb2);
		group.add(rb3);
	}
	
	public void adiconarLabels() {
		Componentes.addJLabel(this, "Novo Programa", 318, 20, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Nome", 190, 72, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Canal",  190, 165,Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Horario", 190, 230,Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Status", 300, 230, 110, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Temporada", 420, 230, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		
//		Componentes.addJLabel(this, "Tipo", 220, 100, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
//		Componentes.addJLabel(this, "Dias de Transmiss�o", 220, 240, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
	}
	
	
	public void adicionarTextFields() {
		try {
			 MaskFormatter mascaraHorario = new MaskFormatter("##:##");
			tfhorario = new JFormattedTextField(mascaraHorario);
			tfhorario.setBounds( 190, 260, 90, Medidas.ALTURA_30);
			add(tfhorario);
		} catch (ParseException e) {}
		
		tfNome = Componentes.addJTextField(this, 190, 95,Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		tfTemporada = Componentes.addJTextField(this, 420, 260, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
//		tfCanalDeTransmissao = Componentes.addJTextField(this, 190, 190,
//				Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);//mudar pra combobox
//		tfdiasDeTransmissao = Componentes.addJTextField(this, 220, 270,Medidas.COMPRIMENTO_255, Medidas.ALTURA_30); //substituir por checkBox. aqui marca apenas as medidas
	}
	
	private void adicionandoComboBox() {
		CentralDeInformacoes centralValoresFixos = new CentralDeInformacoes();
		ArrayList<String> canaisTxt = Componentes.passandoArrayCanalParaString(central.getCanais());
		canais = Componentes.inserirComboBox(this, canaisTxt, 190, 170,
		Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		ArrayList<String> statusTxt = centralValoresFixos.obterTiposDeStatus();
		status = Componentes.inserirComboBox(this, statusTxt, 300,260, 
				115, Medidas.ALTURA_30);
		
	}
}
