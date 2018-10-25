package com.mruv.activemqconf.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mruv.activemqconf.domain.model.SystemUser;
import com.mruv.activemqconf.service.SystemUserService;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// WEB TIER
//
// Clone this project then:
//   -> access the end points using postman
@RestController
@RequestMapping("/users")
public class SystemUserController {
    
    @Autowired
    private SystemUserService suService;

    // save a single system user
    // the post body should be a json object
    // ****************************************
    // {
    //   "FullName": "name value",
    //   "PhoneNumber": "254...",
    //   "NationalId": "12...",
    //   "EmailAddress": "mruv@kdkdkdkd.com"
    // }
    @PostMapping("/one")
    public void postOne(@RequestBody SystemUser user) {
        suService.postOne(user);
    }
    private static final Logger LOG = Logger.getLogger(SystemUserController.class.getName());

    // save many users
    // the post body should be a json array
    // ****************************************
    //
    // [
    //  {
    //   "FullName": "name value",
    //   "PhoneNumber": "254...",
    //   "NationalId": "12...",
    //   "EmailAddress": "mruv@kdkdkdkd.com"
    //  },
    //  ... many more
    // ]
    // 
    @PostMapping("/many")
    public void postMany(@RequestBody List<SystemUser> users) throws JsonProcessingException {
        suService.postMany(users);
    }
    
    // View
    @GetMapping
    public List<SystemUser> getAll() {
        return suService.getAll();
    }
}
