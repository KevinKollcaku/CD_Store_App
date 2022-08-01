package view;



import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Employee;
import model.Sells;
import model.User;
import model.Accesers.ActiveControler;
import model.Accesers.BuyAcces;
import model.Accesers.CDAccess;
import model.Accesers.EmplyeeAccess;
import model.Accesers.GenreAccess;
import model.Accesers.SellsAccess;
import model.Accesers.SupliersAccess;
import model.Accesers.UserAccess;
import view.ViewMain.AdminView;
import view.ViewMain.ManagerView;
import view.ViewMain.UserView;




/*
Need a lot of fixes, because we can not leve it like this,
every time we are moving to a new window we need to pass not 
only  the stage, but also the current user that is loged in
this is very important becuse by doing so we eleminate


*/
public class loging extends  Application{
    private String usn;
    private String pass;
    private Button submit;
    private javafx.scene.text.Text message;

    public loging(){

    }
    
    //it just shows the username and passwd field for you to enter
    //it alos includes a submit button
    


    protected String getusername(){
        return usn;
    }

    protected String getpasswd(){
        return pass;
    }



    @Override
    public void start(Stage arg0)  {


        //used to create the username part of the log in
        javafx.scene.control.TextField usname =new javafx.scene.control.TextField();
        javafx.scene.control.Label username=new javafx.scene.control.Label("  Username: ",usname);
        usname.setPromptText("Please enter username!");
        username.setStyle("-fx-font-size:15");
        username.setContentDisplay(ContentDisplay.RIGHT);
       
        //used to create the passwd part of the login
        javafx.scene.control.PasswordField passwd =new javafx.scene.control.PasswordField();
        passwd.setPromptText("Please enter password!");
        javafx.scene.control.Label password=new javafx.scene.control.Label("  Password:  ",passwd);
        password.setStyle("-fx-font-size:15");
        password.setContentDisplay(ContentDisplay.RIGHT);

       //the submit button, to check if such user exist so it lets you in
       submit=new Button("Submit");
       submit.getStyleClass().add("login-but");
       
   
       //the message we use to tell the person if the infromation he enterd is incorrect
       message=new javafx.scene.text.Text("");

       //the image that will be placed on the backgroun
     
        Image photo_sorce=new Image("var/logo/Login.jpg");
        ImageView photo=new ImageView(photo_sorce);
        //photo.setFitHeight(400);
        photo.setFitWidth(600);
        photo.setPreserveRatio(true);
        

       StackPane sp=new StackPane();

       GridPane buttons=new GridPane();
       buttons.add(submit, 0, 1);

    
       VBox pana= new VBox(12);
       Text header=new Text("                            Log in");
       header.setStyle("-fx-font-size:20; text-align:center");
       pana.getChildren().addAll(header,username,password,buttons,message);
       pana.setAlignment(Pos.CENTER_LEFT);
       

       sp.getChildren().addAll(photo,pana);

        
        Scene skena=new Scene(sp,600,337);
        arg0.setScene(skena);
        arg0.setTitle("temp");
        skena.getStylesheets().addAll(this.getClass().getResource("../var/css/style.css").toExternalForm());
        arg0.show();

        pana.setOnKeyPressed(e->{
            if(e.getCode()==KeyCode.ENTER){
                usn=usname.getText();
            pass=passwd.getText();

            message.setText("you are in");
            try{
            AdminView temp=new AdminView();
            temp.exce(arg0,new User("admin", "admin", 1),new Employee(new User("admin", "admin", 1)));
    
        }catch(Exception ex){
         System.out.println(ex.getMessage());
         System.out.println(ex.getLocalizedMessage());
            }
               }});;

        submit.setOnAction(e->{
            usn=usname.getText();
            pass=passwd.getText();

            if (usn.equals("admin") && pass.equals("admin")) {
                message.setText("you are in");
                AdminView temp=new AdminView();
                temp.exce(arg0,new User("admin", "admin", 1),new Employee(new User("admin", "admin", 1)));
            }else{
            
                    UserAccess prep=new UserAccess();
                    ArrayList<User> arra=prep.get_data();

                    for(int i=0;i<arra.size();i++){
                        System.out.println(arra.get(i).getUser_name()+ " "+ arra.get(i).getPassword());
                        if(usn.equals(arra.get(i).getUser_name()) && pass.equals(arra.get(i).getPassword())){
                            message.setText("you are in");
                            EmplyeeAccess find=new EmplyeeAccess();
                                Employee the_Employee= find.search_Employee(arra.get(i).getUser_name());

                            if(arra.get(i).getAcces_level()==1){                                
                                System.out.println("We are on a user view");
                                AdminView temp=new AdminView();
                                temp.exce(arg0, arra.get(i), the_Employee);
                            }else if(arra.get(i).getAcces_level()==2){
                                System.out.println("We are on a user view");
                                ManagerView temp=new ManagerView();
                                temp.exce(arg0, arra.get(i), the_Employee);
                            }else{
                                System.out.println("We are on a user view");
                                UserView temp=new UserView();
                                temp.exce(arg0, arra.get(i), the_Employee);
                            }

                            return;
                        }
                    }
                
                message.setText("you are not in "+ usn+" "+pass);
                usname.setText("");
                passwd.setText("");
                
            }
        }
        );
        
        
    }

    public static void main(String[] args) {
        
        System.out.println("ckemi");
        // CDAccess prep=new CDAccess();
        // //prep.destroy_data("alfa");
        // // prep.add_cd(new CD("kamikazi", 2018, "Eminem", 500));
        // // prep.add_cd(new CD("kamikazi2", 2018, "Eminem2", 500));
        // // prep.printdata();
        // System.out.println(prep.get_size());

    //     ByeAcces temp=new ByeAcces();
    //     temp.add_user(new ByCD(new CD(), new Employee(new User())));
    //    // temp.destroy_data("alfa");
        
    //     temp.add_user(new ByCD(new CD("tes",12,"ds",213), new Employee(new User())));
    //     temp.edit_user(0, new ByCD(new CD("success",44,"dis",20), new Employee(new User())));
    //     temp.printdata();
    //     System.out.println(temp.get_size());
    
    ActiveControler alfa=new ActiveControler("beni");
    System.out.print(alfa.get_current_user());
    SupliersAccess data=new SupliersAccess();
    CDAccess data2=new CDAccess();
    //data2.destroy_data("alfa");

    // CD the_prove=new CD("Super",12, "Prova", 123);
    // the_prove.setSuplier("KC");
    // data2.add_cd(the_prove);
    // data.add_suppliers_product(the_prove, 1);

    // BuyCD test=new BuyCD(new CD("kevi2",1123132,"kc222",132131223),new Employee(new User()), 212);

    // BuyAcces data3=new BuyAcces();
    // data3.add_buyed_product(test);
    // data3.printdata();


    //uno.destroy_data("alfa");
    UserAccess d1=new UserAccess();
    EmplyeeAccess d2=new EmplyeeAccess();
    // d1.destroy_data("alfa");
    // d2.destroy_data("alfa");
    BuyAcces d4=new BuyAcces();
    d4.printdata();
   // System.out.println("12/21/12334".matches("[0-9]{2}[/][0-9]{2}[/][0-9]{4}"));

    //System.out.println((new User("kevi","kevi1",3).is_part_of(arra.get(0))));
     Application.launch(args);
      return;
    }
}
