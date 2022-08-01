package model;

import java.io.Serializable;
import java.util.Date;


public class BuyCD implements Serializable{
    private final static long serialVersionUID=123412312323123L;
    private CD buyeditm;
    private Employee seller;
    private int amount_of_sold_CD;
    private int profit;
    private Date the_buy_data;

    public BuyCD(){

    }
    
    public BuyCD(CD temp, Employee emp, int amount){
        this.buyeditm=temp;
        seller=emp;
        amount_of_sold_CD=(amount);
        profit=(getAmount_of_sold_CD()*temp.getPrice());
        the_buy_data=new Date();
    }
    
    public Date getThe_buy_data() {
        return the_buy_data;
    }

    // private void setThe_by_data(Date the_by_data) {
    //     this.the_by_data = the_by_data;
    // }

    public int getProfit() {
        return profit;
    }

    // //we have declared the seter private so only this class can acces it
    // private void setProfit(int profit) {
    //     this.profit = profit;
    // }

    public int getAmount_of_sold_CD() {
        return amount_of_sold_CD;
    }

    // //we have declared the seter private so only this class can acces it
    // private void setAmount_of_sold_CD(int amount_of_sold_CD) {
    //     this.amount_of_sold_CD = amount_of_sold_CD;
    // }

    public Employee getSeller() {
        return seller;
    }

    public CD getByeditm() {
        return buyeditm;
    }

    @Override
    public String toString() {
        return super.toString()+" products name: "+getByeditm().getName()+ " \nthe sellesr: "+getSeller().getName()+ " sold on: "+getThe_buy_data()+
        "\namount of product solded was: "+getAmount_of_sold_CD();
    }
   
    
}
