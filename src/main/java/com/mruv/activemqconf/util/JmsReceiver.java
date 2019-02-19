package com.mruv.activemqconf.util;

import com.mruv.activemqconf.domain.model.SystemUser;
import com.mruv.activemqconf.domain.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class JmsReceiver {

    public static final String Q_ONE = "Q_One";

    @Autowired
    private SystemUserRepository repository;

    @JmsListener(destination = JmsReceiver.Q_ONE)
    public void receive(@Payload SystemUser user) {
        repository.save(user);
    }
}
