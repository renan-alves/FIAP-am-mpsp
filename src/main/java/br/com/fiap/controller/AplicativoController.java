package br.com.fiap.controller;

import java.net.URI;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fiap.model.ChamadoModel;
import br.com.fiap.repository.ChamadoRepository;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/aplicativo")
public class AplicativoController {
	
	@Autowired
	public ChamadoRepository repository;

	@GetMapping()
	@ApiOperation(value = "Retorna uma lista de chamados")
	public ResponseEntity<List<ChamadoModel>> findAll(Model model) {
			
		List<ChamadoModel> chamados = repository.findAll();
		return ResponseEntity.ok(chamados);		
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna o chamado a partir do identificador")
	public ResponseEntity<ChamadoModel> findById(@PathVariable("id") long id) {
		
		ChamadoModel chamado = repository.findById(id).get();
		return ResponseEntity.ok(chamado);
	}
	
	@PostMapping()
	@ApiOperation(value = "Cadastra um novo chamado")
	public ResponseEntity<Object> save(@RequestBody @Valid ChamadoModel chamadoModel) {
		chamadoModel.setDataCriacao(Timestamp.from(Instant.now()));
		ChamadoModel chamado = repository.save(chamadoModel);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(chamado.getIdChamado()).toUri();
		//Procurar como retornar json de resposta 
//		{
//			"msg":"usuário criado com sucesso"
//		}
//		
		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/fechamento")
	@ApiOperation(value = "Finaliza um chamado aberto")
	public ResponseEntity<Object> updateFechaChamado(@RequestBody Map<String, Long> protocoloChamado) {
		
		ChamadoModel chamado = repository.findByProtocoloChamado(protocoloChamado.get("protocoloChamado"));
		chamado.setDataResposta(Timestamp.from(Instant.now()));
		chamado.setStatusChamado("fechado");
		
		repository.updateStatusChamado(chamado.getStatusChamado(), chamado.getDataResposta(), chamado.getProtocoloChamado());

		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/avaliacao")
	@ApiOperation(value = "Atualiza avaliacao")
	public ResponseEntity<Object> updateAvaliacaoChamado(@RequestBody Map<String, Long> json) {
		ChamadoModel chamado = repository.findByProtocoloChamado(json.get("protocoloChamado"));
		chamado.setNotaChamado(json.get("notaChamado").intValue());
		
		repository.updateNotaChamado(chamado.getNotaChamado(), chamado.getProtocoloChamado());

		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Exclui um chamado")
	public ResponseEntity<Object> deleteById(@PathVariable("id") long id) {
		
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
