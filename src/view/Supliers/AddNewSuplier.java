package view.Supliers;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Employee;
import model.Supplier;
import model.User;
import model.Accesers.SupliersAccess;
import view.ViewMain.AdminView;
import view.ViewMain.ManagerView;
import view.interfaces.Formats;

public class AddNewSuplier  {

    public AddNewSuplier() {
    }

    public void exce(Stage PrimaryStage, BorderPane SecondaryPane,User the_User,Employee the_Employee, MenuBar tabes){
        
        SupliersAccess data=new SupliersAccess();
        
        GridPane gp=new GridPane();
        
        // plase to enter the name
        Label Name=new Label("Name: ");
        TextField name=new TextField();

        //button to submit and button to cancle
        Button submit=new Button("Submit");
        submit.getStyleClass().add("login-but");
        Button cancle = new Button("Cancle");
        cancle.getStyleClass().add("cancle-but");
        
        gp.addRow(0, new Text("Please fill the information for the new suplier"));
        gp.addRow(2, Name,name);
        gp.addRow(4, cancle, submit);


        //submiting buton that will save the new suplier
        submit.setOnAction(e->{

            //calling the function to add the new suplier
            System.out.print("\ncalling the function to add the new suplier\n");
            
            try{
                data.add_Supplier(new Supplier(name.getText()));
            }catch(Exception ex){
                System.out.println(ex.getMessage());
                ex.getStackTrace();
            }
            
            AdminView temp=new AdminView();
            ManagerView temp2=new ManagerView();

            if(the_User.getAcces_level()==1)
            temp.exce(PrimaryStage,the_User,the_Employee);
            else{
                temp2.exce(PrimaryStage,the_User,the_Employee);
            }
            
        });

        //cancle buton that will cancle the creation of the new suplier
        cancle.setOnAction(e->{
            AdminView temp= new AdminView();
            ManagerView temp2=new ManagerView();
            if(the_User.getAcces_level()==1)
            temp.exce(PrimaryStage,the_User,the_Employee);
            else{
                temp2.exce(PrimaryStage,the_User,the_Employee);
            }
        });

        SecondaryPane.setCenter(gp);


    }

    
}
