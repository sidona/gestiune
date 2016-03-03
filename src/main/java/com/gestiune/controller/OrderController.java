package com.gestiune.controller;

import com.gestiune.model.Orders;
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



    @RequestMapping(value = "/getAllOrders", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Orders> listOrders(ModelMap model) {
        List<Orders> orders = ordersService.findAllOrders();
        model.addAttribute("orders", orders);
        return ordersService.findAllOrders();
    }

    @RequestMapping(value = "/getAllOrdersById/{entryId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Orders> listOrdersById(@PathVariable int entryId) {
        List<Orders> orders = ordersService.findOrderById(entryId);
        return orders;
    }


    @RequestMapping(value = "/addNewOrder", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    boolean saveOrder(@RequestBody Orders orders) {
        this.ordersService.saveOrder(orders);
        return true;
    }

}
