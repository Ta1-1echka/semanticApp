package controller;

import converter.ProfileConverter;
import dto.ProfileDTO;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.profile.ProfileDaoService;
import service.user.UserDaoService;

/**
 * Created by Tanya on 09.12.2016.
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileDaoService profileDaoService;

    @Autowired
    private UserDaoService userDaoService;

    @Autowired
    private ProfileConverter profileConverter;

    @RequestMapping()
    public ModelAndView getUserProfile(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userDaoService.getByLogin(authentication.getName());
        modelAndView.setViewName("profile");
        modelAndView.addObject("profile", profileConverter.converterToDTO(user.getProfile()));
        return modelAndView;
    }

    @RequestMapping(value = {"/edit"})
    public ModelAndView getUserProfileEdit(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userDaoService.getByLogin(authentication.getName());
        modelAndView.setViewName("profile");
        modelAndView.addObject("profileEdit", user.getProfile());
        return modelAndView;
    }

    @RequestMapping(value = "/edit/update")
    public ModelAndView updateUserProfile(Authentication authentication, @ModelAttribute("profile") ProfileDTO profileDTO) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profile");
        profileDaoService.updateProfile(profileConverter.converterDTOtoUser(profileDTO));
        return modelAndView;
    }
}
