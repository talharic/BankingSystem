package com.example.bankingsystem.service;

import com.example.bankingsystem.entity.Account;
import com.example.bankingsystem.enums.ErrorMessage;
import com.example.bankingsystem.exception.ItemNotFountException;
import com.example.bankingsystem.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;


    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account findById(Long id) {
        return getByIdWithCheck(id);
    }

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public void delete(Long id) {
        Account account = getByIdWithCheck(id);
        accountRepository.delete(account);
    }

    public Account update(Account account) {
        Long id = account.getId();
        if (!accountRepository.existsById(id)) {
            throw new ItemNotFountException(ErrorMessage.ITEM_ERROR_MESSAGE);
        }
        return accountRepository.save(account);
    }

    public Account getByIdWithCheck(Long id) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        Account account;
        if (accountOptional.isPresent()) {
            account = accountOptional.get();
        } else {
            throw new ItemNotFountException(ErrorMessage.ITEM_ERROR_MESSAGE);
        }
        return account;
    }
}
