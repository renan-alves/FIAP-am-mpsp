package br.com.fiap.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.model.ChamadoModel;

@Repository
public interface ChamadoRepository extends JpaRepository<ChamadoModel, Long>{

	@Transactional
	@Modifying
	@Query(value = "UPDATE tb_chamado SET nota_chamado = ?1, status_chamado = ?2 WHERE protocolo_Chamado = ?3", nativeQuery = true)
	void updateStatusChamado(int notaChamado, String statusChamado, long protocoloChamado);
	
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE tb_chamado SET status_chamado = ?1, data_resposta = ?2 WHERE protocolo_Chamado = ?3", nativeQuery = true)
	void updateStatusChamado(String statusChamado, Timestamp dataResposta, long protocoloChamado);
	
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE tb_chamado SET nota_chamado = ?1 WHERE protocolo_Chamado = ?2", nativeQuery = true)
	void updateNotaChamado(int notaChamado, long protocoloChamado);
	
	List<ChamadoModel> findByStatusChamado(String chamado);
	
	Long countByStatusChamado(String chamado);
	
	@Query(value = "select TO_CHAR(data_criacao, 'dd/mm/yyyy') as \"data_criacao\", "+
		       "count(case when status_chamado = 'aberto' then 1 end) as \"abertos\", " +
		       "count(case when status_chamado = 'aguardando' then 1 end) as \"aguardando\", " +
		       "count(case when status_chamado = 'fechado' then 1 end) as \"fechados\" from tb_chamado " +
		       "group by TO_CHAR(data_criacao, 'dd/mm/yyyy') order by TO_CHAR(data_criacao, 'dd/mm/yyyy') desc", nativeQuery = true)
	List<Object> findChartData();

	ChamadoModel findByProtocoloChamado(Long protocolo);
}