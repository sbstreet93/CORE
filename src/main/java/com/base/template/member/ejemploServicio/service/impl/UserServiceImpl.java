package com.base.template.member.ejemploServicio.service.impl;

import com.base.template.member.ejemploServicio.model.User;
import com.base.template.member.ejemploServicio.repository.IUserDao;
import com.base.template.member.ejemploServicio.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	@Transactional(readOnly = true)
	public User findByRut(String rut) {
		return userDao.findByRut(rut);
	}
	
}
