package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.document.DocumentDaoService;

/**
 * Created by Tanya on 24.11.2016.
 */
@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private DocumentDaoService documentDaoService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getMainPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        modelAndView.addObject("docs", documentDaoService.getTenDocuments(1));
        return modelAndView;
    }
}
