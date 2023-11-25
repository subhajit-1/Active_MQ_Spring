package com.abc.api.message;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMessageConsumer {

 @JmsListener(destination = "employee.queue")
 public void receiveMessage(EmployeeMessage message) {
     // Implement logic to handle the received message
     System.out.println("Received message: " + message.toString());

     // For example, you can perform some actions based on the message
     if ("CREATED".equals(message.getAction())) {
         System.out.println("Employee created. ID: " + message.getEmployeeId());
         // Add additional logic as needed
     } else if ("UPDATED".equals(message.getAction())) {
         System.out.println("Employee updated. ID: " + message.getEmployeeId());
         // Add additional logic as needed
     } else if ("DELETED".equals(message.getAction())) {
         System.out.println("Employee deleted. ID: " + message.getEmployeeId());
         // Add additional logic as needed
     }
 }
}
