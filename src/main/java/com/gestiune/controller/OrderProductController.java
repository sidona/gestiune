package com.gestiune.controller;

import com.gestiune.model.OrderProductPK;
import com.gestiune.service.OrderProductPkService;
import com.gestiune.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by sdonose on 2/16/2016.
 */

@Controller
@RequestMapping("/")
public class OrderProductController {
    @Autowired
    public OrderProductService orderProductService;

    @Autowired
    public OrderProductPkService orderProductPkService;

    @RequestMapping(value = "/getAllOrderProduct", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<OrderProduct> listOrderProduct(ModelMap model) {
        List<OrderProduct> orders = orderProductService.findAllOrderProduct();
        model.addAttribute("orders", orders);
        return orderProductService.findAllOrderProduct();
    }


    @RequestMapping(value = "/getAllProductOrderPk", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<OrderProductPK> listProductOrder(ModelMap model) {
        List<OrderProductPK> orders = orderProductPkService.findAllProductOrder();
        model.addAttribute("orders", orders);
        return orderProductPkService.findAllProductOrder();
    }



}
