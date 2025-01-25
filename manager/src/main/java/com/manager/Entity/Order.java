package com.manager.Entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.manager.enums.OrderStatus;
import com.manager.enums.PaymentMethods;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
@Entity
@Table(name = "tb_orders")
public class Order implements Serializable{

	

	private static final long serialVersionUid = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_orders_seq")
    @SequenceGenerator(name = "tb_orders_seq", sequenceName = "tb_orders_seq", allocationSize = 1)
	private Integer id;
	private Client client;
	@OneToMany
	@JoinColumn(name = "orders_id")
	private List<Product> products;
	private LocalDate date;
	private Employe employe;
	private OrderStatus status;
	private PaymentMethods paymentMethods;
	private Double discount;
	private Double total;
	private Double frete;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dt_cadastro;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dt_alteracao;
	
	
	
	public Integer getid() {
		return id;
	}
	public void setid(Integer id) {
		id = id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public PaymentMethods getPaymentMethods() {
		return paymentMethods;
	}
	public void setPaymentMethods(PaymentMethods paymentMethods) {
		this.paymentMethods = paymentMethods;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
	public Double getFrete() {
		return frete;
	}
	public void setFrete(Double frete) {
		this.frete = frete;
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
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
