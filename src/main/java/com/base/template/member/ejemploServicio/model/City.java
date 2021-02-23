package com.base.template.member.ejemploServicio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cities")
public class City implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date created;
	
	@JsonIgnoreProperties(value = {"city", "handler", "hibernateLazyInitializer"})
	@ManyToOne(fetch = FetchType.LAZY)
	private Region region;
	
	@JsonIgnoreProperties(value = {"city", "handler", "hibernateLazyInitializer"})
	@OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Commune> communes;
	
	@PrePersist
	public void prePersist() {
		this.created = new Date();
	}
	
	public City() {
		this.communes = new ArrayList<Commune>();
	}

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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<Commune> getCommunes() {
		return communes;
	}

	public void setCommunes(List<Commune> communes) {
		this.communes = communes;
	}
	
	public void addCommune(Commune commune) {
		this.communes.add(commune);
	}

}