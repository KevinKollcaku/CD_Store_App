package model;

import java.io.Serializable;



public class Employee implements Serializable{
    
    private final static long serialVersionUID=12341212323123123L;
    private String user_name;
    private String Name;
    private String Surname;
    private String phone_number;
    private char gender;
    private int age;
    private String birthday;
    private double salery;
    private String e_mail;

    //private boolean completed=false;
    //ndoshta duhet qe tu shtoj edhe birthday

    public Employee(User temp){
        this.setUser_name(temp.getUser_name());
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Employee(String name,String surn,String usr, String phone, char gender, int age,double salery, String e_mail){
        this.setUser_name(usr);
        this.setName(name);
        this.setSurname(surn);
        this.setPhone_number(phone);
        this.setGender(gender);
        this.setAge(age);
        this.setSalery(salery);
        this.setE_mail(e_mail);
        //completed=true;
    }

    public boolean user_already_exists(String name,String surn,String usr, String phone, char gender, int age,
    double salery, String e_mail, Employee testing){
        if(name.equals(testing.getName()) && surn.equals(testing.getSurname()) && usr.equals(testing.getSurname()))
        return true;
        
        return false;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail=e_mail;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        //for(int i=0;i<arr)
        this.user_name = user_name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        this.Surname = surname;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalery() {
        return salery;
    }

    public void setSalery(double salery) {
        this.salery = salery;
    }

    @Override
	public String toString() {
		return "Employee name: " + Name + " Surname: " + Surname + 
			 " Phone: " + phone_number + " salary: " + salery+" username: "+user_name +" e_mail: "+ e_mail;
	}
    
}
