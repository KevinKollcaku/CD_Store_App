package view.Product;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.CD;
import model.Employee;
import model.User;
import model.Accesers.CDAccess;

public class ViewProducts{


    public void exce(Stage PrimaryStage, BorderPane SecondaryPane, User the_User,Employee the_Employee , MenuBar tabes) {
        
        //creating a file accesser for the cd-s

        BorderPane bp = new BorderPane();
        CDAccess datas=new CDAccess();
      

        // creating an observable list witht he datas form the file of cd-s
        ObservableList<CD> data_for_cd= FXCollections.observableArrayList(datas.get_data());

        // feading this observable lsit into our table
        TableView tabela=new TableView<>(data_for_cd);

        TableColumn name=new TableColumn<>("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn artist = new TableColumn<>("Artist");
        artist.setCellValueFactory(new PropertyValueFactory<>("artist"));

        TableColumn year = new TableColumn<>("Year or relese");
        year.setCellValueFactory(new PropertyValueFactory<>("year"));

        TableColumn copies=new TableColumn<>("Stock");
        copies.setCellValueFactory(new PropertyValueFactory<>("copies"));

        TableColumn price=new TableColumn<>("Price");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        TableColumn supplier=new TableColumn<>("Supplier");
        supplier.setCellValueFactory(new PropertyValueFactory<>("suplier"));

        
        try{
            TableColumn genre=new TableColumn<>("Genre");
            genre.setCellValueFactory(new PropertyValueFactory<>("Genre"));
    
        tabela.setItems(data_for_cd);
        tabela.getColumns().addAll(name,artist,year,copies,price,supplier,genre);
       // System.out.println(datas.get_data().get(2).getSupliersname()+"_______________________________________________");


    }catch(Exception ex){
        System.out.println(ex.getMessage()+" --------------------------");
    }

        Button edit=new Button("Edit");
        edit.getStyleClass().add("login-but");
        Button bye=new Button("Bye");
        bye.getStyleClass().add("login-but");
        Button add=new Button("Add Stock");
        add.getStyleClass().add("login-but");
        HBox commands=new HBox(12);
        commands.getChildren().addAll(bye,edit,add);
        commands.setAlignment(Pos.CENTER);

        if(the_User.getAcces_level()!=1){
            edit.setVisible(false);
            if(the_User.getAcces_level()==3){
                add.setVisible(false);
                //add.setVisible(false);
            }
        }else{
            edit.setVisible(true);
            System.out.println("We are on a Manager view");
        }

        
        bp.setCenter(tabela);
        bp.setBottom(commands);

        SecondaryPane.setCenter(bp);

        edit.setOnAction(e->{
            EditProduct temp=new EditProduct();
            temp.exce(PrimaryStage, SecondaryPane, the_User,the_Employee ,(CD)tabela.getSelectionModel().getSelectedItem(), tabes,tabela.getSelectionModel().getSelectedIndex());
        });

        bye.setOnAction(e->{
            ByeProduct temp=new ByeProduct();
            temp.exce(PrimaryStage, SecondaryPane, the_User,the_Employee, (CD)tabela.getSelectionModel().getSelectedItem(), tabes, tabela.getSelectionModel().getSelectedIndex(), true);;
        });

        add.setOnAction(e->{
            AddProductStock temp=new AddProductStock();
            temp.exce(PrimaryStage, SecondaryPane, the_User,the_Employee, (CD)tabela.getSelectionModel().getSelectedItem(), tabes,  tabela.getSelectionModel().getSelectedIndex());
        });

        
    }

    
}
