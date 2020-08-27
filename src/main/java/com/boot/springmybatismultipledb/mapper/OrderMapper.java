package com.boot.springmybatismultipledb.mapper;

import com.boot.springmybatismultipledb.entity.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface OrderMapper {

    void createOrder(Order order);
}
