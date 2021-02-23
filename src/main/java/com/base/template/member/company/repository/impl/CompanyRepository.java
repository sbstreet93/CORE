package com.base.template.member.company.repository.impl;

import com.base.template.member.company.model.Company;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Slf4j
public class CompanyRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void persist(Company company){
        entityManager.persist(company);
    }
}
