package validation;

import converter.UserConverter;
import dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import service.user.UserDaoService;

@Component
public class UserValidation implements Validator {

    @Autowired
    private UserDaoService userDaoService;

    @Autowired
    private UserConverter userConverter;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "login.empty", "Login mustn't be empty.");
        if(userDaoService.isExist(userConverter.converterDTOtoUser((UserDTO)target)))
            errors.rejectValue("login", "login.exist","This login already exists.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "Password mustn't be empty.");

    }
}
