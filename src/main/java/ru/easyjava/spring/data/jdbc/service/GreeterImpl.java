package ru.easyjava.spring.data.jdbc.service;

import org.springframework.stereotype.Service;
import ru.easyjava.spring.data.jdbc.dao.GreeterDao;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Simple greeter implementation.
 */
@Service
public class GreeterImpl implements Greeter {
    /**
     * Our data layer.
     */
    @Inject
    private GreeterDao dao;

    @Override
    public final String greet() {
        List<Map<String, Object>>  greets = dao.getGreetings();
        Iterator<Map<String, Object>> it = greets.iterator();
        if (!it.hasNext()) {
            return "No greets";
        }
        Map<String, Object> row = it.next();
        return row.get("GREETING") + ", " + row.get("TARGET");
    }
}
