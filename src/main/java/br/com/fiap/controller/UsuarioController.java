package br.com.fiap.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fiap.model.UsuarioModel;
import br.com.fiap.repository.UsuarioRepository;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UsuarioController {
	
	@Autowired
	public UsuarioRepository repository;
	
	@PostMapping("/signup")
	@ApiOperation(value = "Cadastra um novo usuário")
	public ResponseEntity<Object> save(@RequestBody @Valid UsuarioModel usuarioModel) {
		UsuarioModel usuario = repository.save(usuarioModel);
		System.out.println(usuario.getEmailUsuario());
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(usuario.getIdUsuario()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/login")
	@ApiOperation(value = "Verifica se o usuário existe")
	public String doLogin(@RequestBody UsuarioModel usuario) {
		String nome_usuario = repository.doLogin(usuario.getEmailUsuario(), usuario.getSenhaUsuario());
		
		return nome_usuario;
	}
}
