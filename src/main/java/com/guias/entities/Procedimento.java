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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "procedimento")
public class Procedimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codigo_tiss;
	private Double valor;

	@CreationTimestamp
	private Instant data_cadastro;

	@UpdateTimestamp
	private Instant data_alteracao;

	@JsonIgnore
	@OneToMany(mappedBy = "procedimento", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ProcedimentoGuia> procedimentosGuia = new HashSet<>();

	public Procedimento() {
		super();
	}

	public Procedimento(Long id, String codigo_tiss, Double valor, Instant data_cadastro, Instant data_alteracao) {
		super();
		this.id = id;
		this.codigo_tiss = codigo_tiss;
		this.valor = valor;
		this.data_cadastro = data_cadastro;
		this.data_alteracao = data_alteracao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo_tiss() {
		return codigo_tiss;
	}

	public void setCodigo_tiss(String codigo_tiss) {
		this.codigo_tiss = codigo_tiss;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
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

	public Set<ProcedimentoGuia> getProcedimentosGuia() {
		return this.procedimentosGuia;
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
		Procedimento other = (Procedimento) obj;
		return Objects.equals(id, other.id);
	}

}
