package view.Genre;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Employee;
import model.User;
import model.Accesers.GenreAccess;
import view.ViewMain.AdminView;
import view.ViewMain.ManagerView;
import view.interfaces.Formats;

public class AddNewGenre implements Formats{

    public AddNewGenre(){
        System.out.println("__Adding a new Genre__");
    }

    public void exce(Stage PrimaryStage, BorderPane SecondaryPane, User the_User, Employee the_Employee, MenuBar tabes){

        tabes.setVisible(false);

        GenreAccess data=new GenreAccess();

        Label title=new Label("-Adding A New Genre-");
        title.setAlignment(Pos.CENTER);

        Label Name=new Label("Enter the name of teh Genre: ");

        TextField name_Field=new TextField();
        name_Field.setPromptText("Enter the name of the Genre ");

        Button save=new Button("Save the new Genre");
        save.getStyleClass().add("login-but");
        Button cancle=new Button("Cancle");
        cancle.getStyleClass().add("cancle-but");

        GridPane gp=new GridPane();

        gp.addRow(1,Name, name_Field);
        gp.addRow(2, cancle,save);
        save.setAlignment(Pos.CENTER_RIGHT);
        cancle.setAlignment(Pos.CENTER_RIGHT);
        gp.setAlignment(Pos.CENTER);

        BorderPane bp=new BorderPane();
        bp.setTop(title);
        bp.setCenter(gp);

        SecondaryPane.setCenter(bp);


        //butons action
        save.setOnAction(e->{

            try {
                data.add_new_genre(name_Field.getText());
            } catch (Exception e1) {
                name_Field.clear();
                System.out.println(e1.getMessage());
                name_Field.setPromptText(e1.getMessage());
               return;
            }

            AdminView temp=new AdminView();
            ManagerView temp2=new ManagerView();
            if(the_User.getAcces_level()==1){
                temp.exce(PrimaryStage,the_User,the_Employee);
            }else{
                temp2.exce(PrimaryStage,the_User,the_Employee);
            }
        });


     
        cancle.setOnAction(e->{
            
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
