package com.myfood.registerservice.service;

import com.myfood.registerservice.entity.Client;
import com.myfood.registerservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Client client) {

        Optional<Client> newClient = clientRepository.findById(client.getId());

        if (newClient.isPresent()) {

            return clientRepository.save(client);
        }
        return null;
    }

    public boolean deleteClient(Long id) {
        Optional<Client> client = clientRepository.findById(id);

        if (client.isPresent()) {
            clientRepository.delete(client.get());
            return true;
        } else {
            return false;
        }
    }

    public Optional<Client> getClientById (Long id) {
        return clientRepository.findById(id);
    }
}
