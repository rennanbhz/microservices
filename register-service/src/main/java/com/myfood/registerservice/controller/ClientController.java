package com.myfood.registerservice.controller;

import com.myfood.registerservice.domain.ClientDTO;
import com.myfood.registerservice.entity.Client;
import com.myfood.registerservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/create")
    public ResponseEntity createClient (@RequestBody ClientDTO clientDTO) {

        try {

            return ResponseEntity.ok(clientService.createClient(Client.clientMapper(clientDTO)));

        } catch (Exception e) {

           return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateClient (@PathVariable ("id") Long id, @RequestBody ClientDTO clientDTO) {

        Client client = Client.clientMapper(clientDTO);
        client.setId(id);

        Client updatedClient = clientService.updateClient(client);
        return Objects.nonNull(updatedClient) ? ResponseEntity.ok(updatedClient) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteClient (@PathVariable("id") Long id) {
        return clientService.deleteClient(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity getClientById (@PathVariable("id") Long id) {
        Optional<Client> client = clientService.getClientById(id);
        return client.isPresent() ? ResponseEntity.ok(client.get()) : ResponseEntity.notFound().build();
    }
}
