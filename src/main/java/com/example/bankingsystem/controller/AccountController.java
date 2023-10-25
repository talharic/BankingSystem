package com.example.bankingsystem.controller;

import com.example.bankingsystem.entity.Account;
import com.example.bankingsystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Account> accountList = accountService.findAll();
        return ResponseEntity.ok(accountList);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        Account account = accountService.findById(id);
        return ResponseEntity.ok(account);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Account account) {
        accountService.save(account);
        return ResponseEntity.ok(account);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        accountService.delete(id);
        return ResponseEntity.ok(Void.TYPE);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Account account){
        account = accountService.update(account);
        return ResponseEntity.ok(account);
    }
}
