package com.example.demo;

import com.example.demo.entity.ClientStatus;
import com.example.demo.repository.ClientStatusRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class DemoApplication {

    public DemoApplication(ClientStatusRepository clientStatusRepository) {
        clientStatusRepository.save(new ClientStatus(0, "CREATED", LocalDateTime.now()));
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
