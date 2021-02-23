package com.base.template.member.ejemploServicio.repository;

import java.util.List;

import com.base.template.member.ejemploServicio.model.Region;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface IRegionDao extends CrudRepository<Region, Integer> {

	@Query("select r from Region r join fetch r.country c where c.id = ?1")
	public List<Region> findAllByCountryId(Integer countryId);
	
}
