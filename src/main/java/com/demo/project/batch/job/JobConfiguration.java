package com.demo.project.batch.job;

import com.demo.project.core.domain.entity.MerchantEntity;
import com.demo.project.core.identification.merchant.IdentificationRecord;
import com.demo.project.core.service.ServiceFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class JobConfiguration {

    private final JobBuilderFactory jobBuilderFactory;

    public JobConfiguration(JobBuilderFactory jobBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
    }

    @Bean
    public Job jobFileLoader(@Qualifier("stepLoaderFile") Step stepLoaderFile) {
        return jobBuilderFactory
                .get("jobFileLoader")
                .start(stepLoaderFile)
                .build();
    }

    @Bean
    @JobScope
    public ItemProcessor<IdentificationRecord, MerchantEntity> loadFileItemProcessor(final ServiceFactory factory) {
        return item -> factory.getService(item.getRecordId()).getBuilder(item).build();
    }

}
