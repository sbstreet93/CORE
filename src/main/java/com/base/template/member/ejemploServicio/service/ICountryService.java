package com.base.template.member.ejemploServicio.service;

import com.base.template.member.ejemploServicio.model.Country;

import java.util.List;


public interface ICountryService {

	public List<Country> findAll();
	
	public Country findById(Integer id);
	
}
