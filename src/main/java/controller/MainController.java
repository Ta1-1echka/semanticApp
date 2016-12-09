package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import other.Page;
import service.document.DocumentDaoService;

/**
 * Created by Tanya on 24.11.2016.
 */
@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private Page page;

    @Autowired
    private DocumentDaoService documentDaoService;

    @RequestMapping
    public String getMain() {
        return "redirect:/page/1";
    }

    @RequestMapping(value = "page/{id}", method = RequestMethod.GET)
    public ModelAndView getIdPageOfDocuments(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        modelAndView.addObject("docs", documentDaoService.getTenDocuments(id));
        page.getCountOfAllDocuments();
        modelAndView.addObject("begin", page.getBegin(id));
        modelAndView.addObject("end", page.getEnd(id));
        modelAndView.addObject("id", id);
        return modelAndView;
    }


}
