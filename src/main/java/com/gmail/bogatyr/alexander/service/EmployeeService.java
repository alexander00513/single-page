package com.gmail.bogatyr.alexander.service;

import com.gmail.bogatyr.alexander.dao.EmployeeDao;
import com.gmail.bogatyr.alexander.entity.Employee;
import com.google.inject.Inject;

import java.util.List;

/**
 * This class represents class with business logic for Employee entity
 */
public class EmployeeService {

    @Inject
    private EmployeeDao employeeDao;

    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
}
