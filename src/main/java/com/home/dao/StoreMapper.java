package com.home.dao;

import com.home.entity.Borrow;
import com.home.entity.Store;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.SortedMap;

public interface StoreMapper {

    @Results({
            @Result(column = "id",property = "borrowId"),
            @Result(column = "device_id",property = "deviceId"),
            @Result(column = "device_name",property = "deviceName"),
            @Result(column = "date",property = "date"),
            @Result(column = "customer_id",property = "customerId"),
            @Result(column = "name",property = "customerName")
    })
    @Select("select * from borrow,customer,store where borrow.device_id = store.device_id and borrow.customer_id = " +
            "customer.customer_id order by id")
    List<Borrow> getBorrowList();

    @Delete("delete from borrow where id = #{id}")
    void deleteBorrow(String id);

    @Results({
            @Result(column = "device_id",property = "deviceId"),
            @Result(column = "device_name",property = "deviceName"),
            @Result(column = "amount",property = "amount"),
            @Result(column = "price",property = "price"),
    })
    @Select("select * from store order by device_id")
    List<Store> listStores();

    @Insert("insert into borrow(customer_id,device_id,date) values(#{cid},#{sid},NOW())")
    void addBorrow(@Param("cid") int cid,@Param("sid")int sid);

    @Delete("delete from store where device_id = #{sid}")
    void deleteStore(String sid);

    @Insert("insert into store values(#{sid},#{name},#{amount},#{price} )")
    void addStore(@Param("sid") String sid,@Param("name") String name, @Param("amount") int amount,
                  @Param("price") int price);
}
