package com.demo.project.core.repository.impl;

import com.demo.project.core.repository.SequenceRepository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class SequenceRepositoryImpl implements SequenceRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;


    public SequenceRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Long getNextSequenceValue(String sequenceName) {
        return jdbcTemplate.queryForObject("SELECT " + sequenceName + ".nextval from dual", new HashMap<>(), Long.class);
    }
}
