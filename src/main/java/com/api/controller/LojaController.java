package com.api.controller;

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
import com.api.model.Loja;
import com.api.repository.LojaRepository;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api")
public class LojaController {
	@Autowired
	public LojaRepository repository;
	
	@GetMapping("/loja")
	public List<Loja> index(){
		return repository.findAll();
	}
	
	@GetMapping("/loja/{id}")
	public Loja view(@PathVariable("id") Long id) {
		return repository.findById(id).get();
	}
	
	@GetMapping("/loja/{email}/{senha}")
	public Loja login(@PathVariable("email") String email, @PathVariable("senha") String senha) {
		return repository.findByEmailAndSenha(email, senha).get();
	}
	
	@PostMapping("/loja")
	public Loja storage(@RequestBody Loja loja) {
		return repository.save(loja);
	}
	
	@DeleteMapping("/loja/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		Loja loja = repository.findById(id).get();
		repository.delete(loja);
	}
	
	@PutMapping("/loja")
	public Loja update(@RequestBody Loja loja) {
		return repository.save(loja);
	}
}
