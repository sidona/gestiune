package com.gestiune.service;

import com.gestiune.dao.CustomerDao;
import com.gestiune.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sdonose on 2/8/2016.
 */

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDao dao;


//    public Customer findById(int id) {
//        return dao.findById(id);
//    }

    public List<Customer> findAll() {
        return dao.findAll();
    }



//    public void saveCustomer(Customer customer) {
//        dao.saveCustomer(customer);
//    }


}
