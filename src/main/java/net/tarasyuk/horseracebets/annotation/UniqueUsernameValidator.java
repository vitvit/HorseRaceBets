package net.tarasyuk.horseracebets.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import net.tarasyuk.horseracebets.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

public class UniqueUsernameValidator implements
		ConstraintValidator<UniqueUsername, String> {

	@Autowired
	UserService userService;

	@Override
	public void initialize(UniqueUsername constraintAnnotation) {

	}

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		if (userService ==null){
			return true;
		}
		return userService.findUser(username) == null;
	}

}
