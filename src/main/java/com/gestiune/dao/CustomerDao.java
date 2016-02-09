package com.gestiune.dao;

import com.gestiune.model.Customer;

import java.util.List;

/**
 * Created by sdonose on 2/8/2016.
 */
public interface CustomerDao {

    List<Customer> findAll();
    List<Customer> findAllCustomer();
}
