package com.gmail.bogatyr.alexander.resources;

import com.codahale.metrics.annotation.Timed;
import com.gmail.bogatyr.alexander.entity.Department;
import com.gmail.bogatyr.alexander.service.DepartmentService;
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
@Path(ApplicationUrl.DEPARTMENT_URL)
@Produces(MediaType.APPLICATION_JSON)
public class DepartmentResource {

    @Inject
    private DepartmentService departmentService;

    @GET
    @Timed
    @UnitOfWork(readOnly = true)
    public List<Department> findAll() {
        return departmentService.findAll();
    }
}
