package com.pl.springboot.mvc.jpa.controller;


import com.pl.springboot.mvc.jpa.dao.RoleDao;
import com.pl.springboot.mvc.jpa.dao.UserDao;
import com.pl.springboot.mvc.jpa.model.Role;
import com.pl.springboot.mvc.jpa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "adminPanel",method = RequestMethod.GET)
public class AboutMePageController {


    @Autowired
    UserDao userDao;


    @Autowired
    RoleDao roleDao;

    //    ABOUT USER PAGE
    @RequestMapping(value = "userPage",method = RequestMethod.GET)
    public String getAboutUserPage(Model model,
                                   @ModelAttribute("userForm")User userForm,
                                   @SessionAttribute("user")User u){

        List<Role> roleList = (List<Role>) roleDao.findAll();

        User user = u;
        model.addAttribute("name",user.getName());
        model.addAttribute("lastName",user.getLast_name());
        model.addAttribute("roleList",roleList);

        return "aboutMePage";
    }


    // CHANGE ADMIN NAME IN USER PAGE
    @RequestMapping(path = "changeName",method = RequestMethod.POST)
    public String changeAdminName(@ModelAttribute("userForm")User userForm,
                                  @SessionAttribute("user")User u,
                                  HttpServletRequest request){
        if(userForm.getName().isEmpty() || userForm.getName().equals("")){
            return "redirect:/adminPanel/userPage";
        }else{
            u.setName(userForm.getName());
            request.getSession().setAttribute("user",u);
            userDao.updateName(u.getId_user(),userForm.getName());
            return "redirect:/adminPanel/userPage";
        }
    }



    // CHANGE ADMIN LAST NAME IN USER PAGE
    @RequestMapping(path = "changeLastName",method = RequestMethod.POST)
    public String changeAdminLastName(@ModelAttribute("userForm")User userForm,
                                      @SessionAttribute("user")User u,
                                      HttpServletRequest request){
        if(userForm.getLast_name().isEmpty() || userForm.getLast_name().equals("")){
            return "redirect:/adminPanel/userPage";
        }else{
            u.setLast_name(userForm.getLast_name());
            request.getSession().setAttribute("user",u);
            userDao.updateLastName(u.getId_user(),userForm.getLast_name());
            return "redirect:/adminPanel/userPage";
        }
    }



    // CHANGE ADMIN ROLE IN USER PAGE
    @RequestMapping(path = "changeRole",method = RequestMethod.POST)
    public String changeAdminRole(@ModelAttribute("userForm")User userForm,
                                  @SessionAttribute("user")User user,
                                  @ModelAttribute("selectRole")String roleName,
                                  HttpServletRequest request){
        if(user.getRole().getName().equals(roleName)) {
            return "redirect:/adminPanel/userPage";
        } else{
            Role newRole = roleDao.getRoleByRoleName(roleName);
            user.setRole(newRole);
            request.getSession().setAttribute("user",user);

            System.out.println(user.getId_user()+" "+user.getRole().toString());
            userDao.updateRole(user.getId_user(),user.getRole());

            return "redirect:/adminPanel/userPage";
        }
    }


    // CHANGE ADMIN COUNTRY IN USER PAGE
    @RequestMapping(path = "changeCountry",method = RequestMethod.POST)
    public String changeCountry(@ModelAttribute("userForm")User userForm,
                                @SessionAttribute("user")User u,
                                HttpServletRequest request) {
        if (userForm.getCountry().isEmpty() || userForm.getCountry().equals("")) {
            return "redirect:/adminPanel/userPage";
        } else {
            u.setCountry(userForm.getCountry());
            request.getSession().setAttribute("user", u);
            userDao.updateCountry(u.getId_user(), userForm.getCountry());
            return "redirect:/adminPanel/userPage";
        }
    }


    // CHANGE ADMIN LOGIN IN USER PAGE
    @RequestMapping(path = "changeLogin",method = RequestMethod.POST)
    public String changeLogin(@ModelAttribute("userForm")User userForm,
                              @SessionAttribute("user")User u,
                              HttpServletRequest request) {
        if (userForm.getLogin().isEmpty() || userForm.getLogin().equals("")) {
            return "redirect:/adminPanel/userPage";
        } else {
            u.setLogin(userForm.getLogin());
            request.getSession().setAttribute("user", u);
            userDao.updateLogin(u.getId_user(), userForm.getLogin());
            return "redirect:/adminPanel/userPage";
        }
    }


    // CHANGE ADMIN PASSWORD IN USER PAGE
    @RequestMapping(path = "changePassword",method = RequestMethod.POST)
    public String changePassword(@ModelAttribute("userForm")User userForm,
                                 @SessionAttribute("user")User u,
                                 HttpServletRequest request) {
        if (userForm.getPassword().isEmpty() || userForm.getPassword().equals("")) {
            return "redirect:/adminPanel/userPage";
        } else {
            u.setPassword(userForm.getPassword());
            request.getSession().setAttribute("user", u);
            userDao.updatePassword(u.getId_user(), userForm.getPassword());
            return "redirect:/adminPanel/userPage";
        }
    }

}
