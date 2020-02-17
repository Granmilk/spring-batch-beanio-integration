package com.demo.project.core.service;

import com.demo.project.core.identification.merchant.IdentificationRecord;
import com.demo.project.core.mapper.MerchantBuilder;

public abstract class MerchantService {

    public abstract MerchantBuilder getBuilder(IdentificationRecord record);
}
