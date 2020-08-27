package com.boot.springmybatismultipledb.controller;

import cn.hutool.core.lang.Snowflake;
import com.boot.springmybatismultipledb.entity.Order;
import com.boot.springmybatismultipledb.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    Snowflake snowflake = new Snowflake(1,1);


    @RequestMapping("/createOrder")
    public Order createOrder(@RequestBody Order order){
        order.setId(snowflake.nextId());
        order.setAmount(order.getCount()*10);
        orderService.createOrder(order);
        return order;
    }
}
