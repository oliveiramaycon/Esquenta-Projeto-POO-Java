package telas.ouvintes;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import modelo.usuario.Usuario;
import telas.TelaInicial;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Mensageiro;
import utilidades.Persistencia;

public class OuvinteDaLabellRecuperarSenha implements MouseListener {
	
	private TelaInicial telaInicial;
	
	public OuvinteDaLabellRecuperarSenha(TelaInicial telaInicial) {
		this.telaInicial = telaInicial;
	}
	
// METODO SO SERVE PARA ENTRAR NA NOVA TELA NAO FEITO NA CLASSE LINKlABEL POR CONFLITOS COM A CLASS:
	
	public void mouseClicked(MouseEvent e) {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");
		
		
		Usuario estouValido = central.getUsuariosCadastrados().get(0);
		
		
		if(estouValido != null) {
			Mensageiro.enviarSenha(estouValido);
			System.out.println("feito");
		}else
			Componentes.msgFalha(telaInicial, "Usuario esta invalido");
		
		//if(estouValido != null) {
	}
//}	
	
//			String senha = JOptionPane.showInputDialog("Nova  senha");
//			String ComfirmacaoSenha = JOptionPane.showInputDialog("Confirme a senha ");
//			if(senha.equals(ComfirmacaoSenha)) {
//			central.editarSenha(senha, login);
//			persistencia.salvarCentral(central,"central");
//			}else
//				JOptionPane.showMessageDialog(telaInicial, "Snha e corfimacao dela nao sao iguais");
//		}else
//			JOptionPane.showMessageDialog(telaInicial, "Voce nao esta valido para recuperar a senha!!");
//		

	
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
