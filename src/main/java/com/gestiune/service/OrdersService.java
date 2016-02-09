package com.gestiune.service;

import com.gestiune.model.Order;

import java.util.List;

/**
 * Created by sdonose on 2/8/2016.
 */
public interface OrdersService {
    List<Order> findAllOrders();
}
