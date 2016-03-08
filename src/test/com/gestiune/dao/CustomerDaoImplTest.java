package com.gestiune.dao;

import com.gestiune.model.Customer;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by sdonose on 3/8/2016.
 */
public class CustomerDaoImplTest extends EntityDaoImplTest {
    @Autowired
    CustomerDao customerDao;

    @Test
    public void testFindById() throws Exception {
        Assert.assertNotNull(customerDao.findById(1));
        Assert.assertNull(customerDao.findById(3));
    }

    @Test
    public void testSaveCustomer() throws Exception {
        customerDao.saveCustomer(getSampleCustomer());
        Assert.assertEquals(customerDao.findAll().size(), 3);
    }

    @Test
    public void testFindAll() throws Exception {
        Assert.assertEquals(customerDao.findAll().size(), 2);
    }
    public Customer getSampleCustomer(){
        Customer customer = new Customer();
        customer.setName("Karen");
       customer.setId(25);
        customer.setAddress("molifului");
        customer.setTelephone("8956");
        return customer;
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Employee.xml"));
        return dataSet;
    }
}