package com.project.ad.service.impl;

import com.project.ad.dao.CreativeRepository;
import com.project.ad.entity.Creative;
import com.project.ad.service.ICreativeService;
import com.project.ad.vo.CreativeRequest;
import com.project.ad.vo.CreativeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreativeServiceImpl implements ICreativeService {

    private  final CreativeRepository creativeRepository;

    @Autowired
    public CreativeServiceImpl(CreativeRepository creativeRepository) {
        this.creativeRepository = creativeRepository;
    }

    @Override
    public CreativeResponse creatCreative(CreativeRequest request) {
        Creative creative = creativeRepository.save(
                request.convertToEntity()
        );
        return null;
    }
}
