package com.base.template.member.company.controller;

import java.util.List;

import com.base.template.member.company.controller.model.CompanyRequest;
import com.base.template.member.company.controller.model.CompanyResponse;
import com.base.template.member.company.model.Company;
import com.base.template.member.company.service.ICompanyService;
import com.base.template.member.company.validator.CompanyValidator;
import com.base.template.member.ejemploServicio.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("api/company")
public class CompanyController {
	
	@Autowired
	private ICompanyService companyService;
	
	@Autowired
	private ICountryService countryService;
	
	@Autowired
	private IRegionService regionService;
	
	@Autowired
	private ICityService citySerivce;
	
	@Autowired
	private ICommuneService communeService;
	
	@RequestMapping({"/list"})
	public String list(Model model) {
		model.addAttribute("title", "Empresas");
		model.addAttribute("companies", companyService.findAllWithAddressWithCommuneWithRegionWithContry());
		return "company/list";
	}
	
	@PostMapping
	public CompanyResponse create(@Valid @RequestBody CompanyRequest companyRequest) {
		return new CompanyResponse();
	}
	
	@GetMapping(value = "/load-comapny", produces = { "application/json" })
	public @ResponseBody List<Company> loadcomapny(){
		return companyService.findAllWithAddressWithCommuneWithRegionWithContry();
	}

	@InitBinder("companyRequest")
	public void initBinder(final WebDataBinder binder){
		binder.addValidators(new CompanyValidator());
	}
}
