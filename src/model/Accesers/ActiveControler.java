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

public class ActiveControler {
    private final static String name="CD_Store/src/var/active.txt";
    private File file_path;

    public ActiveControler(String temp){
        file_path=new File(name);
        write_file(temp);
    }

    public ActiveControler(User temp){
        file_path=new File(name);
        write_file(temp.getUser_name());
    }

    public String get_current_user(){
        return read_file();
    }


    
    private String read_file(){
        try(
            FileInputStream temp=new FileInputStream(file_path);
            BufferedInputStream input_temp=new BufferedInputStream(temp);
            ObjectInputStream input=new ObjectInputStream(input_temp);
        )
        {
           System.out.println("ckemi");

           String active=(String) input.readObject();

           return active;

        } catch (Exception e) {
            System.out.println("file did not exist");
            System.out.println(file_path);
            e.getStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }

    private void write_file(String active){
        try(
            FileOutputStream temp=new FileOutputStream(file_path);
            BufferedOutputStream output_temp=new BufferedOutputStream(temp);
            ObjectOutputStream output=new ObjectOutputStream(output_temp);
        )
        {
        System.out.println("ckemi");

        output.writeObject(active);;

            
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            e.getStackTrace();
        }
    }
    
}
