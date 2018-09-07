package com.codecool.supercharge.controller;

import com.codecool.supercharge.model.Account;
import com.codecool.supercharge.model.Transaction;
import com.codecool.supercharge.model.User;
import com.codecool.supercharge.service.AccountService;
import com.codecool.supercharge.service.TransactionService;
import com.codecool.supercharge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

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
    public String mainPage(){
        return "Bank Controller 1.0 - See README";
    }

    @ResponseBody
    @RequestMapping(value = "/{userid}/deposit/{amount}/{event}", method = RequestMethod.GET)
    public String deposit(@PathVariable("userid") Integer userid, @PathVariable("amount") Integer amount, @PathVariable("event") String event){
        return changeBalance(userid, amount, event);
    }

    @ResponseBody
    @RequestMapping(value = "/{userid}/withdraw/{amount}/{event}", method = RequestMethod.GET)
    public String withdraw(@PathVariable("userid") Integer userid, @PathVariable("amount") Integer amount, @PathVariable("event") String event){
        return changeBalance(userid, -amount, event);
    }

    @ResponseBody
    @RequestMapping(value = "/{userid}/transfer/{amount}/{event}/{accountid}", method = RequestMethod.GET)
    public String transfer(@PathVariable("userid") Integer userid,
                           @PathVariable("amount") Integer amount,
                           @PathVariable("event") String event,
                           @PathVariable("accountid") Integer accountid){
        User user = userService.getUserById(userid);
        Account account = accountService.getAccountByUser(user);
        Account account2 = accountService.getAccountById(accountid);
        account.changeBalance(-amount);
        account2.changeBalance(amount);
        accountService.saveAccount(account);
        accountService.saveAccount(account2);
        transactionService.saveTransaction(new Transaction(account, new Date(), event, -amount));
        transactionService.saveTransaction(new Transaction(account2, new Date(), event, amount));
        return user.getFirstName() + " " + user.getLastName() + " transfered: "+ Integer.toString(amount) + " to: " + account2.getId();


    }

    private String changeBalance(int userid, int amount, String event){
        User user = userService.getUserById(userid);
        Account account = accountService.getAccountByUser(user);
        account.changeBalance(amount);
        accountService.saveAccount(account);
        transactionService.saveTransaction(new Transaction(account, new Date(), event, amount));
        return user.getFirstName() + " " + user.getLastName() + ": "+ Integer.toString(amount) + " balance: " + Integer.toString(account.getBalance());
    }
}
