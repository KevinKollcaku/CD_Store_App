package view.Product;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.CD;
import model.Employee;
import model.User;
import model.Accesers.CDAccess;
import view.ViewMain.AdminView;
import view.ViewMain.ManagerView;

public class EditProduct {
    public EditProduct(){

    }

    public void exce(Stage PrimaryStage, BorderPane SecondaryPane, User the_User,Employee the_Employee, CD the_cd, MenuBar tabes,int index) {
        
        CDAccess data=new CDAccess();

        BorderPane bp=new BorderPane();
        GridPane gp=new GridPane();

        Label Title= new Label("Title");
        Label Artist= new Label("Artist: ");
        Label year = new Label("Year: ");
        Label price=new Label("Price: ");

        TextField titel_field=new TextField(the_cd.getName());
        TextField Artist_field=new TextField(the_cd.getArtist());
        TextField Year_fild=new TextField(""+the_cd.getYear());
        TextField price_Field=new TextField(""+the_cd.getPrice());

        Button edit=new Button("Edit porduct");
        edit.getStyleClass().add("login-but");
        Button close=new Button("Discarde");
        close.getStyleClass().add("cancle-but");


        gp.addRow(1, Title,titel_field);
        gp.addRow(2, Artist,Artist_field);
        gp.addRow(3, year,Year_fild);
        gp.addRow(4, price,price_Field);
        gp.addRow(5,edit,close);
        

        //the HBox where we will save the 2 butons
        // HBox controlls=new HBox();
        // controlls.getChildren().addAll(edit,close);


    
        // Year_fild.setText(" "+the_cd.getYear());
        // Artist_field.setText(the_cd.getArtist());
        titel_field.setText(the_cd.getName());

            // Year_fild.setEditable(false);
            // Artist_field.setEditable(false);
            // titel_field.setEditable(false);

        
        bp.setTop(new Label("Editing a CD"));
        bp.setCenter(gp);
        // bp.setBottom(controlls);
        SecondaryPane.setCenter(bp);

        edit.setOnAction(e->{
            the_cd.setArtist(Artist_field.getText());
            the_cd.setName(titel_field.getText());
            try {
                the_cd.setYear(0+Integer.parseInt(Year_fild.getText().substring(0,Year_fild.getText().length())));
                the_cd.setPrice(0+Integer.parseInt(price_Field.getText().substring(0,price_Field.getText().length())));
        
            } catch (Exception ex) {
                System.out.println("<____________"+ex.getMessage());
            }
                        
            data.edit_cd(index, the_cd);

            //shifting back to the view that we had before!!
            AdminView temp=new AdminView();
            ManagerView temp2=new ManagerView();

            if(the_User.getAcces_level()==1)
            temp.exce(PrimaryStage,the_User,the_Employee);
            else{
                temp2.exce(PrimaryStage,the_User,the_Employee);
            }
        });

        close.setOnAction(e->{
            //shifting back to the view that we had before
            AdminView temp=new AdminView();
            ManagerView temp2=new ManagerView();
            if(the_User.getAcces_level()==1)
            temp.exce(PrimaryStage,the_User,the_Employee);
            else{
                temp2.exce(PrimaryStage,the_User,the_Employee);
            }
        });
        


    }
    
}
