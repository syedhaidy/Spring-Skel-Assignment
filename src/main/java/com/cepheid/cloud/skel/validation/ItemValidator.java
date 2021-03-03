package com.cepheid.cloud.skel.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ItemValidator implements ConstraintValidator<ItemValidatorVal, String>{
	@Override
	public void initialize(ItemValidatorVal arg0) { 
	}
	@Override
	public boolean isValid(String state, ConstraintValidatorContext arg1) {
		//Validation Logic
		if(state==null){
			return false;
		}
		if (state.length()<2) {
			return false;
		}else{
			return true;
		}
	}
}
