package com.christiantusset.tasklistapp.persist;

import com.christiantusset.tasklistapp.entity.Tarefa;
import com.christiantusset.tasklistapp.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

@Service
public class DemoDB {


	@Autowired
	private TarefaRepository tarefaRepository;
	
	public void instantiateTestDatabase() throws ParseException {
		
		Tarefa tarefaExemplo1 = new Tarefa(null, "Livro", "Realizar leitura indicada",
				false, null, null, null);
		Tarefa tarefaExemplo2 = new Tarefa(null, "Teoria", "Aprofundamento teórico",
				false, null, null, null);
		Tarefa tarefaExemplo3 = new Tarefa(null, "Recepção", "Receber cliente envolvido",
				false, null, null, null);
		Tarefa tarefaExemplo4 = new Tarefa(null, "Acompanhamento", "Acompanhar andamento do Projeto",
				false, null, null, null);
		Tarefa tarefaExemplo5 = new Tarefa(null, "Pesquisa", "Pesquisa e seleção de textos para estudo",
				false, null, null, null);

		tarefaRepository.saveAll(Arrays.asList(tarefaExemplo1, tarefaExemplo2, tarefaExemplo3,
				tarefaExemplo4, tarefaExemplo5));
	}
}
