package com.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nome, descricao, tamanho;
	private double valor;
	private String categoria;
	private double desconto;
	private String imagem_url;

	public Produto(int id, String nome, String descricao, String tamanho, double valor, String categoria,
			double desconto, String imagem_url) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.tamanho = tamanho;
		this.valor = valor;
		this.categoria = categoria;
		this.desconto = desconto;
		this.imagem_url = imagem_url;
	}


	public Produto() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getTamanho() {
		return tamanho;
	}


	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public double getDesconto() {
		return desconto;
	}


	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}


	public String getImagem_url() {
		return imagem_url;
	}


	public void setImagem_url(String imagem_url) {
		this.imagem_url = imagem_url;
	}
	
	
}