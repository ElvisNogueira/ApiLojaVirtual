package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Produto;
import com.api.repository.LojaRepository;
import com.api.repository.ProdutoRepository;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ProdutoController {
	@Autowired
	private ProdutoRepository pr;
	@Autowired
	private LojaRepository lr;
	
	@GetMapping("/produto")
	public List<Produto> index(){
		return pr.findAll();
	}
	
	@GetMapping("/produto/{id}")
	public Produto view(@PathVariable("id") int id) {
		return pr.findById(id).get();
	}
	
	@PostMapping("/produto")
	public Produto storage(@RequestBody Produto produto, String email, String senha) {
		if(lr.findByEmailAndSenha(email, senha) != null) {
			return pr.save(produto);
		}
		return produto;
	}
	
	@DeleteMapping("/produto/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		Produto produto = pr.findById(id).get();
		pr.delete(produto);
	}
	
	@PutMapping("/produto")
	public Produto update(@RequestBody Produto produto) {
		System.out.println(produto.getId());
		return pr.save(produto);
	}
}
