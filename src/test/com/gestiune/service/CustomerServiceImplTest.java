package com.gestiune.service;

import com.gestiune.controller.CustomerControllerTest;
import com.gestiune.dao.CustomerDao;
import com.gestiune.model.Customer;
import junit.framework.Assert;
import org.mockito.Mock;
import org.mockito.Spy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.atLeastOnce;
import static org.testng.Assert.*;

/**
 * Created by sdonose on 3/8/2016.
 */
public class CustomerServiceImplTest {
    @Mock
    CustomerDao dao;

    @InjectMocks
    CustomerServiceImpl customerService;

    @Spy
    List<Customer> customers=new ArrayList<Customer>();

    @BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        customers = getCustomerList();
    }

    @Test
    public void testFindById() throws Exception {
        Customer emp = customers.get(0);
        when(dao.findById(anyInt())).thenReturn(emp);
        Assert.assertEquals(customerService.findById(emp.getId()),emp);
    }

    @Test
    public void testFindAll() throws Exception {
        when(dao.findAll()).thenReturn(customers);
        Assert.assertEquals(customerService.findAll(), customers);
    }

    @Test
    public void testSaveCustomer() throws Exception {
        doNothing().when(dao).saveCustomer(any(Customer.class));
        customerService.saveCustomer(any(Customer.class));
        verify(dao, atLeastOnce()).saveCustomer(any(Customer.class));
    }

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