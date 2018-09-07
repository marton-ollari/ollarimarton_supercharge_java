package com.codecool.supercharge.controller;

import com.codecool.supercharge.service.AccountService;
import com.codecool.supercharge.service.TransactionService;
import com.codecool.supercharge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SuperchargeController {
    @Autowired
    UserService userService;

    @Autowired
    AccountService accountService;

    @Autowired
    TransactionService transactionService;

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainpage(){
        return "Bank Controller 1.0 - See README";
    }
}
