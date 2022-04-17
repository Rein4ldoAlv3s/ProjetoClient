package com.reinaldo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reinaldo.domain.Cliente;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Integer>{

}
