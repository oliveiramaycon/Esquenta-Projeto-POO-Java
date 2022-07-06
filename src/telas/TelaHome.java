package telas;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import utilidades.Componentes;
import utilidades.Icones;
import utilidades.Medidas;

public class TelaHome extends TelaPadrao {

	
	public TelaHome() {
		super("Home");
	}
	
	
	@Override
	public void adicionarComponentesGraficos() {
		adicionarBotoes();
		adiconarLabels();
		
	}

	
	public void adicionarBotoes() {
		Componentes.addJButton(this,"Programa", 253, 222, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJButton(this,"Canal", 383, 222, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		JMenuBar barraMenu = Componentes.addJMenubar(this,  600, 80, 80, 80);
		JMenu menu = Componentes.addJMenuComIcone(barraMenu, Icones.ENGRENAGEM);
		menu.setToolTipText("opções");
		
		JMenuItem perfil = Componentes.addItemNoMenu(menu, "Sair");
	}
	
	public void adiconarLabels() {
		Componentes.addJLabel(this, "BEM VINDO(a)", 318, 100, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		
	}
	//remover caso seja necessário e utilizar outro esquema
	
	
}
