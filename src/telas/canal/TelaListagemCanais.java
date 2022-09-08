package telas.canal;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.itextpdf.text.log.SysoCounter;

import modelo.usuario.Usuario;
import telas.TelaPadrao;
import telas.canal.ouvintes.OuvinteBotoesTelaListagem;
import telas.ouvintes.OuvinteBotaoVoltarParaHome;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Icones;
import utilidades.Imagens;
import utilidades.Medidas;
import utilidades.OutlineJLabel;
import utilidades.Persistencia;

public class TelaListagemCanais extends TelaPadrao {

	private OutlineJLabel lbTitulo;
	private JButton botaoAddCanal;
	private JButton botaoFiltro;
	private JButton botaoDetalhes;
	private Usuario usuarioLogado;
	private JTextField tfPesquisa;
	private JTable tabelaListagem;

	public OutlineJLabel getLbTitulo() {
		return lbTitulo;
	}

	public void setLbTitulo(OutlineJLabel lbTitulo) {
		this.lbTitulo = lbTitulo;
	}

	public JButton getBotaoAddCanal() {
		return botaoAddCanal;
	}

	public void setBotaoAddCanal(JButton botaoAddCanal) {
		this.botaoAddCanal = botaoAddCanal;
	}

	public JButton getBotaoFiltro() {
		return botaoFiltro;
	}

	public void setBotaoFiltro(JButton botaoFiltro) {
		this.botaoFiltro = botaoFiltro;
	}

	public JButton getBotaoDetalhes() {
		return botaoDetalhes;
	}

	public void setBotaoDetalhes(JButton botaoDetalhes) {
		this.botaoDetalhes = botaoDetalhes;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public JTextField getTfPesquisa() {
		return tfPesquisa;
	}

	public void setTfPesquisa(JTextField tfPesquisa) {
		this.tfPesquisa = tfPesquisa;
	}

	public JTable getTabelaListagem() {
		return tabelaListagem;
	}

	public void setTabelaListagem(JTable tabelaListagem) {
		this.tabelaListagem = tabelaListagem;
	}

	public TelaListagemCanais(Usuario usuarioLogado) {
		super("Listagem de Canais");
		this.usuarioLogado = usuarioLogado;
		adicionarTabela();
		adicionarBotoes();

	}

	@Override
	public void adicionarComponentesGraficos() {
		adicionarBackground();
		adicionarMenu();
		adiconarLabels();
		adicionarTextField();
	}

	private void adicionarBackground() {
		JLabel background = new JLabel(Imagens.BACKGROUND_TELA_LISTAGEM);
		setContentPane(background);
	}

	private void adicionarMenu() {
		Componentes.addMenuPadrao(this);
	}

	private void adiconarLabels() {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");

		lbTitulo = Componentes.addJLabel(this, "Canais", 408, 30, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		lbTitulo.setOutlineColor(Color.WHITE);
		Componentes.addJLabel(this, "Canais cadastrados: " + central.getCanais().size(), 30, Medidas.DEFAULT_Y_FOOTER, 400,
				Medidas.ALTURA_30);
	}

	private void adicionarTabela() {
		tabelaListagem = Componentes.addTabelaTodosCanais(this, this.usuarioLogado, tfPesquisa, 30, 130, 825, 370);
	}

	private void adicionarTextField() {
		tfPesquisa = Componentes.addJTextFieldComIcone(this, Icones.LUPA, 30, 100, 280, 25);
		tfPesquisa.setForeground(Color.GRAY);
		tfPesquisa.setToolTipText("Realize uma busca");
	}

	private void adicionarBotoes() {
		JButton botaoVoltar = Componentes.addJButton(this, "Voltar", Icones.VOLTAR, 20, 20, Medidas.COMPRIMENTO_50,
				Medidas.ALTURA_30);
		botaoVoltar.addActionListener(new OuvinteBotaoVoltarParaHome(this, usuarioLogado));

		botaoAddCanal = Componentes.addJButton(this, "", Icones.ADICIONAR, 805, 95, Medidas.COMPRIMENTO_50, Medidas.ALTURA_30);
		OuvinteBotoesTelaListagem ouvinteAdd = new OuvinteBotoesTelaListagem(this);
		botaoAddCanal.addActionListener(ouvinteAdd);
		botaoAddCanal.setToolTipText("Novo Canal");

		botaoDetalhes = Componentes.addJButton(this, "Detalhes", 725, Medidas.DEFAULT_Y_FOOTER, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		OuvinteBotoesTelaListagem ouvinteDetalhes = new OuvinteBotoesTelaListagem(this);
		botaoDetalhes.addActionListener(ouvinteDetalhes);
		if(tabelaListagem.getModel().getRowCount() == 0){
			botaoDetalhes.setEnabled(false);
		}
	}

}
