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
//afiseaza nume si pret
    @RequestMapping(value = "/getAllProduct", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Product> listProduct(ModelMap model) {
        List<Product> products = service.findAllProducts();
        model.addAttribute("product", products);
        System.out.println("product" + products.getClass());
        return service.findAllProducts();

    }
    @RequestMapping(value = "/getListProduct", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Product> listAllProduct(ModelMap model) {
        List<Product> products = service.findAllProduct();
        model.addAttribute("product", products);
        System.out.println("product" + products.getClass());
        return service.findAllProduct();

    }

    @RequestMapping(value = "/newProduct", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    boolean saveProduct(@RequestBody Product product) {

        this.service.saveProduct(product);
        return true;
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Product productId(@PathVariable int id) {
        Product product = service.findById(id);
        return product;

    }

    @RequestMapping(value = "/productList/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Product> productDetailId(@PathVariable int id) {
        List<Product> product = service.findByIdDetail(id);
        return product;

    }

    @RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    boolean deleteProduct(@PathVariable int id) {
        this.service.deleteProductById(id);

        return true;
    }


}




