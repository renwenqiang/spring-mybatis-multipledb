package com.boot.springmybatismultipledb.mapper;

import com.boot.springmybatismultipledb.entity.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface StorageMapper {

    void decreaseStorage(Order order);
}
