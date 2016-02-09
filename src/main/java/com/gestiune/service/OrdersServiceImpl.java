package com.gestiune.service;

import com.gestiune.dao.OrdersDao;
import com.gestiune.model.Order;
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

    public List<Order> findAllOrders() {
        return dao.findAllOrders();
    }
}
