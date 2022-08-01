package model;

import java.io.Serializable;

public class Sells implements Serializable{
    private final static long serialVersionUID=123412341233143L;
    private int costo;
    private int profit;

    public Sells(int costo, int profit) {
        this.costo = costo;
        this.profit = profit;
    }


    public int getCosto() {
        return costo;
    }
    public void setCosto(int costo) {
        this.costo = costo;
    }
    public void addCosto(int num){
        this.costo+=num;
    }

    public int getProfit() {
        return profit;
    }
    public void setProfit(int profit) {
        this.profit = profit;
    }
    public void addProfit(int num){
        this.profit+=num;
    }

    @Override
    public String toString() {
        System.out.println("Inside to string");
        return super.toString()+" profit: "+ getProfit()+" costo: "+getCosto();
    }
}
