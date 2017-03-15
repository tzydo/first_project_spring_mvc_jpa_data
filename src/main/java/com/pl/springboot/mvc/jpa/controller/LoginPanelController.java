package com.pl.springboot.mvc.jpa.controller;
import com.pl.springboot.mvc.jpa.dao.UserDao;
import com.pl.springboot.mvc.jpa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@Controller

public class LoginPanelController {

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "*",method = RequestMethod.GET)
    public String getDefaultPage(){
        return "redirect:/login";
    }

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String getLogintPage(HttpServletRequest request){

        User user = null;
        try{
            user = (User) request.getSession().getAttribute("user");
            if(user.equals(null)){
                return "loginPanel";
            }else {
                if (user.getRole().getName().equals("user")){
                    return ("redirect:/userPage/failUser");
                }else{
                    return "redirect:/userPage/aboutUser";
                }
            }
        }catch (Exception ex){
            return "loginPanel";
        }


    }

    @RequestMapping(value = "check",method = RequestMethod.POST)
    public String checkLogin(@RequestParam("login")String login,
                             @RequestParam("password")String password,
                             HttpServletRequest request){

            User user = null;
        try{
            user = userDao.findByLoginAndPassword(login,password);
            if(!user.equals(null)){
                request.getSession().setAttribute("user",user);
                return "redirect:/login";
            }else{
                return "redirect:/userPage/failUser";
            }

        }catch (Exception ex){
            return "redirect:/userPage/failUser";
        }

    }



}
