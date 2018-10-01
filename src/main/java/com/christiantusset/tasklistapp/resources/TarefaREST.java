package com.christiantusset.tasklistapp.resources;

import com.christiantusset.tasklistapp.dto.TarefaDTO;
import com.christiantusset.tasklistapp.entity.Tarefa;
import com.christiantusset.tasklistapp.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TarefaREST {
	
	@Autowired
	private TarefaService service;

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index.html");
	}

	@RequestMapping(value="/tarefas", method=RequestMethod.GET)
	public ResponseEntity<List<TarefaDTO>> buscarTarefas() {
		List<Tarefa> list = service.retornaTodasTarefas();
		List<TarefaDTO> listDto = list.stream().map(obj -> new TarefaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	/**
	 * Buscar tarefa salva no banco de dados.
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/tarefa/{id}", method=RequestMethod.GET)
	public ResponseEntity<Tarefa> buscarTarefa(@PathVariable Integer id) {
		Tarefa tarefa = service.buscarTarefa(id);
		return ResponseEntity.ok().body(tarefa);
	}

	/**
	 * Salvar novos registros.
	 * @return
	 */
	@RequestMapping(value="/salvar", method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody TarefaDTO tarefaDto) {
		Tarefa obj = service.fromDTO(tarefaDto);
		obj = service.salvarTarefa(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	/**
	 * Atualizar registros existentes.
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/atualizar/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@Valid @RequestBody TarefaDTO tarefaDto, @PathVariable Integer id) {
		Tarefa obj = service.fromDTO(tarefaDto);
		obj.setId(id);
		obj = service.atualizarTarefa(obj);
		return ResponseEntity.noContent().build();
	}

	/**
	 * Remover tarefa do banco.
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/remover/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.remover(id);
		return ResponseEntity.noContent().build();
	}

}