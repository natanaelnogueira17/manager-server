package com.manager.Entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
@Entity
@Table(name = "tb_product")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_product_seq")
    @SequenceGenerator(name = "tb_product_seq", sequenceName = "tb_product_seq", allocationSize = 1)
	private Integer id;
	private String name;
	private String descricption;
	private Integer quantity;
	private Double priceAquisition;
	private Double priceSale;
	private LocalDate dateAquisition;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescricption() {
		return descricption;
	}
	public void setDescricption(String descricption) {
		this.descricption = descricption;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPriceAquisition() {
		return priceAquisition;
	}
	public void setPriceAquisition(Double priceAquisition) {
		this.priceAquisition = priceAquisition;
	}
	public Double getPriceSale() {
		return priceSale;
	}
	public void setPriceSale(Double priceSale) {
		this.priceSale = priceSale;
	}
	public LocalDate getDateAquisition() {
		return dateAquisition;
	}
	public void setDateAquisition(LocalDate dateAquisition) {
		this.dateAquisition = dateAquisition;
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
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}
		
	

}
