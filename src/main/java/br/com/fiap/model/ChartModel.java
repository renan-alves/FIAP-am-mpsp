package br.com.fiap.model;

public class ChartModel {

	private String data_criacao;
	private String status;
	private String quantidade;
	
	public ChartModel(String data_criacao, String status, String quantidade) {
		this.data_criacao = data_criacao;
		this.status = status;
		this.quantidade = quantidade;
	}
	
	public String getData_criacao() {
		return data_criacao;
	}
	public void setData_criacao(String data_criacao) {
		this.data_criacao = data_criacao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getquantidade() {
		return quantidade;
	}
	public void setquantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
