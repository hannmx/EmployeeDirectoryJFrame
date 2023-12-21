package org.hannmx;

import java.util.ArrayList;

public class EmployeeDirectory {
    private ArrayList<Employee> employees;

    public EmployeeDirectory() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    public ArrayList<Employee> findEmployeesByExperience(int experience) {
        ArrayList<Employee> foundEmployees = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.getExperience() == experience) {
                foundEmployees.add(emp);
            }
        }
        return foundEmployees;
    }

    public String findPhoneNumberByName(String name) {
        for (Employee emp : employees) {
            if (emp.getName().equalsIgnoreCase(name)) {
                return emp.getPhoneNumber();
            }
        }
        return "Employee not found";
    }

    public Employee findEmployeeByEmployeeID(int employeeID) {
        for (Employee emp : employees) {
            if (emp.getEmployeeID() == employeeID) {
                return emp;
            }
        }
        return null; // Employee not found
    }
}
