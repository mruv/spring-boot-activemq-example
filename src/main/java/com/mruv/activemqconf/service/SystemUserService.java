package com.mruv.activemqconf.service;

import com.mruv.activemqconf.domain.model.SystemUser;
import com.mruv.activemqconf.domain.repository.SystemUserRepository;
import com.mruv.activemqconf.util.JmsReceiver;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class SystemUserService {

    @Autowired
    private JmsTemplate msgSender;
    @Autowired
    private SystemUserRepository repository;

    public void postOne(SystemUser user) {
        msgSender.convertAndSend(JmsReceiver.Q_ONE, user);
    }

    public List<SystemUser> getAll() {
        return repository.findAll();
    }
}
