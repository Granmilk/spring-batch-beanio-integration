package com.demo.project.core.service.impl;

import com.demo.project.core.repository.SequenceRepository;
import com.demo.project.core.service.SequenceService;
import org.springframework.stereotype.Service;

@Service
public class SequenceServiceImpl implements SequenceService {

    private final SequenceRepository sequenceRepository;

    public SequenceServiceImpl(SequenceRepository sequenceRepository) {
        this.sequenceRepository = sequenceRepository;
    }

    @Override
    public Long getNextValue(String sequenceName) {
        return sequenceRepository.getNextSequenceValue(sequenceName);
    }
}
