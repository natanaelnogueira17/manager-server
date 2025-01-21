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
@Table(name = "tb_phone_number")
public class PhoneNumber implements Serializable{
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer id;
		private String mobile;
		private String fix;
		private LocalDate dt_cadastro;
		private LocalDate dt_alteracao;
		
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public String getFix() {
			return fix;
		}
		public void setFix(String fix) {
			this.fix = fix;
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
			PhoneNumber other = (PhoneNumber) obj;
			return Objects.equals(id, other.id);
		}
		
		

}
