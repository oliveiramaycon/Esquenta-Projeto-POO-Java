package telas.programa.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.usuario.Usuario;
import telas.programa.TelaListagemProgramas;
import utilidades.GeradorDePdf;
import utilidades.Mensageiro;

public class OuvinteMenu implements ActionListener {

	private TelaListagemProgramas telaListagemProgramas;

	public OuvinteMenu(TelaListagemProgramas telaListagemProgramas) {
		super();
		this.telaListagemProgramas = telaListagemProgramas;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String opcao = e.getActionCommand();

		switch (opcao) {

		case "Receber programacao":
			JOptionPane.showMessageDialog(telaListagemProgramas, "Aguarde, estamos gerando a programacao!");
			GeradorDePdf.SeriesFavoritas();
			JOptionPane.showMessageDialog(telaListagemProgramas, "Documento gerado com sucesso!");
			break;

		case "Emitir Relatorio":
			JOptionPane.showMessageDialog(telaListagemProgramas, "Aguarde, estamos enviando o E-mail!");
			GeradorDePdf.ObterProgramacao();
			Mensageiro.enviarEmail();
			JOptionPane.showMessageDialog(telaListagemProgramas, "E-mail enviado com sucesso!");
			break;
		}

	}

}
