package com.guias.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "status")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;

	@CreationTimestamp
	private Instant data_criacao;

	@UpdateTimestamp
	private Instant data_alteracao;

	@JsonIgnore
	@OneToMany(mappedBy = "status")
	private List<Guia> guias = new ArrayList<>();

	public Status() {
		super();
	}

	public Status(Long id, String descricao, Instant data_criacao, Instant data_alteracao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.data_criacao = data_criacao;
		this.data_alteracao = data_alteracao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Instant getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(Instant data_criacao) {
		this.data_criacao = data_criacao;
	}

	public Instant getData_alteracao() {
		return data_alteracao;
	}

	public void setData_alteracao(Instant data_alteracao) {
		this.data_alteracao = data_alteracao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Status other = (Status) obj;
		return Objects.equals(id, other.id);
	}

}
