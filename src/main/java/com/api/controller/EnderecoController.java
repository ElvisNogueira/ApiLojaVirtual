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

import com.api.model.Endereco;
import com.api.repository.EnderecoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value = "API REST ENDERECO")
@CrossOrigin(origins="*")
public class EnderecoController {
	@Autowired
	public EnderecoRepository enderecoRepository;
	
	@ApiOperation(value = "Retorna uma lista de Endereços")
	@GetMapping("/endereco")
	public List<Endereco> index(){
		return enderecoRepository.findAll();
	}
	
	@ApiOperation(value = "Retorna um Endereço")
	@GetMapping("/endereco/{id}")
	public Endereco view(@PathVariable("id") Long id) {
		return enderecoRepository.findById(id).get();
	}
	
	@ApiOperation(value = "Cadastra um endereço")
	@PostMapping("/endereco")
	public Endereco storage(@RequestBody Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	@ApiOperation(value = "Deleta um endereço")
	@DeleteMapping("/endereco/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		Endereco endereco = enderecoRepository.findById(id).get();
		enderecoRepository.delete(endereco);
	}
	
	@ApiOperation(value = "Edita um endereço")
	@PutMapping("/endereco")
	public Endereco update(@RequestBody Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
}
