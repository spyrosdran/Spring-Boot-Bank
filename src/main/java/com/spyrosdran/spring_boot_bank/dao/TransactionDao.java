package com.spyrosdran.spring_boot_bank.dao;

import com.spyrosdran.spring_boot_bank.entity.Client;
import com.spyrosdran.spring_boot_bank.entity.Transaction;

public interface TransactionDao {

    public Transaction findById(int id);
    public void save(Transaction transaction);
    public void update(Transaction transaction);
    public void deleteById(int id);
}
