package com.cabal.project.core.identification.merchant;

import com.cabal.project.core.util.Constants;
import org.beanio.annotation.Field;
import org.beanio.annotation.Record;
import org.beanio.builder.Align;
import org.hibernate.validator.constraints.br.CPF;

@Record
public class OwnerRecord extends RegisterDataRecord {

    private String name;
    private String cpf;
    private Integer typeDocument;
    private Integer typeOwner;

    @Override
    @Field(length = 1, rid = true, literal = Constants.MerchantRecordId.OWNER_REGISTER_ID, required = true, ordinal = 1)
    public String getRecordId() {
        return recordId;
    }

    @Field(maxLength = 8, required = true, ordinal = 2)
    public String getMerchantId() {
        return merchantId;
    }

    @Field(maxLength = 50, required = true, ordinal = 3)
    public String getName() {
        return name;
    }

    @CPF
    @Field(length = 11, padding = '0', align = Align.LEFT, ordinal = 4)
    public String getCpf() {
        return cpf;
    }

    @Field(maxLength = 1, ordinal = 5)
    public Integer getTypeDocument() {
        return typeDocument;
    }

    @Field(maxLength = 1, ordinal = 6)
    public Integer getTypeOwner() {
        return typeOwner;
    }

}
