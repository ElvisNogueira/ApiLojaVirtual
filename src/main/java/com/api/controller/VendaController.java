package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Produto;
import com.api.model.Venda;
import com.api.repository.ProdutoRepository;
import com.api.repository.VendaRepository;

@RestController
@RequestMapping("/api")
public class VendaController {
	@Autowired
	private VendaRepository repository;
	
	@GetMapping("/venda")
	public List<Venda> index(){
		return repository.findAll();
	}
	
	@GetMapping("/venda/{id}")
	public Venda view(@PathVariable("id") Long id) {
		return repository.findById(id).get();
	}
	
	@PostMapping("/venda")
	public Venda storage(@RequestBody Venda venda) {
		return repository.save(venda);
	}
	
	@DeleteMapping("/venda/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		Venda venda = repository.findById(id).get();
		repository.delete(venda);
	}
	
	@PutMapping("/venda")
	public Venda update(@RequestBody Venda venda) {
		return repository.save(venda);
	}
}
