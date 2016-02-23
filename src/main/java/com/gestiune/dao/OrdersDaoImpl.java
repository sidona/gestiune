package com.gestiune.dao;

import com.gestiune.model.Customer;
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
        List<Orders>orderses=sessionFactory.getCurrentSession().createQuery(" select c.name,c.id, ord.id from Customer c inner join c.orders ord").list();
        return orderses;
    }

    public List<Orders> findAllOrdersTotal() {
        List<Orders> orderses=sessionFactory.getCurrentSession()
                .createQuery("select o.id, c.name,p.name,op.quantity,pe.priceUnit,pe.priceUnit*op.quantity as product_total from Customer  c inner join c.orders o inner join o.orderProduct op inner join op.entryProduct pe inner join pe.products p")
                .list();
        return orderses;
    }


//    public List<Orders> findAllOrders() {
//        List<Orders> orderses=sessionFactory.getCurrentSession().createQuery("select or.total,or.orderId from Orders or inner join or.customer c").list();
//        return orderses;
//    }

    public void saveOrder(Orders orders) {
        persist(orders);
    }

    public List<Orders> findOrderById(int id) {
        List<Orders> orders=sessionFactory.getCurrentSession().createQuery("\n" +
                "\n" +
                "select op.id, op.quantity, o.id, c.name, c.id from OrderProduct op inner join op.order o inner join o.customer c where c.id=:id").setInteger("id",id).list();
        return orders;
    }
}
