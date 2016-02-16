package com.gestiune.dao;

import com.gestiune.model.OrderProductPK;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sdonose on 2/16/2016.
 */

@Repository("orderProductPkDao")
public class OrderProductPkDaoImpl extends AbstractDao<Integer, OrderProductPK> implements OrderProductPkDao {

    @Autowired
    private SessionFactory sessionFactory;


    public List<OrderProductPK> findAllProductOrder() {
      List<OrderProductPK> list=(List<OrderProductPK>)sessionFactory.getCurrentSession().createSQLQuery("select\n" +
              "    o.order_id,\n" +
              "    p.name,\n" +
              "    p.price,\n" +
              "    op.quantity,\n" +
              "    p.price * op.quantity as product_total\n" +
              "from orders o\n" +
              "join order_product op\n" +
              "  on o.order_id=op.order_id\n" +
              "join product p\n" +
              "  on op.product_id=p.product_id;\n").list();
        return list;
    }
}
