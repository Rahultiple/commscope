package com.commscope.bu.exceptionHandler;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.commscope.bu.constants.BUConstants;
public class DateValidatorImpl   implements ConstraintValidator<DateValidatorIntf, String> {

	@Override
    public void initialize(DateValidatorIntf constraintAnnotation) {
		System.out.println("initialize --"+constraintAnnotation);
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
			if (value == null) {
	            return true;
	        }
			
		 	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        try {
		 	LocalDate ld = LocalDate.parse(value,formatter);
		 	 return true;
	        }catch (Exception e) {
	        	BUConstants.threadLocal.set(value);
				// TODO: handle exception
	        	  return false;
			}
	    
	}
 
  

}
