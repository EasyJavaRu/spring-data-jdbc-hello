package ru.easyjava.spring.data.jdbc.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.easyjava.spring.data.jdbc.service.DBInitService;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@ContextConfiguration("/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class GreeterDaoImplIT {
    @Inject
    private JdbcTemplate jdbcTemplate;

    @Inject
    private GreeterDao testedObject;

    @Inject
    private DBInitService dbInitService;

    @DirtiesContext
    @Test
    public void testRetrieve() {
        dbInitService.initializeDatabase();

        testedObject.addGreet("TEST", "TEST");

        List<Map<String, Object>> actual = testedObject.getGreetings();
        Iterator<Map<String,Object>> it = actual.iterator();
        Map<String, Object> row =it.next();
        assertThat(row.get("GREETING"), is("TEST"));
        assertThat(row.get("TARGET"), is("TEST"));
    }

}