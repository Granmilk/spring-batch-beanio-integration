package com.demo.project.core.mapper;

import com.demo.project.core.domain.entity.MerchantEntity;
import com.demo.project.core.identification.merchant.MerchantRecord;

public class MerchantBuilder extends IdentificationBuilder {

    private final MerchantRecord merchantRecord;

    public MerchantBuilder(MerchantRecord merchantRecord) {
        this.merchantRecord = merchantRecord;
    }

    @Override
    public MerchantEntity build() {
        MerchantEntity.MerchantEntityBuilder builder = MerchantEntity.builder()
                .merchantId(merchantRecord.getMerchantId())
                .tradeName(merchantRecord.getTradeName())
                .document(merchantRecord.getCnpj())
                .documentType(merchantRecord.getTypeDocument())
                .registrationDate(merchantRecord.getDate())
                .registrationHour(merchantRecord.getSchedule());

        return builder.build();
    }
}
