package com.project.ad.service.impl;


import com.project.ad.constant.Constants;
import com.project.ad.dao.AdUserRepository;
import com.project.ad.entity.AdUser;
import com.project.ad.exception.AdException;
import com.project.ad.service.IUserService;
import com.project.ad.utils.CommonUtils;
import com.project.ad.vo.CreateUserRequest;
import com.project.ad.vo.CreateUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j  //添加日志属性
@Service //标记为bean
public class UserServiceImpl implements IUserService {

    private final AdUserRepository userRepository;

    @Autowired
    public UserServiceImpl(AdUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public CreateUserResponse createUser(CreateUserRequest request) throws AdException {


        if (!request.validate()) {  // 验证传入参数是否正确
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        AdUser oldUser = userRepository.findByUsername(request.getUsername());


        if (oldUser != null) {  // 判断当前系统是否有重名用户
            throw new AdException(Constants.ErrorMsg.SAME_NAME_ERROR);
        }
        AdUser newUser = userRepository.save(new AdUser(
                request.getUsername(), CommonUtils.md5(request.getUsername())
        ));
        return new CreateUserResponse(
                newUser.getId(), newUser.getUsername(), newUser.getToken(),
                newUser.getCreateTime(), newUser.getUpdateTime()
        );
    }
}
