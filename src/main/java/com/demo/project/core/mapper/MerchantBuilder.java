package com.demo.project.core.mapper;

import com.demo.project.core.domain.entity.MerchantEntity;

public abstract class MerchantBuilder {

    MerchantBuilder() {
    }

    public abstract MerchantEntity build();

}
