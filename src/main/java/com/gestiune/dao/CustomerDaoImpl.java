package com.gestiune.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.gestiune.model.Customer;
import com.gestiune.model.Product;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.Queue;

/**
 * Created by sdonose on 2/8/2016.
 */
@Repository("customerDao")
public class CustomerDaoImpl extends AbstractDao<Integer, Customer> implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Customer> findAll() {
        Criteria criteria = createEntityCriteria();
        System.out.println("CustomerDaoImpl.findAll"+criteria.list());
        return (List<Customer>) criteria.list();
    }

    public List<Customer> findAllCustomer() {

        List<Customer> list=(List<Customer>)sessionFactory.getCurrentSession().createQuery(String.format("FROM Order o JOIN o.customer c ")).list();
         return list;

    }
}
