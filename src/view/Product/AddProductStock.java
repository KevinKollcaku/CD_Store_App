package view.Product;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.CD;
import model.Employee;
import model.User;
import model.Accesers.CDAccess;
import model.Accesers.SellsAccess;
import view.ViewMain.AdminView;
import view.ViewMain.ManagerView;
import view.ViewMain.UserView;

public class AddProductStock {

    public AddProductStock(){
        System.out.println("Updating the Stack of the Product");
    }

    public void exce(Stage PrimaryStage, BorderPane SecondaryPane, User the_User,Employee the_Employee ,CD the_cd, MenuBar tabes,int index) {
        tabes.setVisible(false);

        CDAccess data=new CDAccess();
        SellsAccess data2=new SellsAccess();

        Label Title=new Label("Adding Stock");

        Label amount=new Label("Amount to add");

        TextField amount_field=new TextField();
        amount_field.setPromptText("Enter the new Stock");

        Button canle=new Button("Cancle");
        canle.getStyleClass().add("cancle-but");
        Button add=new Button("Add");
        add.getStyleClass().add("login-but");


        VBox vb=new VBox();
        
        GridPane gp=new GridPane();

        gp.addRow(1, amount,amount_field);
        gp.addRow(2, canle,add);

        vb.getChildren().addAll(Title,gp);
        vb.setAlignment(Pos.CENTER);

        SecondaryPane.setCenter(vb);

        add.setOnAction(e->{

            int num=Integer.parseInt(amount_field.getText().substring(0, amount_field.getText().length()));

            if(num<1){
                amount_field.clear();
                amount_field.setPromptText("Invalide input");
                return;
            }else{
                data.add_cd_stock(index, num);
                data2.add_costo(num*the_cd.getPrice());
            }
               
                AdminView temp=new AdminView();
                ManagerView temp2=new ManagerView();
                UserView temp3=new UserView();
                if(the_User.getAcces_level()==1)
                temp.exce(PrimaryStage,the_User,the_Employee);
                else if(the_User.getAcces_level()==2){
                    temp2.exce(PrimaryStage,the_User,the_Employee);
                }else{
                    temp3.exce(PrimaryStage,the_User,the_Employee);
                }

        });

        
        canle.setOnAction(e->{
            //shifting back to the view that we had before
            AdminView temp=new AdminView();
            ManagerView temp2=new ManagerView();

            if(the_User.getAcces_level()==1)
            temp.exce(PrimaryStage,the_User,the_Employee);
            else if(the_User.getAcces_level()==2){
                temp2.exce(PrimaryStage,the_User,the_Employee);
            }
        });
        
    }
    
}
