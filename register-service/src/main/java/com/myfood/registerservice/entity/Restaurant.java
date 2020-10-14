package com.myfood.registerservice.entity;

import com.myfood.registerservice.domain.RestaurantDTO;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String email;
    private String password;

    public static Restaurant restaurantMapper(RestaurantDTO restaurantDTO) {
        return new ModelMapper().map(restaurantDTO, Restaurant.class);
    }
}
