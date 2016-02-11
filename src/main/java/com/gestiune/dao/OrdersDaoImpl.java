package com.gestiune.dao;

import com.gestiune.model.Order;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sdonose on 2/8/2016.
 */
@Repository("ordersDao")
public class OrdersDaoImpl extends AbstractDao<Integer, Order> implements OrdersDao{


    public List<Order> findAllOrders() {
        Criteria criteria = createEntityCriteria();
        return (List<Order>) criteria.list();
    }

    public void saveOrder(Order order) {
        persist(order);
    }


}
