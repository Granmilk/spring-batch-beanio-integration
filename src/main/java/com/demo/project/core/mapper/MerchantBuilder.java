package com.demo.project.core.mapper;

import com.demo.project.core.domain.entity.MerchantEntity;
import com.demo.project.core.identification.merchant.MerchantRecord;

public class MerchantBuilder extends IdentificationBuilder {

    private final MerchantRecord merchantRecord;
    private final Long sequenceNumber;

    public MerchantBuilder(MerchantRecord merchantRecord, Long sequenceNumber) {
        this.merchantRecord = merchantRecord;
        this.sequenceNumber = sequenceNumber;
    }

    @Override
    public MerchantEntity build() {
        MerchantEntity.MerchantEntityBuilder builder = MerchantEntity.builder()
                .merchantSeq(sequenceNumber)
                .merchantId(merchantRecord.getMerchantId())
                .tradeName(merchantRecord.getTradeName())
                .document(merchantRecord.getCnpj())
                .documentType(merchantRecord.getTypeDocument())
                .registrationDate(merchantRecord.getDate())
                .registrationHour(merchantRecord.getSchedule());

        return builder.build();
    }
}
