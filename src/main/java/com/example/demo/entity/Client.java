package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Client {
    @EmbeddedId
    private ClientPk id;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "CREATED")
    private LocalDateTime created;

    @ManyToOne
    @JoinColumn(name = "STATUS")
    private ClientStatus status;
}

