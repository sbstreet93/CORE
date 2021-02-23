package com.base.template.member.ejemploServicio.service.impl;

import java.util.List;

import com.base.template.member.ejemploServicio.model.Region;
import com.base.template.member.ejemploServicio.repository.IRegionDao;
import com.base.template.member.ejemploServicio.service.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegionServiceImpl implements IRegionService {
	
	@Autowired
	private IRegionDao regionDao;

	@Override
	@Transactional(readOnly = true)
	public List<Region> findAllByCountryId(Integer countryId) {
		return regionDao.findAllByCountryId(countryId);
	}

}
