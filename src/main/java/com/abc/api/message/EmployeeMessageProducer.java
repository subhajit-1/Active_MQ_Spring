package com.abc.api.message;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMessageProducer {

    private final JmsTemplate jmsTemplate;

    public EmployeeMessageProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(EmployeeMessage message) {
        jmsTemplate.convertAndSend("employee.queue", message);
    }
}
