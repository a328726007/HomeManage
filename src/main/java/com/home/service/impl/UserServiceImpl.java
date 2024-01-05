package com.home.service.impl;

import com.home.dao.UserMapper;
import com.home.entity.User;
import com.home.service.UserService;
import com.home.util.MybatisUtil;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService {
    @Override
    public boolean auth(String username, String password, HttpSession session) {
        try(SqlSession sqlSession = MybatisUtil.getSession()){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUser(username,password);
            if(user == null) return false;
            session.setAttribute("user",user);
            return true;
        }
    }
}
