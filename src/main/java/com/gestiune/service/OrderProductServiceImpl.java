package com.gestiune.service;

import com.gestiune.dao.OrderProductDao;
import com.gestiune.model.OrderProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sdonose on 2/16/2016.
 */
@Service("orderProductService")
@Transactional
public class OrderProductServiceImpl implements OrderProductService{

    @Autowired
    private OrderProductDao dao;


    public List<OrderProduct> findAllOrderProduct() {
        return dao.findAllOrderProduct();
    }
}
