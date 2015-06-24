package com.gmail.bogatyr.alexander.dao;

import com.gmail.bogatyr.alexander.entity.Employee;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * This class represents...
 */
public class EmployeeDao extends AbstractDAO<Employee> {

    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    @Inject
    public EmployeeDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Employee> findAll() {
        return list(criteria());
    }
}
