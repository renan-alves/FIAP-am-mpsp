package br.com.fiap.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fiap.model.ChamadoModel;
import br.com.fiap.repository.ChamadoRepository;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/chamado")
public class ChamadoController {
	
	@Autowired
	public ChamadoRepository repository;
	
	@GetMapping()
	public String findAll(Model model) {
		List<ChamadoModel> findByStatus_chamado = repository.findByStatusChamado("aberto");
		model.addAttribute("listaChamados", findByStatus_chamado);
		model.addAttribute("quantidadeAberto", repository.countByStatusChamado("aberto"));
		model.addAttribute("quantidadeAguardando", repository.countByStatusChamado("aguardando"));
		model.addAttribute("quantidadeFechado", repository.countByStatusChamado("fechado"));
		return "home";
	}
	
	@GetMapping("/lista")
	public String findById(@RequestParam String status, Model model) {
		List<ChamadoModel> findByStatusChamado = repository.findByStatusChamado(status);
		model.addAttribute("listaChamados", findByStatusChamado);
		model.addAttribute("quantidadeAberto", repository.countByStatusChamado("aberto"));
		model.addAttribute("quantidadeAguardando", repository.countByStatusChamado("aguardando"));
		model.addAttribute("quantidadeFechado", repository.countByStatusChamado("fechado"));
		return "home";
	}

	@PostMapping()
	@ApiOperation(value = "Cadastra um novo chamado")
	public ResponseEntity<Object> save(@RequestBody @Valid ChamadoModel chamadoModel) {
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
	
	@PutMapping()
	@ApiOperation(value = "Finaliza um chamado aberto")
	public ResponseEntity<Object> updateStatusChamado(@RequestBody ChamadoModel chamado ) {
		
		chamado.setNotaChamado(chamado.getNotaChamado());
		chamado.setStatusChamado(chamado.getStatusChamado());
		chamado.setProtocoloChamado(chamado.getProtocoloChamado());
		repository.updateStatusChamado(chamado.getNotaChamado(), chamado.getStatusChamado(), chamado.getProtocoloChamado());

		
		return ResponseEntity.ok().build();
	}
}
