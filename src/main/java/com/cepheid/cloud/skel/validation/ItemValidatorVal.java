package com.cepheid.cloud.skel.validation;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = ItemValidator.class) //validator
@Target( { ElementType.METHOD, ElementType.FIELD })// Placement of annotation
@Retention(RetentionPolicy.RUNTIME)
public @interface ItemValidatorVal {
   String message() default "{ItemValidatorVal}"; 
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}