package com.gmail.bogatyr.alexander.configuration.guice;

import com.gmail.bogatyr.alexander.dao.DepartmentDao;
import com.gmail.bogatyr.alexander.dao.EmployeeDao;
import com.gmail.bogatyr.alexander.service.DepartmentService;
import com.gmail.bogatyr.alexander.service.EmployeeService;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.ProvisionException;
import org.hibernate.SessionFactory;

/**
 * This class represents simple Guice IoC module
 */
public class GuiceModule extends AbstractModule {

    private SessionFactory sessionFactory;

    public GuiceModule(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    protected void configure() {
        bind(DepartmentDao.class).asEagerSingleton();
        bind(EmployeeDao.class).asEagerSingleton();
        bind(DepartmentService.class).asEagerSingleton();
        bind(EmployeeService.class).asEagerSingleton();
    }

    @Provides
    public SessionFactory providesSessionFactory() {
        if (sessionFactory == null) {
            throw new ProvisionException("The Hibernate session factory has not yet been set");
        }
        return sessionFactory;
    }
}
