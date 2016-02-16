package com.gestiune.service;

import com.gestiune.dao.OrderProductPkDao;
import com.gestiune.model.OrderProductPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sdonose on 2/16/2016.
 */

@Service("orderProductPkService")
@Transactional
public class OrderProductPkServiceImpl implements OrderProductPkService {
    @Autowired
    public OrderProductPkDao dao;

    public List<OrderProductPK> findAllProductOrder() {
        return dao.findAllProductOrder();
    }
}
