package com.gestiune.dao;

import com.gestiune.model.OrderProductPK;

import java.util.List;

/**
 * Created by sdonose on 2/16/2016.
 */
public interface OrderProductPkDao {

    List<OrderProductPK> findAllProductOrder();
}
