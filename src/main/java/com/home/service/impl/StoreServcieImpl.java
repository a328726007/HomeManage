package com.home.service.impl;

import com.home.dao.CustomerMapper;
import com.home.dao.StoreMapper;

import com.home.entity.Borrow;

import com.home.entity.Customer;
import com.home.entity.Store;
import com.home.service.StoreService;
import com.home.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;


import java.nio.channels.SeekableByteChannel;
import java.util.List;

public class StoreServcieImpl implements StoreService {
    @Override
    public List<Borrow> getBorrowList() {
        try(SqlSession session = MybatisUtil.getSession()){
            StoreMapper mapper = session.getMapper(StoreMapper.class);
            return mapper.getBorrowList();
        }
    }

    @Override
    public void deleteBorrow(String id) {
        try (SqlSession session = MybatisUtil.getSession()){
            StoreMapper mapper = session.getMapper(StoreMapper.class);
            mapper.deleteBorrow(id);
        }
    }

    @Override
    public List<Customer> listCustomers() {
        try (SqlSession session = MybatisUtil.getSession()){
            CustomerMapper mapper = session.getMapper(CustomerMapper.class);
            return mapper.listCustomers();
        }

    }

    @Override
    public List<Store> listStores() {
        try(SqlSession session = MybatisUtil.getSession()){
            StoreMapper mapper = session.getMapper(StoreMapper.class);
            return mapper.listStores();
        }
    }

    @Override
    public void addBorrow(int cid, int sid) {
        try(SqlSession session = MybatisUtil.getSession()){
            StoreMapper mapper = session.getMapper(StoreMapper.class);
            mapper.addBorrow(cid,sid);
        }
    }

    @Override
    public void deleteStore(String sid) {
        try (SqlSession session = MybatisUtil.getSession()){
            StoreMapper mapper = session.getMapper(StoreMapper.class);
            mapper.deleteStore(sid);
        }
    }

    @Override
    public void addStore(String sid, String name, int amount, int price) {
        try(SqlSession session = MybatisUtil.getSession()) {
            StoreMapper mapper = session.getMapper(StoreMapper.class);
            mapper.addStore(sid,name,amount,price);
        }
    }
}
