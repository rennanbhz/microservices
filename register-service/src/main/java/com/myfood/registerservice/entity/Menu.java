package com.myfood.registerservice.entity;

import com.myfood.registerservice.domain.MenuDTO;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant restaurant;

    public static Menu create(MenuDTO menuDTO) {
        return new ModelMapper().map(menuDTO, Menu.class);
    }

}
