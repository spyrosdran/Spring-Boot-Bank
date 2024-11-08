package com.spyrosdran.spring_boot_bank.dao;

import com.spyrosdran.spring_boot_bank.entity.Client;

public interface ClientDao {

    public Client findById(int id);
    public void save(Client client);
    public void update(Client client);
    public void deleteById(int id);
}
