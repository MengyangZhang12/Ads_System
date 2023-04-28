package com.project.ad.dao;

import com.project.ad.entity.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * AdUser的查询接口
 */
public interface AdUserRepository extends JpaRepository<AdUser, Long> {

    /**
     * <h2>根据用户名查找用户记录</h2>
     */
    AdUser findByUsername(String username);

}
