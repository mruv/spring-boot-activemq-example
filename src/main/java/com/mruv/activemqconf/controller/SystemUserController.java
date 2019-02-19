package com.mruv.activemqconf.controller;

import com.mruv.activemqconf.domain.model.SystemUser;
import com.mruv.activemqconf.service.SystemUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class SystemUserController {
    
    @Autowired
    private SystemUserService suService;
    
    @PostMapping
    public void postForSystemUser(@RequestBody SystemUser user) {
        suService.postOne(user);
    }

    @GetMapping
    public List<SystemUser> getForSystemUserList() {
        return suService.getAll();
    }
}
