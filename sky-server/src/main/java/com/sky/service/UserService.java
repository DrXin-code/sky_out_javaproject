package com.sky.service;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    /**
     * 登录方法
     */
    User wxlogin(UserLoginDTO userLoginDTO);
}
