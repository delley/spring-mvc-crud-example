package br.com.froli.springmvc.model;

public class Contato {

	private Long codigo;
	
	private String nome;
	
	private String email;
	
	private String endereco;
	
	private String telefone;
	
	public Contato() {
	}

	public Contato(Long codigo, String nome, String email, String endereco, String telefone) {
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Contato [codigo=" + codigo + ", nome=" + nome + ", email=" + email + ", endereco=" + endereco
				+ ", telefone=" + telefone + "]";
	}
	
}
