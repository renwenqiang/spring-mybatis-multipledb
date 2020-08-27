package com.boot.springmybatismultipledb.service.impl;

import com.boot.springmybatismultipledb.entity.Order;
import com.boot.springmybatismultipledb.mapper.OrderMapper;
import com.boot.springmybatismultipledb.mapper.StorageMapper;
import com.boot.springmybatismultipledb.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderMapper orderMapper;

    @Resource
    StorageMapper storageMapper;


    Logger logger = LoggerFactory.getLogger(this.getClass());


//    @Transactional
    @Override
    public void createOrder(Order order) {
        storageMapper.decreaseStorage(order);
//        int k = 1/0;
        logger.info("库存已扣减，商品代码:{}，购买数量:{}。创建订单中...",order.getCommodityCode(),order.getCount());
        orderMapper.createOrder(order);
    }
}
