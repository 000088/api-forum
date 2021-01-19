package br.com.forum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.forum.email.EmailService;
import br.com.forum.modelo.Usuario;
import br.com.forum.repository.UsuarioRepository;

@RestController
@RequestMapping("/user")
public class CadastroController {
	
  @Autowired	
  UsuarioRepository userRepository;

  @Autowired
  EmailService emailService;
	
	    @PostMapping
	    @RequestMapping("/register") //criacao de usuario com nome,email e senha
	    public ResponseEntity<?> register (@RequestBody @Valid Usuario user){
		user.setSenha(new BCryptPasswordEncoder().encode(user.getPassword()));
		userRepository.save(user);
		emailService.sendEmail(user); //enviando email para usuario registrado na api
						
		return ResponseEntity.ok("Criado com sucesso");
	}

}
