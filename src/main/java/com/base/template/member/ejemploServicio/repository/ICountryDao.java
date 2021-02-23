package com.base.template.member.ejemploServicio.repository;

import com.base.template.member.ejemploServicio.model.Country;
import org.springframework.data.repository.CrudRepository;

public interface ICountryDao extends CrudRepository<Country, Integer> {

}
