package com.demo.project.core.mapper;

import com.demo.project.core.domain.entity.MerchantEntity;

public abstract class IdentificationBuilder {

    IdentificationBuilder() {
    }

    public abstract MerchantEntity build();

}
