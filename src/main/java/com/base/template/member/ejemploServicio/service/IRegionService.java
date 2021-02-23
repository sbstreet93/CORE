package com.base.template.member.ejemploServicio.service;

import com.base.template.member.ejemploServicio.model.Region;

import java.util.List;


public interface IRegionService {

	public List<Region> findAllByCountryId(Integer countryId);
	
}
