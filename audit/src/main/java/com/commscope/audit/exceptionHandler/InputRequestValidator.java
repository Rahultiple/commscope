package com.commscope.audit.exceptionHandler;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.commscope.audit.model.RequestAuditModel;


@Component("beforeCreateWebsiteUserValidator")
public class InputRequestValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return RequestAuditModel.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
    	
    	//
    	RequestAuditModel member = (RequestAuditModel) obj ;

        // validate the input
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
         javax.validation.Validator validator = factory.getValidator();
        Set<ConstraintViolation<RequestAuditModel>> validate = validator.validate(member);
        
		for (ConstraintViolation<RequestAuditModel> set : validate) {
			Path propertyPath = set.getPropertyPath();
			System.out.println(""+propertyPath.toString());
			System.out.println(set.getInvalidValue()+"-------"+set.getMessage());
			 errors.rejectValue(propertyPath.toString(),propertyPath.toString(),set.getMessage());
		}
    	    	       
        errors.addAllErrors(errors);
    }

    @SuppressWarnings("unused")
	private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
}
