package com.base.template.member.ejemploServicio.repository;

import com.base.template.member.ejemploServicio.model.User;
import org.springframework.data.repository.CrudRepository;


public interface IUserDao extends CrudRepository<User, Long> {
	
	public User findByUsername(String username);
	
	public User findByRut(String rut);
	
}