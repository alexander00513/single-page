package com.gmail.bogatyr.alexander.health;

import com.codahale.metrics.health.HealthCheck;
import com.google.inject.Inject;
import org.hibernate.SessionFactory;

/**
 * This class represents simple sessionFactory health check
 */
public class SessionFactoryHealthCheck extends HealthCheck {

    @Inject
    private SessionFactory sessionFactory;

    @Override
    protected Result check() throws Exception {
        if (sessionFactory != null) {
            return Result.healthy();
        }
        return Result.unhealthy("Session factory is not created");
    }
}
