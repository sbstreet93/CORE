package com.base.template.member.company.service;

import com.base.template.member.company.model.Company;

import java.util.List;

public interface ICompanyService {

	public List<Company> findAllWithAddressWithCommuneWithRegionWithContry();
	
}
