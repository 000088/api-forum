package br.com.forum.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.forum.modelo.Usuario;

@Service
public class EmailService {  
	
	@Autowired                                         //ENVIADOR DE EMAIL COM JAVAMAILSENDER
	private JavaMailSender javaMailSender;
		
    public void sendEmail (Usuario user) {
	 
	 SimpleMailMessage mail = new SimpleMailMessage();
	 mail.setTo(user.getEmail());
	 mail.setFrom("no-reply@gabriel.com");
	 mail.setSubject("Sending email!!");
	 mail.setText("Hello "+ user.getNome()); //texto enviado para o email do usuario
	 
	 javaMailSender.send(mail);                   

 }
 
 

 
 
 
	
	
}