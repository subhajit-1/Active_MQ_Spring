package com.abc.api.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import jakarta.jms.ConnectionFactory;

@Configuration
@EnableJms
public class ActiveMQConfig {

 @Bean
 public ConnectionFactory connectionFactory() {
     return new ActiveMQConnectionFactory();
 }

 @Bean
 public JmsTemplate jmsTemplate() {
     return new JmsTemplate(connectionFactory());
 }

 @Bean
 public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
     DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
     factory.setConnectionFactory(connectionFactory());
     return factory;
 }
}

