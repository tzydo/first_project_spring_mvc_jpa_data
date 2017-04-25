package com.pl.springboot.mvc.jpa.controller;
import com.pl.springboot.mvc.jpa.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping(value = "adminPanel",method = RequestMethod.GET)
public class AdminPageController {


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

}
