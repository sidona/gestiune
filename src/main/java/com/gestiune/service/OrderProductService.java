package com.gestiune.service;

import com.gestiune.model.OrderProduct;

import java.util.List;

/**
 * Created by sdonose on 2/16/2016.
 */
public interface OrderProductService {
    List<OrderProduct> findAllOrderProduct();

    void saveProduct(OrderProduct orderProduct);
}
