package com.gestiune.dao;

import com.gestiune.model.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sdonose on 2/8/2016.
 */
@Repository("customerDao")
public class CustomerDaoImpl extends AbstractDao<Integer, Customer> implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

//    public Customer findById(int id) {
//        return getByKey(id);
//    }
//
//    public void saveCustomer(Customer customer){
//        persist(customer);
//    }



    public List<Customer> findAll() {
        List<Customer>list=sessionFactory.getCurrentSession().createQuery("from Customer ").list();
        return list;
    }

//    public List<Customer> findAll() {
//        Criteria criteria = createEntityCriteria();
//        System.out.println("CustomerDaoImpl.findAll"+criteria.list());
//        return (List<Customer>) criteria.list();
//    }


}
