package com.gmail.bogatyr.alexander.service;

import com.gmail.bogatyr.alexander.dao.DepartmentDao;
import com.gmail.bogatyr.alexander.entity.Department;
import com.google.inject.Inject;

import java.util.List;

/**
 * This class represents class with business logic for Department entity
 */
public class DepartmentService {

    @Inject
    private DepartmentDao departmentDao;

    public List<Department> findAll() {
        return departmentDao.findAll();
    }
}
