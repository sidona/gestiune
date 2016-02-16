package com.gestiune.dao;

import com.gestiune.model.Orders;
import com.gestiune.model.OrdersPK;

import java.util.List;

/**
 * Created by sdonose on 2/16/2016.
 */
public interface OrdersPkDao {
    List<OrdersPK> findAllOrdersPK();
}
