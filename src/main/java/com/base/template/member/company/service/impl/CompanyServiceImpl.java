package com.base.template.member.company.service.impl;

import java.util.List;

import com.base.template.member.company.model.Company;
import com.base.template.member.ejemploServicio.repository.ICompanyDao;
import com.base.template.member.company.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyServiceImpl implements ICompanyService {

	@Autowired
	private ICompanyDao companyDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Company> findAllWithAddressWithCommuneWithRegionWithContry() {
		return companyDao.findAllWithAddressWithCommuneWithRegionWithContry();
	}

}
