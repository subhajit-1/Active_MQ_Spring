package com.abc.api.message;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMessageConsumer {

 @JmsListener(destination = "employee.queue")
 public void receiveMessage(String message){
     // Implement logic to handle the received message


     message = message.replaceFirst("EmployeeMessage ","");
     System.out.println("Received message: " + message.toString());

     ObjectMapper objectMapper = new ObjectMapper();
     EmployeeMessage employeeMessage = new EmployeeMessage();

     try {
         employeeMessage = objectMapper.readValue(message, EmployeeMessage.class);
     } catch (JsonProcessingException e) {
         throw new RuntimeException(e);
     }


     // For example, you can perform some actions based on the message
     if ("CREATED".equals(employeeMessage.getAction())) {
         System.out.println("Employee created. ID: " + employeeMessage.getEmployeeId());
         // Add additional logic as needed
     } else if ("UPDATED".equals(employeeMessage.getAction())) {
         System.out.println("Employee updated. ID: " + employeeMessage.getEmployeeId());
         // Add additional logic as needed
     } else if ("DELETED".equals(employeeMessage.getAction())) {
         System.out.println("Employee deleted. ID: " + employeeMessage.getEmployeeId());
         // Add additional logic as needed
     }
 }
}
