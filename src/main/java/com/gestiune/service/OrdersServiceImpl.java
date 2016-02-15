package com.gestiune.service;

import com.gestiune.dao.OrdersDao;
import com.gestiune.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sdonose on 2/8/2016.
 */

@Service("ordersService")
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao dao;

    public List<Orders> findAllOrders() {
        return dao.findAllOrders();
    }

    public void saveOrder(Orders orders) {
        dao.saveOrder(orders);
    }

    public List<Orders> findOrderByProduct() {
        return dao.findOrderByProduct();
    }


}
