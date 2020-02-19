package com.demo.project.core.service;

public interface ServiceFactory {

    IdentificationService getService(String registerId);
}
