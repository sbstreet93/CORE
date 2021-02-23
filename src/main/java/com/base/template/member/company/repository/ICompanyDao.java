package com.base.template.member.company.repository;

import com.base.template.member.company.model.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICompanyDao extends CrudRepository<Company, Integer>{
	
	@Query("select c from Company c join fetch c.address a join fetch a.commune co join fetch co.city ci join fetch ci.region r join fetch r.country")
	public List<Company> findAllWithAddressWithCommuneWithRegionWithContry();


}