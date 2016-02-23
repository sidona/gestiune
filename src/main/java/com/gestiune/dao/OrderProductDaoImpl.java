package com.gestiune.dao;

import com.gestiune.model.OrderProduct;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sdonose on 2/16/2016.
 */

@Repository("orderProductDao")
public class OrderProductDaoImpl extends AbstractDao<Integer, OrderProduct> implements OrderProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<OrderProduct> findAllOrderProduct() {
        List<OrderProduct> orderProducts=sessionFactory.getCurrentSession().createQuery("select op.id, op.quantity, o.id, c.name, c.id from OrderProduct op inner join op.order o inner join o.customer c").list();
        return orderProducts;
    }
}
