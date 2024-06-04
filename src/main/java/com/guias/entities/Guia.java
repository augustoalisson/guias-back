package com.guias.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "guia")
public class Guia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "prestador_id")
	private Prestador prestador;

	@ManyToOne
	@JoinColumn(name = "status_id")
	private Status status;

	@CreationTimestamp
	private Instant data_emissao;
	private Instant data_vencimento;

	@UpdateTimestamp
	private Instant data_alteracao;

	@JsonIgnore
	@OneToMany(mappedBy = "guia", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ProcedimentoGuia> procedimentosGuia = new HashSet<>();

	public Guia() {
		super();
	}

	public Guia(Long id, Cliente cliente, Prestador prestador, Status status, Instant data_emissao,
			Instant data_vencimento, Instant data_alteracao) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.prestador = prestador;
		this.status = status;
		this.data_emissao = data_emissao;
		this.data_vencimento = data_vencimento;
		this.data_alteracao = data_alteracao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Prestador getPrestador() {
		return prestador;
	}

	public void setPrestador(Prestador prestador) {
		this.prestador = prestador;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Instant getData_emissao() {
		return data_emissao;
	}

	public void setData_emissao(Instant data_emissao) {
		this.data_emissao = data_emissao;
	}

	public Instant getData_vencimento() {
		return data_vencimento;
	}

	public void setData_vencimento(Instant data_vencimento) {
		this.data_vencimento = data_vencimento;
	}

	public Instant getData_alteracao() {
		return data_alteracao;
	}

	public void setData_alteracao(Instant data_alteracao) {
		this.data_alteracao = data_alteracao;
	}

	public Set<ProcedimentoGuia> getProcedimentosGuia() {
		return procedimentosGuia;
	}

	public void setProcedimentosGuia(Set<ProcedimentoGuia> procedimentosGuia) {
		this.procedimentosGuia = procedimentosGuia;
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
		Guia other = (Guia) obj;
		return Objects.equals(id, other.id);
	}

}
