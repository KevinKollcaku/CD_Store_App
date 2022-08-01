package model;

import java.io.Serializable;

public class Genre implements Serializable{
    private final static long serialVersionUID=1221451234123123L;
    private  String genername;
    
    public Genre(){
        genername="";
        System.out.println("A new genre is created!!");
    }

    public Genre(String temp){
        genername = temp;
    }

    public String getGenername() {
        return genername;
    }

    public void setGenername(String gener_name) {
        this.genername = gener_name;
    }

    
}
