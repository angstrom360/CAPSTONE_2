package com.trilogyed.AdminAPI.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RefreshScope
public class SecureAppController {

    @RequestMapping(value = "/loggedin", method = RequestMethod.GET)
    public String loggedIn(Principal principal) {
        return "Hello " + principal.getName() + "! Looks like you're logged in!";
    }

    @RequestMapping(value = "/allDone", method = RequestMethod.GET)
    public String allDone() {
        return "That's All Folks!";
    }
}