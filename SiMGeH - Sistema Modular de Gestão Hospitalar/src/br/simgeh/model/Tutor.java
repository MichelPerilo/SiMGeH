/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.model;

/**
 *
 * @author Bartô
 */
public class Tutor {

	private String nome;
	private String cpf;
	private Endereco endereco;
	private String fone_1;
	private String fone_2;

	public Tutor(String nome, String cpf, Endereco endereco, String fone_1, String fone_2){
		this.setNome(nome);
		this.setCpf(cpf);
		this.setEndereco(endereco);
		this.setFone_1(fone_1);
		this.setFone_2(fone_2);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getFone_1() {
		return fone_1;
	}

	public void setFone_1(String fone_1) {
		this.fone_1 = fone_1;
	}

	public String getFone_2() {
		return fone_2;
	}

	public void setFone_2(String fone_2) {
		this.fone_2 = fone_2;
	}
	
	public boolean equals(Tutor tutor) {
		if(tutor.getCpf().equals(this.getCpf()))
			return true;
		else
			return false;
	}
	
}
