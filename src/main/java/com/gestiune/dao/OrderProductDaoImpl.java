package com.gestiune.dao;

import com.gestiune.model.OrderProduct;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sdonose on 2/16/2016.
 */

@Repository("orderProductDao")
public class OrderProductDaoImpl extends AbstractDao<Integer, OrderProduct> implements OrderProductDao {

    public List<OrderProduct> findAllOrderProduct() {
        Criteria criteria = createEntityCriteria();
        return (List<OrderProduct>) criteria.list();
    }
}
