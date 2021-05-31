package model.bean;

public class Expense {

	private int id;
	private String expenseName;
	private double value;
	private int status;
	private String dataOfCreation;
	private String company_Key;
	
	
	public Expense() {}
	public Expense(int id,String expenseName,double value,int status,String dataOfCreation) {
		this.id = id;
		this.expenseName = expenseName;
		this.value = value;
		this.status = status;
		this.dataOfCreation = dataOfCreation;
		

	}
	
	public String getCompany_Key() {
		return company_Key;
	}
	public void setCompany_Key(String company_Key) {
		this.company_Key = company_Key;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getExpenseName() {
		return expenseName;
	}
	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDataOfCreation() {
		return dataOfCreation;
	}
	public void setDataOfCreation(String dataOfCreation) {
		this.dataOfCreation = dataOfCreation;
	}
	
	@Override
	public String toString() {
		return "Name: "+this.expenseName+"\nValue: "+this.value+"\nStatus: "+this.status+"\nData Creation: "+this.dataOfCreation;
	}


	
}
