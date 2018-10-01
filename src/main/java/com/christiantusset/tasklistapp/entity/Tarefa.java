package com.christiantusset.tasklistapp.entity;

import com.christiantusset.tasklistapp.persist.EntidadePersist;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "tarefa")
@EntityListeners(EntidadePersist.class)
public class Tarefa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "status")
	private boolean status;

	@Column(name = "data_criacao")
	private String dataCriacao;

	@Column(name = "data_edicao")
	private String dataEdicao;

	@Column(name = "data_finalizacao")
	private String dataFinalizacao;


	public Tarefa() {}

	public Tarefa(Integer id, String titulo, String descricao, boolean status,
				  String dataCriacao, String dataEdicao, String dataFinalizacao) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.status = status;
		this.dataCriacao = dataCriacao;
		this.dataEdicao = dataEdicao;
		this.dataFinalizacao = dataFinalizacao;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Tarefa tarefa = (Tarefa) o;
		return Objects.equals(id, tarefa.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Tarefa{" +
				"id=" + id +
				", titulo='" + titulo + '\'' +
				", descricao='" + descricao + '\'' +
				", status=" + status +
				", dataCriacao=" + dataCriacao +
				", dataEdicao=" + dataEdicao +
				", dataFinalizacao=" + dataFinalizacao +
				'}';
	}
}
