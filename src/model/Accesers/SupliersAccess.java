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
import model.Supplier;

public class SupliersAccess {

    private final static String name="CD_Store/src/var/supliers.dat";
    private File file_path;
    //this will store all the users, after we have read them from the file
    //it will also be used to right back an undatet vrsion on the list of users
    private ArrayList<Supplier> array=new ArrayList<>();

    //whene we right data to a file using the sereliation, an automatic serial number
    //is assigned to it, but this is not good because this automatic serial number
    //can change becuse it is effected by many things, such as the JVM enivorment
    // tha class structure changes etc..
    // that is why we excpicitly define it here
    public final static long serialVersionUID = 6529685098267757690L;
    
    public SupliersAccess(){
        file_path=new java.io.File(name);
        read_file();
    }

    public SupliersAccess(String path){
        this.file_path= new java.io.File(path);
        read_file();
    }

    public void edit_Supplier(int index,Supplier temp){
        array.remove(index);
        array.add(index,temp);
        write_file();
    }

    //this will edit an existing product by deleting the old version and adding the
    //new version in the array, then the array will right the data in the file
     //public void edit_suplier_product(int index,Supplier temp,String old_cd,String new_cd);{
    //     array.get(index).edit_porduct(old_cd, new_cd);
    //     write_file();
    // }
    public void here(){
        
    };

    //this funciton will and a suplire to the array
    //then we write the array to the file
    public void add_Supplier(Supplier temp){
        for(int i=0;i<array.size();i++){
            System.out.println(array.get(i).getSupplier_name());
        }
        array.add(temp);
        write_file();
        System.out.println("\n suplier added");
        
    }

    //here we will ad a new porduct to a specific suplier
    //we then will right the data again to the file
    public void add_suppliers_product(CD new_porduct, int index){
        
        System.out.println("we have added this porduct to teh suplier witht he name: "+array.get(index).getSupplier_name());
        array.get(index).add_new_product(new_porduct);
        write_file();
      
    }

    //removes teh suplire directly by finding its name and deleting it
    public void remove_Supplier(Supplier temp){
        
        for(int i=0;i<array.size();i++){
            if(temp.getSupplier_name().equals(array.get(i).getSupplier_name()))
            {
                array.remove(i);
            write_file();  
            return;
            }
        }
        return;
    }
    
    //removes the suplier by using the index in the lies/ tabelview
    public void remove_Supplier(int index){
        
        array.remove(index);
        write_file();
        return;
    }

    public ArrayList<Supplier> get_data(){
        //read_file();
        return array;
    }


    public int get_size(){
        return array.size();
    }

    public void printdata(){
        read_file();
        System.out.println(array.size());
        for(int i=0;i<array.size();i++){
            System.out.print("i");
            System.out.println(array.get(i).getSupplier_name()+ array.get(i).toString());
        }
        System.out.println("Done");
    }

    public void destroy_data(String temp){
        if(temp.equals("alfa")){
            array.clear();
            write_file();
        }
        return;
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

           array=(ArrayList<Supplier>) input.readObject();

           if(array.size()>0){
           if(!(array.get(0) instanceof Supplier)){
               System.out.println("we have some deserilazation problems");
               array.clear();
               return;
            }
        }

        System.out.println("there are in the user.dat: "+array.size());
        System.out.println("_______________________Exception reading from supliers file 0.0x______________________________");
            
        } catch (Exception e) {
            System.out.println("_______________________Exception reading from supliers file______________________________");
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


    public void close(){
        array.clear();
    }
    
}
