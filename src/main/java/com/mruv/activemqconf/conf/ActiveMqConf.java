package com.mruv.activemqconf.conf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jndi.ldap.pool.PooledConnectionFactory;
import javax.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
@EnableJms
public class ActiveMqConf {

    /* @Bean
    public ConnectionFactory connectionFactory() {

        PooledConnectionFactory pooledConnectionFactory
                = new PooledConnectionFactory(new ActiveMQConnectionFactory(
                        "vm://localhost?broker.persistent=false,useShutdownHook=false"));
        pooledConnectionFactory.setMaxConnections(100);
        pooledConnectionFactory.setIdleTimeout(30000);
        pooledConnectionFactory.setUseAnonymousProducers(true);
        pooledConnectionFactory.setTimeBetweenExpirationCheckMillis(-1);
        pooledConnectionFactory.setReconnectOnException(true);

        return pooledConnectionFactory;
    }*/
    @Bean
    public JmsListenerContainerFactory<?> containerFactory(ConnectionFactory connectionFactory,
            DefaultJmsListenerContainerFactoryConfigurer configurer) {

        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        return factory;
    }

    /*@Bean
    public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
        return new JmsTemplate(connectionFactory);
    }*/
    @Bean
    public MessageConverter jacksonJmsMessageConverter(ObjectMapper objectMapper) {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setObjectMapper(objectMapper);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
}
