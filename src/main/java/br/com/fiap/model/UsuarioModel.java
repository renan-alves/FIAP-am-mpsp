package br.com.fiap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "TB_USUARIO")
public class UsuarioModel {

	private long idUsuario;
	private String nomeUsuario;
	private String emailUsuario;
	private String senhaUsuario;

	public UsuarioModel() {
	}

	public UsuarioModel(String emailUsuario, String senhaUsuario) {
		super();
		this.emailUsuario = emailUsuario;
		this.senhaUsuario = senhaUsuario;
	}


	@Column(name = "EmailUsuario")
	@NotNull(message = "Email obrigatório")
	@Size(min = 10, max = 80, message = "Email deve ser entre 10 e 80 caracteres")
	public String getEmailUsuario() {
		return emailUsuario;
	}
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	@Column(name = "SenhaUsuario")
	@NotNull(message = "Senha obrigatório")
	@Size(min = 8, max = 50, message = "Senha deve ser entre 08 e 50 caracteres")
	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Id
	@Column(name = "IdUsuario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_SEQ")
	@SequenceGenerator(name = "USUARIO_SEQ", sequenceName = "USUARIO_SEQ", allocationSize = 1)
	@ApiModelProperty(value = "Id do Usuário")
	public long getIdUsuario() {
		return idUsuario;
	}

	@Column(name = "NomeUsuario")
	@NotNull(message = "Nome obrigatório")
	@Size(min = 2, max = 50, message = "NOME deve ser entre 2 e 40 caractéres")
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
}
