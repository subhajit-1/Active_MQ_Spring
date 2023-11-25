package com.abc.api.message;



import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMessageConsumer {

 @JmsListener(destination = "employee.queue")
 public void receiveMessage(EmployeeMessage message) {
     // Implement logic to handle the received message
     System.out.println("Received message: " + message.toString());

     // Example logic: You might want to perform some actions based on the message
     if ("CREATED".equals(message.getAction())) {
         System.out.println("Employee with ID " + message.getEmployeeId() + " created.");
         // Perform additional actions for employee creation
     } else if ("UPDATED".equals(message.getAction())) {
         System.out.println("Employee with ID " + message.getEmployeeId() + " updated.");
         // Perform additional actions for employee update
     } else if ("DELETED".equals(message.getAction())) {
         System.out.println("Employee with ID " + message.getEmployeeId() + " deleted.");
         // Perform additional actions for employee deletion
     } else {
         System.out.println("Unknown action: " + message.getAction());
     }
 }
}

