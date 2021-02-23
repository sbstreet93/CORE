package com.base.template.member.ejemploServicio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.acp.cloud.app.validations.ValidUniqueIdentifier;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "users")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler" , "documents", "role", "address"})
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Column(name = "paternal_last_name")
	private String paternalLastName;

	@Column(name = "maternal_last_name")
	private String maternalLastName;

	@ValidUniqueIdentifier
	private String rut;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "birth_date")
	private Date birthDate;

	private String email;
	private String phone;

	@Column(name = "cell_phone")
	private String cellPhone;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date created;
	
	@Column(unique = true)
	private String username;
	private String password;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Role role;
	
	private Integer state;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Address address;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Document> documents;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Work> workers;

	@PrePersist
	public void prePersist() {
		this.created = new Date();
	}
	
	public User() {
		this.documents = new ArrayList<Document>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPaternalLastName() {
		return paternalLastName;
	}

	public void setPaternalLastName(String paternalLastName) {
		this.paternalLastName = paternalLastName;
	}

	public String getMaternalLastName() {
		return maternalLastName;
	}

	public void setMaternalLastName(String maternalLastName) {
		this.maternalLastName = maternalLastName;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public void addDocument(Document document) {
		this.documents.add(document);
	}

}