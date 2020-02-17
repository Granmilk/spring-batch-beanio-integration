package com.demo.project.core.domain.datasource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "managerFactory",
        transactionManagerRef = "platformTransactionManager",
        basePackages = {"com.demo.project.core"})
public class DataSourceConfiguration {

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "application.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean managerFactory(EntityManagerFactoryBuilder builder,
                                                                 @Qualifier("dataSource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages("com.demo.project.core.domain.entity")
                .persistenceUnit("persistenceUnit")
                .build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager platformTransactionManager(
            @Qualifier("managerFactory") EntityManagerFactory managerFactory) {
        return new JpaTransactionManager(managerFactory);
    }

}
