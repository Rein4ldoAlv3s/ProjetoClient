package com.reinaldo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reinaldo.domain.Cidade;

public interface CidadeRepo extends JpaRepository<Cidade, Integer>{

}
