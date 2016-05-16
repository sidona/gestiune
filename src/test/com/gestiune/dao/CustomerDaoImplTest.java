package com.gestiune.dao;

import com.gestiune.model.Customer;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by sdonose on 3/8/2016.
 */

@Repository
@ContextConfiguration(locations = {"classpath:Customer.xml"})
public class CustomerDaoImplTest extends EntityDaoImplTest {

    @Autowired
    CustomerDao customerDao;

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Customer.xml"));
        return dataSet;
    }

//    @Test
//    public void testFindById() throws Exception {
//        Assert.assertNotNull(customerDao.findById(1));
//        Assert.assertNull(customerDao.findById(3));
//    }

//    @Test
//    public void testSaveCustomer() throws Exception {
//        customerDao.saveCustomer(getSampleCustomer());
//        Assert.assertEquals(customerDao.findAll().size(), 3);
//    }

    @Test
    public void testFindAll() throws Exception {
        Assert.assertEquals(customerDao.findAll().size(), 2);
    }

    public Customer getSampleCustomer() {
        Customer customer = new Customer();
        customer.setName("Karen");
        customer.setAddress("molifului");
        customer.setTelephone("8956");
        return customer;
    }

}