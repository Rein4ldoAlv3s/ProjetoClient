package com.reinaldo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reinaldo.domain.Estado;

@Repository
public interface EstadoRepo extends JpaRepository<Estado, Integer>{

}
