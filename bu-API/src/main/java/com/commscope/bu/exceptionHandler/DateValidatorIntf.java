package com.commscope.bu.exceptionHandler;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateValidatorImpl.class)
@Documented
public @interface DateValidatorIntf {
	
	String message() default "Check Input Date Format";
	 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
}
