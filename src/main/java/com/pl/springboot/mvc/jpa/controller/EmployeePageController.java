package com.pl.springboot.mvc.jpa.controller;

import com.pl.springboot.mvc.jpa.dao.RoleDao;
import com.pl.springboot.mvc.jpa.dao.UserDao;
import com.pl.springboot.mvc.jpa.model.Role;
import com.pl.springboot.mvc.jpa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "adminPanel",method = RequestMethod.GET)
public class EmployeePageController {

    @Autowired
    UserDao userDao;

    @Autowired
    RoleDao roleDao;

    //    LIST EMPLOYEE PAGE
    @RequestMapping(value = "employeeList",method = RequestMethod.GET)
    public String getEmployeeList(Model model,
                                  @SessionAttribute("user")User u){

        List<User> userList = (List<User>) userDao.findAll();
        List<Role> roleList = (List<Role>) roleDao.findAll();
        User user = u;

        model.addAttribute("name",user.getName());
        model.addAttribute("lastName",user.getLast_name());
        model.addAttribute("userList",userList);
        model.addAttribute("roleList",roleList);
        return "employeeList";
    }



    @RequestMapping(path = "delete/{id}",method = RequestMethod.POST)
    public String deleteEmployee(@PathVariable("id")int id){

            userDao.updateRole(id,null);
            userDao.delete(id);
            return "redirect:/adminPanel/employeeList";

    }



    @RequestMapping(path = "addEmployee",method = RequestMethod.POST)
    public String addEmployee(@RequestParam(value = "name")String name,
                              @RequestParam("lastName")String lastName,
                              @RequestParam("country")String country,
                              @RequestParam("login")String login,
                              @RequestParam("password")String password,
                              @ModelAttribute("selectRole")String roleName){

        Role newRole = roleDao.getRoleByRoleName(roleName);


        if(name.isEmpty() || name.equals("")||
                lastName.isEmpty() || lastName.equals("")||
                country.isEmpty() || country.equals("")||
                login.isEmpty() || login.equals("")||
                password.isEmpty() || password.equals("")){
            return "redirect:/adminPanel/employeeList";
        }else {
            User user = new User(0,name,lastName,country,login,password,newRole);

            userDao.save(user);
            return "redirect:/adminPanel/employeeList";
        }
    }
}
