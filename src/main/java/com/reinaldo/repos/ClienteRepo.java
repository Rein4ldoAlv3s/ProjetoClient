package com.reinaldo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reinaldo.domain.Cliente;

public interface ClienteRepo extends JpaRepository<Cliente, Integer>{

}
