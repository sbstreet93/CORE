package com.base.template.member.ejemploServicio.repository;

import java.util.List;

import com.base.template.member.ejemploServicio.model.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ICityDao extends CrudRepository<City, Integer> {
	
	@Query("select c from City c join fetch c.region r where r.id = ?1")
	public List<City> findAllByRegionId(Integer regionId);

}
