package controller;

import entity.Document;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.document.DocumentDaoService;
import service.user.UserDaoService;

import java.util.List;

/**
 * Created by Tanya on 09.12.2016.
 */
@Controller
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private UserDaoService userDaoService;

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
        if (user.getUserDocs().size() < id * 10)
            modelAndView.addObject("addedDocs", user.getUserDocs().subList(id * 10 - 10, user.getUserDocs().size() - 1));
        else
            modelAndView.addObject("addedDocs", user.getUserDocs().subList(id * 10 - 10, id*10));

        modelAndView.addObject("id", id);
        return modelAndView;
    }

    @RequestMapping(value = "favorite")
    public String getUserFavoriteDocs(Authentication authentication) {
        return "redirect:/document/favorite/1";
    }

    @RequestMapping(value = "favorite/{idPage}")
    public ModelAndView getByIdPageFavoriteDocs(@PathVariable("idPage") int idPage, Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userDaoService.getByLogin(authentication.getName());
        modelAndView.addObject("id", idPage);
        modelAndView.addObject("favDocs", user.getDocs());
        modelAndView.setViewName("document");
        return modelAndView;
    }

    @RequestMapping(value = "addToFavorite/{idPage}/{idDoc}")
    public ModelAndView addDocToFavoriteDocs(@PathVariable("idPage") int idPage,
                                             @PathVariable("idDoc") int idDoc, Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userDaoService.getByLogin(authentication.getName());
        user.getDocs().add(documentDaoService.getDocumentById(idDoc));
        userDaoService.updateUser(user);
        modelAndView.addObject("user", user);
        modelAndView.addObject("docs", documentDaoService.getTenDocuments(idPage));
        modelAndView.addObject("id", idPage);
        modelAndView.setViewName("document");
        return modelAndView;
    }

    @RequestMapping(value = "deleteFromFavorite/{idPage}/{idDoc}")
    public ModelAndView deleteDocFromFavoriteDocs(@PathVariable("idPage") int idPage,
                                                  @PathVariable("idDoc") int idDoc, Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userDaoService.getByLogin(authentication.getName());
        System.out.println(user.getDocs().size());
        List<Document> docs = user.getDocs();
        for (int i = 0; i < docs.size(); i++) {
            if (docs.get(i).getIdDocument() == idDoc) {
                user.getDocs().remove(user.getDocs().get(i));
                break;
            }

        }
        System.out.println(user.getDocs().size());
        userDaoService.updateUser(user);
        modelAndView.addObject("user", user);

        modelAndView.addObject("favDocs", user.getDocs());
        modelAndView.addObject("id", idPage);
        modelAndView.setViewName("document");
        return modelAndView;
    }


    @RequestMapping(value = "{id}")
    public ModelAndView getByIdPageAddDocs(Authentication authentication, @PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();

        User user = userDaoService.getByLogin(authentication.getName());
        modelAndView.addObject("user", user);

        modelAndView.addObject("id", id);
        System.out.println("documentDaoService.getTenDocuments(id)=" + documentDaoService.getTenDocuments(id).size());
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
    public ModelAndView addDoc(@RequestParam("file") MultipartFile file,
                               Authentication authentication, @RequestParam("name") String name) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userDaoService.getByLogin(authentication.getName());
        System.out.println("user.getDocs().size()" + user.getDocs().size());
        documentDaoService.saveDocument(file, name, user);
        modelAndView.addObject("message", file.getOriginalFilename() + " is successfully added");
        modelAndView.setViewName("document");
        return modelAndView;

    }
}
