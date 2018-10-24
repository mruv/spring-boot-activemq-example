package com.mruv.activemqconf.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mruv.activemqconf.domain.model.SystemUser;
import com.mruv.activemqconf.domain.repository.SystemUserRepository;
import com.mruv.activemqconf.util.JmsReceiver;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class SystemUserService {

    // msg sender
    @Autowired
    private JmsTemplate msgSender;
    @Autowired
    private SystemUserRepository repository;
    @Autowired
    private ObjectMapper mapper;

    public void postOne(SystemUser user) {
        // enqueue
        msgSender.convertAndSend(JmsReceiver.ONE_USER_RCV_Q, user);
    }

    public void postMany(List<SystemUser> users) throws JsonProcessingException {
        // enqueue
        // convert Collection to json array before sending
        // helps avoid conversion exceptions 
        //  --> java.lang.ClassCastException: java.util.LinkedHashMap cannot be cast to com.mruv.activemqconf.domain.model.SystemUser
        msgSender.convertAndSend(JmsReceiver.MANY_USERS_RCV_Q, mapper.writeValueAsString(users));
    }

    public List<SystemUser> getAll() {
        return repository.findAll();
    }
}
