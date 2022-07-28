package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import modelo.usuario.Usuario;
import telas.programa.TelaListagemProgramas;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Icones;
import utilidades.Medidas;
import utilidades.Persistencia;

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
		JButton programa = Componentes.addJButton(this,"Programa", 253, 222, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJButton(this,"Canal", 383, 222, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		JMenuBar barraMenu = Componentes.addJMenubar(this,  600, 80, 80, 80);
		JMenu menu = Componentes.addJMenuComIcone(barraMenu, Icones.ENGRENAGEM);
		menu.setToolTipText("op��es");
		programa.addActionListener(new OuvinteBotaoPrograma());
		
		JMenuItem perfil = Componentes.addItemNoMenu(menu, "Sair");
	}
	private class OuvinteBotaoPrograma implements ActionListener{
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral("central");

		public void actionPerformed(ActionEvent e) {
		//	Usuario usuarioAtivo = central.getUsuariosCadastrados().get(1);
			//TODO: ACHAR UMA FORMA DE RESGATAR O USUARIO ATIVO
			dispose();
//			new TelaListagemProgramas(usuarioAtivo);
		}
		
	}
	public void adiconarLabels() {
		Componentes.addJLabel(this, "BEM VINDO(a)", 318, 100, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		
	}
	//remover caso seja necess�rio e utilizar outro esquema
	
	
}
