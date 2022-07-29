package utilidades;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;

import modelo.usuario.Usuario;

public class Mensageiro {

public static void enviarEmail(Usuario u) {
		
		String remetente = "projetoseriespoo@gmail.com";
		String senha = "nchwpdgmrfccbxki";
		
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(remetente, senha));
		email.setSSLOnConnect(true);
		try {
			email.setFrom(remetente);
			email.setSubject("Programaçao da semana");
			email.setMsg("Segue anexo da programacao da semana");
			email.addTo(u.getEmail());
			
			EmailAttachment anexo = new EmailAttachment();
			
			anexo.setPath("relatorio.pdf");
			email.attach(anexo);
			email.send();
			JOptionPane.showMessageDialog(null, "Envio Realizado com Sucesso", "", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

