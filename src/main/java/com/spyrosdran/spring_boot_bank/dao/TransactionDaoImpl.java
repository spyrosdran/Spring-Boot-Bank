package com.spyrosdran.spring_boot_bank.dao;

import com.spyrosdran.spring_boot_bank.entity.Client;
import com.spyrosdran.spring_boot_bank.entity.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionDaoImpl implements TransactionDao{

    private EntityManager entityManager;

    @Autowired
    public TransactionDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Transaction findById(int id) {
        return entityManager.find(Transaction.class, id);
    }

    @Override
    @Transactional
    public void save(Transaction transaction) {
        entityManager.persist(transaction);
    }

    @Override
    @Transactional
    public void update(Transaction transaction) {
        entityManager.merge(transaction);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Transaction transaction = entityManager.find(Transaction.class, id);
        entityManager.remove(transaction);
    }
}
