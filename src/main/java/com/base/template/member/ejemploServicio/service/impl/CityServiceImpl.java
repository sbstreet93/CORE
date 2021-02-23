package com.base.template.member.ejemploServicio.service.impl;

import java.util.List;

import com.base.template.member.ejemploServicio.model.City;
import com.base.template.member.ejemploServicio.repository.ICityDao;
import com.base.template.member.ejemploServicio.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CityServiceImpl implements ICityService {

	@Autowired
	private ICityDao cityDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<City> findAllByRegionId(Integer regionId) {
		return cityDao.findAllByRegionId(regionId);
	}

	
}
