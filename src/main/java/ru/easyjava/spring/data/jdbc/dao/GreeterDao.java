package ru.easyjava.spring.data.jdbc.dao;

import java.util.List;
import java.util.Map;

/**
 * Database layer.
 */
public interface GreeterDao {
    /**
     * Adds some greet to the database.
     * @param greeting Greeting text.
     * @param target greeting consumer.
     */
    void addGreet(String greeting, String target);

    /**
     * Returns all greetings.
     * @return List with all greetings in the database.
     */
    List<Map<String, Object>> getGreetings();
}
