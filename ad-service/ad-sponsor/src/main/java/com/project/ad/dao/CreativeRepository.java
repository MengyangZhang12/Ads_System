package com.project.ad.dao;

import com.project.ad.entity.Creative;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 创意查询接口
 * 默认通过主键查询，删除和增改都是支持的
 * 但是jpa查询效率比mybatis或者写sql略低
 */
public interface CreativeRepository extends JpaRepository<Creative, Long> {
}
