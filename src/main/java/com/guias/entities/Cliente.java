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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name = "tipo_id")
	private TipoCliente tipo;

	@ManyToOne
	@JoinColumn(name = "titular_id")
	private Cliente titular;

	@ManyToOne
	@JoinColumn(name = "plano_id")
	private Plano plano;

	@CreationTimestamp
	private Instant data_alteracao;

	@UpdateTimestamp
	private Instant data_cadastro;

	@JsonIgnore
	@OneToMany(mappedBy = "titular")
	private List<Cliente> dependentes = new ArrayList<>();

	public Cliente() {
		super();
	}

	public Cliente(Long id, Pessoa pessoa_id, TipoCliente tipo_id, Cliente titular_id, Plano plano_id,
			Instant data_alteracao, Instant data_cadastro) {
		super();
		this.id = id;
		this.pessoa = pessoa_id;
		this.tipo = tipo_id;
		this.titular = titular_id;
		this.plano = plano_id;
		this.data_alteracao = data_alteracao;
		this.data_cadastro = data_cadastro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa_id) {
		this.pessoa = pessoa_id;
	}

	public TipoCliente getTipo() {
		return tipo;
	}

	public void setTipo(TipoCliente tipo_id) {
		this.tipo = tipo_id;
	}

	public Cliente getTitular() {
		return titular;
	}

	public void setTitular(Cliente titular_id) {
		this.titular = titular_id;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano_id) {
		this.plano = plano_id;
	}

	public Instant getData_alteracao() {
		return data_alteracao;
	}

	public void setData_alteracao(Instant data_alteracao) {
		this.data_alteracao = data_alteracao;
	}

	public Instant getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Instant data_cadastro) {
		this.data_cadastro = data_cadastro;
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
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}

}
