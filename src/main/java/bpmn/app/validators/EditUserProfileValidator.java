package bpmn.app.validators;

import bpmn.app.model.AppUser;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import bpmn.app.utilities.AppdemoUtils;

public class EditUserProfileValidator implements Validator {
	private static final String EMAIL_PATTERN = "^[a-zA-z0-9]+[\\._a-zA-Z0-9]*@[a-zA-Z0-9]+{2,}\\.[a-zA-Z]{2,}[\\.a-zA-Z0-9]*$";

	@Override
	public boolean supports(Class<?> cls) {
		return AppUser.class.equals(cls);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		AppUser u = (AppUser) obj;
		
		ValidationUtils.rejectIfEmpty(errors, "name", "error.userName.empty");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "error.userLastName.empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "error.userEmail.empty");
		
		if (!u.getEmail().equals(null)) {
			boolean isMatch = AppdemoUtils.checkEmailOrPassword(EMAIL_PATTERN, u.getEmail());
			if(!isMatch) {
				errors.rejectValue("email", "error.userEmailIsNotMatch");
			}
		}
		
	}

}
