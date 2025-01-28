package com.manager.Entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import org.springframework.lang.NonNull;

import com.manager.enums.Function;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name = "tb_employe")
public class Employe implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_employe_seq")
    @SequenceGenerator(name = "tb_employe_seq", sequenceName = "tb_employe_seq", allocationSize = 1)
	private Integer id;
	@Column(name = "nm_employe")
	private String description;
	@NonNull
	private String cpf;
	@Transient
	private Function function;
	@Column(name = "function")
	private Integer functionValue;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dt_cadastro;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dt_alteracao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Function getFunction() {
		return function;
	}
	public void setFunction(Function function) {
		this.function = function;
	}
	
	
	public Date getDt_cadastro() {
		return dt_cadastro;
	}
	public void setDt_cadastro(Date dt_cadastro) {
		this.dt_cadastro = dt_cadastro;
	}
	public Date getDt_alteracao() {
		return dt_alteracao;
	}
	public void setDt_alteracao(Date dt_alteracao) {
		this.dt_alteracao = dt_alteracao;
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
		Employe other = (Employe) obj;
		return Objects.equals(id, other.id);
	}
	public Integer getFunctionValue() {
		return functionValue;
	}
	public void setFunctionValue(Integer functionValue) {
		this.functionValue = functionValue;
	}  
	
	
}
