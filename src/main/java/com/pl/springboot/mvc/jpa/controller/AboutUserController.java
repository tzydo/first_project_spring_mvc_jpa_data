package com.pl.springboot.mvc.jpa.controller;

import com.pl.springboot.mvc.jpa.dao.JobTitleDao;
import com.pl.springboot.mvc.jpa.dao.RoleDao;
import com.pl.springboot.mvc.jpa.dao.UserDao;
import com.pl.springboot.mvc.jpa.model.JobTitle;
import com.pl.springboot.mvc.jpa.model.Role;
import com.pl.springboot.mvc.jpa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("user")
public class AboutUserController {

    @Autowired
    RoleDao roleDao;

    @Autowired
    JobTitleDao jobTitleDao;

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "role",method = RequestMethod.GET)
    @ResponseBody
    public List<Role> getRole(){
        List<Role> roleList = (List<Role>) roleDao.findAll();
        return roleList;
    }



    @RequestMapping(value = "jobTitle",method = RequestMethod.GET)
    @ResponseBody
    public List<JobTitle> getJobTitle(){
        List<JobTitle> jobTitleList = (List<JobTitle>) jobTitleDao.findAll() ;
        return jobTitleList;
    }


    @RequestMapping(value = "user",method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@RequestParam("id")int id){
        User user  = (User) userDao.findOne(id) ;
        return user;
    }

    @RequestMapping(value = "findAll",method = RequestMethod.GET)
    @ResponseBody
    public List<User>getAllUser(){
        List<User> userList = (List<User>) userDao.findAll();
        return  userList;
    }



}
