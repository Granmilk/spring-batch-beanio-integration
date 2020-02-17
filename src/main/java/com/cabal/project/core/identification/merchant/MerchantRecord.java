package com.cabal.project.core.identification.merchant;

import com.cabal.project.core.util.Constants;
import org.beanio.annotation.Field;
import org.beanio.annotation.Record;
import org.hibernate.validator.constraints.br.CNPJ;

@Record
public class MerchantRecord extends RegisterDataRecord {

    private String tradeName;
    private String cnpj;
    private Integer typeDocument;
    private String date;
    private String schedule;

    @Override
    @Field(length = 1, rid = true, literal = Constants.MerchantRecordId.DATA_REGISTER_ID, required = true, ordinal = 1)
    public String getRecordId() {
        return recordId;
    }

    @Field(maxLength = 8, required = true, ordinal = 2)
    public String getMerchantId() {
        return merchantId;
    }

    @Field(maxLength = 30, required = true, ordinal = 3)
    public String getTradeName() {
        return tradeName;
    }

    @CNPJ
    @Field(length = 14, ordinal = 4)
    public String getCnpj() {
        return cnpj;
    }

    @Field(maxLength = 1, ordinal = 5)
    public Integer getTypeDocument() {
        return typeDocument;
    }

    @Field(maxLength = 8, format = "yyyyMMdd", ordinal = 6)
    public String getDate() {
        return date;
    }

    @Field(maxLength = 8, ordinal = 7)
    public String getSchedule() {
        return schedule;
    }

}
