package telas;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import telas.ouvintes.OuvinteBotaoCadastrarCanal;
import telas.ouvintes.OuvinteRadioButton;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Imagens;
import utilidades.Medidas;

public class TelaNovoCanal extends TelaPadrao {

	private JTextField tfNome;
	private JTextField tfTipo;
	private JRadioButton rb1;
	private JRadioButton rb2;
	private JComboBox cbTv;
	private JComboBox cbBroadcasting;
	private JLabel numeroCanal;
	private JLabel linkBroadcasting;
	private JTextField tfNumeroOuLink;
	
	public JTextField getTfNome() {
		return tfNome;
	}

	public void setTfNome(JTextField tfNome) {
		this.tfNome = tfNome;
	}

	public JTextField getTfTipo() {
		return tfTipo;
	}

	public void setTfTipo(JTextField tfTipo) {
		this.tfTipo = tfTipo;
	}

	public JRadioButton getRb1() {
		return rb1;
	}

	public void setRb1(JRadioButton rb1) {
		this.rb1 = rb1;
	}

	public JRadioButton getRb2() {
		return rb2;
	}

	public void setRb2(JRadioButton rb2) {
		this.rb2 = rb2;
	}

	public JComboBox getCbTv() {
		return cbTv;
	}

	public void setCbTv(JComboBox cbTv) {
		this.cbTv = cbTv;
	}

	public JComboBox getCbBroadcasting() {
		return cbBroadcasting;
	}

	public void setCbBroadcasting(JComboBox cbBroadcasting) {
		this.cbBroadcasting = cbBroadcasting;
	}
	
	public JLabel getNumeroCanal() {
		return numeroCanal;
	}

	public void setNumeroCanal(JLabel numeroCanal) {
		this.numeroCanal = numeroCanal;
	}

	public JLabel getLinkBroadcasting() {
		return linkBroadcasting;
	}

	public void setLinkBroadcasting(JLabel linkBroadcasting) {
		this.linkBroadcasting = linkBroadcasting;
	}

	

	

	public JTextField getTfNumeroOuLink() {
		return tfNumeroOuLink;
	}

	public void setTfNumeroOuLink(JTextField tfNumeroOuLink) {
		this.tfNumeroOuLink = tfNumeroOuLink;
	}

	public TelaNovoCanal() {
		super("Novo Canal");
	}

	@Override
	public void adicionarComponentesGraficos() {
		adicionarBotoes();
		adiconarLabels();
		adicionarTextFields();
		adicionarRadios();
		addComboBoxes();
//		adicionarBackground();
	}

//	public void adicionarBackground() {
//		JLabel background = new JLabel(Imagens.BACKGROUND_TELA_INICIAL);
//		setContentPane(background);
//	}
	private void adicionarBotoes() {
		JButton botaoVoltar = Componentes.addJButton(this, "Voltar", 20, 20, Medidas.COMPRIMENTO_130,
				Medidas.ALTURA_30);
		// TODO:ouvinte voltar
		JButton botaoCadastrar = Componentes.addJButton(this, "Cadastrar", 280, 400, Medidas.COMPRIMENTO_130,
				Medidas.ALTURA_30);
		OuvinteBotaoCadastrarCanal ouvinteCadastrarCanal = new OuvinteBotaoCadastrarCanal(this);
		botaoCadastrar.addActionListener(ouvinteCadastrarCanal);

	}

	private void adiconarLabels() {
		
		Componentes.addJLabel(this, "Novo Canal", 318, 20, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Nome", 220, 130, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Tipo", 220, 200, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);

		numeroCanal = Componentes.addJLabel(this,"Número do Canal", 220, 315, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		linkBroadcasting = Componentes.addJLabel(this,"Link", 220, 315, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		linkBroadcasting.setVisible(false);
	}

	private void adicionarTextFields() {
		tfNome = Componentes.addJTextField(this, 220, 162, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		// tfTipo = Componentes.addJTextField(this, 220, 232,Medidas.COMPRIMENTO_255,
		tfNumeroOuLink = Componentes.addJTextField(this, 220, 350, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		// Medidas.ALTURA_30);
	}

	public void adicionarRadios() {
		rb1 = Componentes.addRadioButton(this, "Televisão", 220, 233, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		rb1.setSelected(true);
		rb2 = Componentes.addRadioButton(this, "Broadcasting", 350, 233, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		OuvinteRadioButton ouvinteRadioBotao = new OuvinteRadioButton(this);

		rb1.addActionListener(ouvinteRadioBotao);
		rb2.addActionListener(ouvinteRadioBotao);
		ButtonGroup group = new ButtonGroup();
		group.add(rb1);
		group.add(rb2);
	}

	public void addComboBoxCanaisTelevisao() {
		CentralDeInformacoes central = new CentralDeInformacoes();
		cbTv = Componentes.inserirComboBox(this, central.obterTiposDeCanaisTelevisivos(), 220, 270, Medidas.COMPRIMENTO_255,
				Medidas.ALTURA_30);

	}

	public void addComboBoxCanaisBroadcasting() {
		CentralDeInformacoes central = new CentralDeInformacoes();
		cbBroadcasting = Componentes.inserirComboBox(this, central.obterTiposDeCanaisBroadcasting(), 220, 270, Medidas.COMPRIMENTO_255,
				Medidas.ALTURA_30);
		cbBroadcasting.setVisible(false);

	}
	public void addComboBoxes() {
		addComboBoxCanaisBroadcasting();
		addComboBoxCanaisTelevisao();
	}
	
		

}
