package bpmn.app.validators;

import bpmn.app.model.AppUser;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import bpmn.app.utilities.AppdemoUtils;

public class ChangePasswordValidator implements Validator {
    private static final String PASSWORD_PATTERN = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\!\\@\\#\\$\\*])(?!.*\\s).{8,12}$";

    @Override
    public boolean supports(Class<?> cls) {
        return AppUser.class.equals(cls);
    }

    @Override
    public void validate(Object obj, Errors errors) {

        @SuppressWarnings("unused")
        AppUser u = (AppUser) obj;

        ValidationUtils.rejectIfEmpty(errors, "newPassword", "error.userPassword.empty");

    }

    public void checkPasswords(String newPass, Errors errors) {

        if (!newPass.equals(null)) {
            boolean isMatch = AppdemoUtils.checkEmailOrPassword(PASSWORD_PATTERN, newPass);
            if (!isMatch) {
                errors.rejectValue("newPassword", "error.userPasswordIsNotMatch");
            }
        }
    }
}
