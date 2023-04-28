package com.project.ad.search;

import com.project.ad.search.vo.SearchRequest;
import com.project.ad.search.vo.SearchResponse;

/**
 * 用于广告的检索请求
 */
public interface ISearch {

    /**
     * 定义服务接口
     * 媒体方发起请求，传递进来一个request对象，
     * 检索服务根据request对象返回一个response对象
     */
    SearchResponse fetchAds(SearchRequest request);
}

