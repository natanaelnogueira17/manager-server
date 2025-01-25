package com.manager.Entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_client")
public class Client implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_client_seq")
    @SequenceGenerator(name = "tb_client_seq", sequenceName = "tb_client_seq", allocationSize = 1)
	private Integer id;
	@Column(name = "nm_client")
	private String descricao;
	private String cpf;
	@ElementCollection
	@OneToMany
	private List<Adress> adress;
	private String email;
	@ElementCollection
	@OneToMany
	private List<PhoneNumber> phoneNumbers;
	private String size;
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
	
	

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Adress> getAdress() {
		return adress;
	}
	public void setAdress(List<Adress> adress) {
		this.adress = adress;
	}
	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
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
		return Objects.hash(cpf, email, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email) && Objects.equals(id, other.id);
	}
	
	
	
	
	

}
