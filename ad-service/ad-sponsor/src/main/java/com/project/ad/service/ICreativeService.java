package com.project.ad.service;

import com.project.ad.vo.CreativeRequest;
import com.project.ad.vo.CreativeResponse;

public interface ICreativeService {
    CreativeResponse creatCreative(CreativeRequest request);
}
