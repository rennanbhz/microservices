package com.myfood.registerservice.entity;

import com.myfood.registerservice.domain.ClientDTO;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Data
@Entity
@Table("tb_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String email;
    private String password;

    public static Client clientMapper (ClientDTO clientDTO) {
        return new ModelMapper().map(clientDTO, Client.class);
    }
}
