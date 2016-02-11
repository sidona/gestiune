package com.gestiune.dao;

import com.gestiune.model.Order;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sdonose on 2/8/2016.
 */
@Repository("ordersDao")
public class OrdersDaoImpl extends AbstractDao<Integer, Order> implements OrdersDao{

    @Autowired
    private SessionFactory sessionFactory;

    public List<Order> findAllOrders() {
        Criteria criteria = createEntityCriteria();
        return (List<Order>) criteria.list();
    }

    public void saveOrder(Order order) {
        persist(order);
    }

    public List<Order> findOrderByProduct() {
        List<Order> orders=(List<Order>)sessionFactory.getCurrentSession().createSQLQuery("SELECT *" +
                "FROM orders o \n" +
                "\tINNER JOIN order_product op ON ( o.order_id = op.order_id  )  ").addEntity("o",Order.class).list();
        return orders;
    }


}
