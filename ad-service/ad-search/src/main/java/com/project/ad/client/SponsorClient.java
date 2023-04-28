package com.project.ad.client;

import com.project.ad.entity.AdPlan;
import com.project.ad.vo.AdPlanGetRequest;
import com.project.ad.vo.CommonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "eureka-client-feign", fallback = SponsorClientHystrix.class)
public interface SponsorClient {

    /**
     * 获取广告计划
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/ad-sponsor/get/adPlan", method = RequestMethod.POST)
    CommonResponse<List<AdPlan>> getAdPlans(@RequestBody AdPlanGetRequest request);

}

