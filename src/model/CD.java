package model;

import java.io.Serializable;

public class CD implements Serializable{
    private final static long serialVersionUID=123412312323123L;
    private String name;
    private int year;
    private String artist;
    private int price;
    private int copies;
    private String suplier;
    private String Genre;
    


public CD(){

}
    public CD(String name,int year, String artist, int price){
        this.setName(name);
        this.setYear(year);
        this.setArtist(artist);
        this.setPrice(price);
        this.setSuplier("kevi_suplier");
        System.out.println("creating a new CD!!!");
    }

    public CD(String name,int year, String artist, int price,int copies){
        this.setName(name);
        this.setYear(year);
        this.setArtist(artist);
        this.setPrice(price);
        this.setCopies(copies);
        this.setSuplier("kevi");
        System.out.println("creating a new CD!!!");
    }

    public String getGenre() {
        return Genre;
    }
    
    public void setGenre(String genre) {
        this.Genre = genre;
    }

    public String getSuplier() {
        return suplier;
    }

    public void setSuplier(String supliers_name) {
        this.suplier = supliers_name;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        
        return super.toString()+ " name: "+getName() +" artist: "+getArtist()+ " price: "+getPrice()+" copies: "+getCopies()+"suplier: "+ getSuplier();
    }

    
    
}
