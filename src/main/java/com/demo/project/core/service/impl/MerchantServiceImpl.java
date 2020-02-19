package com.demo.project.core.service.impl;

import com.demo.project.core.identification.merchant.IdentificationRecord;
import com.demo.project.core.identification.merchant.MerchantRecord;
import com.demo.project.core.mapper.IdentificationBuilder;
import com.demo.project.core.mapper.MerchantBuilder;
import com.demo.project.core.domain.repository.MerchantRepository;
import com.demo.project.core.service.IdentificationService;
import com.demo.project.core.util.Constants;
import org.springframework.stereotype.Service;

@Service(Constants.MerchantRecordId.DATA_REGISTER_ID)
public class MerchantServiceImpl extends IdentificationService {
    private final MerchantRepository merchantRepository;
    private MerchantBuilder merchantBuilder;

    public MerchantServiceImpl(final MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }


    @Override
    public IdentificationBuilder getBuilder(IdentificationRecord record) {
        merchantBuilder = new MerchantBuilder((MerchantRecord) record);
        return merchantBuilder;
    }
}
