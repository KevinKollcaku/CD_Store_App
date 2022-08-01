package view.Product;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.CD;
import model.Employee;
import model.Genre;
import model.User;
import model.Accesers.CDAccess;
import model.Accesers.GenreAccess;
import model.Accesers.SupliersAccess;
import view.Genre.ListofGenre;
import view.ViewMain.AdminView;
import view.ViewMain.ManagerView;

//nuk besoj se eshte shume e noevojshme

public class AddNewProduct {
    public AddNewProduct(){

    }

    public void exce(Stage PrimaryStage, BorderPane SecondaryPane, User the_User, Employee the_Employee, MenuBar tabes) {
        
        //used to comunicate with the file that stores the cd-s
        CDAccess data=new CDAccess();
        SupliersAccess data2=new SupliersAccess();
        GenreAccess data3=new GenreAccess();
        

        BorderPane bp=new BorderPane();
        GridPane gp=new GridPane();
        
        CD the_new_cd=new CD();

        Label Title= new Label("Title");
        Label Artist= new Label("Artist: ");
        Label year = new Label("Year: ");
        Label price=new Label("Price");
        Label copies=new Label("Coplies");
        Label suplier=new Label("The suplier");
        Label genre=new Label("The Genre");
    

        TextField titel_field=new TextField();
        TextField Artist_field=new TextField();
        TextField Year_fild=new TextField();
        TextField price_fild=new TextField();
        TextField copies_fild=new TextField();

        //we read all the supliers from the file and add then to a combobox
        //se we can then select one of them
        ObservableList<model.Supplier> supliers_list= FXCollections.observableArrayList(data2.get_data());
        ComboBox<String> list_of_supliers=new ComboBox<>();
        
        //we now fill the combobox with the names of the supliers
        for(int i=0;i<supliers_list.size();i++){
            list_of_supliers.getItems().add(supliers_list.get(i).getSupplier_name());
        }

        ObservableList<Genre> genre_list= FXCollections.observableArrayList(data3.get_data());
        ComboBox<String> list_of_ganre=new ComboBox<>();

        for(int i=0;i<genre_list.size();i++){
            list_of_ganre.getItems().add(genre_list.get(i).getGenername());
        }
       // list_of_supliers.getItems().addAll(supliers_list);



        Button add=new Button("Add porduct");
        Button close=new Button("Discarde");
        add.getStyleClass().add("login-but");
        close.getStyleClass().add("cancle-but");


        gp.addRow(1, Title,titel_field);
        gp.addRow(2, Artist,Artist_field);
        gp.addRow(3, year,Year_fild);
        gp.addRow(4, price,price_fild);
        gp.addRow(5,copies,copies_fild);
        gp.addRow(6, suplier,list_of_supliers);
        gp.addRow(7, genre,list_of_ganre);
        
        
        //this will be the bottom in which we will have the butons to add or cancle the edition
        HBox comands=new HBox();
        comands.getChildren().addAll(add,close);

        //we enter all the tinhs inside a border pane, somehow unnecessary i think
        bp.setCenter(gp);
        bp.setBottom(comands);
        SecondaryPane.setCenter(bp);

        //buttons action
        add.setOnAction(e->{
            

            the_new_cd.setName(titel_field.getText());
            the_new_cd.setArtist(Artist_field.getText());
            the_new_cd.setYear(Integer.parseInt(Year_fild.getText()));
            the_new_cd.setPrice(Integer.parseInt(price_fild.getText()));
            the_new_cd.setCopies(Integer.parseInt(copies_fild.getText()));
            the_new_cd.setSuplier(list_of_supliers.getSelectionModel().getSelectedItem());
            the_new_cd.setGenre(list_of_ganre.getSelectionModel().getSelectedItem());
            System.out.print("-------------->"+the_new_cd.toString()+"<-------------");

            data.add_cd(the_new_cd);
            data2.add_suppliers_product(the_new_cd, list_of_supliers.getSelectionModel().getSelectedIndex());

            AdminView temp=new AdminView();
            ManagerView temp2=new ManagerView();
            if(the_User.getAcces_level()==1){
                temp.exce(PrimaryStage,the_User,the_Employee);
            }else{
                temp2.exce(PrimaryStage,the_User,the_Employee);
            }
        });


        //butons action
        close.setOnAction(e->{
            data2.printdata();
            System.out.print("\n________________________closed_______________________\n");
            AdminView temp=new AdminView();
            ManagerView temp2=new ManagerView();
            if(the_User.getAcces_level()==1){
                temp.exce(PrimaryStage,the_User,the_Employee);
            }else{
                temp2.exce(PrimaryStage,the_User,the_Employee);
            }
        });
        


    }
}
