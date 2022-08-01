package model.Accesers;

import model.Employee;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EmplyeeAccess {
    private final static String name="CD_Store/src/etc/emplyee.dat";
    private File file_path;
    // private java.io.FileOutputStream output_tool;
    // private java.io.BufferedOutputStream output;
    // private java.io.FileInputStream input_tool;
    // private java.io.BufferedInputStream input;
    private ArrayList<Employee> array=new ArrayList<>();
    
    public EmplyeeAccess(){
        file_path=new java.io.File(name);
        read_file();
    }


    public EmplyeeAccess(String path){
        this.file_path= new java.io.File(path);
        read_file();
    }

    public void edit_employee(int index,Employee temp){
        array.remove(index);
        array.add(index,temp);
        write_file();
    }

    public void edit_employee(int index,Employee temp,String User_name){
        array.remove(index);
        temp.setUser_name(User_name);
        array.add(index,temp);
        write_file();
    }

    public void add_employee(Employee temp) throws Exception{
        for(int i=0;i<array.size();i++){
            if(temp.getName().equals(array.get(i).getName()) || temp.getSurname().equals(array.get(i).getSurname()) || temp.getUser_name().equals(array.get(i).getUser_name())){
                System.out.println("This user already exists!!!");
                throw new Exception("This user already exists!!!");
            }
        }
        array.add(temp);
        write_file();
        //array.clear();
    }

    public void remove_employee(Employee temp){
        for(int i=0;i<array.size();i++){
            if(temp.toString().equals(array.get(i).toString()))
            {array.remove(i);
                
            return;
            }
        }
        return;
    }

    public void remove_employee(int temp){
        array.remove(temp);
        write_file();
    }

    public ArrayList<Employee> get_data(){
        //read_file();
        return array;
    }

    public ArrayList<Employee> search_Employees(String name, String surname){
        ArrayList<Employee> temp=new ArrayList<>();

        for(int i=0;i<temp.size();i++){
            if(array.get(i).getName().equals(name) || array.get(i).getSurname().equals(surname))
            temp.add(array.get(i));
        }
    return temp;
    }

    public Employee search_Employee(String user_name){
        for(int i=0;i<array.size();i++){
            if(array.get(i).getUser_name().equals(user_name)){
                return array.get(i);
            }
        }

        return null;
    }

    public void close(){
        array.clear();
    }

    public int get_size(){
        return array.size();
    }

    public void destroy_data(String temp){
        if(temp.equals("alfa")){
            array.clear();
            write_file();
        }
        return;
    }

    public void printdata(){
        for(int i=0;i<array.size();i++){
            System.out.print("i");
            System.out.println(array.get(i).toString());
        }
        System.out.println("Done");
    }



    private void read_file(){
        try(
            FileInputStream temp=new FileInputStream(file_path);
            BufferedInputStream input_temp=new BufferedInputStream(temp);
            ObjectInputStream input=new ObjectInputStream(input_temp);
        )
        {
            System.out.println("ckemi");

            //dangerous
            
           array=(ArrayList<Employee>) input.readObject();

           if(!(array.get(1) instanceof Employee)){
           System.out.println("we have some deserilazation problems");
           array.clear();
           return;
        }

           System.out.println("there are in the user.dat: "+array.size());

            
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private void write_file(){
        try(
            FileOutputStream temp=new FileOutputStream(file_path);
            BufferedOutputStream output_temp=new BufferedOutputStream(temp);
            ObjectOutputStream output=new ObjectOutputStream(output_temp);
        )
        {
            System.out.println("ckemi");

           output.writeObject(array);;

           System.out.println("there are in the user.dat: "+array.size());

            
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

}
