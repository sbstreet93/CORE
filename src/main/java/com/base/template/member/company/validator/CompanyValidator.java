package com.base.template.member.company.validator;

import com.base.template.member.company.controller.model.CompanyRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CompanyValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return CompanyRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CompanyRequest companyRequest = (CompanyRequest) target;
    }
}
