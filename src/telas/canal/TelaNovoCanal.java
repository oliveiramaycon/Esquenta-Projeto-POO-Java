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
import telas.canal.ouvintes.OuvinteBotaoVoltarListagem;
import telas.canal.ouvintes.OuvinteRadioButton;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Icones;
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
		adicionarBotoes();
	}

	public TelaNovoCanal(Canal canal, Usuario usuarioLogado) {
		super("Edicao de Canal");
		this.canal = canal;
		this.usuarioLogado = usuarioLogado;
		adicionarBotoes();
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
		adicionarMenu();
		adiconarLabels();
		adicionarTextFields();
		adicionarRadios();
		addComboBoxes();
	}

	private void adicionarBackground() {
		JLabel background = new JLabel(Imagens.BACKGROUND_TELA_CADASTRO);
		setContentPane(background);
	}

	private void adicionarMenu() {
		Componentes.addMenuPadrao(this);
	}

	private void adicionarBotoes() {
		JButton botaoVoltar = Componentes.addJButton(this, "Voltar", Icones.VOLTAR, 40, 20, Medidas.COMPRIMENTO_50,
				Medidas.ALTURA_30);
		OuvinteBotaoVoltarListagem ouvinteBotaoVoltarParaListagem = new OuvinteBotaoVoltarListagem(this, usuarioLogado);
		botaoVoltar.addActionListener(ouvinteBotaoVoltarParaListagem);

		botaoCadastrar = Componentes.addJButton(this, "Cadastrar", 370, 490, Medidas.COMPRIMENTO_130,
				Medidas.ALTURA_30);
		OuvinteBotaoCadastrarCanal ouvinteCadastrarCanal = new OuvinteBotaoCadastrarCanal(this);
		botaoCadastrar.addActionListener(ouvinteCadastrarCanal);

	}

	private void adiconarLabels() {
		lbTitulo = Componentes.addJLabel(this, "Novo Canal", 390, 30, Medidas.COMPRIMENTO_310, Medidas.ALTURA_30);
		lbTitulo.setOutlineColor(Color.WHITE);

		Componentes.addJLabel(this, "Nome", 240, 130, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Tipo", 240, 200, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);

		numeroCanal = Componentes.addJLabel(this, "Numero do Canal", 240, 315, Medidas.COMPRIMENTO_255,
				Medidas.ALTURA_30);
		linkBroadcasting = Componentes.addJLabel(this, "Link", 240, 315, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		linkBroadcasting.setVisible(false);
	}

	private void adicionarTextFields() {
		tfNome = Componentes.addJTextField(this, 240, 162, 400, Medidas.ALTURA_30);
		tfNumeroOuLink = Componentes.addJTextField(this, 240, 350, 400, Medidas.ALTURA_30);

	}

	private void adicionarRadios() {
		rb1 = Componentes.addRadioButton(this, "Televisao", 240, 233, 170, Medidas.ALTURA_30);
		rb1.setSelected(true);
		rb2 = Componentes.addRadioButton(this, "Broadcasting", 410, 233, 230, Medidas.ALTURA_30);
		OuvinteRadioButton ouvinteRadioBotao = new OuvinteRadioButton(this);

		rb1.addActionListener(ouvinteRadioBotao);
		rb2.addActionListener(ouvinteRadioBotao);
		ButtonGroup group = new ButtonGroup();
		group.add(rb1);
		group.add(rb2);
	}

	private void addComboBoxCanaisTelevisao() {
		CentralDeInformacoes central = new CentralDeInformacoes();
		cbTv = Componentes.inserirComboBox(this, central.obterTiposDeCanaisTelevisivos(), 240, 270, 400,
				Medidas.ALTURA_30);

	}

	private void addComboBoxCanaisBroadcasting() {
		CentralDeInformacoes central = new CentralDeInformacoes();
		cbBroadcasting = Componentes.inserirComboBox(this, central.obterTiposDeCanaisBroadcasting(), 240, 270, 400,
				Medidas.ALTURA_30);
		cbBroadcasting.setVisible(false);

	}

	private void addComboBoxes() {
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

	private void preencherCampos() {

		botaoCadastrar.setText("Salvar");

		lbTitulo.setVisible(false);
		Componentes.addJLabel(this, "Edicao de Canal", 335, 20, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30)
				.setOutlineColor(Color.WHITE);
		;

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
