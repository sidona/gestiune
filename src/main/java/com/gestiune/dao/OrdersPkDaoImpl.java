package com.gestiune.dao;

import com.gestiune.model.OrdersPK;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sdonose on 2/16/2016.
 */
@Repository("ordersPkDao")
public class OrdersPkDaoImpl extends AbstractDao<Integer, OrdersPK> implements OrdersPkDao {
    @Autowired
    private SessionFactory sessionFactory;


    public List<OrdersPK> findAllOrdersPK() {
       List<OrdersPK> list=(List<OrdersPK>)sessionFactory.getCurrentSession().createSQLQuery("select\n" +
               "    o.order_id,\n" +
               "    c.customer_id,\n" +
               "    c.name,\n" +
               "    sum(p.price * op.quantity) as order_total\n" +
               "from orders o\n" +
               "join order_product op\n" +
               "  on o.order_id=op.order_id\n" +
               "join customer c\n" +
               "on c.customer_id=o.customer_id  \n" +
               "join product p\n" +
               "  on op.product_id=p.product_id\n" +
               "  group by o.order_id\n").list();
        return list;
    }

    public OrdersPK findById(int orderId) {
//       Criteria criteria=createEntityCriteria();
//        criteria.add(Restrictions.eq("orderId",orderId));
//        return (List<OrdersPK>) criteria.list();
        return (OrdersPK) sessionFactory.getCurrentSession().get(OrdersPK.class,orderId);
    }

}
