package ru.easyjava.spring.data.jdbc.service;

/**
 * Database preparation service.
 */
public interface DBInitService {
    /**
     * Creates tables in the database.
     */
    void initializeDatabase();
}
