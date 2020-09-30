package com.myfood.registerservice.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ClientDTO {

    private String name;
    private String email;
    private String password;

}
