package com.chair.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.chair.service.CustomerService;

@Controller
public class UserController {

    @Autowired
    private CustomerService customerService;
}
