package com.gestiune.controller;

import com.gestiune.model.Customer;
import com.gestiune.model.Orders;
import com.gestiune.model.Product;
import com.gestiune.service.CustomerService;
import com.gestiune.service.OrdersService;
import com.gestiune.service.ProductService;
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

    @Autowired
    public CustomerService serviceCustomer;

    @Autowired
    public OrdersService ordersService;

//Order

    @RequestMapping(value = "/getAllOrders", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Orders> listOrders(ModelMap model) {
        List<Orders> orders = ordersService.findAllOrders();
        model.addAttribute("orders", orders);
        return ordersService.findAllOrders();
    }

    @RequestMapping(value = "/getAllOrdersByProduct", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Orders> listOrdersByProduct(ModelMap model) {
        List<Orders> orders = ordersService.findOrderByProduct();
        model.addAttribute("orders", orders);
        return ordersService.findOrderByProduct();
    }


    @RequestMapping(value = "/addNewOrder", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    boolean saveOrder(@RequestBody Orders orders) {
        this.ordersService.saveOrder(orders);
        return true;
    }

//Customer

    @RequestMapping(value = "/newCustomer", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    boolean saveCustomer(@RequestBody Customer customer) {
        this.serviceCustomer.saveCustomer(customer);
        return true;
    }

    @RequestMapping(value = "/getAllCustomer", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Customer> listCustomer(ModelMap model) {
        List<Customer> customers = serviceCustomer.findAll();
        model.addAttribute("customer", customers);
        return serviceCustomer.findAll();
    }


    @RequestMapping(value = "/getAllCus", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Customer> listCustomerAll(ModelMap model) {
        List<Customer> customers = serviceCustomer.findAllCustomer();
        model.addAttribute("customer", customers);
        return serviceCustomer.findAllCustomer();
    }

    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Customer customerId(@PathVariable int customerId) {
       Customer customer = serviceCustomer.findById(customerId);
        return customer;

    }

//Product

    @RequestMapping(value = "/getAllProduct", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Product> listProduct(ModelMap model) {
        List<Product> products = service.findAllProducts();
        model.addAttribute("product", products);
        System.out.println("product" + products.getClass());
        return service.findAllProducts();

    }

    @RequestMapping(value = "/getAllProductOrder", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Product> listProductOrder(ModelMap model) {
        List<Product> products = service.findAllProductOrder();
        model.addAttribute("product", products);
        System.out.println("product ");
        return service.findAllProductOrder();

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




