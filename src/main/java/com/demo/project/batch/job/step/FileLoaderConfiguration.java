package com.demo.project.batch.job.step;

import com.demo.project.core.domain.entity.MerchantEntity;
import com.demo.project.core.identification.merchant.IdentificationRecord;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class FileLoaderConfiguration {

    private final StepBuilderFactory stepBuilderFactory;

    public FileLoaderConfiguration(StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Step stepLoaderFile(@Value("${spring.batch.chunk.size}") Integer chunkSize,
                               ItemReader<IdentificationRecord> loadFileItemReader,
                               ItemProcessor<IdentificationRecord, MerchantEntity> loadFileItemProcessor,
                               ItemWriter<MerchantEntity> loadFileItemWriter,
                               PlatformTransactionManager platformTransactionManager) {
        return stepBuilderFactory
                .get("stepLoaderFile")
                .transactionManager(platformTransactionManager)
                .<IdentificationRecord, MerchantEntity>chunk(chunkSize)
                .reader(loadFileItemReader)
                .processor(loadFileItemProcessor)
                .writer(loadFileItemWriter)
                .build();
    }

}
