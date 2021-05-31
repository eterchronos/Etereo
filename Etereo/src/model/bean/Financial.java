package model.bean;

public class Financial {
    private int id;
    private double cash;
    private double debit;
    private String data;



    void Financial(){}
    void Financial(int id, double addCash, double debit,String data){
        this.id = id;
        this.cash = addCash;
        this.debit=debit;
        this.data=data;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString(){
        return "Cash: "+this.cash;
    }
}
