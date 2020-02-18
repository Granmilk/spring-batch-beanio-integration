package com.demo.project.core.util;

public final class Constants {

    public static final String REGISTER_BEANIO_STREAM = "merchantFileFixedLength";

    private Constants() {
    }

    public static class MerchantRecordId {

        private MerchantRecordId() {
        }

        public static final String DATA_REGISTER_ID = "C";
        public static final String OWNER_REGISTER_ID = "P";
        public static final String ADDRESS_REGISTER_ID = "E";

    }

    public static class IdentificationSequenceName {

        private IdentificationSequenceName() {
        }

        public static final String MERCHANT = "SQ_MERCH";
    }
}
