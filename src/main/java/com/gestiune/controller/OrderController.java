package com.gestiune.controller;

import com.gestiune.model.Orders;
import com.gestiune.model.OrdersPK;
import com.gestiune.service.OrdersPkService;
import com.gestiune.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sdonose on 2/16/2016.
 */

@Controller
@RequestMapping("/")
public class OrderController {
    @Autowired
    public OrdersService ordersService;
    @Autowired
    public OrdersPkService ordersPkService;


    @RequestMapping(value = "/getAllOrders", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Orders> listOrders(ModelMap model) {
        List<Orders> orders = ordersService.findAllOrders();
        model.addAttribute("orders", orders);
        return ordersService.findAllOrders();
    }

    @RequestMapping(value = "/getAllOrdersByProduct", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Orders> listOrdersByProduct(ModelMap model) {
        List<Orders> orders = ordersService.findOrderByProduct();
        model.addAttribute("orders", orders);
        return ordersService.findOrderByProduct();
    }


    @RequestMapping(value = "/addNewOrder", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    boolean saveOrder(@RequestBody Orders orders) {
        this.ordersService.saveOrder(orders);
        return true;
    }

    @RequestMapping(value = "/getAllOrdersPk", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<OrdersPK> listOrdersPK(ModelMap model) {
        List<OrdersPK> orders = ordersPkService.findAllOrdersPK();
        model.addAttribute("orders", orders);
        return ordersPkService.findAllOrdersPK();
    }

    @RequestMapping(value = "/orderPk/{orderId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public OrdersPK orderId(@PathVariable int orderId) {
        OrdersPK ordersPK = ordersPkService.findById(orderId);
        return ordersPK;

    }

}
