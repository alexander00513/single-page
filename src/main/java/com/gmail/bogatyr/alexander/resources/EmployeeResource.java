package com.gmail.bogatyr.alexander.resources;

import com.codahale.metrics.annotation.Timed;
import com.gmail.bogatyr.alexander.entity.Employee;
import com.gmail.bogatyr.alexander.service.EmployeeService;
import com.gmail.bogatyr.alexander.utils.ApplicationUrl;
import com.google.inject.Inject;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * This class represents...
 */
@Path(ApplicationUrl.EMPLOYEE_URL)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    @Inject
    private EmployeeService employeeService;

    @GET
    @Timed
    @UnitOfWork(readOnly = true)
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
}
