package com.pl.springboot.mvc.jpa.controller;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.pl.springboot.mvc.jpa.dao.RoleDao;
import com.pl.springboot.mvc.jpa.dao.UserDao;
import com.pl.springboot.mvc.jpa.model.Role;
import com.pl.springboot.mvc.jpa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping(value = "adminPanel",method = RequestMethod.GET)
public class AdminPageController {

    @Autowired
    UserDao userDao;


    @Autowired
    RoleDao roleDao;


//    ONLY TEMPLATE PAGE FOR TEST
    @RequestMapping(value = "*",method = RequestMethod.GET)
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



    @RequestMapping(path = "delete/{id}",method = RequestMethod.POST)
    public String deleteEmployee(@PathVariable("id")int id){
        try{
            userDao.delete(id);
            return "redirect:/userPage/employeeList";
        }catch (Exception ex){
            return "redirect:/userPage/failUser";
        }
    }



//    ABOUT USER PAGE
    @RequestMapping(value = "userPage",method = RequestMethod.GET)
    public String getAboutUserPage(Model model,
                                   @ModelAttribute("userForm")User userForm,
                                   @SessionAttribute("user")User u){

        List<Role>roleList = (List<Role>) roleDao.findAll();

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

            userDao.updateRole(user.getId_user(),user.getRole().getId_role());
//            System.out.println(user.getId_user()+" "+newRole.getId_role());
            return "redirect:/adminPanel/userPage";
        }
    }
}
