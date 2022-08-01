package model.Accesers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Genre;

public class GenreAccess {
    private final static String name="CD_Store/src/var/ganre.dat";
    private File file_path;
    
    ArrayList<Genre> array=new ArrayList<>();

    public GenreAccess(){
        file_path=new File(name);
        read_file();
    }

    public void add_new_genre(String temp) throws Exception{
        //check if genre allready exists
        if(array.size()==0){
        }else{
        for(int i=0;i<array.size();i++){
            if(array.get(i).getGenername().equals(temp)){
                System.out.println("___________FAILD TO CREATE A NEW GENRE__________________");
                throw new Exception("This genre allready Exists!!");
            }
        }
    }
        array.add(new Genre(temp));
        
        write_file();
    }

    public void destroy_data(String temp){
        if(temp.equals("alfa")){
            array.clear();
            write_file();
        }
        return;
    }


    public void remove_genre(int index){
        array.remove(index);
        write_file();
    }

    public void edit_genre(Genre new_genre,int index) throws Exception{
        
        for(int i=0;i<array.size();i++){
            if(array.get(i).getGenername().equals(new_genre.getGenername())){
                throw new Exception("This genre allready Exists!!");
            }
        }
        array.remove(index);
        array.add(index,new_genre);
        write_file();
    }

    public ArrayList<Genre> get_data(){
        return array;
    }

    public void printing(){
        for(int i=0;i<array.size();i++){
            System.out.println(array.get(i).getGenername());
        }
    }


    private void read_file(){
        // write_file();
         try(
             FileInputStream temp=new FileInputStream(file_path);
             BufferedInputStream input_temp=new BufferedInputStream(temp);
             ObjectInputStream input=new ObjectInputStream(input_temp);
         )
         {
             System.out.println("ckemi, we do this one time");
 
             //dangerous
 
            array=(ArrayList<Genre>) input.readObject();
 
            if(array.size()>0){
            if(!(array.get(0) instanceof Genre)){
                System.out.println("we have some deserilazation problems in Gener File");
                array.clear();
                return;
             }
         }
 
         System.out.println("there are in the user.dat: "+array.size());
         System.out.println("_______________________No Problem Reading from the file______________________________");
             
         } catch (Exception e) {
             System.out.println("_______________________Exception reading from Genre file______________________________");
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
             System.out.println("ckemi,we are going out"+ array.size());
 
            output.writeObject(array);
 
          //  System.out.println("there are in the user.dat: "+array.size());
 
             
         } catch (Exception e) {
             e.getStackTrace();
         }
     }
 





}