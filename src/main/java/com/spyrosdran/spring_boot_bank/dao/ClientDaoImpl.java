package com.spyrosdran.spring_boot_bank.dao;

import com.spyrosdran.spring_boot_bank.entity.Client;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDaoImpl implements ClientDao{

    private EntityManager entityManager;

    @Autowired
    public ClientDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Client findById(int id) {
        return entityManager.find(Client.class, id);
    }

    @Override
    @Transactional
    public void save(Client client) {
        entityManager.persist(client);
    }

    @Override
    @Transactional
    public void update(Client client) {
        entityManager.merge(client);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Client client = entityManager.find(Client.class, id);
        entityManager.remove(client);
    }
}
