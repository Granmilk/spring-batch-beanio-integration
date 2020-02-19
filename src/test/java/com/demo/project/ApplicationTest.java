package com.demo.project;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
@SpringBatchTest
public class ApplicationTest {

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private JobLauncherTestUtils jobLauncherTestUtils;

    private JdbcTemplate jdbcTemplate;

    @Test
    public void testJob() throws Exception {
        jdbcTemplate.execute("SELECT 1");
        JobExecution jobExecution = jobLauncherTestUtils.launchJob();
        Assert.assertEquals("COMPLETED", jobExecution.getExitStatus().getExitCode());
    }

}
