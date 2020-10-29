package br.com.fiap.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_CHAMADO")
public class ChamadoModel {

	private long idChamado;
	private long protocoloChamado;
	private String tituloChamado;
	private String descricaoChamado;
	private String statusChamado;
	private int idPromotorChamado;
	private Integer notaChamado;
	private Timestamp dataCriacao;
	private Timestamp dataResposta;
	private UsuarioModel usuario;

	public ChamadoModel() {
	}

	public ChamadoModel(long idChamado, long protocoloChamado, String tituloChamado, String descricaoChamado,
			String statusChamado, int idPromotorChamado, Integer notaChamado, Timestamp dataCriacao, Timestamp dataResposta,
			UsuarioModel usuario) {
		this.idChamado = idChamado;
		this.protocoloChamado = protocoloChamado;
		this.tituloChamado = tituloChamado;
		this.descricaoChamado = descricaoChamado;
		this.statusChamado = statusChamado;
		this.idPromotorChamado = idPromotorChamado;
		this.notaChamado = notaChamado;
		this.dataCriacao = dataCriacao;
		this.dataResposta = dataResposta;
		this.usuario = usuario;
	}

	//Finaliza chamado
	public ChamadoModel(long protocoloChamado, String statusChamado, int idPromotorChamado, Integer notaChamado, UsuarioModel usuario ) {
		super();
		this.protocoloChamado = protocoloChamado;
		this.statusChamado = statusChamado;
		this.idPromotorChamado = idPromotorChamado;
		this.notaChamado =  notaChamado;
		this.usuario = usuario;
				
	}
	
	//Cria chamado
	public ChamadoModel(long protocoloChamado, int idPromotorChamado, UsuarioModel usuario ) {
		super();
		this.protocoloChamado = protocoloChamado;
		this.idPromotorChamado = idPromotorChamado;
		this.usuario = usuario;
	}

	@Id
	@Column(name = "IdChamado")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHAMADO_SEQ")
	@SequenceGenerator(name = "CHAMADO_SEQ", sequenceName = "CHAMADO_SEQ", allocationSize = 1)
	public long getIdChamado() {
		return idChamado;
	}

	public void setIdChamado(long idChamado) {
		this.idChamado = idChamado;
	}

	@Column(name = "ProtocoloChamado")
	@NotNull(message = "Protocolo obrigatório")
	public long getProtocoloChamado() {
		return protocoloChamado;
	}

	public void setProtocoloChamado(long protocoloChamado) {
		this.protocoloChamado = protocoloChamado;
	}

	@Column(name = "TituloChamado")
	public String getTituloChamado() {
		return tituloChamado;
	}

	public void setTituloChamado(String tituloChamado) {
		this.tituloChamado = tituloChamado;
	}

	@Column(name = "DescricaoChamado")
	public String getDescricaoChamado() {
		return descricaoChamado;
	}

	public void setDescricaoChamado(String descricaoChamado) {
		this.descricaoChamado = descricaoChamado;
	}

	@Column(name = "StatusChamado", columnDefinition = "varchar(255) default 'Aberto'")
	public String getStatusChamado() {
		return statusChamado;
	}

	public void setStatusChamado(String statusChamado) {
		this.statusChamado = statusChamado;
	}

	@Column(name = "IdPromotorChamado")	
	public int getIdPromotorChamado() {
		return idPromotorChamado;
	}

	public void setIdPromotorChamado(int idPromotorChamado) {
		this.idPromotorChamado = idPromotorChamado;
	}

	@Column(name = "NotaChamado", columnDefinition = "number(10,0) default null")
	public Integer getNotaChamado() {
		return notaChamado;
	}

	public void setNotaChamado(Integer notaChamado) {
		this.notaChamado = notaChamado;
	}
	
	@Column(name = "DataCriacao")
	public Timestamp getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Timestamp dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Column(name = "DataResposta")
	public Timestamp getDataResposta() {
		return dataResposta;
	}

	public void setDataResposta(Timestamp dataResposta) {
		this.dataResposta = dataResposta;
	}

	@ManyToOne()
	@JoinColumn(name = "IdUsuario", nullable = false)
	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

}
