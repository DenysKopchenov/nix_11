package ua.com.alevel.db.impl;

import ua.com.alevel.db.EmployeeDB;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.db.CustomList;

import java.util.UUID;

public class EmployeeDBImpl implements EmployeeDB {
    private static EmployeeDBImpl instance;
    CustomList<Employee> employees;

    private EmployeeDBImpl() {
        employees = new CustomList<>();
    }

    public static EmployeeDBImpl getInstance(){
        if (instance == null){
            instance = new EmployeeDBImpl();
        }
        return instance;
    }


    @Override
    public void create(Employee employee) {
        employee.setId(generateId());
        employees.add(employee);
    }

    @Override
    public void update(Employee employee) {
        Employee current = findById(employee.getId());
        current.setFirstName(employee.getFirstName());
        current.setLastName(employee.getLastName());
    }

    @Override
    public void delete(String id) {
        employees.remove(findById(id));
    }

    @Override
    public Employee findById(String id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(id)) {
                return employees.get(i);
            }
        }
        return null;
    }

    @Override
    public CustomList<Employee> findAll() {
        return employees;
    }

    private String generateId() {
        String generatedId = UUID.randomUUID().toString();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(generatedId)) {
                generateId();
            }
        }
        return generatedId;
    }

}
