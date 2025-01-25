package com.manager.Entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_adress")
public class Adress implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String steet;
	private Integer number;
	private String complement;
	private String city;
	private String state;
	private String counttry;
	private LocalDate dt_cadastro;
	private LocalDate dt_alteracao;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSteet() {
		return steet;
	}
	public void setSteet(String steet) {
		this.steet = steet;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCounttry() {
		return counttry;
	}
	public void setCounttry(String counttry) {
		this.counttry = counttry;
	}
	
	public LocalDate getDt_cadastro() {
		return dt_cadastro;
	}
	public void setDt_cadastro(LocalDate dt_cadastro) {
		this.dt_cadastro = dt_cadastro;
	}
	public LocalDate getDt_alteracao() {
		return dt_alteracao;
	}
	public void setDt_alteracao(LocalDate dt_alteracao) {
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
		Adress other = (Adress) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
