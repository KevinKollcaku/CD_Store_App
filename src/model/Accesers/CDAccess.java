package model.Accesers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.CD;

public class CDAccess {

    private static String name="CD_Store/src/var/stock.dat";
    

    private File file_path;
    // private java.io.FileOutputStream output_tool;
    // private java.io.BufferedOutputStream output;
    // private java.io.FileInputStream input_tool;
    // private java.io.BufferedInputStream input;
    private ArrayList<CD> array=new ArrayList<>();
    
    public CDAccess(){
       // this.name="C:\\Users\\user\\Desktop\\CD_Store\\CD_Store\\src\\var\\stock.dat";
        file_path=new java.io.File(name);
        
        if(!file_path.exists()){
            System.out.println("We created a new file, becuse ther was no file with such name");
         try {
            file_path.createNewFile();
            System.out.println("created successfuly");
         } catch (Exception e) {
             e.printStackTrace();
         }
        }
        read_file();
    }

    public CDAccess(String path){
        this.file_path= new java.io.File(path);
        read_file();
    }

    public int search_CD(String name) throws Exception{
        
        for(int i=0;i<array.size();i++){
            if(name.equals(array.get(i).getName()))
            {
            return i;
            }
        }
    throw new Exception("This Cd is not in inventory");
    }

    public void edit_cd(int index,CD temp){
        array.remove(index);
        array.add(index,temp);
        write_file();
    }

    public void add_cd(CD temp){
        array.add(temp);
        write_file();
        //array.clear();
    }

    public void add_cd_stock(int index,int num){
        array.get(index).setCopies(array.get(index).getCopies()+num);
        write_file();
    }

    public void remove_cd(CD temp){
        for(int i=0;i<array.size();i++){
            if(temp.equals(array.get(i)))
            {array.remove(i);
            return;
            }
        }
        return;
    }

    public ArrayList<CD> limited_cd(int num){
        ArrayList<CD> temp=new ArrayList<>();
        for(int i=0;i<array.size();i++){
            if(array.get(i).getCopies()<=num)
            {
            temp.add(array.get(i));
            }
        }
        return temp;
    }

    public ArrayList<CD> limited_cd(){
        ArrayList<CD> temp=new ArrayList<>();
        for(int i=0;i<array.size();i++){
            if(array.get(i).getCopies()<=5)
            {
            temp.add(array.get(i));
            }
        }
        return temp;
    }

    public ArrayList<CD> get_data(){
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
    public void printdata(){
        for(int i=0;i<array.size();i++){
            System.out.print("i--");
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

           array=(ArrayList<CD>) input.readObject();

           if(!(array.get(1) instanceof CD)){
           System.out.println("we have some deserilazation problems");
           array.clear();
           return;
        }

           System.out.println("there are in the user.dat: "+array.size());

            
        } catch (Exception e) {
            System.out.println("file did not exist");
            System.out.println(file_path);
            e.getStackTrace();
            System.out.println(e.getMessage());
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
            System.out.println(e.getLocalizedMessage());
            e.getStackTrace();
        }
    }
    
}
