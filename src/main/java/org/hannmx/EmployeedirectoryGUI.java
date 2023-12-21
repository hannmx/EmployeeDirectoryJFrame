package org.hannmx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EmployeedirectoryGUI extends JFrame {
    private EmployeeDirectory directory;

    public EmployeedirectoryGUI() {
        directory = new EmployeeDirectory();

        // Добавление нескольких тестовых сотрудников
        directory.addEmployee(new Employee(1, "1234567890", "John Doe", 5));
        directory.addEmployee(new Employee(2, "0987654321", "Jane Smith", 3));
        directory.addEmployee(new Employee(3, "1112223334", "Alice Johnson", 7));

        setTitle("Employee Directory");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton searchByExperienceBtn = new JButton("Search by Experience");
        JButton searchPhoneNumberByNameBtn = new JButton("Search Phone Number by Name");
        JButton searchByEmployeeIDBtn = new JButton("Search by Employee ID");

        JTextField inputField = new JTextField(15);
        JTextArea resultArea = new JTextArea(10, 30);

        searchByExperienceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int experience = Integer.parseInt(inputField.getText());
                ArrayList<Employee> employees = directory.findEmployeesByExperience(experience);
                displayResults(resultArea, employees);
            }
        });

        searchPhoneNumberByNameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = inputField.getText();
                String phoneNumber = directory.findPhoneNumberByName(name);
                resultArea.setText(phoneNumber);
            }
        });

        searchByEmployeeIDBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int employeeID = Integer.parseInt(inputField.getText());
                Employee emp = directory.findEmployeeByEmployeeID(employeeID);
                if (emp != null) {
                    resultArea.setText(emp.getName() + "'s phone number is: " + emp.getPhoneNumber());
                } else {
                    resultArea.setText("Employee not found");
                }
            }
        });

        panel.add(new JLabel("Enter value:"));
        panel.add(inputField);
        panel.add(searchByExperienceBtn);
        panel.add(searchPhoneNumberByNameBtn);
        panel.add(searchByEmployeeIDBtn);
        panel.add(resultArea);

        add(panel);
        setVisible(true);
    }

    private void displayResults(JTextArea resultArea, ArrayList<Employee> employees) {
        StringBuilder sb = new StringBuilder();
        if (employees.isEmpty()) {
            sb.append("No employees found with this experience.");
        } else {
            sb.append("Employees with this experience:\n");
            for (Employee emp : employees) {
                sb.append("Name: ").append(emp.getName()).append(", ID: ").append(emp.getEmployeeID()).append("\n");
            }
        }
        resultArea.setText(sb.toString());
    }
}
