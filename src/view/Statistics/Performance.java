package view.Statistics;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.BuyCD;
import model.Employee;
import model.Sells;
import model.User;
import model.Accesers.BuyAcces;
import model.Accesers.EmplyeeAccess;
import model.Accesers.SellsAccess;

//se kam idene me te vogel si do e beje kete gje!!!
public class Performance {

    public Performance() {
        System.out.println("We are in the Statistic territory!!!");
    }

    public void exce(Stage PrimaryStage, BorderPane SecondaryPane, User the_User, Employee the_Employee, MenuBar tabes){
        
        SellsAccess data=new SellsAccess();
        BuyAcces data2=new BuyAcces();
        
        //this is the tabepane that will hold all of the different tabes!!!
        TabPane tp=new TabPane();

        Tab tab=new Tab();
        tab.setText("Status");
        
        //this just adds the new tab to teh tabpane!!!!
        tp.getTabs().add(tab);
        tab.setClosable(false);

        final CategoryAxis xAxis=new CategoryAxis();
        final NumberAxis yAxis=new NumberAxis();
        final BarChart<String,Number> bc=new BarChart<>(xAxis, yAxis);
        bc.setTitle("The Curretn status of the Bussiness");
        xAxis.setLabel("Components");
        yAxis.setLabel("Amount of Money");

        XYChart.Series seria1=new XYChart.Series<>();
        seria1.setName("Money amount");

        seria1.getData().add(new XYChart.Data("Sells", data.get_data().getProfit()));
        seria1.getData().add(new XYChart.Data("Costo", data.get_data().getCosto()));

        bc.getData().add(seria1);

        Button close=new Button("Close");

        VBox vb=new VBox();
        vb.getChildren().addAll(bc,close);
        vb.setAlignment(Pos.CENTER);

        tab.setContent(vb);
//--------------------------------------------------------------
        Tab tab2=new Tab();
        tab2.setText("Cashier performance");
        tab2.setClosable(false);

        
        final CategoryAxis xAxis2=new CategoryAxis();
        final NumberAxis yAxis2=new NumberAxis();
        final BarChart<String,Number> bc2=new BarChart<>(xAxis2, yAxis2);
        bc2.setTitle("Cashier Performance");
        xAxis2.setLabel("Cashiers");
        yAxis2.setLabel("Sells");

        XYChart.Series seria2=new XYChart.Series<>();
        seria2.setName("Money amount");

        EmplyeeAccess temp=new EmplyeeAccess();
        ArrayList<Employee> data1=temp.get_data();

        BuyAcces temp2=new BuyAcces();
        ArrayList<BuyCD> data3=temp2.get_data();

        int sells_made=0;

        for(int i=0;i<temp.get_size();i++){
        sells_made=0;    
            
            for(int j=0;j<data3.size();j++){
                if(data3.get(j).getSeller().getName()==null)
                continue;
                
                if(data3.get(j).getSeller().getName().equals(data1.get(i).getName())){
                    sells_made+=data3.get(j).getProfit();
                }
            }
            seria2.getData().add(new XYChart.Data(data1.get(i).getName(),sells_made));
        }

        bc2.getData().add(seria2);
        

        Button close2=new Button("Close");

        VBox vb2=new VBox();
        vb2.getChildren().addAll(bc2,close);
        vb2.setAlignment(Pos.CENTER);

        tab2.setContent(vb2);
        tp.getTabs().add(tab2);


        SecondaryPane.setCenter(tp);

        close.setOnAction(e->{

            System.out.println("Closing things");
        });

    }


}
