package com.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.model.Cliente;
import com.api.model.Loja;
import com.api.model.Produto;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long> {
	public Optional<Loja> findByEmailAndSenha(String email, String senha);
}
