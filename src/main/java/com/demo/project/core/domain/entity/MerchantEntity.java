package com.demo.project.core.domain.entity;

import com.demo.project.core.util.Constants;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@SuperBuilder
@Table(name = "MERCHANT")
@SequenceGenerator(name = "merchantSeq",
        sequenceName = Constants.IdentificationSequenceName.MERCHANT,
        allocationSize = 1)
public class MerchantEntity implements Serializable {

    @Id
    @Setter
    @Column(name = "CD_SEQ_MERCHANT")
    private Long merchantSeq;

    @Column(name = "CD_MERCHANT")
    protected String merchantId;

    @Column(name = "NM_TRADE_NAME")
    protected String tradeName;

    @Size(min = 11, max = 14)
    @Column(name = "NU_DOCUMENT")
    protected String document;

    @Column(name = "CD_DOCUMENT_TYPE")
    protected Integer documentType;

    @Column(name = "DT_REGISTRATION")
    protected String registrationDate;

    @Column(name = "HR_REGISTRATION")
    protected String registrationHour;

    @Size(max = 50)
    @Column(name = "NM_CONTACT_FULL_NAME")
    protected String contactName;

    @Size(min = 11, max = 14)
    @Column(name = "NU_CONTACT_DOCUMENT")
    protected String contactDocument;

    @Column(name = "CD_CONTACT_DOCUMENT_TYPE")
    protected Integer contactDocumentType;

    @Column(name = "CD_CONTACT_TYPE")
    protected Integer contactType;

    @Size(max = 250)
    @Column(name = "DS_ADDRESS")
    protected String address;

    @Column(name = "CD_ZIP_CODE")
    protected Integer zipCode;

    @Column(name = "CD_CITY_TYPE")
    protected Integer cityType;

}
