package com.base.template.member.ejemploServicio.service;

import com.base.template.member.ejemploServicio.model.Document;
import com.base.template.member.ejemploServicio.model.DocumentType;

import java.util.List;


public interface IDocumentService {

	public List<Document> findAllWithUser();
	
	public Integer findByDocumentTypeByUserId(Integer documentTypeId, Long userId);
	
	public void save(Document document);
	
	public void delete(Long id);
	
	public Document findById(Long id);
	
	public List<DocumentType> findAllDocumentTypes();
	
	public DocumentType findDocumentTypeById(Integer id);
	
}
