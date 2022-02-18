package ua.com.alevel.dao.impl;

import ua.com.alevel.dao.EmployeeDao;
import ua.com.alevel.db.EmployeeDB;
import ua.com.alevel.db.impl.EmployeeDBImpl;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.db.CustomList;

import java.util.Optional;


public class EmployeeDaoImpl implements EmployeeDao {

    private static EmployeeDaoImpl instance;
    private EmployeeDB employeeDB;

    public static EmployeeDaoImpl getInstance() {
        if (instance == null) {
            instance = new EmployeeDaoImpl();
        }
        return instance;
    }

    private EmployeeDaoImpl() {
        employeeDB = EmployeeDBImpl.getInstance();
    }

    @Override
    public void create(Employee employee) {
        employeeDB.create(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeDB.update(employee);
    }

    @Override
    public void delete(String id) {
        employeeDB.delete(id);
    }

    @Override
    public Optional<Employee> findById(String id) {
        return Optional.ofNullable(employeeDB.findById(id));
    }

    @Override
    public CustomList<Employee> findAll() {
        return employeeDB.findAll();
    }
}
