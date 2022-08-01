package model.Accesers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Sells;

public class SellsAccess {
    private File file_path;
    
    Sells obj;

    public SellsAccess(){
        file_path=new File("CD_Store/src/var/profit.dat");
        read_file();
        if(obj==null){
            System.out.print("______________dealing with a null object__________");
            obj=new Sells(0, 0);
        }

    }

    public void add_profit(int num){
        obj.addProfit(num);
        write_file();
    }
    public void add_costo(int num){
        obj.addCosto(num);
        write_file();
    }
    public void restart(){
        obj.setCosto(0);
        obj.setProfit(0);
        write_file();
    }

    public Sells get_data(){
        return obj;
    }

    public void set_data(Sells temp){
        obj=temp;
        write_file();
    }

    public void read_file(){
        try(
            FileInputStream input=new FileInputStream(file_path);
            BufferedInputStream input_buf=new BufferedInputStream(input);
            ObjectInputStream read=new ObjectInputStream(input_buf);
        ){
            obj=(Sells)read.readObject();

            if(!(obj instanceof Sells)){
                throw new Exception("We have some deserilization problems");
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void write_file(){
        try(
            FileOutputStream out=new FileOutputStream(file_path);
            BufferedOutputStream output_buffered=new BufferedOutputStream(out);
            ObjectOutputStream write=new ObjectOutputStream(output_buffered);
        ){
            write.writeObject(obj);
            
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
