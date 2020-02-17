package com.demo.project.core.identification.merchant;

import lombok.ToString;

@ToString(callSuper = true)
public abstract class RegisterDataRecord extends IdentificationRecord {

    String merchantId;
}
