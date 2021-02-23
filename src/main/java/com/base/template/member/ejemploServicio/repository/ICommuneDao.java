package com.base.template.member.ejemploServicio.repository;

import java.util.List;

import com.base.template.member.ejemploServicio.model.Commune;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ICommuneDao extends CrudRepository<Commune, Integer>{
	
	@Query("select co from Commune co join fetch co.city ci where ci.id = ?1")
	public List<Commune> findAllByCityId(Integer cityId);

}
