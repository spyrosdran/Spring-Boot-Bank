package com.spyrosdran.spring_boot_bank.service;

import com.spyrosdran.spring_boot_bank.dao.ClientDao;
import com.spyrosdran.spring_boot_bank.dao.TransactionDao;
import com.spyrosdran.spring_boot_bank.entity.Client;
import com.spyrosdran.spring_boot_bank.entity.Transaction;
import org.springframework.stereotype.Service;

public interface BankService {

    public void save(Client client);
    public void save(Transaction transaction);
    public void update(Client client);
    public void update(Transaction transaction);
    public Client findClientById(int id);
    public Transaction findTransactionById(int id);
    public void deleteClientById(int id);
    public void deleteTransactionById(int id);
    public float getBalance(int clientId);
    public boolean deposit(float amount, int clientId);
    public boolean withdraw(float amount, int clientId);
    public boolean transferMoney(float amount, int payerId, int receiverId);
}
