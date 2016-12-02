package controller;

import entity.User;
import hibernate.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Tanya on 26.11.2016.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(method = RequestMethod.GET)
    public String getLoginPage() {
        User u = new User();
        u.setLogin("Ta1-1echka");
        u.setPassword("1111");
        System.out.println("***"+userDao.getUserByLoginPassword(u).getProfile().getFirstname());
        return "login";
    }
}
