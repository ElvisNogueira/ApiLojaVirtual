package com.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.model.Cliente;
import com.api.model.Produto;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	public Optional<Cliente> findByLoginAndSenha(String login, String senha);
}
