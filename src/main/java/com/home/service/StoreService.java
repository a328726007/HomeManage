package com.home.service;

import com.home.entity.Borrow;
import com.home.entity.Customer;
import com.home.entity.Store;

import java.util.List;

public interface StoreService {
    List<Borrow> getBorrowList();

    void deleteBorrow(String id);

    List<Store> listStores();

    List<Customer> listCustomers();

    void addBorrow(int cid,int sid);

    void deleteStore(String sid);

    void addStore(String sid,String name, int amount, int price);
}
