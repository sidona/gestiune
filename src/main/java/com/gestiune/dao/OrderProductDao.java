package com.gestiune.dao;

import com.gestiune.model.OrderProduct;

import java.util.List;

/**
 * Created by sdonose on 2/16/2016.
 */
public interface OrderProductDao {

    List<OrderProduct> findAllOrderProduct();


}
