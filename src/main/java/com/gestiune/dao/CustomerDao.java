package com.gestiune.dao;

import com.gestiune.model.Customer;

import java.util.List;

/**
 * Created by sdonose on 2/8/2016.
 */
public interface CustomerDao {

//    Customer findById(int id);
//
//    void saveCustomer(Customer customer);

    List<Customer> findAll();


}
