package br.com.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.fiap.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, String>{
	@Query("SELECT nomeUsuario from UsuarioModel u WHERE u.emailUsuario = ?1 AND  u.senhaUsuario = ?2")
	String doLogin(String email_usuario, String senha_usuario);
}
