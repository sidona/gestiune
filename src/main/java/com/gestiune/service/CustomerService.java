package com.gestiune.service;

import com.gestiune.model.Customer;

import java.util.List;

/**
 * Created by sdonose on 2/8/2016.
 */
public interface CustomerService {

    List<Customer> findAll();
    List<Customer> findAllCustomer();
}
