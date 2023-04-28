package com.project.ad.client;

import com.project.ad.entity.AdPlan;
import com.project.ad.vo.AdPlanGetRequest;
import com.project.ad.vo.CommonResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SponsorClientHystrix implements SponsorClient{

    @Override
    public CommonResponse<List<AdPlan>> getAdPlans(AdPlanGetRequest request) {
        return new CommonResponse<>(-1, "eureka-client-ad-sponsor error");
    }
}
