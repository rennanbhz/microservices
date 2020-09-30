package com.myfood.registerservice.controller;

import com.myfood.registerservice.domain.ClientDTO;
import com.myfood.registerservice.entity.Client;
import com.myfood.registerservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/create")
    public ResponseEntity createCliente (@RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.createClient(Client.clientMapper(clientDTO)));
    }

}
