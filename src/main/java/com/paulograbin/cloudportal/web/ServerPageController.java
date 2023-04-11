package com.paulograbin.cloudportal.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/server/{subscriptionCode}/{serverCode}")
public class ServerPageController {

    private static final Logger LOG = LoggerFactory.getLogger(ServerPageController.class);


    @GetMapping
    public String go() {

        return "server.html";
    }
}
