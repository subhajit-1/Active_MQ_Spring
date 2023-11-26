package com.abc.api.message;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class EmployeeMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long employeeId;
    private String employeeName;
    private String action;

    public EmployeeMessage() {
        // Default constructor for serialization
    }


    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "{" +
                "\"employeeId\": " + employeeId + ", " +
                "\"employeeName\": \"" + employeeName + "\", " +
                "\"action\": \"" + action + "\"" +
                "}";
    }
}
