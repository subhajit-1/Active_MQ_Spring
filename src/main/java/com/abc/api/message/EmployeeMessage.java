package com.abc.api.message;

import java.io.Serializable;

import jakarta.jms.Message;
import jakarta.jms.ObjectMessage;

public class EmployeeMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long employeeId;
    private String action;

    // Constructors, getters, and setters

    public EmployeeMessage() {
    }

    public EmployeeMessage(Long employeeId, String action) {
        this.employeeId = employeeId;
        this.action = action;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "EmployeeMessage{" +
                "employeeId=" + employeeId +
                ", action='" + action + '\'' +
                '}';
    }

    public void receiveMessage(Message message) {
        try {
            if (message instanceof ObjectMessage) {
                ObjectMessage objectMessage = (ObjectMessage) message;
                Serializable object = objectMessage.getObject();

                if (object instanceof EmployeeMessage) {
                    EmployeeMessage employeeMessage = (EmployeeMessage) object;
                    // Process the message as needed
                    System.out.println("Received Employee Message: " + employeeMessage.toString());
                } else {
                    // Handle unexpected message type
                    System.err.println("Received unexpected message type");
                }
            } else {
                // Handle unexpected message type
                System.err.println("Received unexpected message type");
            }
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }
}
