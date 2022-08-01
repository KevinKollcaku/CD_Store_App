package model.Accesers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import model.BuyCD;

public class BuyAcces {
    
    //the path to acces teh file that stores the buyed products
    private final static String name="CD_Store/src/var/bye.dat";
    private File file_path;

    //the array used to store the information read from the file
    private ArrayList<BuyCD> array=new ArrayList<>();


    
    public BuyAcces(){
        file_path=new java.io.File(name);
        read_file();
    }

    public BuyAcces(String path){
        this.file_path= new java.io.File(path);
        read_file();
    }


    public void add_buyed_product(BuyCD temp){

        //come back here, becuse thing are not working properly!!!
        
        System.out.println("\n\nThe new product was bought!!!!\n\n");
        File file=new File("CD_Store/Bills/"+temp.getThe_buy_data().getTime()+".txt");
        
        try {
            boolean just_of_need=file.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        try(
            FileWriter out=new FileWriter(file);
            PrintWriter output=new PrintWriter(out); 
            
        ){
            System.out.println("################################################");
            output.write(temp.toString());
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");


        }catch(Exception ex){
            System.out.print("Critical error with the bill generate!!!!");
            System.out.println(ex.getMessage()+" \n"+ ex.getLocalizedMessage()+"\n");
        }
        
        array.add(temp);
        write_file();
        //array.clear();
    }


    public ArrayList<BuyCD> get_data(){
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

           array=(ArrayList<BuyCD>) input.readObject();

           if(!(array.get(1) instanceof BuyCD)){
           System.out.println("we have some deserilazation problems");
           array.clear();
           return;
        }

           System.out.println("there are in the user.dat: "+array.size());

            
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
            System.out.println(e.getLocalizedMessage());
            e.getStackTrace();
        }
    }



    
}
