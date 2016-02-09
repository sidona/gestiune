package com.gestiune.controller;

import com.gestiune.model.Customer;
import com.gestiune.model.Order;
import com.gestiune.model.Product;
import com.gestiune.service.CustomerService;
import com.gestiune.service.OrdersService;
import com.gestiune.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by sdonose on 2/6/2016.
 */

@Controller
@RequestMapping("/")
public class ProductController {

    @Autowired
    public ProductService service;

    @Autowired
    public CustomerService serviceCustomer;

    @Autowired
    public OrdersService ordersService;



    @RequestMapping(value = "/getAllOrders", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Order> listOrders(ModelMap model){
        List<Order> orders=ordersService.findAllOrders();
        model.addAttribute("orders",orders);
        return ordersService.findAllOrders();
    }
   



    @RequestMapping(value = "/getAllCustomer", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Customer> listCustomer(ModelMap model){
        List<Customer> customers=serviceCustomer.findAll();
        model.addAttribute("customer",customers);
        return serviceCustomer.findAll();
    }

    @RequestMapping(value = "/getAllCus", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Customer> listCustomerAll(ModelMap model){
        List<Customer> customers=serviceCustomer.findAllCustomer();
        model.addAttribute("customer",customers);
        return serviceCustomer.findAllCustomer();
    }


    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Product> listProduct(ModelMap model) {
        List<Product> products = service.findAllProducts();
        model.addAttribute("product", products);
        System.out.println("product ");
        return service.findAllProducts();

    }

}
