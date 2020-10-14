package com.myfood.registerservice.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class RestaurantDTO {

    private String name;
    private String email;
    private String password;

}
