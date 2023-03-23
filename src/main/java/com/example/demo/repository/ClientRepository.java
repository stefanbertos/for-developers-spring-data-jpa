package com.example.demo.repository;

import com.example.demo.entity.Client;
import com.example.demo.entity.ClientPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, ClientPk> {

}
