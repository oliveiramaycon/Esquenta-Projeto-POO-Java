package telas;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import utilidades.Componentes;
import utilidades.Icones;
import utilidades.Medidas;

public class TelaListagemProgramas extends TelaPadrao{

	public TelaListagemProgramas() {
		super("Programas");
	}
	
	
	@Override
	public void adicionarComponentesGraficos() {
		adicionarBotoes();
		adiconarLabels();
	}

	public void adicionarBotoes() {
		JButton botaoVoltar = Componentes.addJButton(this, "Voltar", 20, 20, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		JMenuBar barraMenu = Componentes.addJMenubar(this,  640, 80, 30, 80);
		JMenu menu = Componentes.addJMenuComIcone(barraMenu, Icones.ENGRENAGEM);
		menu.setToolTipText("opções");
		
		JMenuItem novoPrograma = Componentes.addItemNoMenu(menu, "Novo Programa");
		JMenuItem perfil = Componentes.addItemNoMenu(menu, "Sair");
	}
	
	public void adiconarLabels() {
		Componentes.addJLabel(this, "BEM VINDO(a)", 318, 15, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Programas", 318, 85, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Filtrar", 20, 120, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		
	}
}
