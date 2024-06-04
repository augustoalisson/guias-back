package com.guias.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProcedimentoGuia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "guia_id")
	private Guia guia;

	@ManyToOne
	@JoinColumn(name = "procedimento_id")
	private Procedimento procedimento;

	@CreationTimestamp
	private Instant data_cadastro;

	@UpdateTimestamp
	private Instant data_alteracao;

	public ProcedimentoGuia() {
		super();
	}

	public ProcedimentoGuia(Long id, Guia guia, Procedimento procedimento, Instant data_cadastro,
			Instant data_alteracao) {
		super();
		this.id = id;
		this.guia = guia;
		this.procedimento = procedimento;
		this.data_cadastro = data_cadastro;
		this.data_alteracao = data_alteracao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Guia getGuia() {
		return guia;
	}

	public void setGuia(Guia guia) {
		this.guia = guia;
	}

	public Procedimento getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
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
		ProcedimentoGuia other = (ProcedimentoGuia) obj;
		return Objects.equals(id, other.id);
	}

}
