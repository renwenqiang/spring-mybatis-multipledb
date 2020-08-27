package com.boot.springmybatismultipledb.mapper;

import com.boot.springmybatismultipledb.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {

    void createOrder(Order order);
}
