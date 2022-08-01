package view.Supliers;



import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Supplier;
import model.User;
import model.Accesers.SupliersAccess;

public class ListOfSupliers {

    public ListOfSupliers(){
        System.out.println("Insinde the list of users");

    }

    public void exce(Stage PrimaryStage, BorderPane SecondaryPane,User the_user, MenuBar tabes){
        

        tabes.setVisible(true);

        BorderPane ThirdthPane=new BorderPane();

        SupliersAccess infor=new SupliersAccess();

        ObservableList<Supplier> lista = FXCollections.observableArrayList(infor.get_data());

        TableView tabela= new TableView<>();

        tabela.setEditable(true);

        TableColumn name = new TableColumn<>("Supliers Name ");
        name.setCellValueFactory(new PropertyValueFactory<>("supplier_name"));
        
        TableColumn something=new TableColumn<>("List of providing products");
       //ObservableList<model.Supplier> raw_list_of_products
      // something.setCellValueFactory(new PropertyValueFactory<>("provided_products"));
      // something.setCellFactory(cellDAta->cellData.getValue().produce_box);

        tabela.setItems(lista);
        tabela.getColumns().addAll(name,something);

        Button edit= new Button("Edit");
        edit.getStyleClass().add("login-but");

        edit.setOnAction(e->{
            EdditSuplier changing=new EdditSuplier();
            changing.exce(PrimaryStage, SecondaryPane, the_user, (Supplier)tabela.getSelectionModel().getSelectedItem(),tabes,tabela.getSelectionModel().getSelectedIndex());

        });
        
        ThirdthPane.setCenter(tabela);
        ThirdthPane.setBottom(edit);

        SecondaryPane.setCenter(ThirdthPane);




    }
}
