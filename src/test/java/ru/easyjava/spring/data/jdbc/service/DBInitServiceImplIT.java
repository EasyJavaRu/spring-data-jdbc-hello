package ru.easyjava.spring.data.jdbc.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@ContextConfiguration("/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DBInitServiceImplIT {
    @Inject
    private JdbcTemplate jdbcTemplate;

    @Inject
    private DBInitService testedObject;

    @Test
    @DirtiesContext
    public void testInitialize() {
        testedObject.initializeDatabase();

        jdbcTemplate.execute("SELECT GREETING FROM EXAMPLE");
    }
}