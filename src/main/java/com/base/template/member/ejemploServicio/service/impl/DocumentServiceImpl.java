package com.base.template.member.ejemploServicio.service.impl;

import java.util.List;

import com.base.template.member.ejemploServicio.model.Document;
import com.base.template.member.ejemploServicio.model.DocumentType;
import com.base.template.member.ejemploServicio.repository.IDocumentDao;
import com.base.template.member.ejemploServicio.repository.IDocumentTypeDao;
import com.base.template.member.ejemploServicio.service.IDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DocumentServiceImpl implements IDocumentService {

	@Autowired
	private IDocumentDao documentDao;
	
	@Autowired
	private IDocumentTypeDao documentTypeDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Document> findAllWithUser() {
		return documentDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Integer findByDocumentTypeByUserId(Integer documentTypeId, Long userId) {
		return documentDao.findByDocumentTypeByUserId(documentTypeId, userId);
	}
	
	@Override
	@Transactional
	public void save(Document document) {
		documentDao.save(document);
	}
	
	@Override
	public void delete(Long id) {
		documentDao.deleteById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Document findById(Long id) {
		return documentDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DocumentType> findAllDocumentTypes() {
		return (List<DocumentType>) documentTypeDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public DocumentType findDocumentTypeById(Integer id) {
		return documentTypeDao.findById(id).orElse(null);
	}

}
