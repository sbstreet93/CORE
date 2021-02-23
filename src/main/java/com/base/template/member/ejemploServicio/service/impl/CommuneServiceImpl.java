package com.base.template.member.ejemploServicio.service.impl;

import java.util.List;

import com.base.template.member.ejemploServicio.model.Commune;
import com.base.template.member.ejemploServicio.repository.ICommuneDao;
import com.base.template.member.ejemploServicio.service.ICommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommuneServiceImpl implements ICommuneService {

	@Autowired
	private ICommuneDao communeDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Commune> findAllByCityId(Integer cityId) {
		return communeDao.findAllByCityId(cityId);
	}

}
