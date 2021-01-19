package br.com.bytebank.model;

/**
 * Class represents the ByteBank costumers.
 * 
 * @author "Luis Ricardo Benhossi"
 * @version 0.1
 *
 */
public class Client {

	private String name;
	private String cpf;
	private String profession;
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return this.cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getProfession() {
		return this.profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	
}