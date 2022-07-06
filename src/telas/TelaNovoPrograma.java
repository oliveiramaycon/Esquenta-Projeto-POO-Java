package telas;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import telas.ouvintes.OuvinteBotaoCadastrarPrograma;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Medidas;

public class TelaNovoPrograma extends TelaPadrao {

	private JTextField tfNome;
	private JComboBox<String> tfTipo;
	private JTextField tfCanalDeTransmissao;
	private JTextField tfdiasDeTransmissao;
	
	
	
	public JTextField getTfNome() {
		return tfNome;
	}
	public void setTfNome(JTextField tfNome) {
		this.tfNome = tfNome;
	}
	
	public JComboBox<String> getTfTipo() {
		return tfTipo;
	}
	public void setTfTipo(JComboBox<String> tfTipo) {
		this.tfTipo = tfTipo;
	}
	public JTextField getTfCanalDeTransmissao() {
		return tfCanalDeTransmissao;
	}
	public void setTfCanalDeTransmissao(JTextField tfCanalDeTransmissao) {
		this.tfCanalDeTransmissao = tfCanalDeTransmissao;
	}
	public JTextField getTfdiasDeTransmissao() {
		return tfdiasDeTransmissao;
	}
	public void setTfdiasDeTransmissao(JTextField tfdiasDeTransmissao) {
		this.tfdiasDeTransmissao = tfdiasDeTransmissao;
	}



	
	public TelaNovoPrograma() {
		super("Novo Programa");
	}
	
	
	
	@Override
	public void adicionarComponentesGraficos() {
		adicionarBotoes();
		adiconarLabels();
		adicionarTextFields();
		comboBoxTipoPrograma();
	}
	
	public void adicionarBotoes() {
		JButton botaoVoltar = Componentes.addJButton(this, "Voltar", 20, 20, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		//TODO:ouvinte voltar
		
		
		JButton botaoCadastrar = Componentes.addJButton(this, "Cadastrar", 280, 305, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		OuvinteBotaoCadastrarPrograma ouvinteCadastrarPrograma = new OuvinteBotaoCadastrarPrograma(this);
		botaoCadastrar.addActionListener(ouvinteCadastrarPrograma);
	}
	
	public void adiconarLabels() {
		Componentes.addJLabel(this, "Novo Programa", 318, 20, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Nome", 220, 30, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Tipo", 220, 100, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Canal de Exibição", 220, 170, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Dias de Transmissão", 220, 240, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
	}
	
	
	public void adicionarTextFields() {
		tfNome = Componentes.addJTextField(this, 220, 65,Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		tfCanalDeTransmissao = Componentes.addJTextField(this, 220, 205,Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		tfdiasDeTransmissao = Componentes.addJTextField(this, 220, 270,Medidas.COMPRIMENTO_255, Medidas.ALTURA_30); //substituir por checkBox. aqui marca apenas as medidas
	}
	
	public void comboBoxTipoPrograma() {
		tfTipo = Componentes.inserirComboBox(this, 220, 135,Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
	}

}
