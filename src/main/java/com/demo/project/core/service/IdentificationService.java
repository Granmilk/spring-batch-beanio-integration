package com.demo.project.core.service;

import com.demo.project.core.identification.merchant.IdentificationRecord;
import com.demo.project.core.mapper.IdentificationBuilder;

public abstract class IdentificationService {

    public abstract IdentificationBuilder getBuilder(IdentificationRecord record);
}
