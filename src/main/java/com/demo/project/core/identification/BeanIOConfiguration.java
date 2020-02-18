package com.demo.project.core.identification;

import com.demo.project.core.identification.merchant.MerchantRecord;
import com.demo.project.core.util.Constants;
import org.beanio.StreamFactory;
import org.beanio.builder.FixedLengthParserBuilder;
import org.beanio.builder.StreamBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanIOConfiguration {

    @Bean
    public StreamFactory buildStreamFactory() {

        final String DELIMITED_FORMAT = "fixedlength";

        StreamFactory streamFactory = StreamFactory.newInstance();

        StreamBuilder streamBuilderFixedLength = new StreamBuilder(Constants.REGISTER_BEANIO_STREAM)
                .format(DELIMITED_FORMAT)
                .ignoreUnidentifiedRecords()
                .parser(new FixedLengthParserBuilder())
                .addRecord(MerchantRecord.class);

        streamFactory.define(streamBuilderFixedLength);

        return streamFactory;
    }

}
