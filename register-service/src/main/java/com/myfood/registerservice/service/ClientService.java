package com.myfood.registerservice.service;

import com.myfood.registerservice.entity.Client;
import com.myfood.registerservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient (Client client) {
        return clientRepository.save(client);
    }
}
