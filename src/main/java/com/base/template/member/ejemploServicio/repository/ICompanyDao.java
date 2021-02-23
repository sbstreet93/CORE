package com.base.template.member.ejemploServicio.repository;

import java.util.List;

import com.base.template.member.company.model.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ICompanyDao  extends CrudRepository<Company, Integer>{
	
	@Query("select c from Company c join fetch c.address a join fetch a.commune co join fetch co.city ci join fetch ci.region r join fetch r.country")
	public List<Company> findAllWithAddressWithCommuneWithRegionWithContry();

}