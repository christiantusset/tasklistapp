package com.christiantusset.tasklistapp.services;

import com.christiantusset.tasklistapp.dto.TarefaDTO;
import com.christiantusset.tasklistapp.entity.Tarefa;
import com.christiantusset.tasklistapp.repositories.TarefaRepository;
import com.christiantusset.tasklistapp.services.exceptions.DataIntegrityException;
import com.christiantusset.tasklistapp.services.exceptions.ObjectNotFoundException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository repo;

	/**
	 * Método para buscar tarefa pelo ID.
	 * @param id
	 */
	public Tarefa buscarTarefa(Integer id) {
		Optional<Tarefa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Tarefa.class.getName()));
	}

	/**
	 * Método para inserir nova Tarefa no banco de dados
	 * @param tarefa
	 */
	public Tarefa salvarTarefa(Tarefa tarefa) {
		tarefa.setId(null);
		return repo.save(tarefa);
	}

	/**
	 * Método para retornar todas as Tarefas do banco de dados
	 * @return
	 */
	public List<Tarefa> retornaTodasTarefas() {
		return repo.findAll();
	}

	/**
	 * Método para remover tarefa do banco
	 * @param id
	 */
	public void remover(Integer id) {
		Tarefa tarefa = buscarTarefa(id);
		try {
			repo.delete(tarefa);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}

	/**
	 * Método para atualizar registro no banco de dados
	 * @param tarefa
	 */
	public Tarefa atualizarTarefa(Tarefa tarefa) {
		Tarefa newTarefa = buscarTarefa(tarefa.getId());
		atualizarDados(newTarefa, tarefa);
		return repo.save(newTarefa);
	}

	/**
	 * Método para atualizar informações da Tarefa
	 * @param newTarefa
	 * @param tarefa
	 */
	private void atualizarDados(Tarefa newTarefa, Tarefa tarefa) {
		newTarefa.setTitulo(tarefa.getTitulo());
		newTarefa.setDescricao(tarefa.getDescricao());
		newTarefa.setStatus(tarefa.getStatus());
		newTarefa.setDataCriacao(tarefa.getDataCriacao());
		newTarefa.setDataEdicao(tarefa.getDataEdicao());
		newTarefa.setDataFinalizacao(tarefa.getDataFinalizacao());
	}

	public Tarefa fromDTO(TarefaDTO tarefaDto) {
		return new Tarefa(tarefaDto.getId(), tarefaDto.getTitulo(), tarefaDto.getDescricao(),
				tarefaDto.getStatus(), tarefaDto.getDataCriacao(), tarefaDto.getDataEdicao(),
				tarefaDto.getDataFinalizacao());
	}

}
