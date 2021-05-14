package model.bean;

public class Employee {

	private int id;
	private int cargo;
	private String cargo_key;
	
	private String nome;
	private int status;
	private int idade;
	private double salario;


	private String data;
	public Employee() {}

	public Employee(int id, String cargo_key, int cargo, String nome, int status, int idade, double salario, String data) {
		this.id = id;
		this.cargo = cargo;
		this.cargo_key = cargo_key;
		this.nome = nome;
		this.status = status;
		this.idade = idade;
		this.salario = salario;
		this.data = data;
	}
	
	public String getCargo_key() {
		return cargo_key;
	}

	public void setCargo_key(String cargo_key) {
		this.cargo_key = cargo_key;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}


	public int getCargo() {
		return cargo;
	}

	public void setCargo(int cargo) {
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
		return "id: "+this.id+"\nCargo Key: "+this.cargo+"\nCargo: "+this.cargo+"\nNome: "+this.nome+"\nstatus: "+this.status+"\nIdade: "+this.idade+"\nSalario: "+this.salario;
	}
}
