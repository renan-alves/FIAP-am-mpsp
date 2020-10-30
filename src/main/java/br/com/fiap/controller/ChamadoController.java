package br.com.fiap.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
		List<Object> result = repository.findChartData();
		List<String> dia = new ArrayList<String>();
		List<String> qtdAberto = new ArrayList<String>();
		List<String> qtdAguardando = new ArrayList<String>();
		List<String> qtdFechado = new ArrayList<String>();
		
		Iterator<Object> itr = result.iterator();
		while(itr.hasNext()){
		   Object[] obj = (Object[]) itr.next();
		   dia.add("'"+obj[0].toString()+"'");
		   qtdAberto.add(obj[1].toString());
		   qtdAguardando.add(obj[2].toString());
		   qtdFechado.add(obj[3].toString());
		}
		
		model.addAttribute("quantidadeAberto", repository.countByStatusChamado("aberto"));
		model.addAttribute("quantidadeAguardando", repository.countByStatusChamado("aguardando"));
		model.addAttribute("quantidadeFechado", repository.countByStatusChamado("fechado"));
		model.addAttribute("dia", dia);
		model.addAttribute("qtdAberto", qtdAberto);
		model.addAttribute("qtdAguardando", qtdAguardando);
		model.addAttribute("qtdFechado", qtdFechado);
		
		return "home";
	}
	
	@GetMapping("/lista")
	public String findById(@RequestParam String status, Model model) {
		List<ChamadoModel> findByStatusChamado = repository.findByStatusChamado(status);
		model.addAttribute("listaChamados", findByStatusChamado);
		model.addAttribute("quantidadeAberto", repository.countByStatusChamado("aberto"));
		model.addAttribute("quantidadeAguardando", repository.countByStatusChamado("aguardando"));
		model.addAttribute("quantidadeFechado", repository.countByStatusChamado("fechado"));
		return "listas-chamados/"+status;
	}
	
	@GetMapping("/{pagina}/{protocolo}")
	public String showDetails(@PathVariable("pagina") String pagina, @PathVariable("protocolo") long protocolo, 
			Model model, RedirectAttributes redirectAttributes, HttpServletRequest request) {
		
		ChamadoModel chamado = repository.findByProtocoloChamado(protocolo);
		
		if(chamado == null) {
			redirectAttributes.addFlashAttribute("messages", "Chamado não encontrado!");
			if(pagina.equals("home")) return "redirect:/chamado";
			
			return "redirect:/chamado/lista?status="+pagina;
		}

		model.addAttribute("chamado", chamado);
		return "mock-detalhes/detalhes-"+chamado.getStatusChamado();
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
