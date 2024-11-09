package com.spyrosdran.spring_boot_bank.service;

import com.spyrosdran.spring_boot_bank.dao.ClientDao;
import com.spyrosdran.spring_boot_bank.dao.TransactionDao;
import com.spyrosdran.spring_boot_bank.entity.Client;
import com.spyrosdran.spring_boot_bank.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService{

    private ClientDao clientDao;
    private TransactionDao transactionDao;

    @Autowired
    public BankServiceImpl(ClientDao clientDao, TransactionDao transactionDao) {
        this.clientDao = clientDao;
        this.transactionDao = transactionDao;
    }

    @Override
    public void save(Client client) {
        clientDao.save(client);
    }

    @Override
    public void save(Transaction transaction) {
        transactionDao.save(transaction);
    }

    @Override
    public void update(Client client) {
        clientDao.update(client);
    }

    @Override
    public void update(Transaction transaction) {
        transactionDao.update(transaction);
    }

    @Override
    public Client findClientById(int id) {
        return clientDao.findById(id);
    }

    @Override
    public Transaction findTransactionById(int id) {
        return transactionDao.findById(id);
    }

    @Override
    public void deleteClientById(int id) {
        clientDao.deleteById(id);
    }

    @Override
    public void deleteTransactionById(int id) {
        transactionDao.deleteById(id);
    }

    @Override
    public float getBalance(int clientId) {
        return clientDao.findById(clientId).getBalance();
    }

    @Override
    public int deposit(float amount, int clientId) {

        // Error code 1: amount of money is invalid
        if (amount <= 0) return 1;

        Client client = findClientById(clientId);
        float balance = client.getBalance();

        balance += amount;
        client.setBalance(balance);

        save(client);

        // Code 0: successful deposit
        return 0;
    }

    @Override
    public int withdraw(float amount, int clientId) {

        // Error code 1: amount of money is invalid
        if (amount <= 0) return 1;

        // Error code 2: amount to deposit is bigger than balance
        Client client = findClientById(clientId);
        float balance = client.getBalance();

        if (amount > balance) return 2;

        balance -= amount;
        client.setBalance(balance);

        save(client);
        
        return 0;
    }

    @Override
    public boolean transferMoney(float amount, int payerId, int receiverId) {
        return false;
    }
}
