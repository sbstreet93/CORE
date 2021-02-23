package com.base.template.member.ejemploServicio.service.impl;

import java.util.List;

import com.base.template.member.ejemploServicio.model.Country;
import com.base.template.member.ejemploServicio.repository.ICountryDao;
import com.base.template.member.ejemploServicio.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CountryServiceImpl implements ICountryService {

	@Autowired
	private ICountryDao countryDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Country> findAll() {
		return (List<Country>) countryDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Country findById(Integer id) {
		return countryDao.findById(id).orElse(null);
	}

}
