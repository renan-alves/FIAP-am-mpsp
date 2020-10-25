package br.com.fiap.repository;

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
	
	List<ChamadoModel> findByStatusChamado(String chamado);
	
	Long countByStatusChamado(String chamado);
}
