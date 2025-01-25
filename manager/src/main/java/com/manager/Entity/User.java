package com.manager.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_user")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_user_seq")
    @SequenceGenerator(name = "tb_user_seq", sequenceName = "tb_user_seq", allocationSize = 1)
	private Integer id;
	private String login;
	private String password;
	@Column(name = "nm_user")
	private String description;
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	

}
