package com.base.template.member.ejemploServicio.service;

import com.base.template.member.ejemploServicio.model.Commune;

import java.util.List;


public interface ICommuneService {

	public List<Commune> findAllByCityId(Integer cityId);
	
}
