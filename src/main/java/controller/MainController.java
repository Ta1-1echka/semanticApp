package controller;


import entity.Profile;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.document.DocumentDaoService;
import service.profile.ProfileDaoService;
import service.user.UserDaoService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Tanya on 24.11.2016.
 */
@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private DocumentDaoService documentDaoService;

    @Autowired
    private UserDaoService userDaoService;

    @Autowired
    private ProfileDaoService profileDaoService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getMainPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        modelAndView.addObject("docs", documentDaoService.getTenDocuments(1));
        return modelAndView;
    }

    @RequestMapping(value = "addedDocs")
    public ModelAndView getUserAddedDocs(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        modelAndView.addObject("docs", userDaoService.getByLogin(authentication.getName()).getUserDocs());
        return modelAndView;
    }

    @RequestMapping(value = "doc")
    public ModelAndView getAddDocumentPage(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userDaoService.getByLogin(authentication.getName());
        modelAndView.setViewName("addDocument");
        return modelAndView;
    }

    @RequestMapping(value = "doc/add")
    @ResponseBody
    public String addDoc(@RequestParam("file") MultipartFile file) {
        ModelAndView modelAndView = new ModelAndView();
        String fileName = null;
        if (!file.isEmpty()) {
            try {
                fileName = file.getOriginalFilename();
                byte[] bytes = file.getBytes();
                BufferedOutputStream buffStream =
                        new BufferedOutputStream(new FileOutputStream(new File("src/main/webapp/resources/docs/"+fileName)));
                buffStream.write(bytes);
                buffStream.close();
                return "You have successfully uploaded " + fileName;
            } catch (Exception e) {
                return "You failed to upload " + fileName + ": " + e.getMessage();
            }
        } else {
            return "Unable to upload. File is empty.";
        }
    }

    @RequestMapping(value = "/profile")
    public ModelAndView getUserProfile(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userDaoService.getByLogin(authentication.getName());
        modelAndView.setViewName("main");
        modelAndView.addObject("profile", user.getProfile());
        return modelAndView;
    }

    @RequestMapping(value = "update/profile")
    public ModelAndView updateUserProfile(@ModelAttribute("profile") Profile profile) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        profileDaoService.updateProfile(profile);
        return modelAndView;
    }
}
