package com.gestiune.controller;

import com.gestiune.model.Customer;
import com.gestiune.service.CustomerService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ModelMap;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

/**
 * Created by sdonose on 3/8/2016.
 */

public class CustomerControllerTest {

    @Mock
    CustomerService customerService;

    @Mock
    Customer customer;


    @InjectMocks
    CustomerController customerController;

    @Spy
    List<Customer> customers = new ArrayList<Customer>();

    @Spy
    ModelMap model;



    @BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        customers = getCustomerList();
    }

//    @Test
//    public void testSaveCustomer() throws Exception {
//        Assert.assertEquals(customerController.saveCustomer(customer),true);
//        Assert.assertEquals(((Customer)model.get("customer")).getId(), 0);
//
//    }

    @Test
    public void testListCustomer() throws Exception {
        when(customerService.findAll()).thenReturn(customers);
        Assert.assertEquals(customerController.listCustomer(), customerService.findAll());


    }

//    @Test
//    public void testCustomerId() throws Exception {
//        Customer emp = customers.get(0);
//        when(customerService.findById(anyInt())).thenReturn(emp);
//        Assert.assertEquals(customerController.customerId(anyInt()),"customers");
//        Assert.assertNotNull(model.get("customer"));
//        Assert.assertEquals(((Customer)model.get("customer")).getId(), 1);
//
//
//    }

    public List<Customer> getCustomerList(){
        Customer customer = new Customer();
        customer.setName("kate");
        customer.setId(28);
        customer.setAddress("molidului");
        customer.setTelephone("8956896");

        Customer customer1 = new Customer();
        customer1.setName("mary");
        customer1.setId(21);
        customer1.setAddress("victoriei");
        customer1.setTelephone("00000");

        customers.add(customer);
        customers.add(customer1);
        return customers;
    }
}