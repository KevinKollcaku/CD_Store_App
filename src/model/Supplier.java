package model;

import java.io.Serializable;
import java.util.ArrayList;


public class Supplier implements Serializable{
    private final static long serialVersionUID=123412343L;
    private String supplier_name;

    private ArrayList<String> provided_products;

    //this two object are not serilazebe, that is why we have added teh trasistent key word
    //if the matters were even worst, we would need to re define the writObject() and rightObjects()
    //functions so we could do some explicit serilazation of the objects that didn't implement 
    //the serializable interface.
    // private transient ObservableList<CD> lista;
    // private transient ComboBox<String> porducBox;


    public Supplier(String name){
        System.out.println("___________________The new suplier is created___________________________");
        provided_products=new ArrayList<String>();
        // lista=FXCollections.observableArrayList(provided_products);
        // porducBox=new ComboBox<>();

        this.setSupplier_name(name);

        //we are filling the combobox with the necesary infromation
        // for(int i=0;i<provided_products.size();i++){   
        //     porducBox.getItems().add(provided_products.get(i).getName());
        // }
        
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public void add_new_product(CD temp){
        provided_products.add(temp.getName());

        System.out.println("This suplier has this porducts:");
        for(int i=0;i<provided_products.size();i++){
            System.out.println(provided_products.get(i));
        }
        // lista=FXCollections.observableArrayList(provided_products);
        // //debuging purpuse
        // for(int i=0;i<provided_products.size();i++){   
        //     porducBox.getItems().add(provided_products.get(i).getName());
        // }
    }

    // public void increase_number_of_stock_of_a_prduct(CD temp,int increment){
    //     for(int i=0;i<provided_products.size();i++){
    //         if(temp.equals(provided_products.get(i))){
    //             provided_products.get(i).setCopies(provided_products.get(i).getCopies()+increment);
    //         }
    //     }
    // }

    public ArrayList<String> get_list_of_products(){
        return provided_products;
    }

    public int get_number_of_provided_products(){
        return provided_products.size();
    }

    // we have getters and setters and alos a property function to work whith our 
    // combobox, that is when we add it to the tabelview the table can access the
    // combobox by this function, due to the process called reflection
    // public ComboBox<String> getPorducBox(){
    //     return porducBox;
    // }

    // public void setPorducBox(ComboBox<String> temp){
    //     this.porducBox=temp;
    // }

    // public ComboBox<String> porducBoxProperty(){
    //     return this.porducBox;
    // }

    //
    public boolean product_is_here(String name){

        for(int i=0;i<provided_products.size();i++){
            if(name.equals(provided_products.get(i)))
            return true;
        }
        return false;
    }

    // public void sell_product(CD temp, int number) throws Exception{
    //     for(int i=0;i<provided_products.size();i++){
    //         if(temp.equals(provided_products.get(i))){
    //             provided_products.get(i).setCopies(provided_products.get(i).getCopies()-number);
    //         }
    //     }
    //     throw new Exception("this product is not here");

    // }

    // public void edit_porduct(CD olde_cd,CD new_cd){
        
    //     for(int i=0;i<provided_products.size();i++){
    //         if(provided_products.get(i).getName().equals(olde_cd.getName())){
    //             provided_products.remove(i);
    //             provided_products.add(i, new_cd);
    //         }
    //     }
    // }
    
    public void remove_porduct(String product){
        for(int i=0;i<provided_products.size();i++){
            if(product.equals(provided_products.get(i))){
                provided_products.remove(i);
            }
        }
    }
}
