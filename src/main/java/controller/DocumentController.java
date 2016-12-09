package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import other.Page;
import service.document.DocumentDaoService;
import service.user.UserDaoService;

/**
 * Created by Tanya on 09.12.2016.
 */
@Controller
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private UserDaoService userDaoService;

    @Autowired
    private Page page;

    @Autowired
    private DocumentDaoService documentDaoService;

    @RequestMapping(value = "/added")
    public String getUserAddedDocs(Authentication authentication) {
        return "redirect:/document/added/1";
    }

    @RequestMapping
    public String getAllDocs(Authentication authentication) {
        return "redirect:/document/1";
    }

    @RequestMapping(value = "/added/{id}")
    public ModelAndView getByIdPageUserAddedDocs(Authentication authentication, @PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("document");
        User user = userDaoService.getByLogin(authentication.getName());
        modelAndView.addObject("user", user);
        page.getCountOfListDocument(user.getUserDocs());
        modelAndView.addObject("addedDocs", user.getUserDocs());
        modelAndView.addObject("begin", page.getBegin(id));
        modelAndView.addObject("end", page.getEnd(id));
        return modelAndView;
    }


    @RequestMapping(value = "{id}")
    public ModelAndView getByIdPageAddDocs(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        page.getCountOfAllDocuments();
        System.out.println(page.getBegin(id));
        System.out.println(page.getEnd(id));
        modelAndView.addObject("begin", page.getBegin(id));
        modelAndView.addObject("end", page.getEnd(id));
        modelAndView.addObject("docs", documentDaoService.getTenDocuments(id));
        modelAndView.setViewName("document");
        return modelAndView;
    }

    @RequestMapping(value = "/new")
    public ModelAndView getAddDocumentPage(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userDaoService.getByLogin(authentication.getName());
        modelAndView.addObject("user", user);
        modelAndView.setViewName("addDocument");
        return modelAndView;
    }

    @RequestMapping(value = "/new/add")
    public ModelAndView addDoc(@RequestParam("file") MultipartFile file, @ModelAttribute("user") User user, @RequestParam("name") String name) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(user.toString());
        System.out.println(name);
        documentDaoService.saveDocument(file, name, user);
        modelAndView.addObject("message", file.getOriginalFilename()+" is successfully added");
        modelAndView.setViewName("document");
        return modelAndView;

    }
}