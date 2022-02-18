package ua.com.alevel.controller;

import ua.com.alevel.entity.Employee;
import ua.com.alevel.service.EmployeeService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    private static final EmployeeService employeeService = EmployeeService.getInstance();

    public static void run() {
        System.out.println("Welcome to employee CRUD");
        showMenu();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input;
            while (true) {
                input = reader.readLine();
                switch (input) {
                    case "1" -> create(reader);
                    case "2" -> update(reader);
                    case "3" -> delete(reader);
                    case "4" -> findById(reader);
                    case "5" -> findAll();
                    case "exit" -> System.exit(0);
                }
            }
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    private static void showMenu() {
        System.out.println("if you want create employee, please enter 1");
        System.out.println("if you want update employee, please enter 2");
        System.out.println("if you want delete employee, please enter 3");
        System.out.println("if you want find employee by id, please enter 4");
        System.out.println("if you want find all employees, please enter 5");
        System.out.println("if you want exit, please enter 'exit'");

    }

    private static void create(BufferedReader reader) throws IOException {
        System.out.println("Create employee");
        System.out.println("Enter first name");
        String firstName = nameInput(reader);
        System.out.println("Enter last name");
        String lastName = nameInput(reader);

        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employeeService.create(employee);

        System.out.println("Employee created");
        showMenu();
    }

    private static void update(BufferedReader reader) throws IOException {
        System.out.println("Update employee");
        System.out.println("Enter employee id");
        String id = reader.readLine();
        System.out.println("Enter first name");
        String firstName = nameInput(reader);
        System.out.println("Enter last name");
        String lastName = nameInput(reader);

        Employee employee = new Employee();
        employee.setId(id);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        try {
            employeeService.update(employee);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            showMenu();
        }
    }

    private static void delete(BufferedReader reader) throws IOException {
        System.out.println("Delete employee");
        System.out.println("Enter employee id");
        String id = reader.readLine();
        try {
            employeeService.delete(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            showMenu();
        }
    }

    private static void findById(BufferedReader reader) throws IOException {
        System.out.println("Find employee by id");
        System.out.println("Enter employee id");
        String id = reader.readLine();
        try {
            System.out.println(employeeService.findById(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            showMenu();
        }
    }

    private static void findAll() {
        System.out.println("All employees");
        System.out.println(employeeService.findAll());
        showMenu();
    }

    private static String nameInput(BufferedReader reader) throws IOException {
        String input = reader.readLine();
        if (!input.matches("[A-ZА-Я][a-zа-я]+")) {
            System.out.println("Start with uppercase letter, may contains only letters");
            input = nameInput(reader);
        }
        return input;
    }

}
