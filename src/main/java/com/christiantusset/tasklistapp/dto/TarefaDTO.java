package com.christiantusset.tasklistapp.dto;

import com.christiantusset.tasklistapp.entity.Tarefa;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

public class TarefaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message="Preenchimento obrigatório")
    private String titulo;

    @NotEmpty(message="Preenchimento obrigatório")
    private String descricao;

    private boolean status;

    private String dataCriacao;

    private String dataEdicao;

    private String dataFinalizacao;


    public TarefaDTO() {}

    public TarefaDTO(Tarefa tarefa) {
        this.id = tarefa.getId();
        this.titulo = tarefa.getTitulo();
        this.descricao = tarefa.getDescricao();
        this.status = tarefa.getStatus();
        this.dataCriacao = tarefa.getDataCriacao();
        this.dataEdicao = tarefa.getDataEdicao();
        this.dataFinalizacao = tarefa.getDataFinalizacao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getDataEdicao() {
        return dataEdicao;
    }

    public void setDataEdicao(String dataEdicao) {
        this.dataEdicao = dataEdicao;
    }

    public String getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(String dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }
}
