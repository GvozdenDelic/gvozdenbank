package com.fullstack.gvozdenbank.controllers;

import com.fullstack.gvozdenbank.dto.BankAccountDTO;
import com.fullstack.gvozdenbank.exceptions.InsuficientBalanceException;
import com.fullstack.gvozdenbank.exceptions.UnauthorisedUserException;
import com.fullstack.gvozdenbank.services.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank-account")
public class BankAccountController {
    private final BankAccountService bankAccountService;

    @Autowired
    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @PostMapping
    public String createBankAccount(@RequestBody BankAccountDTO bankAccount) {
        return bankAccountService.createBankAccount(bankAccount);
    }

    @GetMapping("/{id}")
    public BankAccountDTO getBankAccountById(@PathVariable Long id) {
        return bankAccountService.getBankAccountById(id);
    }

    @GetMapping
    public List<BankAccountDTO> getAllBankAccounts() {
        return bankAccountService.getAllBankAccounts();
    }

    @PutMapping("/deposit/{id}")
    public String deposit(@PathVariable Long userId, @PathVariable Long accountId, @PathVariable Float amount) throws UnauthorisedUserException {
        return bankAccountService.deposit(userId, accountId, amount);
    }

    @PutMapping("/withdraw/{id}")
    public String withdraw(@PathVariable Long userId, @PathVariable Long accountId, @PathVariable Float amount) throws UnauthorisedUserException, InsuficientBalanceException {
        return bankAccountService.withdraw(userId, accountId, amount);
    }

    @DeleteMapping("/{id}")
    public String deleteBankAccountById(@PathVariable Long id) {
        return bankAccountService.deleteBankAccountById(id);
    }
}