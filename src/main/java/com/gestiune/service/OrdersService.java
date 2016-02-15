package com.gestiune.service;

import com.gestiune.model.Orders;

import java.util.List;

/**
 * Created by sdonose on 2/8/2016.
 */
public interface OrdersService {
    List<Orders> findAllOrders();

    void saveOrder(Orders orders);

    List<Orders> findOrderByProduct();
}
