package controller;

import dto.UserDTO;
import entity.Profile;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import service.user.UserDaoService;
import validation.UserValidation;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ModelAndView getErrorSignupPage(@ModelAttribute("userDTO") UserDTO userDTO, HttpServletRequest request,
                                           BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signup");
        Map<String, ?> redAttr = RequestContextUtils.getInputFlashMap(request);
        modelAndView.addObject("userDTO", userDTO);
        //bindingResult = (BindingResult) redAttr.get("result");
        userValidation.validate(userDTO, bindingResult);
        return modelAndView;
    }

    @RequestMapping(value = "/user", method = {RequestMethod.POST, RequestMethod.GET})
    public String registerNewUser(@ModelAttribute("userDTO") UserDTO userDTO, BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {
        String returnStr = null;
        userValidation.validate(userDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userDTO", userDTO);
            redirectAttributes.addFlashAttribute("result", bindingResult);
            returnStr = "redirect:/register/error";
        } else {
            userDaoService.saveUser(userDTO);
            returnStr = "redirect:/login";
        }
        return returnStr;
    }
}
