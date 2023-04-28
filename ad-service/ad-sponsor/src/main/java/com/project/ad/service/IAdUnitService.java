package com.project.ad.service;

import com.project.ad.exception.AdException;
import com.project.ad.vo.*;

public interface IAdUnitService {
    AdUnitResponse createUnit(AdUnitRequest request)
            throws AdException;

    AdUnitKeywordResponse createUnitKeyword(AdUnitKeywordRequest request)
            throws AdException;

    AdUnitItResponse createUnitIt(AdUnitItRequest request)
            throws AdException;

    AdUnitDistrictResponse createUnitDistrict(AdUnitDistrictRequest request)
            throws AdException;
    CreativeUnitResponse createCreativeUnit(CreativeUnitRequest request)
            throws AdException;
}
