package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>{
	
}
