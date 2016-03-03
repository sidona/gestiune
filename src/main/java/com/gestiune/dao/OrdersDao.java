package com.gestiune.dao;


import com.gestiune.model.Orders;

import java.util.List;

/**
 * Created by sdonose on 2/8/2016.
 */
public interface OrdersDao {

    List<Orders> findAllOrders();

    List<Orders> findAllOrdersTotal();

    void saveOrder(Orders orders);

    List<Orders> findOrderById(int entryId);
}
