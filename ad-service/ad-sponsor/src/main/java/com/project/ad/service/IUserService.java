package com.project.ad.service;

import com.project.ad.exception.AdException;
import com.project.ad.vo.CreateUserRequest;
import com.project.ad.vo.CreateUserResponse;

public interface IUserService {

    /**
     * 创建用户
     * @param request
     * @return
     * @throws AdException
     */
    CreateUserResponse createUser(CreateUserRequest request) throws AdException;
}
