package com.cabal.project.core.identification.merchant;

import lombok.ToString;

@ToString
public abstract class RegisterDataRecord {

    protected String recordId;
    protected String merchantId;

    public abstract String getRecordId();
    public abstract String getMerchantId();

}
