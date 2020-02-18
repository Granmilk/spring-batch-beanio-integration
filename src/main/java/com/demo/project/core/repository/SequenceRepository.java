package com.demo.project.core.repository;

public interface SequenceRepository {
    Long getNextSequenceValue(String sequenceName);
}
