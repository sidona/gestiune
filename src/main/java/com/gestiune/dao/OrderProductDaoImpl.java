package com.gestiune.dao;

import com.gestiune.model.OrderProduct;
import com.sun.org.apache.bcel.internal.generic.InstructionListObserver;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by sdonose on 2/16/2016.
 */

@Repository("orderProductDao")
public class OrderProductDaoImpl extends AbstractDao<Integer, OrderProduct> implements OrderProductDao {

    @Autowired
    private SessionFactory sessionFactory;


    @SuppressWarnings("unchecked")
    public List<OrderProduct> findAllOrderProduct() {

        List<OrderProduct> orderProducts = sessionFactory.getCurrentSession().createQuery("from OrderProduct op inner join op.order o inner join o.customer c order by c.id ").list();
        return orderProducts;

    }
}
