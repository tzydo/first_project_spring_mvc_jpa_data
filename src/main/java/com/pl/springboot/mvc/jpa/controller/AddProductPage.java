package com.pl.springboot.mvc.jpa.controller;


import com.pl.springboot.mvc.jpa.dao.MarkDao;
import com.pl.springboot.mvc.jpa.dao.ModelDao;
import com.pl.springboot.mvc.jpa.dao.ProductTypeDao;
import com.pl.springboot.mvc.jpa.model.Mark;
import com.pl.springboot.mvc.jpa.model.Modell;
import com.pl.springboot.mvc.jpa.model.ProductType;
import com.pl.springboot.mvc.jpa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "adminPanel",method = RequestMethod.GET)
public class AddProductPage {



    @Autowired
    private ProductTypeDao productTypeDao;

    @Autowired
    private MarkDao markDao;

    @Autowired
    private ModelDao modelDao;



    @RequestMapping(value = "addProduct", method = RequestMethod.GET)
    public String getAddProductPage(Model model,
                                    HttpServletRequest request){

        User user = (User) request.getSession().getAttribute("user");
        try{
            if(!user.equals(null)){
                List<ProductType> productTypeList = (List<ProductType>) productTypeDao.findAll();
                List<Mark> markList = (List<Mark>) markDao.findAll();
                List<Modell> modellList = (List<Modell>) modelDao.findAll();



                model.addAttribute("name", user.getName());
                model.addAttribute("lastName", user.getLast_name());
                model.addAttribute("productTypeList",productTypeList);
                model.addAttribute("markList",markList);
                model.addAttribute("modellList",modellList);
                model.addAttribute("name", user.getName());
                model.addAttribute("lastName", user.getLast_name());

                return "addProductPage";
            }else {
                return "redirect:/login";
            }
        }catch (Exception ex){
            return "redirect:/login";
        }
    }

}
