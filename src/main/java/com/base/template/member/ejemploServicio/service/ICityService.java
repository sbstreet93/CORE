package com.base.template.member.ejemploServicio.service;

import com.base.template.member.ejemploServicio.model.City;

import java.util.List;


public interface ICityService {
	
	public List<City> findAllByRegionId(Integer regionId);

}
