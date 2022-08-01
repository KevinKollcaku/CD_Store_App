package model;

import java.io.Serializable;


public class User implements Serializable{
    private final static long serialVersionUID=12341234123123L;
    private String user_name;
    private String password;
    private int acces_level; // 1 -admin *** 2-mangare *** 3-user

    //default construceter with random usermane and a fixed passwd and lowes accesl level
    public User(){
        user_name=(" "+ Math.random());
        password=("");
        acces_level=1;
    }

    //a constructer with specific parameters
    public User(String name,String passwd,int acces){
        this.user_name=name;
        this.password=passwd;
        this.acces_level=acces;
    }

    public boolean isequal(User temp){
        if(this.getUser_name()==temp.getUser_name() && this.getPassword()==temp.getPassword())
        return true;
    return false;
    }

    //geter for username
    public String getUser_name(){
        return user_name;
    }

    //geter for password
    public String getPassword(){
        return password;
    }

    //geter for acces level
    public int getAcces_level(){
        return acces_level;
    }

    //checks if the user is the same
    public boolean is_part_of(String name,String passswd,User temp){

        if(name.equals(temp.getUser_name()) && passswd.equals(temp.getPassword()))
        return true;

        return false;
    }

    public boolean is_part_of(User temp){
        if(this.toString().equals(temp.toString()))
        return true;
    return false;
    }

    @Override
    public String toString() {
        System.out.println("called!!!");
        return super.toString()+" "+ user_name+" "+password+" "+ acces_level;
    }

}
