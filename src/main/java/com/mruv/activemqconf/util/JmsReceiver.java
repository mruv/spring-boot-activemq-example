package com.mruv.activemqconf.util;
//
// This is where it all happens

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mruv.activemqconf.domain.model.SystemUser;
import com.mruv.activemqconf.domain.repository.SystemUserRepository;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

//
// Receive data from the service layer --> enqueue --> dequeue --> save to database
//
@Component
public class JmsReceiver {
    
    // global listener / distination / receiver / queue names
    public static final String MANY_USERS_RCV_Q = "ManyUsersQ";
    public static final String ONE_USER_RCV_Q = "OneUserQ";
    
    // Jpa repos
    @Autowired
    private SystemUserRepository repository;
    @Autowired
    private ObjectMapper mapper;
    
    // Time to receive!!!
    
    
    // watch out for this 'destination'
    @JmsListener(destination = JmsReceiver.MANY_USERS_RCV_Q)
    public void receiveMany(@Payload String users) throws IOException {
        
        // change message back to a Collection
        List<SystemUser> userList = mapper.readValue(
                users, mapper.getTypeFactory().constructCollectionType(List.class, SystemUser.class));
        // persist
        repository.saveAll(userList);
    }
    
    @JmsListener(destination = JmsReceiver.ONE_USER_RCV_Q)
    public void receiveOne(@Payload SystemUser user) {
        repository.save(user);
    }
    private static final Logger LOG = Logger.getLogger(JmsReceiver.class.getName());
}
