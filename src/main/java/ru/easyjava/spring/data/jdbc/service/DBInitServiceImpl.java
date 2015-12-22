package ru.easyjava.spring.data.jdbc.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Database preparation service implementation.
 */
@Service
public class DBInitServiceImpl implements DBInitService {
    /**
     * Query that create table.
     */
    private static final String CREATE_QUERY =
            "CREATE TABLE EXAMPLE (GREETING VARCHAR(6), TARGET VARCHAR(6))";

    /**
     * Our data layer.
     */
    @Inject
    private JdbcTemplate jdbcTemplate;

    @Override
    public final void initializeDatabase() {
        jdbcTemplate.execute(CREATE_QUERY);
    }
}
