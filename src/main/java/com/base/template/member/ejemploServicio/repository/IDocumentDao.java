package com.base.template.member.ejemploServicio.repository;

import java.util.List;

import com.base.template.member.ejemploServicio.model.Document;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface IDocumentDao extends CrudRepository<Document, Long>{
	
	@Query("select d from Document d join fetch d.user u join fetch d.documentType dt")
	public List<Document> findAll();
	
	@Query("select count(d) from Document d where d.documentType.id = ?1 and d.user.id = ?2")
	public int findByDocumentTypeByUserId(int documentTypeId, long userId);

}
