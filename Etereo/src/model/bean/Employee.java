package model.bean;

public class Employee {

	private int id;
	private int empresa;
	private String cargo;
	private String nome;
	private int status;
	private int idade;
	private double salario;
	
	public Employee() {}

	public Employee(int id, int empresa, String cargo, String nome, int status, int idade, double salario) {
		this.id = id;
		this.empresa = empresa;
		this.cargo = cargo;
		this.nome = nome;
		this.status = status;
		this.idade = idade;
		this.salario = salario;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmpresa() {
		return empresa;
	}

	public void setEmpresa(int empresa) {
		this.empresa = empresa;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	@Override
	public String toString() {
		return "id: "+this.id+"\nEmpresa: "+this.empresa+"\nCargo: "+this.cargo+"\nNome: "+this.nome+"\nstatus: "+this.status+"\nIdade: "+this.idade+"\nSalario: "+this.salario;
	}
}
