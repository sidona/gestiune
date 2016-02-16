package com.gestiune.dao;

import com.gestiune.model.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sdonose on 2/8/2016.
 */
@Repository("customerDao")
public class CustomerDaoImpl extends AbstractDao<Integer, Customer> implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Customer findById(int customerId) {
        return getByKey(customerId);
    }

    public void saveCustomer(Customer customer){
        persist(customer);
    }

    public List<Customer> findAll() {
        Criteria criteria = createEntityCriteria();
        System.out.println("CustomerDaoImpl.findAll"+criteria.list());
        return (List<Customer>) criteria.list();
    }


}
