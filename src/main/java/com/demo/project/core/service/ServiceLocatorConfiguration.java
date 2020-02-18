package com.demo.project.core.service;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceLocatorConfiguration {

    @Bean
    public ServiceLocatorFactoryBean locatorFactoryBean() {
        ServiceLocatorFactoryBean serviceLocatorFactoryBean = new ServiceLocatorFactoryBean();
        serviceLocatorFactoryBean.setServiceLocatorInterface(ServiceFactory.class);
        return serviceLocatorFactoryBean;
    }

}
