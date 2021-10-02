package com.example.service;


import com.example.dao.BankAccountDao;
import com.example.entity.BankAccount;

public class BankAccountService {

    private BankAccountDao bankAccountDao = new BankAccountDao();

    public BankAccount create(BankAccount bankAccount) {
        // write validations for create bank account
        return bankAccountDao.create(bankAccount);
    }
}
