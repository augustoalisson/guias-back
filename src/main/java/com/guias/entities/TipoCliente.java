package com.guias.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_cliente")
public class TipoCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String descricao;

	@Column(nullable = false, unique = true)
	private String sigla;

	@CreationTimestamp
	private Instant data_cadastro;

	@UpdateTimestamp
	private Instant data_alteracao;

	@JsonIgnore
	@OneToMany(mappedBy = "tipo")
	private List<Cliente> clientes = new ArrayList<>();

	public TipoCliente() {
		super();
	}

	public TipoCliente(Long id, String descricao, String sigla, Instant data_cadastro, Instant data_alteracao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.sigla = sigla;
		this.data_cadastro = data_cadastro;
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Instant getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Instant data_cadastro) {
		this.data_cadastro = data_cadastro;
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
		TipoCliente other = (TipoCliente) obj;
		return Objects.equals(id, other.id);
	}

}
