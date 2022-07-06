package telas;

import javax.swing.JButton;
import javax.swing.JTextField;

import telas.ouvintes.OuvinteBotaoCadastrarCanal;
import utilidades.Componentes;
import utilidades.Medidas;

public class TelaNovoCanal extends TelaPadrao {
	
	private JTextField tfNome;
	private JTextField tfTipo;
	
	
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



	public TelaNovoCanal() {
		super("Novo Canal");
	}
	
	
	@Override
	public void adicionarComponentesGraficos() {
		adicionarBotoes();
		adiconarLabels();
		adicionarTextFields();
	}
	
	private void adicionarBotoes() {
		JButton botaoVoltar = Componentes.addJButton(this, "Voltar", 20, 20, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		//TODO:ouvinte voltar
		JButton botaoCadastrar = Componentes.addJButton(this, "Cadastrar", 280, 270, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		OuvinteBotaoCadastrarCanal ouvinteCadastrarCanal = new OuvinteBotaoCadastrarCanal(this);
		botaoCadastrar.addActionListener(ouvinteCadastrarCanal);
	
	}
	
	private void adiconarLabels() {
		Componentes.addJLabel(this, "Novo Canal", 318, 20, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Nome", 220, 130, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Tipo", 220, 200, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		
	}
	
	
	private void adicionarTextFields() {
		tfNome = Componentes.addJTextField(this, 220, 162,Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		tfTipo = Componentes.addJTextField(this, 220, 232,Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
	}

}
