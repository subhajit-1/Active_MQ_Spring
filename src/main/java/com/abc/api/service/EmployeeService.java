package com.abc.api.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.api.entity.Employee;
import com.abc.api.message.EmployeeMessage;
import com.abc.api.message.EmployeeMessageProducer;
import com.abc.api.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMessageProducer messageProducer;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee employee) {
        // Additional logic before saving the employee, if needed
        validateEmployee(employee);

        Employee createdEmployee = employeeRepository.save(employee);

        // Send message to ActiveMQ on employee creation
        EmployeeMessage message = new EmployeeMessage();
        message.setEmployeeId(createdEmployee.getId());
        message.setEmployeeName(createdEmployee.getName());
        message.setAction("CREATED");
        messageProducer.sendMessage(message);

        return createdEmployee;
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        // Additional logic before updating the employee, if needed
        validateEmployee(updatedEmployee);

        // Implement update logic
        Employee savedEmployee = employeeRepository.save(updatedEmployee);

        // Send message to ActiveMQ on employee update
        EmployeeMessage message = new EmployeeMessage();
        message.setEmployeeId(savedEmployee.getId());
        message.setAction("UPDATED");
        messageProducer.sendMessage(message);

        return savedEmployee;
    }

    public void deleteEmployee(Long id) {
        // Additional logic before deleting the employee, if needed

        employeeRepository.deleteById(id);

        // Send message to ActiveMQ on employee deletion
        EmployeeMessage message = new EmployeeMessage();
        message.setEmployeeId(id);
        message.setAction("DELETED");
        messageProducer.sendMessage(message);
    }

    private void validateEmployee(Employee employee) {
        // Implement validation logic, for example, check if the employee details are valid
        if ( employee.getName().isEmpty()) {
            throw new IllegalArgumentException("Employee name cannot be empty");
        }
        // Add more validation as needed
    }
}
