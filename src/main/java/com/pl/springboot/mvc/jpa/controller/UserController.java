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
@RequestMapping(value = "userPage",method = RequestMethod.GET)
public class UserController {

    @Autowired
    UserDao userDao;


    @Autowired
    RoleDao roleDao;


//    ONLY TEMPLATE PAGE FOR TEST
    @RequestMapping(value = "aboutUser",method = RequestMethod.GET)
    public String getDefault(   Model model,
                                @SessionAttribute("user")User u){
        User user = u;
        model.addAttribute("name",user.getName());
        model.addAttribute("lastName",user.getLast_name());

        return "userPage";
    }


//    FAIL LOGIN PAGE
    @RequestMapping(value = "failUser",method = RequestMethod.GET)
    public String getFail(){
        return "failPanel";
    }




//    LOGOUT
    @RequestMapping(value = "logout",method = RequestMethod.POST)
    public String logout(HttpServletRequest request){
        request.getSession().setAttribute("user",null);
        return "redirect:/login";
    }

//    LIST EMPLOYEE PAGE
    @RequestMapping(value = "employeeList",method = RequestMethod.GET)
    public String getEmployeeList(Model model,
                                  @SessionAttribute("user")User u){

        List<User> userList = (List<User>) userDao.findAll();
        User user = u;

        model.addAttribute("name",user.getName());
        model.addAttribute("lastName",user.getLast_name());
        model.addAttribute("userList",userList);

        return "employeeList";
    }


//    ABOUT USER PAGE
    @RequestMapping(value = "userPage",method = RequestMethod.GET)
    public String getAboutUserPage(Model model,
                                   @SessionAttribute("user")User u){

        List<Role>roleList = (List<Role>) roleDao.findAll();

        User user = u;
        model.addAttribute("name",user.getName());
        model.addAttribute("lastName",user.getLast_name());
        model.addAttribute("roleList",roleList);

        return "aboutMePage";
    }


    @RequestMapping(path = "delete/{id}",method = RequestMethod.POST)
    public String deleteEmployee(@PathVariable("id")int id){
        try{
            userDao.delete(id);
            return "redirect:/userPage/employeeList";
        }catch (Exception ex){
            return "redirect:/userPage/failUser";
        }
    }


}
