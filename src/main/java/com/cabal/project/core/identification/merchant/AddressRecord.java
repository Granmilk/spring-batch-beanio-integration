package com.cabal.project.core.identification.merchant;

import com.cabal.project.core.util.Constants;
import org.beanio.annotation.Field;
import org.beanio.annotation.Record;

@Record
public class AddressRecord extends RegisterDataRecord {

    private String city;
    private String district;
    private String address;
    private String additional;
    private Integer number;
    private String cep;
    private Integer addressType;

    @Override
    @Field(length = 1, rid = true, literal = Constants.MerchantRecordId.ADDRESS_REGISTER_ID, required = true, ordinal = 1)
    public String getRecordId() {
        return recordId;
    }

    @Field(maxLength = 8, required = true, ordinal = 2)
    public String getMerchantId() {
        return merchantId;
    }

}
