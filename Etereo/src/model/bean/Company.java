package model.bean;

public class Company {
	private int id;
	private String razaoSocial;
	private String cidade;
	

	private String uf;
	private int status;
	

	public Company() {}
	public Company(int id, String razaoSocial,String cidade,String uf,int status) {
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.cidade = cidade;
		this.uf = uf;
		this.status = status;
	};
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	@Override
	public String toString() {
		return "\nRazao Social: "+this.razaoSocial+"\nCidade:"+this.cidade+"\nUf: "+this.uf;
	}
	
}
