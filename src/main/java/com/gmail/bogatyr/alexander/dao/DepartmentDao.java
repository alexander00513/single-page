package com.gmail.bogatyr.alexander.dao;

import com.gmail.bogatyr.alexander.entity.Department;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * This class represents...
 */
public class DepartmentDao extends AbstractDAO<Department> {

    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    @Inject
    public DepartmentDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Department> findAll() {
        return list(criteria());
    }
}
