package model.bean;

public class Configuration {
    private String companyName;
    private int id;

    void Configuration(){}

    void Configuration(String nameCompany, int id){
        this.companyName = nameCompany;
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString(){
        return this.companyName;
    }
}
