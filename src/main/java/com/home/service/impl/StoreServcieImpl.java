package com.home.service.impl;

import com.home.dao.StoreMapper;
import com.home.dao.UserMapper;
import com.home.entity.Borrow;
import com.home.entity.User;
import com.home.service.StoreService;
import com.home.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StoreServcieImpl implements StoreService {
    @Override
    public List<Borrow> getBorrowList() {
        try(SqlSession session = MybatisUtil.getSession()){
            StoreMapper mapper = session.getMapper(StoreMapper.class);
            return mapper.getBorrowList();
        }
    }
}
