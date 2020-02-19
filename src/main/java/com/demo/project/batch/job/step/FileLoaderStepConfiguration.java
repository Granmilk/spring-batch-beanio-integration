package com.demo.project.batch.job.step;

import com.demo.project.core.domain.entity.MerchantEntity;
import com.demo.project.core.identification.merchant.IdentificationRecord;
import com.demo.project.core.util.Constants;
import org.beanio.StreamFactory;
import org.beanio.spring.BeanIOFlatFileItemReader;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import javax.persistence.EntityManagerFactory;

@Configuration
public class FileLoaderStepConfiguration {

    @Bean
    public ItemReader<IdentificationRecord> loadFileItemReader(@Qualifier("buildStreamFactory")
                                                                       StreamFactory streamFactory) throws Exception {
        BeanIOFlatFileItemReader<IdentificationRecord> beanIOFlatFileItemReader = new BeanIOFlatFileItemReader<>();
        beanIOFlatFileItemReader.setResource(new FileSystemResource("src/test/resources/file/input.txt"));
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
