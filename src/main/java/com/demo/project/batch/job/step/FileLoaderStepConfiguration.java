package com.demo.project.batch.job.step;

import com.demo.project.core.domain.entity.MerchantEntity;
import com.demo.project.core.identification.merchant.IdentificationRecord;
import com.demo.project.core.util.Constants;
import org.beanio.StreamFactory;
import org.beanio.spring.BeanIOFlatFileItemReader;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableBatchProcessing
public class FileLoaderStepConfiguration extends DefaultBatchConfigurer {

    @Bean
    public ItemReader<IdentificationRecord> loadFileItemReader(@Qualifier("buildStreamFactory")
                                                                       StreamFactory streamFactory) throws Exception {
        BeanIOFlatFileItemReader<IdentificationRecord> beanIOFlatFileItemReader = new BeanIOFlatFileItemReader<>();
//        beanIOFlatFileItemReader.setResource();
        beanIOFlatFileItemReader.setStreamFactory(streamFactory);
        beanIOFlatFileItemReader.setStreamName(Constants.REGISTER_BEANIO_STREAM);
        beanIOFlatFileItemReader.afterPropertiesSet();

        return beanIOFlatFileItemReader;
    }

    @Bean
    public ItemWriter<MerchantEntity> loadFileItemWriter(EntityManagerFactory managerFactory) {
        return new JpaItemWriterBuilder<MerchantEntity>()
                .entityManagerFactory(managerFactory)
                .build();
    }

}
