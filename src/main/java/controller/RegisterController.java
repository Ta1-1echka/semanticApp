package controller;

import dto.UserDTO;
import entity.Profile;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.user.UserDaoService;
import validation.UserValidation;

/**
 * Created by Tanya on 26.11.2016.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserDaoService userDaoService;

    @Autowired
    private UserValidation userValidation;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getSignupPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signup");
        User u = new User();
        u.setProfile(new Profile());
        modelAndView.addObject("userDTO", new UserDTO());
        return modelAndView;
    }

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ModelAndView registerNewUser(@ModelAttribute("userDTO") UserDTO userDTO, BindingResult bindingResult) {
        userValidation.validate(userDTO, bindingResult);
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            //modelAndView.addObject(bindingResult.getFieldErrors());
            modelAndView.setViewName("signup");
            modelAndView.addObject("userDTO", userDTO);
            return modelAndView;
        } else {
            userDaoService.saveUser(userDTO);
            modelAndView.setViewName("login");
            return modelAndView;
        }
    }
}
