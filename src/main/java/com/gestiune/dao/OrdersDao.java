package com.gestiune.dao;

import com.gestiune.model.Order;

import java.util.List;

/**
 * Created by sdonose on 2/8/2016.
 */
public interface OrdersDao {

    List<Order> findAllOrders();
}
