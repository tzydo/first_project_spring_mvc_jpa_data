package com.pl.springboot.mvc.jpa.controller;


import com.pl.springboot.mvc.jpa.dao.RoleDao;
import com.pl.springboot.mvc.jpa.dao.UserDao;
import com.pl.springboot.mvc.jpa.model.Role;
import com.pl.springboot.mvc.jpa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
                                   HttpServletRequest request){

        User user = (User) request.getSession().getAttribute("user");
        try{
            if(!user.equals(null)){

                List<Role> roleList = (List<Role>) roleDao.findAll();


                model.addAttribute("name", user.getName());
                model.addAttribute("lastName", user.getLast_name());
                model.addAttribute("roleList", roleList);

                return "aboutMePage";
            }else {
                return "redirect:/login";
            }
        }catch (Exception ex){
            return "redirect:/login";
        }
    }



    // CHANGE ADMIN NAME IN USER PAGE
    @RequestMapping(path = "changeName",method = RequestMethod.POST)
    public String changeAdminName(@RequestParam("newName") String name,
                                  @SessionAttribute("user")User u,
                                  HttpServletRequest request){
        if(name.isEmpty() || name.equals("")|| name.equals(null)){
            return "redirect:/adminPanel/userPage";
        }else{
            u.setName(name);
            request.getSession().setAttribute("user",u);
            userDao.updateName(u.getId_user(),name);
            return "redirect:/adminPanel/userPage";
        }
    }



    // CHANGE ADMIN LAST NAME IN USER PAGE
    @RequestMapping(path = "changeLastName",method = RequestMethod.POST)
    public String changeAdminLastName(@RequestParam("newLastName") String lastName ,
                                      @SessionAttribute("user")User u,
                                      HttpServletRequest request){
        if(lastName.isEmpty() || lastName.equals("") || lastName.equals(null)){
            return "redirect:/adminPanel/userPage";
        }else{
            u.setLast_name(lastName);
            request.getSession().setAttribute("user",u);
            userDao.updateLastName(u.getId_user(),lastName);
            return "redirect:/adminPanel/userPage";
        }
    }



    // CHANGE ADMIN ROLE IN USER PAGE
    @RequestMapping(path = "changeRole",method = RequestMethod.POST)
    public String changeAdminRole(@SessionAttribute("user")User user,
                                  @ModelAttribute("selectRole")String roleName,
                                  HttpServletRequest request){
        if(user.getRole().getName().equals(roleName)) {
            return "redirect:/adminPanel/userPage";
        } else{
            Role newRole = roleDao.getRoleByRoleName(roleName);
            user.setRole(newRole);
            request.getSession().setAttribute("user",user);

            userDao.updateRole(user.getId_user(),user.getRole());

            return "redirect:/adminPanel/userPage";
        }
    }


    // CHANGE ADMIN COUNTRY IN USER PAGE
    @RequestMapping(path = "changeCountry",method = RequestMethod.POST)
    public String changeCountry(@RequestParam("newCountry") String country,
                                @SessionAttribute("user")User u,
                                HttpServletRequest request) {
        if (country.isEmpty() || country.equals("") || country.equals(null)) {
            return "redirect:/adminPanel/userPage";
        } else {
            u.setCountry(country);
            request.getSession().setAttribute("user", u);
            userDao.updateCountry(u.getId_user(), country);
            return "redirect:/adminPanel/userPage";
        }
    }


    // CHANGE ADMIN LOGIN IN USER PAGE
    @RequestMapping(path = "changeLogin",method = RequestMethod.POST)
    public String changeLogin(@RequestParam("newLogin") String login,
                              @SessionAttribute("user")User u,
                              HttpServletRequest request) {
        if (login.isEmpty() || login.equals("") || login.equals(null)) {
            return "redirect:/adminPanel/userPage";
        } else {
            u.setLogin(login);
            request.getSession().setAttribute("user", u);
            userDao.updateLogin(u.getId_user(), login);
            return "redirect:/adminPanel/userPage";
        }
    }


    // CHANGE ADMIN PASSWORD IN USER PAGE
    @RequestMapping(path = "changePassword",method = RequestMethod.POST)
    public String changePassword(@RequestParam("newPassword") String password,
                                 @SessionAttribute("user")User u,
                                 HttpServletRequest request) {
        if (password.isEmpty() || password.equals("") || password.equals(null)) {
            return "redirect:/adminPanel/userPage";
        } else {
            u.setPassword(password);
            request.getSession().setAttribute("user", u);
            userDao.updatePassword(u.getId_user(), password);
            return "redirect:/adminPanel/userPage";
        }
    }

}
