package com.demo.project.core.identification.merchant;

import lombok.ToString;

@ToString
public abstract class IdentificationRecord {

    protected String recordId;

    public abstract String getRecordId();
}
