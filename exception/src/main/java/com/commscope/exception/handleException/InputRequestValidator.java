package com.commscope.exception.handleException;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.commscope.exception.model.InputValidatorIntf;
import com.commscope.exception.model.RequestJsonMessage;

/**
 * Custom Exception handling and input validation for the input request . 
 * so that user defined exception will be raised .
 * @author RT1050
 *
 */

@Component("beforeCreateWebsiteUserValidator")
public class InputRequestValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
    	System.out.println("Class Name::---> "+clazz.getCanonicalName());
    	Class<InputValidatorIntf>[] interfaces = (Class<InputValidatorIntf>[]) clazz.getInterfaces();
    	return InputValidatorIntf.class.equals(interfaces[0]);
    }

    @Override
	public void validate(Object obj, Errors errors) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		javax.validation.Validator validator = factory.getValidator();

		InputValidatorIntf member = (InputValidatorIntf) obj;
		Set<ConstraintViolation<InputValidatorIntf>> validate = validator.validate(member);

		// validate the input

		for (ConstraintViolation<InputValidatorIntf> set : validate) {
			Path propertyPath = set.getPropertyPath();
			System.out.println("" + propertyPath.toString());
			System.out.println(set.getInvalidValue() + "-------" + set.getMessage());
			errors.rejectValue(propertyPath.toString(), propertyPath.toString(), set.getMessage());
		}

		/*
		 * 
		 * 
		 * // System.out.println("Errors -> "+errors); RequestJsonMessage user =
		 * (RequestJsonMessage) obj; if (checkInputString(user.getSenderID())) {
		 * errors.rejectValue("senderID", "senderID","Sender Id is null or Empty"); }
		 * 
		 * if (checkInputString(user.getMessageType())) {
		 * errors.rejectValue("messageType",
		 * "messageType","message Type is null or Empty"); }
		 */

		errors.addAllErrors(errors);
    }

    @SuppressWarnings("unused")
	private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
}
