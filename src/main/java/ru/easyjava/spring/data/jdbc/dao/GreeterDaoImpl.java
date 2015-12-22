package ru.easyjava.spring.data.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * JDBC based implementation of GreeterDao.
 */
@Repository
public class GreeterDaoImpl implements GreeterDao {
    /**
     * Query that populates table with data.
     */
    private static final String DATA_QUERY =
            "INSERT INTO EXAMPLE VALUES(?, ?)";

    /**
     * Query that extracts data from table.
     */
    private static final String GREET_QUERY =
            "SELECT GREETING, TARGET FROM EXAMPLE";

    /**
     * Our data layer.
     */
    @Inject
    private JdbcTemplate jdbcTemplate;

    @Override
    public final void addGreet(final String greeting, final String target) {
        jdbcTemplate.update(DATA_QUERY, greeting, target);
    }

    @Override
    public final List<Map<String, Object>> getGreetings() {
        return jdbcTemplate.queryForList(GREET_QUERY);
    }
}
