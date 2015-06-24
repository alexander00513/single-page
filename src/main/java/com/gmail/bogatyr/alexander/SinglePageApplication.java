package com.gmail.bogatyr.alexander;

import com.gmail.bogatyr.alexander.configuration.SinglePageConfiguration;
import com.gmail.bogatyr.alexander.configuration.guice.GuiceModule;
import com.gmail.bogatyr.alexander.entity.Department;
import com.gmail.bogatyr.alexander.entity.Employee;
import com.gmail.bogatyr.alexander.health.SessionFactoryHealthCheck;
import com.gmail.bogatyr.alexander.resources.DepartmentResource;
import com.gmail.bogatyr.alexander.resources.EmployeeResource;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * This class represents main application class for initialization and launch application
 */
public class SinglePageApplication extends Application<SinglePageConfiguration> {

    private final HibernateBundle<SinglePageConfiguration> hibernateBundle = new HibernateBundle<SinglePageConfiguration>(Department.class, Employee.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(SinglePageConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    @Override
    public void run(SinglePageConfiguration configuration, Environment environment) throws Exception {
        GuiceModule guiceModule = new GuiceModule(hibernateBundle.getSessionFactory());
        Injector injector = Guice.createInjector(guiceModule);
        environment.healthChecks().register("sessionFactory", injector.getInstance(SessionFactoryHealthCheck.class));
        environment.jersey().register(injector.getInstance(DepartmentResource.class));
        environment.jersey().register(injector.getInstance(EmployeeResource.class));
    }

    @Override
    public void initialize(Bootstrap<SinglePageConfiguration> bootstrap) {
        //configuration Hibernate
        bootstrap.addBundle(hibernateBundle);
        //configuration Liquibase
        bootstrap.addBundle(new MigrationsBundle<SinglePageConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(SinglePageConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
        //configuration static resources
        bootstrap.addBundle(new AssetsBundle("/assets", "/app"));
    }

    @Override
    public String getName() {
        return "single-page";
    }

    public static void main(String[] args) throws Exception {
        new SinglePageApplication().run(args);
    }
}
