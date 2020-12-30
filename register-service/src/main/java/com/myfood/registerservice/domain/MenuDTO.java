package com.myfood.registerservice.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MenuDTO {

    private Long id;

    private String name;

    private Double price;

    private Long restaurant;

}
