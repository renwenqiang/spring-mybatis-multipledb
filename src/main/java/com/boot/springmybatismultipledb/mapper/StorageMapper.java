package com.boot.springmybatismultipledb.mapper;

import com.boot.springmybatismultipledb.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageMapper {

    void decreaseStorage(Order order);
}
