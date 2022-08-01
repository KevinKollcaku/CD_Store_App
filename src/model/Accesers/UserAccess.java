package model.Accesers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.User;

//this class acceses the passwd,dat file
//a littel bit confusing but thats how it is
public class UserAccess {
    private final static String name="CD_Store/src/etc/user.dat";
    private File file_path;
    // private java.io.FileOutputStream output_tool;
    // private java.io.BufferedOutputStream output;
    // private java.io.FileInputStream input_tool;
    // private java.io.BufferedInputStream input;
    private ArrayList<User> array=new ArrayList<>();
    
    public UserAccess(){
        file_path=new java.io.File(name);
        read_file();
    }

    public UserAccess(String path){
        this.file_path= new java.io.File(path);
        read_file();
    }

    public void edit_user(int index,User temp){
        array.add(index,temp);
        write_file();
    }

    public void add_user(User temp){
        System.out.println(temp.toString());
        array.add(temp);
        write_file();
        //array.clear();
    }

    public void remove_user(User temp){
        for(int i=0;i<array.size();i++){
            if(temp.equals(array.get(i)))
            {array.remove(i);
                write_file();
            return;
            }
        }
        return;
    }

    public void remove_user(int temp){
        array.remove(temp);
    }

    public User find_User(String user_name) throws Exception{
        for(int i=0;i<array.size();i++){
            if(array.get(i).getUser_name().equals(user_name)){
                return array.get(i);
            }
        }
    throw new Exception("The does not exists a user fo the coresponding subject");
    }

    public boolean exists(User temp){
        for(int i=0;i<array.size();i++){
            if(array.get(i).getUser_name().equals(temp.getUser_name()))
            return true;
        }
        return false;
    }

    public ArrayList<User> get_data(){
        //read_file();
        return array;
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



    private void read_file(){
        try(
            FileInputStream temp=new FileInputStream(file_path);
            BufferedInputStream input_temp=new BufferedInputStream(temp);
            ObjectInputStream input=new ObjectInputStream(input_temp);
        )
        {
            System.out.println("ckemi");

            //dangerous

           array=(ArrayList<User>) input.readObject();

           if(!(array.get(1) instanceof User)){
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
