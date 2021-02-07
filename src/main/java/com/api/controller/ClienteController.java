package com.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Cliente;
import com.api.model.Produto;
import com.api.repository.ClienteRepository;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ClienteController {
	@Autowired
	public ClienteRepository repository;
	
	@GetMapping("/cliente")
	public List<Cliente> index(){
		return repository.findAll();
	}
	
	@GetMapping("/cliente/{id}")
	public Cliente view(@PathVariable("id") Long id) {
		return repository.findById(id).get();
	}
	
	@GetMapping("/cliente/{email}/{senha}")
	public Cliente login(@PathVariable("email") String email, @PathVariable("senha") String senha) {
		return repository.findByEmailAndSenha(email, senha).get();
	}
	
	@PostMapping("/cliente")
	public Cliente storage(@RequestBody Cliente cliente) {
		return repository.save(cliente);
	}
	
	@DeleteMapping("/cliente/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		Cliente cliente = repository.findById(id).get();
		repository.delete(cliente);
	}
	
	@PutMapping("/cliente")
	public Cliente update(@RequestBody Cliente cliente) {
		return repository.save(cliente);
	}
}
