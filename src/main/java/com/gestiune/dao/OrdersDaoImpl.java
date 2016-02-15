package com.gestiune.dao;

import com.gestiune.model.Orders;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * Created by sdonose on 2/8/2016.
 */
@Repository("ordersDao")
public class OrdersDaoImpl extends AbstractDao<Integer, Orders> implements OrdersDao{

    @Autowired
    private SessionFactory sessionFactory;

    public List<Orders> findAllOrders() {
        Criteria criteria = createEntityCriteria();
        return (List<Orders>) criteria.list();
    }

    public void saveOrder(Orders orders) {
        persist(orders);
    }

    public List<Orders> findOrderByProduct() {
        List<Orders> orders=(List<Orders>)sessionFactory.getCurrentSession().createSQLQuery("SELECT *" +
                "FROM orders o \n" +
                "\tINNER JOIN order_product op ON ( o.order_id = op.order_id  )  ").addEntity("o",Orders.class).list();
        return orders;
    }


}
