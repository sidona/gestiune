package com.gestiune.controller;

import com.gestiune.model.*;
import com.gestiune.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sdonose on 2/6/2016.
 */

@Controller
@RequestMapping("/")
public class ProductController {

    @Autowired
    public ProductService service;


//Product

    @RequestMapping(value = "/getAllProduct", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Product> listProduct(ModelMap model) {
        List<Product> products = service.findAllProducts();
        model.addAttribute("product", products);
        System.out.println("product" + products.getClass());
        return service.findAllProducts();

    }

    @RequestMapping(value = "/newProduct", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    boolean saveProduct(@RequestBody Product product) {

        this.service.saveProduct(product);
        return true;
    }

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Product productId(@PathVariable int productId) {
        Product product = service.findById(productId);
        return product;

    }

    @RequestMapping(value = "/deleteProduct/{name}", method = RequestMethod.DELETE)
    @ResponseBody
  boolean deleteProduct(  @PathVariable("name") String name) {
 service.deleteProductByName(name);

        return true ;
    }






}




