package model.bean;

public class Occupation {
 private int id;
 private String cargo;
 private int status;
 
 public Occupation() {}
	public Occupation (int id,String cargo) {
		this.id = id;
		this.cargo = cargo;
	}
 public Occupation (int id,String cargo, int status) {
	 this.id = id;
	 this.cargo = cargo;
	 this.status = status;
 }
	public void setCargoAndId (int id,String cargo) {
		this.id = id;
		this.cargo = cargo;
	}
	public String getCargoAndId () {
		return this.id + this.cargo;
	}
 public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCargo() {
	return cargo;
}

public void setCargo(String cargo) {
	this.cargo = cargo;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
@Override
public String toString() {
	return this.cargo;
}
}
