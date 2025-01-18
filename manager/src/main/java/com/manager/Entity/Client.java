package com.manager.Entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_client")
public class Client implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nm_client;
	private String lnm_client;
	private String cpf;
	@ElementCollection
	@OneToMany
	private List<Adress> adress;
	private String email;
	@ElementCollection
	@OneToMany
	private List<PhoneNumber> phoneNumbers;
	private String size;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNm_client() {
		return nm_client;
	}
	public void setNm_client(String nm_client) {
		this.nm_client = nm_client;
	}
	public String getLnm_client() {
		return lnm_client;
	}
	public void setLnm_client(String lnm_client) {
		this.lnm_client = lnm_client;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	
	
	
	
	

}
