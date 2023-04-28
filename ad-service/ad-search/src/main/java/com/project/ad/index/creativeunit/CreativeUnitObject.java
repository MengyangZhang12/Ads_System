package com.project.ad.index.creativeunit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreativeUnitObject {

    private Long adId;
    private Long unitId;

    // key：adId-unitId
}
