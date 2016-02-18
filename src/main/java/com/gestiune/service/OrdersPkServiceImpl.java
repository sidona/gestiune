package com.gestiune.service;

import com.gestiune.dao.OrdersPkDao;
import com.gestiune.model.OrdersPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sdonose on 2/16/2016.
 */
@Service("ordersPkService")
@Transactional
public class OrdersPkServiceImpl implements OrdersPkService {

    @Autowired
    private OrdersPkDao dao;

    public List<OrdersPK> findAllOrdersPK() {
        return dao.findAllOrdersPK();
    }

    public OrdersPK findById(int orderId) {
        return dao.findById(orderId);
    }
}
