package com.example.demo.vo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ClientVO {
    private String firstname;

    private String lastname;

    private LocalDateTime birthdate;

    private String address;

    private String phone;

    private String email;

    private LocalDateTime created;

    private String status;
}
