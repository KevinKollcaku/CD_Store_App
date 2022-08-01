package view.Supliers;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Supplier;
import model.User;
import model.Accesers.SupliersAccess;

public class EdditSuplier {
    SupliersAccess update=new SupliersAccess();

    public EdditSuplier(){
        System.out.print("Editing the suplier ");
    }

    public void exce(Stage PrimaryStage, BorderPane SecondaryPane,User the_user,Supplier the_Supplier, MenuBar tabes, int index){
        tabes.setVisible(false);
        
        GridPane pana=new GridPane();

        Label supliers_name_labe=new Label("Name: ");
        TextField supTextField = new TextField(the_Supplier.getSupplier_name());

        Button back = new Button("Exit");
        back.getStyleClass().add("cancle-but");
        Button save = new Button("save");
        save.getStyleClass().add("login-but");


        pana.add(new Label("Editing"), 0, 0);
        pana.addRow(1,supliers_name_labe,supTextField);
        pana.add(back,0,2);
        pana.add(save,1,2);

        save.setOnAction(e->{
            update.edit_Supplier(index, new Supplier(supTextField.getText()));
            ListOfSupliers temp2=new ListOfSupliers();
            //temp.exce(PrimaryStage);
            temp2.exce(PrimaryStage, SecondaryPane, the_user, tabes);
    
        });

        back.setOnAction(e->{
           // AdminView temp=new AdminView();
           //temp.exce(PrimaryStage);
            ListOfSupliers temp2=new ListOfSupliers();
            
            temp2.exce(PrimaryStage, SecondaryPane, the_user, tabes);
        });

        SecondaryPane.setCenter(pana);
    }
}
