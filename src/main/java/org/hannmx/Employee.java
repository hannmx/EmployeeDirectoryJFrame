package org.hannmx;

public class Employee {
    private int employeeID;
    private String phoneNumber;
    private String name;
    private int experience;

    public Employee(int employeeID, String phoneNumber, String name, int experience) {
        this.employeeID = employeeID;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.experience = experience;
    }

    // Геттеры и сеттеры для атрибутов сотрудника
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
