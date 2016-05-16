package com.gestiune.controller;

import com.gestiune.model.Customer;
import com.gestiune.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sdonose on 2/16/2016.
 */

@Controller
@RequestMapping("/")
public class CustomerController {

    @Autowired
    public CustomerService serviceCustomer;


//    @RequestMapping(value = "/newCustomer", method = RequestMethod.POST, consumes = "application/json")
//    @ResponseBody
//    boolean saveCustomer(@RequestBody Customer customer) {
//        this.serviceCustomer.saveCustomer(customer);
//        return true;
//    }

    @RequestMapping(value = "/getAllCustomer", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Customer> listCustomer() {
        return serviceCustomer.findAll();
    }



//    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = "application/json")
//    @ResponseBody
//    public Customer customerId(@PathVariable int id) {
//        Customer customer = serviceCustomer.findById(id);
//        return customer;
//
//    }
}
