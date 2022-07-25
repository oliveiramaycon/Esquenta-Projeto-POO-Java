package telas.canal;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import modelo.canal.Canal;
import modelo.canal.CanalBroadcasting;
import modelo.canal.CanalDeTv;
import modelo.canal.enums.TipoCanal;
import modelo.usuario.Usuario;
import telas.TelaPadrao;
import telas.canal.ouvintes.OuvinteBotaoCadastrarCanal;
import telas.canal.ouvintes.OuvinteRadioButton;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Imagens;
import utilidades.Medidas;
import utilidades.OutlineJLabel;

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
	private Canal canal;
	private OutlineJLabel lbTitulo;
	private JButton botaoCadastrar;
	private Usuario usuarioLogado;
	
	
	public TelaNovoCanal(Usuario usuarioLogado) {
		super("Novo Canal");
		this.canal = null;
		this.usuarioLogado = usuarioLogado;
	}

	public TelaNovoCanal(Canal canal,  Usuario usuarioLogado) {
		super("Edição de Canal");
		this.canal = canal;
		this.usuarioLogado = usuarioLogado;
		preencherCampos();
	}
	
	
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

	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}

	public OutlineJLabel getLbTitulo() {
		return lbTitulo;
	}

	public void setLbTitulo(OutlineJLabel lbTitulo) {
		this.lbTitulo = lbTitulo;
	}

	public JButton getBotaoCadastrar() {
		return botaoCadastrar;
	}

	public void setBotaoCadastrar(JButton botaoCadastrar) {
		this.botaoCadastrar = botaoCadastrar;
	}
	
	

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	

	@Override
	public void adicionarComponentesGraficos() {
		adicionarBackground();
		adicionarBotoes();
		adiconarLabels();
		adicionarTextFields();
		adicionarRadios();
		addComboBoxes();
	}

	public void adicionarBackground() {
		JLabel background = new JLabel(Imagens.BACKGROUND_TELA_CADASTRO_DE_CANAL);
		//background.setBounds(0,0,786, 524);
		setContentPane(background);
	}

	private void adicionarBotoes() {
		JButton botaoVoltar = Componentes.addJButton(this, "Voltar", 20, 20, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		// TODO:ouvinte voltar
		botaoCadastrar = Componentes.addJButton(this, "Cadastrar", 310, 400, Medidas.COMPRIMENTO_130,
				Medidas.ALTURA_30);
		OuvinteBotaoCadastrarCanal ouvinteCadastrarCanal = new OuvinteBotaoCadastrarCanal(this);
		botaoCadastrar.addActionListener(ouvinteCadastrarCanal);

	}

	private void adiconarLabels() {
		lbTitulo = Componentes.addJLabel(this, "Novo Canal", 324, 20, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		lbTitulo.setOutlineColor(Color.WHITE);
		
		Componentes.addJLabel(this, "Nome", 220, 130, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Tipo", 220, 200, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);

		numeroCanal = Componentes.addJLabel(this, "Número do Canal", 220, 315, Medidas.COMPRIMENTO_255,
				Medidas.ALTURA_30);
		linkBroadcasting = Componentes.addJLabel(this, "Link", 220, 315, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		linkBroadcasting.setVisible(false);
	}

	private void adicionarTextFields() {
		tfNome = Componentes.addJTextField(this, 220, 162, Medidas.COMPRIMENTO_310, Medidas.ALTURA_30);
		tfNumeroOuLink = Componentes.addJTextField(this, 220, 350, Medidas.COMPRIMENTO_310, Medidas.ALTURA_30);

	}

	public void adicionarRadios() {
		rb1 = Componentes.addRadioButton(this, "Televisão", 220, 233, 170, Medidas.ALTURA_30);
		rb1.setSelected(true);
		rb2 = Componentes.addRadioButton(this, "Broadcasting", 390, 233, 140, Medidas.ALTURA_30);
		OuvinteRadioButton ouvinteRadioBotao = new OuvinteRadioButton(this);

		rb1.addActionListener(ouvinteRadioBotao);
		rb2.addActionListener(ouvinteRadioBotao);
		ButtonGroup group = new ButtonGroup();
		group.add(rb1);
		group.add(rb2);
	}

	public void addComboBoxCanaisTelevisao() {
		CentralDeInformacoes central = new CentralDeInformacoes();
		cbTv = Componentes.inserirComboBox(this, central.obterTiposDeCanaisTelevisivos(), 220, 270,
				Medidas.COMPRIMENTO_310, Medidas.ALTURA_30);

	}

	public void addComboBoxCanaisBroadcasting() {
		CentralDeInformacoes central = new CentralDeInformacoes();
		cbBroadcasting = Componentes.inserirComboBox(this, central.obterTiposDeCanaisBroadcasting(), 220, 270,
				Medidas.COMPRIMENTO_310, Medidas.ALTURA_30);
		cbBroadcasting.setVisible(false);

	}

	public void addComboBoxes() {
		addComboBoxCanaisBroadcasting();
		addComboBoxCanaisTelevisao();
	}

	public boolean isEdit() {
		return this.canal != null;
	}

	private boolean isTelevisao() {
		return canal.getTipoCanal().toString().endsWith("TELEVISAO");
	}

	public TipoCanal obterTipoSelecionado() {
		TipoCanal tipo = null;

		if (getRb1().isSelected()) {
			tipo = TipoCanal.valueOf((String) getCbTv().getSelectedItem());

		} else {
			tipo = TipoCanal.valueOf((String) getCbBroadcasting().getSelectedItem());
		}

		return tipo;
	}

	public void preencherCampos() {

		botaoCadastrar.setText("Salvar");
		
		lbTitulo.setVisible(false);
		Componentes.addJLabel(this, "Edição de Canal", 315, 20, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30).setOutlineColor(Color.WHITE);;
		
		tfNome.setText(canal.getNome());
		String numeroOuLink = null;

		if (this.canal instanceof CanalDeTv) {
			CanalDeTv canal = (CanalDeTv) this.canal;
			numeroOuLink = String.valueOf(canal.getNumeroCanal());
		} else if (this.canal instanceof CanalBroadcasting) {
			CanalBroadcasting canal = (CanalBroadcasting) this.canal;
			numeroOuLink = canal.getLink();
		}

		tfNumeroOuLink.setText(numeroOuLink);

		if (isTelevisao()) {
			rb1.setSelected(true);
			cbTv.setSelectedItem(canal.getTipoCanal().toString());
			cbTv.setVisible(true);
			cbBroadcasting.setVisible(false);
			rb2.setEnabled(false);
		} else {
			rb2.setSelected(true);
			cbBroadcasting.setSelectedItem(canal.getTipoCanal().toString());
			cbBroadcasting.setVisible(true);
			cbTv.setVisible(false);
			rb1.setEnabled(false);
			getNumeroCanal().setVisible(false);
			getLinkBroadcasting().setVisible(true);
		}
	}

}
