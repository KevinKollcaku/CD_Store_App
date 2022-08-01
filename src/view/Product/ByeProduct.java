package view.Product;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.BuyCD;
import model.CD;
import model.Employee;
import model.User;
import model.Accesers.BuyAcces;
import model.Accesers.CDAccess;
import model.Accesers.SellsAccess;
import view.ViewMain.AdminView;
import view.ViewMain.ManagerView;
import view.ViewMain.UserView;

public class ByeProduct {
    
    public ByeProduct(){

    }

    public void exce(Stage PrimaryStage, BorderPane SecondaryPane, User the_User,Employee the_Employee, CD the_cd, MenuBar tabes,int index, boolean selecting) {
        BorderPane bp=new BorderPane();
        GridPane gp=new GridPane();

        Label Title= new Label("Title");
        Label Artist= new Label("Artist: ");
        Label year = new Label("Year: ");
        Label Price =new Label("Price: ");
        Label Amount=new Label("Number of copies");

        Label error_message=new Label("");

        TextField titel_field=new TextField(the_cd.getName());
        titel_field.setEditable(false);
        TextField Artist_field=new TextField(the_cd.getArtist());
        Artist_field.setEditable(false);
        TextField Year_fild=new TextField(""+the_cd.getYear());
        Year_fild.setEditable(false);
        TextField price_Field=new TextField(""+the_cd.getPrice());
        price_Field.setEditable(false);
        TextField amount_Field=new TextField();



        Button buy=new Button("Bye porduct");
        buy.getStyleClass().add("login-but");
        Button close=new Button("Discarde");
        close.getStyleClass().add("cancle-but");


        gp.addRow(1, Title,titel_field);
        gp.addRow(2, Artist,Artist_field);
        gp.addRow(3, year,Year_fild);
        gp.addRow(4, Price, price_Field);
        gp.addRow(5, Amount,amount_Field);
        gp.addRow(6, error_message);
        gp.addRow(7, close,buy);


        // if(selecting){


        // }else{
        //     Year_fild.setText(" "+the_cd.getYear());
        //     Artist_field.setText(the_cd.getArtist());
        //     titel_field.setText(the_cd.getName());

        //     Year_fild.setEditable(false);
        //     Artist_field.setEditable(false);
        //     titel_field.setEditable(false);
        // }

        bp.setCenter(gp);
        SecondaryPane.setCenter(bp);

        buy.setOnAction(e->{
            //number enterd by the user
            int num=Integer.parseInt(amount_Field.getText().substring(0, amount_Field.getText().length()));

            if(the_cd.getCopies()<num){
                amount_Field.clear();
                amount_Field.setPromptText("Not enough Stock");
                //error_message.setText("Sorry but we dont have that many copies of this porduct!!!");
                return;
            }else{
                BuyAcces data=new BuyAcces();
                data.add_buyed_product(new BuyCD(the_cd, the_Employee,num));
                the_cd.setCopies(the_cd.getCopies()-num);
                CDAccess data2=new CDAccess();
                data2.edit_cd(index,the_cd);
                SellsAccess data3=new SellsAccess();
                data3.add_profit(num*the_cd.getPrice()); 
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


        close.setOnAction(e->{
            //shifting back to the view that we had before
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
        


    }


}
