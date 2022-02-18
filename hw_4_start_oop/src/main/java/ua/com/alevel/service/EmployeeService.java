package ua.com.alevel.service;

import ua.com.alevel.dao.EmployeeDao;
import ua.com.alevel.dao.impl.EmployeeDaoImpl;
import ua.com.alevel.db.CustomList;
import ua.com.alevel.entity.Employee;

import java.util.Optional;

public class EmployeeService implements BaseService<Employee>{
    private static EmployeeService instance;
    private EmployeeDao employeeDao;

    private EmployeeService(){
        employeeDao = EmployeeDaoImpl.getInstance();
    }

    public static EmployeeService getInstance(){
        if (instance == null){
            instance = new EmployeeService();
        }
        return instance;
    }

    @Override
    public void create(Employee employee) {
            employeeDao.create(employee);
    }

    @Override
    public void update(Employee employee) throws Exception {
        Optional<Employee> optionalEmployee = employeeDao.findById(employee.getId());
        if (optionalEmployee.isPresent()) {
            employeeDao.update(employee);
        } else {
            throw new Exception("Employee does not exist");
        }
    }

    @Override
    public void delete(String id) throws Exception {
        Optional<Employee> optionalEmployee = employeeDao.findById(id);
        if (optionalEmployee.isPresent()) {
            employeeDao.delete(id);
        } else {
            throw new Exception(id + " does not exist");
        }
    }

    @Override
    public Employee findById(String id) throws Exception {
        Optional<Employee> employeeOptional = employeeDao.findById(id);
        if (employeeOptional.isPresent()){
            return employeeOptional.get();
        } else {
            throw new Exception(id + " does not exist");
        }
    }

    @Override
    public CustomList<Employee> findAll() {
        return employeeDao.findAll();
    }
}
