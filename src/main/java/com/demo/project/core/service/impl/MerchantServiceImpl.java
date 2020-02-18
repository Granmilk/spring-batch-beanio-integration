package com.demo.project.core.service.impl;

import com.demo.project.core.identification.merchant.IdentificationRecord;
import com.demo.project.core.identification.merchant.MerchantRecord;
import com.demo.project.core.mapper.IdentificationBuilder;
import com.demo.project.core.mapper.MerchantBuilder;
import com.demo.project.core.repository.MerchantRepository;
import com.demo.project.core.service.IdentificationService;
import com.demo.project.core.service.SequenceService;
import com.demo.project.core.util.Constants;
import org.springframework.stereotype.Service;

@Service(Constants.MerchantRecordId.DATA_REGISTER_ID)
public class MerchantServiceImpl extends IdentificationService {

    private final SequenceService sequenceService;
    private final MerchantRepository merchantRepository;
    private MerchantBuilder merchantBuilder;

    public MerchantServiceImpl(final SequenceService sequenceService,
                               final MerchantRepository merchantRepository) {
        this.sequenceService = sequenceService;
        this.merchantRepository = merchantRepository;
    }


    @Override
    public IdentificationBuilder getBuilder(IdentificationRecord record) {
        Long sequenceNumber = sequenceService.getNextValue(Constants.IdentificationSequenceName.MERCHANT);
        merchantBuilder = new MerchantBuilder((MerchantRecord) record, sequenceNumber);
        return merchantBuilder;
    }
}
