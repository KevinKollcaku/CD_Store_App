package view.Genre;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Employee;
import model.Genre;
import model.User;
import model.Accesers.GenreAccess;

public class ListofGenre {
    public ListofGenre(){
        System.out.println("__The list of Genre__");
    }

    public void exce(Stage PrimaryStage, BorderPane SecondaryPane, User the_User, Employee the_Employee, MenuBar tabes){
        tabes.setVisible(true);
        GenreAccess data=new GenreAccess();
        data.printing();
        
        ObservableList<Genre> inforamtion= FXCollections.observableArrayList(data.get_data());
        
        TableView list_of_genre=new TableView<>();

        TableColumn name=new TableColumn<>("Genre Name");
        try{
        name.setCellValueFactory(new PropertyValueFactory<>("genername"));
        }catch( Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

        list_of_genre.setItems(inforamtion);
        list_of_genre.getColumns().add(name);

        Button edit=new Button("Eddit selected Genre");
        edit.getStyleClass().add("login-but");
        Button remove=new Button("Remove selected Genre");
        remove.getStyleClass().add("login-but");

        HBox hb=new HBox(15);
        hb.getChildren().addAll(edit,remove);
        hb.setAlignment(Pos.CENTER);

        BorderPane bp=new BorderPane();
        bp.setCenter(list_of_genre);
        bp.setBottom(hb);

        SecondaryPane.setCenter(bp);


        edit.setOnAction(e->{
            EditGenre temp=new EditGenre();
            temp.exce(PrimaryStage, SecondaryPane, the_User, the_Employee, tabes, list_of_genre.getSelectionModel().getSelectedIndex());
            System.out.println("Editing this genre!!!");
        });

        remove.setOnAction(e->{
            data.remove_genre(list_of_genre.getSelectionModel().getSelectedIndex());
            ListofGenre temp=new ListofGenre();
            temp.exce(PrimaryStage, SecondaryPane, the_User, the_Employee, tabes);
            System.out.println("Removing this genre!!!");
        });



    }
    
}
