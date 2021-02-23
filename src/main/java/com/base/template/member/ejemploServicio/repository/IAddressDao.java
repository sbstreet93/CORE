package com.base.template.member.ejemploServicio.repository;

import com.base.template.member.ejemploServicio.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface IAddressDao extends CrudRepository<Address, Integer>{

}
