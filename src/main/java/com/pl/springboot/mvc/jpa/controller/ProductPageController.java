package com.pl.springboot.mvc.jpa.controller;

import com.pl.springboot.mvc.jpa.dao.MarkDao;
import com.pl.springboot.mvc.jpa.dao.ModelDao;
import com.pl.springboot.mvc.jpa.dao.ProductTypeDao;
import com.pl.springboot.mvc.jpa.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "adminPanel",method = RequestMethod.GET)
public class ProductPageController {


    @Autowired
    private ProductTypeDao productTypeDao;

    @Autowired
    private MarkDao markDao;

    @Autowired
    private ModelDao modelDao;

    //    ABOUT PRODUCTS PAGE
    @RequestMapping(value = "productPage",method = RequestMethod.GET)
    public String getProductPage(Model model,
                                   @ModelAttribute("userForm")User userForm,
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


                return "productsPage";
            }else {
                return "redirect:/login";
            }
        }catch (Exception ex){
            return "redirect:/login";
        }
    }



    //ADD PRODUCT TYPE
    @RequestMapping(path = "addProductType", method = RequestMethod.POST)
    public String addProductType(@RequestParam("newProductType")String product){
        ProductType productType = ProductType
                                    .builder()
                                    .id_product_type(0)
                                    .name(product).build();

        productTypeDao.save(productType);
        return "redirect:/adminPanel/productPage";
    }



    //ADD Mark
    @RequestMapping(path = "addMark", method = RequestMethod.POST)
    public String addMark(@RequestParam("newMark")String newMark){
        Mark mark = Mark
                        .builder()
                        .id_mark(0)
                        .name(newMark)
                        .build();

        markDao.save(mark);
        return "redirect:/adminPanel/productPage";
    }



    //ADD Model
    @RequestMapping(path = "addModel", method = RequestMethod.POST)
    public String addModel(@RequestParam("newModel")String newModel){
        Modell model = Modell
                        .builder()
                        .id_model(0)
                        .name(newModel)
                        .build();

        modelDao.save(model);
        return "redirect:/adminPanel/productPage";
    }



    //REMOVE PRODUCT TYPE
    @RequestMapping(path = "removeProductType",method = RequestMethod.POST)
    public String removeProduct(@ModelAttribute("selectProductType")String productName){

        if(!productName.equals("") || !productName.equals(null)){
            productTypeDao.removeByName(productName);
        }
        return "redirect:/adminPanel/productPage";
    }



    //REMOVE Mark
    @RequestMapping(path = "removeMark",method = RequestMethod.POST)
    public String removeMark(@ModelAttribute("selectMark")String mark){

        if(!mark.equals("") || !mark.equals(null)){
            markDao.removeByName(mark);
        }
        return "redirect:/adminPanel/productPage";
    }



    //REMOVE Model
    @RequestMapping(path = "removeModel",method = RequestMethod.POST)
    public String removeModel(@ModelAttribute("selectModel")String model){

        if(!model.equals("") || !model.equals(null)){
            modelDao.removeByName(model);
        }
        return "redirect:/adminPanel/productPage";
    }



}
