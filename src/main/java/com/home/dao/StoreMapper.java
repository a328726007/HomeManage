package com.home.dao;

import com.home.entity.Borrow;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StoreMapper {

    @Results({
            @Result(column = "id",property = "borrowId"),
            @Result(column = "device_id",property = "deviceId"),
            @Result(column = "device_name",property = "deviceName"),
            @Result(column = "date",property = "date"),
            @Result(column = "customer_id",property = "customerId"),
            @Result(column = "name",property = "customerName")
    })
    @Select("select * from borrow,customer,store where borrow.device_id = store.device_id and borrow.customer_id = customer.customer_id;")
    List<Borrow> getBorrowList();     
}
